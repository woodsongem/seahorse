/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;

import seahorse.internal.business.credentialtypeservice.api.datacontracts.CredentialTypeModel;
import seahorse.internal.business.credentialtypeservice.datacontracts.DeleteCredentialTypeReqMsgEntity;
import seahorse.internal.business.credentialtypeservice.external.datacontracts.UserProfileModelExAPI;
import seahorse.internal.business.credentialtypeservice.rest.datacontracts.GetUserProfileIGet;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;
import seahorse.internal.business.katavuccolservice.utilities.KatavuccolServiceUtility;
import seahorse.internal.business.profileservice.datacontracts.UserProfileMsgEntity;
import seahorse.internal.business.shared.aop.InjectLogger;
import seahorse.internal.business.shared.aop.datacontracts.ResultResponse;
import seahorse.internal.business.shared.katavuccol.IKatavuccolClient;


/**
 * @author admin
 *
 */
public class BaseCredentialTypeService implements IBaseCredentialTypeService {

	private final ICredentialTypeServiceRepository credentialTypeServiceRepository;
	private final ICredentialTypeServiceMapper credentialTypeServiceMapper;
	private final IKatavuccolClient katavuccolClient;
	
	@InjectLogger
	Logger logger;
	
	@Inject
	public BaseCredentialTypeService(
			ICredentialTypeServiceRepository credentialTypeServiceRepository,
			ICredentialTypeServiceMapper credentialTypeServiceMapper,
			IKatavuccolClient katavuccolClient)
	{
		this.credentialTypeServiceRepository=credentialTypeServiceRepository;
		this.credentialTypeServiceMapper=credentialTypeServiceMapper;
		this.katavuccolClient=katavuccolClient;
	}
	
	@Override
	public List<CredentialTypeModel> getCredentialTypeByUserId(UUID parsedUserId) {
		return credentialTypeServiceRepository.getCredentialTypeByUserId(parsedUserId, false);		
	}

	@Override
	public Result DeleteCredentialTypeByUserIdAndId(DeleteCredentialTypeReqMsgEntity deleteCredentialTypeReqMsgEntity) {
		CredentialTypeDAO credentialTypeDAO=credentialTypeServiceMapper.mapCredentialTypeDAO(deleteCredentialTypeReqMsgEntity);
		return credentialTypeServiceRepository.deleteCredentialType(credentialTypeDAO);
	}

	@Override
	public UserProfileMsgEntity getUserDetailByUserId(UUID parsedUserId) {
		GetUserProfileIGet getUserProfileIGet= credentialTypeServiceMapper.MapGetUserProfileIGet(parsedUserId);
		ResultResponse resultResponse=katavuccolClient.Get(getUserProfileIGet);
		UserProfileModelExAPI userProfileModelExAPI=KatavuccolServiceUtility.getGson().fromJson(resultResponse.getResponseText(),UserProfileModelExAPI.class);
		return credentialTypeServiceMapper.MapUserProfileMsgEntity(userProfileModelExAPI);
	}
}
