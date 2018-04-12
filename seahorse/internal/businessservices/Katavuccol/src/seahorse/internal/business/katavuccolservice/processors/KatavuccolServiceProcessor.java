/**
 * 
 */
package seahorse.internal.business.katavuccolservice.processors;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.FluentIterable;
import com.google.inject.Inject;

import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.IKatavuccolServiceRepository;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCredentialMessageEntity;


/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceProcessor implements IKatavuccolServiceProcessor {
	
	private final IKatavuccolServiceErrorCode katavuccolServiceErrorCode;
	private final IKatavuccolServiceRepository katavuccolServiceRepository;
	private final IKatavuccolServiceProcessorMapper katavuccolServiceProcessorMapper;
	
	@Inject
	public KatavuccolServiceProcessor(IKatavuccolServiceErrorCode katavuccolServiceErrorCode, 
			IKatavuccolServiceRepository katavuccolServiceRepository,
			IKatavuccolServiceProcessorMapper katavuccolServiceProcessorMapper)
	{
		this.katavuccolServiceErrorCode = katavuccolServiceErrorCode;
		this.katavuccolServiceRepository = katavuccolServiceRepository;
		this.katavuccolServiceProcessorMapper=katavuccolServiceProcessorMapper;
	}
	
	@Override
	public Result ProcessorCreateCredentials(CredentialRequestMessageEntity credentialsRequestMessageEntity) {		
		OutPutResponse outPutResponse=katavuccolServiceRepository.createCredential(credentialsRequestMessageEntity);
		if(outPutResponse.getResultStatus() != ResultStatus.SUCCESS)
		{
			return outPutResponse;
		}
		credentialsRequestMessageEntity.setId(outPutResponse.getId());
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result ProcessorDeleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		OutPutResponse outPutResponse=katavuccolServiceRepository.deleteCredential(deleteCredentialMessageEntity);
		if(outPutResponse.getResultStatus() != ResultStatus.SUCCESS)
		{
			return outPutResponse;
		}		
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result ProcessorUpdateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		Result result;

		result = UpdateCredential(updateCredentialMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}
	
	public Result UpdateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity)
	{		
		List<CredentialMessageEntity> credentialMessageEntites=
		FluentIterable
		.from(updateCredentialMessageEntity.getCredential())
		.filter(x-> KatavuccolServiceUtility.isEqual(x.getId(),updateCredentialMessageEntity.getParsedCredentialId()))
		.toList();
		
		CredentialMessageEntity credentialMessageEntity=credentialMessageEntites.get(0);
		
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
		
		OutPutResponse outPutResponse=katavuccolServiceRepository.updateCredential(updateCredentialMessageEntity);
		if(outPutResponse.getResultStatus() != ResultStatus.SUCCESS)
		{
			return outPutResponse;
		}		
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result ProcessorCreateCredentialType(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}
}
