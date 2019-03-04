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

        public ResultMessageEntity ValidateAuthentication(PartnerKeyDetailsDAO partnerKeyDetailsDAO)
        {
            using (IDbConnection dbConnection = new NpgsqlConnection(configuration.GetConnectionString(ColdFishServiceOpenApiConstants.ConnectionStringDefaultConnection)))
            {
                dbConnection.Open();
                DynamicParameters dynamicParameters = authenticationServiceRepositoryMapper.MapDyParasValidateAuthentication(partnerKeyDetailsDAO);

                partnerKeyDetailsDAO.partnerid = dbConnection.Query<long?>(AuthenticationServiceConstants.ValidatePartnerAuthentication,dynamicParameters,
                                                                          commandType: CommandType.StoredProcedure).Single();

            }

            return new ResultMessageEntity() { ResultStatus= ResultStatus.Success };
        }

        #endregion
    }
}
