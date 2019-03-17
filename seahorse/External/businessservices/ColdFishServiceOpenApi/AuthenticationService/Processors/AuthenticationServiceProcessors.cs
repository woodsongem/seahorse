using System;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.MessageEntities;
using ColdFishServiceOpenApi.AuthenticationService.Utilities;
using ColdFishServiceOpenApi.Commons;
using ColdFishServiceOpenApi.Commons.DataContracts;
using ColdFishServiceOpenApi.Framework.ParallelExecution;
using Microsoft.IdentityModel.Tokens;

namespace ColdFishServiceOpenApi.AuthenticationService.Processors
{
    public class AuthenticationServiceProcessors : IAuthenticationServiceProcessors
    {
        #region local veriables

        private readonly IAuthenticationServiceErrorCodes authenticationServiceErrorCodes;

        #endregion

        #region Constructors

        public AuthenticationServiceProcessors(IAuthenticationServiceErrorCodes authenticationServiceErrorCodes)
        {
            this.authenticationServiceErrorCodes = authenticationServiceErrorCodes;
        }

        #endregion

        #region executors Processor

        public ResultMessageEntity ProcessorGetAuthenticationDetail(AuthenticationReqMsgEntity authenticationMsgEntity)
        {
            IParallelExecution<AuthenticationReqMsgEntity> parallelExecution = new ParallelExecution<AuthenticationReqMsgEntity>();
            parallelExecution.Add(new ParallelAction<AuthenticationReqMsgEntity> { Activity = GenerateToken, IsParallel = true, RequestObject = authenticationMsgEntity });

            return parallelExecution.Execute();
        }

        #endregion

        #region Processors

        public ResultMessageEntity GenerateToken(AuthenticationReqMsgEntity authenticationMsgEntity)
        {
            try
            {
                var claims = new[] {
                    new Claim(JwtRegisteredClaimNames.Sub,authenticationMsgEntity.Username),
                    new Claim(JwtRegisteredClaimNames.Jti,authenticationMsgEntity.PartnerKey)
                };

                var securityKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes("ThisismySecretKey"));
                var credentials = new SigningCredentials(securityKey, SecurityAlgorithms.HmacSha256);
                var issuer = "local.com";

                var token = new JwtSecurityToken(issuer, issuer, claims: claims, expires: DateTime.UtcNow.AddMinutes(10), signingCredentials: credentials);
                authenticationMsgEntity.TokenDetail = new JwtSecurityTokenHandler().WriteToken(token);
            }
            catch (Exception ex)
            {
                return ColdFishServiceOpenApiUtility.GetResultMessageEntity(ResultStatus.Fail, "Error while generating token", authenticationServiceErrorCodes.TokenGenerationUnexpectedError);
            }

            return new ResultMessageEntity() { ResultStatus = ResultStatus.Success };
        }

        #endregion

    }
}
