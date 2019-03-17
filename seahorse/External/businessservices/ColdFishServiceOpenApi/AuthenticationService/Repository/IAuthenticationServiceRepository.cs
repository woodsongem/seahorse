using System;
using System.Collections.Generic;
using ColdFishServiceOpenApi.AuthenticationService.DataContracts.Daos;
using ColdFishServiceOpenApi.Commons.DataContracts;

namespace ColdFishServiceOpenApi.AuthenticationService.Repository
{
    public interface IAuthenticationServiceRepository
    {
        List<PartnerKeyDetailsDAO> GetPartnerDetail(PartnerKeyDetailsDAO partnerKeyDetailsDAO);
    }
}
