using KatavuccolPortalWeb.BusinessService.DataContracts.Commons;
using KatavuccolPortalWeb.BusinessService.DataContracts.InternalServiceDataContracts.CredentialTypeService;

namespace KatavuccolPortalWeb.BusinessService.Services.CredentialTypeService.PostProcessor
{
    public class CredentialTypeBusinessServicePostProcessor : ICredentialTypeBusinessServicePostProcessor
    {
        public Result PostProcessCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity)
        {
            return new Result() { ResultStatus = ResultStatus.Success };
        }

        public Result PostProcessGetCredentialTypeById(GetCredentialTypeMsgEntity getCredentialTypeMsgEntity)
        {
            return new Result() { ResultStatus = ResultStatus.Success };
        }
    }
}
