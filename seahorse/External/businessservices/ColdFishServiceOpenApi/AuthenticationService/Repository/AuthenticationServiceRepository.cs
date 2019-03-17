using System.Collections.Generic;
using System.Data;
using System.Linq;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.Daos;
using ColdFishServiceOpenApi.AuthenticationService.Utilities;
using ColdFishServiceOpenApi.Commons;
using ColdFishServiceOpenApi.Commons.DataContracts;
using Dapper;
using Microsoft.Extensions.Configuration;
using Npgsql;

namespace ColdFishServiceOpenApi.AuthenticationService.Repository
{
    public class AuthenticationServiceRepository : IAuthenticationServiceRepository
    {

        #region Local Variables

        private readonly IAuthenticationServiceRepositoryMapper authenticationServiceRepositoryMapper;
        private readonly IConfiguration configuration;

        #endregion


        #region Constructors

        public AuthenticationServiceRepository(IAuthenticationServiceRepositoryMapper authenticationServiceRepositoryMapper,
            IConfiguration configuration)
        {
            this.authenticationServiceRepositoryMapper = authenticationServiceRepositoryMapper;
            this.configuration = configuration;
        }

        #endregion



        #region Public Repository methods

        public List<PartnerKeyDetailsDAO> GetPartnerDetail(PartnerKeyDetailsDAO partnerKeyDetailsDAO)
        {
            List<PartnerKeyDetailsDAO> partnerKeyDetails;
            using (IDbConnection dbConnection = new NpgsqlConnection(configuration.GetConnectionString(ColdFishServiceOpenApiConstants.ConnectionStringDefaultConnection)))
            {
                dbConnection.Open();
                DynamicParameters dynamicParameters = authenticationServiceRepositoryMapper.MapDyParasValidateAuthentication(partnerKeyDetailsDAO);

                partnerKeyDetails = dbConnection.Query<PartnerKeyDetailsDAO>(AuthenticationServiceConstants.GetPartnerDetailFunName, dynamicParameters,
                                                                          commandType: CommandType.StoredProcedure).ToList();

            }

            return partnerKeyDetails;
        }

        #endregion
    }
}
