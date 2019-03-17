using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.Daos;
using ColdFishServiceOpenApi.Commons.DataContracts;
using Dapper;

namespace ColdFishServiceOpenApi.AuthenticationService.Repository
{
    public interface IAuthenticationServiceRepositoryMapper
    {
        DynamicParameters MapDyParasValidateAuthentication(PartnerKeyDetailsDAO partnerKeyDetailsDAO);
    }
}
