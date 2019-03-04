using System;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.Daos;
using ColdFishServiceOpenApi.Commons.DataContracts;

namespace ColdFishServiceOpenApi.AuthenticationService.Repository
{
    public interface IAuthenticationServiceRepository
    {
        ResultMessageEntity ValidateAuthentication(PartnerKeyDetailsDAO partnerKeyDetailsDAO);
    }
}
