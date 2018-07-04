/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import javax.ws.rs.core.Response.Status;

import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeResMsgEntity;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;

/**
 * @author admin
 *
 */
public interface ICredentialTypeServiceMapper {

	CredentialTypeDAO MapcredentialTypeDAO(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);

	CreateCredentialTypeResMsgEntity mapCreateCredentialTypeResMsgEntity(Result result,CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity);

	CreateCredentialTypeResMsgEntity mapCreateCredentialTypeResMsgEntity(Result result, Status badRequest);

}
