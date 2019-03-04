using System;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApi.Framework.ParallelExecution;
using Microsoft.IdentityModel.Tokens;

namespace ColdFishServiceOpenApi.AuthenticationService.Processors
{
    public class AuthenticationServiceProcessors : IAuthenticationServiceProcessors
    {
        public ResultMessageEntity ProcessorGetAuthenticationDetail(AuthenticationReqMsgEntity authenticationMsgEntity)
        {
            IParallelExecution<AuthenticationReqMsgEntity> parallelExecution = new ParallelExecution<AuthenticationReqMsgEntity>();
            parallelExecution.Add(new ParallelAction<AuthenticationReqMsgEntity> { Activity = GenerateToken, IsParallel = true, RequestObject = authenticationMsgEntity });

            return parallelExecution.Execute();
        }



        public ResultMessageEntity GenerateToken(AuthenticationReqMsgEntity authenticationMsgEntity)
        {
            var claims = new[] { 
                new Claim(JwtRegisteredClaimNames.Sub,authenticationMsgEntity.Username),
                new Claim(JwtRegisteredClaimNames.Jti,authenticationMsgEntity.PartnerKey)
            };
            var signingKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes("OpenAPI"));
            var token = new JwtSecurityToken(claims: claims,expires:DateTime.UtcNow.AddMinutes(10),signingCredentials:new SigningCredentials (signingKey, SecurityAlgorithms.Sha256));
            authenticationMsgEntity.TokenDetail = new JwtSecurityTokenHandler().WriteToken(token);

            return new ResultMessageEntity() { ResultStatus=ResultStatus.Success };
        }
    }
}
