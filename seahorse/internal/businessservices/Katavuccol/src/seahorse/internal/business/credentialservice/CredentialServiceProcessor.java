/**
 * 
 */
package seahorse.internal.business.credentialservice;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.FluentIterable;
import com.google.inject.Inject;

import seahorse.internal.business.credentialservice.dal.datacontracts.CredentialDAO;
import seahorse.internal.business.credentialservice.datacontracts.CreateCredentialRequestMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.CredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.DeleteCredentialMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.GetCredentialByUserIdMessageEntity;
import seahorse.internal.business.credentialservice.datacontracts.UpdateCredentialMessageEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeMessageEntity;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;

/**
 * @author admin
 *
 */
public class CredentialServiceProcessor implements ICredentialServiceProcessor {

	private final IKatavuccolServiceErrorCode katavuccolServiceErrorCode;
	private final ICredentialServiceRepository credentialServiceRepository;
	private final ICredentialServiceProcessorMapper credentialServiceProcessorMapper;
	
	@Inject
	public CredentialServiceProcessor(IKatavuccolServiceErrorCode katavuccolServiceErrorCode, 
			ICredentialServiceRepository credentialServiceRepository,
			ICredentialServiceProcessorMapper credentialServiceProcessorMapper)
	{
		this.katavuccolServiceErrorCode = katavuccolServiceErrorCode;
		this.credentialServiceRepository = credentialServiceRepository;
		this.credentialServiceProcessorMapper=credentialServiceProcessorMapper;
	}
	
	@Override
	public Result processorGetCredentialsByUserId(GetCredentialByUserIdMessageEntity getCredentialByUserIdMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result processorCreateCredentials(CreateCredentialRequestMessageEntity credentialRequestMessageEntity) {
		Result result=createCredential(credentialRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return new Result(ResultStatus.SUCCESS);
	}
	
	@Override
	public Result processorDeleteCredential(DeleteCredentialMessageEntity deleteCredentialMessageEntity) {
		Result result=deleteCredential(deleteCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return new Result(ResultStatus.SUCCESS);
	}
	
	@Override
	public Result deleteCredential(DeleteCredentialMessageEntity deleteCredentialMessageEntity)
	{
		OutPutResponse outPutResponse=credentialServiceRepository.deleteCredential(deleteCredentialMessageEntity);
		if(outPutResponse.getResultStatus() != ResultStatus.SUCCESS)
		{
			return outPutResponse;
		}		
		return new Result(ResultStatus.SUCCESS);
	}
	
	@Override
	public Result createCredential(CreateCredentialRequestMessageEntity credentialRequestMessageEntity)
	{
		OutPutResponse outPutResponse=credentialServiceRepository.createCredential(credentialRequestMessageEntity);
		if(outPutResponse.getResultStatus() != ResultStatus.SUCCESS)
		{
			return outPutResponse;
		}
		credentialRequestMessageEntity.setId(outPutResponse.getId());
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result processorUpdateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		Result result;

		result = updateCredential(updateCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}
	
	@Override
	public Result updateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity)
	{		
		List<CredentialDAO> credentialMessageEntites=
		FluentIterable
		.from(updateCredentialMessageEntity.getCredential())
		.filter(x-> KatavuccolServiceUtility.isEqual(x.getId(),updateCredentialMessageEntity.getParsedCredentialId()))
		.toList();
		
		CredentialDAO credentialMessageEntity=credentialMessageEntites.get(0);
		
		if(StringUtils.isEmpty(updateCredentialMessageEntity.getDescription()))
		{
			updateCredentialMessageEntity.setDescription(credentialMessageEntity.getDescription());
		}
		
		if(updateCredentialMessageEntity.getParsedCredentialTypeId() == null)
		{
			updateCredentialMessageEntity.setParsedCredentialTypeId(credentialMessageEntity.getCredentialTypeId());
		}
		
		if(updateCredentialMessageEntity.getValue() == null)
		{
			updateCredentialMessageEntity.setValue(credentialMessageEntity.getValue());
		}
		
		OutPutResponse outPutResponse=credentialServiceRepository.updateCredential(updateCredentialMessageEntity);
		if(outPutResponse.getResultStatus() != ResultStatus.SUCCESS)
		{
			return outPutResponse;
		}		
		return new Result(ResultStatus.SUCCESS);
	}

	

}
