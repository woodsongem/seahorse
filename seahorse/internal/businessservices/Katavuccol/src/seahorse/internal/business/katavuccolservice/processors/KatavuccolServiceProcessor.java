/**
 * 
 */
package seahorse.internal.business.katavuccolservice.processors;

import com.google.inject.Inject;

import seahorse.internal.business.katavuccolservice.api.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.IKatavuccolServiceRepository;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
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
		OutPutResponse outPutResponse=katavuccolServiceRepository.updateCredential(updateCredentialMessageEntity);
		if(outPutResponse.getResultStatus() != ResultStatus.SUCCESS)
		{
			return outPutResponse;
		}		
		return new Result(ResultStatus.SUCCESS);
	}
}
