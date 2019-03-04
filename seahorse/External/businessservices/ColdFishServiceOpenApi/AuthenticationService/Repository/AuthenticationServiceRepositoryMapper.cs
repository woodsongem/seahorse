using System;
using System.Data;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.Daos;
using ColdFishServiceOpenApi.Commons.DataContracts;
using Dapper;
using Microsoft.Extensions.Configuration;
using Npgsql;

namespace ColdFishServiceOpenApi.AuthenticationService.Repository
{
    public class AuthenticationServiceRepositoryMapper : IAuthenticationServiceRepositoryMapper
    {
        public DynamicParameters MapDyParasValidateAuthentication(PartnerKeyDetailsDAO partnerKeyDetailsDAO)
        {
            DynamicParameters dynamicParameters = new DynamicParameters();
            dynamicParameters.Add("@partnerusername", partnerKeyDetailsDAO.username);
            dynamicParameters.Add("@partnerpassword", partnerKeyDetailsDAO.password);
            dynamicParameters.Add("@partnerkeyname", partnerKeyDetailsDAO.partnerkey);
            return dynamicParameters;
        }
    }
}
