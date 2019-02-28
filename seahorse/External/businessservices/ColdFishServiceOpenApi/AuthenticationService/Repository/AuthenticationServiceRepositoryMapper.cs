using System;
using System.Data;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.Daos;
using ColdFishServiceOpenApi.Commons.DataContracts;
using Microsoft.Extensions.Configuration;
using Npgsql;

namespace ColdFishServiceOpenApi.AuthenticationService.Repository
{
    public class AuthenticationServiceRepositoryMapper : IAuthenticationServiceRepositoryMapper
    {
        #region Local Variables

        private readonly IAuthenticationServiceRepositoryMapper authenticationServiceRepositoryMapper;
        private readonly IConfiguration configuration;

        #endregion


        #region Constructors

        public AuthenticationServiceRepositoryMapper(IAuthenticationServiceRepositoryMapper authenticationServiceRepositoryMapper,
            IConfiguration configuration)
        {
            this.authenticationServiceRepositoryMapper = authenticationServiceRepositoryMapper;
            this.configuration = configuration;
        }

        #endregion



        #region Public Repository methods

        public ResultMessageEntity ValidateAuthentication(PartnerKeyDetailsDAO partnerKeyDetailsDAO)
        {
            using (IDbConnection dbConnection = new NpgsqlConnection(configuration.GetConnectionString("DefaultConnection"))
            {

            }
            return new ResultMessageEntity();
        }

        #endregion
    }
}
