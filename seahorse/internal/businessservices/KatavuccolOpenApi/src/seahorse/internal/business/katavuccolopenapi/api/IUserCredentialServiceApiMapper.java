/**
 * 
 */
package seahorse.internal.business.katavuccolopenapi.api;

import javax.servlet.http.HttpServletRequest;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;
import seahorse.internal.business.usercredentialapi.api.datacontracts.CreateProfileApiModel;
import seahorse.internal.business.usercredentialservice.datacontracts.CreateProfileApiMsgEntity;

/**
 * @author SMJE
 *
 */
public interface IUserCredentialServiceApiMapper {

	CreateProfileApiMsgEntity MapCreateProfileApiMsgEntity(CreateProfileApiModel createProfileApiModel);

	OutPutResponse MapOutPutResponse(OutPutResponse outPutResponse, CreateProfileApiMsgEntity createProfileApiMsgEntity,HttpServletRequest httpRequest);

}
