/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.List;

import com.google.inject.Inject;

import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByIdMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByUserIdMsgEntity;
import seahorse.internal.business.katavuccolservice.api.datacontracts.CredentialTypeModel;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;

/**
 * @author admin
 *
 */
public class CredentialTypeServiceVerifier implements ICredentialTypeServiceVerifier {
	private final IBaseCredentialTypeService  baseCredentialTypeService;
	

	@Inject
	public CredentialTypeServiceVerifier(IBaseCredentialTypeService  baseCredentialTypeService)
	{
		this.baseCredentialTypeService=baseCredentialTypeService;
	}
	
	@Override
	public Result verifyGetCredentialTypeByUserId(CredentialTypeByUserIdMsgEntity credentialTypeByUserId) {
		List<CredentialTypeModel> credentialTypeModel=baseCredentialTypeService.getCredentialTypeByUserId(credentialTypeByUserId.getParsedUserId());
		return null;
	}

	@Override
	public Result verifyGetCredentialTypeById(CredentialTypeByIdMsgEntity credentialTypeByIdMsgEntity) {		
		return null;
	}

}
