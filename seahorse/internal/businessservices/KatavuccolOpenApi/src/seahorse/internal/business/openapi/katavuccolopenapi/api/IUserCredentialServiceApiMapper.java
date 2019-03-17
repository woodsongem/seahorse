/**
 * 
 */
package seahorse.internal.business.openapi.katavuccolopenapi.api;

import javax.servlet.http.HttpServletRequest;

import seahorse.internal.business.openapi.usercredentialapi.api.datacontracts.CreateProfileApiModel;
import seahorse.internal.business.openapi.usercredentialservice.datacontracts.CreateProfileApiMsgEntity;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;

/**
 * @author SMJE
 *
 */
public interface IUserCredentialServiceApiMapper {

	CreateProfileApiMsgEntity MapCreateProfileApiMsgEntity(CreateProfileApiModel createProfileApiModel);

	OutPutResponse MapOutPutResponse(OutPutResponse outPutResponse, CreateProfileApiMsgEntity createProfileApiMsgEntity,HttpServletRequest httpRequest);

	OutPutResponse mapOutPutResponse(OutPutResponse outPutResponse,HttpServletRequest httpRequest);

}
