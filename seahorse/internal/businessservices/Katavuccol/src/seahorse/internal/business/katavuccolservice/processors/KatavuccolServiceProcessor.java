/**
 * 
 */
package seahorse.internal.business.katavuccolservice.processors;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.datastax.driver.core.utils.UUIDs;
import com.google.common.collect.FluentIterable;
import com.google.inject.Inject;

import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.OutPutResponse;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.IKatavuccolServiceRepository;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.katavuccolservice.datacontracts.CategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.CredentialTypeRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCategoryRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.DeleteCredentialRequestMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCategoryMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.GetCredentialValueMessageEntity;
import seahorse.internal.business.katavuccolservice.datacontracts.UpdateCategoryMessageEntity;
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
	public Result processorCreateCredentials(CredentialRequestMessageEntity credentialsRequestMessageEntity) {		
		OutPutResponse outPutResponse=katavuccolServiceRepository.createCredential(credentialsRequestMessageEntity);
		if(outPutResponse.getResultStatus() != ResultStatus.SUCCESS)
		{
			return outPutResponse;
		}
		credentialsRequestMessageEntity.setId(outPutResponse.getId());
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result processorDeleteCredential(DeleteCredentialRequestMessageEntity deleteCredentialMessageEntity) {
		OutPutResponse outPutResponse=katavuccolServiceRepository.deleteCredential(deleteCredentialMessageEntity);
		if(outPutResponse.getResultStatus() != ResultStatus.SUCCESS)
		{
			return outPutResponse;
		}		
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
	
	public Result updateCredential(UpdateCredentialMessageEntity updateCredentialMessageEntity)
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
	public Result processorCreateCredentialType(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result processorCreateCategory(CategoryRequestMessageEntity categoryRequestMessageEntity) {		
		Result result;
		result=createCategory(categoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}
	
	public Result createCategory(CategoryRequestMessageEntity categoryRequestMessageEntity)
	{
		categoryRequestMessageEntity.setId(UUIDs.timeBased());
		OutPutResponse outPutResponse=katavuccolServiceRepository.createCategory(categoryRequestMessageEntity);
		if(outPutResponse.getResultStatus() != ResultStatus.SUCCESS)
		{
			return new Result(ResultStatus.ERROR);
		}
		
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result processorDeleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		Result result;
		result=deleteCategory(deleteCategoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}
	
	public Result deleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity)
	{
		OutPutResponse outPutResponse=katavuccolServiceRepository.deleteCategory(deleteCategoryRequestMessageEntity);
		if(outPutResponse.getResultStatus() != ResultStatus.SUCCESS)
		{
			return new Result(ResultStatus.ERROR);
		}
		
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result processorGetCategory(GetCategoryMessageEntity getCategoryMessageEntity) {
		Result result;
		result=getCategory(getCategoryMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}

	public Result getCategory(GetCategoryMessageEntity getCategoryMessageEntity) {
		List<CategoryDAO> categoryDAO=katavuccolServiceRepository.getCategoryDetailByUserId(getCategoryMessageEntity.getParsedUserId());
		if(categoryDAO==null || categoryDAO.isEmpty())
		{
			return new Result(ResultStatus.ERROR);
		}
		getCategoryMessageEntity.setCategory(categoryDAO);
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}

	@Override
	public Result processorUpdateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		Result result;
		result=updateCategory(updateCategoryMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS,"","","");
	}

	public Result updateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity) {		
		Result result=katavuccolServiceRepository.updateCategory(updateCategoryMessageEntity);
		if(result.getResultStatus() != ResultStatus.SUCCESS)
		{
			return new Result(ResultStatus.ERROR);
		}
		
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result processorGetCredentialValueByUserId(GetCredentialValueMessageEntity getCredentialValueMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
