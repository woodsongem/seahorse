/**
 * 
 */
package seahorse.internal.business.katavuccolservice.processors;

/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceProcessor implements IKatavuccolServiceProcessor {
	
	/*private final IKatavuccolServiceErrorCode katavuccolServiceErrorCode;
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
	public Result processorDeleteCredential(DeleteCredentialMessageEntity deleteCredentialMessageEntity) {
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
		Result result=getDecryptCredentialValue(getCredentialValueMessageEntity);
		if(result.getResultStatus() != ResultStatus.SUCCESS)
		{
			return new Result(ResultStatus.ERROR);
		}
		
		return new Result(ResultStatus.SUCCESS);
	}

	public Result getDecryptCredentialValue(GetCredentialValueMessageEntity getCredentialValueMessageEntity) {
			String decryptCredentialValue=seahorse.internal.business.katavuccolservice.utilities.KatavuccolServiceUtility
							.decrypt(
									KatavuccolEncryption.decrypt(getCredentialValueMessageEntity.getCredential().getEncryptKey(),5),									 
									getCredentialValueMessageEntity.getCredential().getValue(),
									KatavuccolEncryption.decrypt(getCredentialValueMessageEntity.getCredential().getUserEncryptKey(),5));
		
			getCredentialValueMessageEntity.getCredential().setDecryptValue(decryptCredentialValue);
		return new Result(ResultStatus.SUCCESS);
	}*/
	
}
