/**
 * 
 */
package seahorse.internal.business.katavuccolservice.api;

/**
 * @author sajanmje
 *
 */
public class KatavuccolServiceApiMapper implements IKatavuccolServiceApiMapper {

	/*@Override
	public CredentialResponse mapCredentialsResponse(CredentialResponseMessageEntity credentialsResMessageEntity) {
		CredentialResponse credentialsResponse=new CredentialResponse();
		if(credentialsResMessageEntity == null)
		{
			return credentialsResponse;
		}
		if(credentialsResMessageEntity.getId() != null)
		{
			credentialsResponse.setId(credentialsResMessageEntity.getId().toString());
		}
		if (credentialsResMessageEntity.getResultMessages() == null) {
			return credentialsResponse;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : credentialsResMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(resultMessageMS.getErrorCode());
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		credentialsResponse.setResultMessages(resultMessages);		
		
		return	credentialsResponse;
	}

	@Override
	public CredentialRequestMessageEntity mapCredentialRequestMessageEntity(CreateCredentialRequestModel credentialRequest,String userid,String categoryId, HttpServletRequest httpRequest) {
		CredentialRequestMessageEntity credentialRequestMessageEntity=new CredentialRequestMessageEntity();
		credentialRequestMessageEntity.setUserId(userid);		
		credentialRequestMessageEntity.setCategoryId(categoryId);		
		if(credentialRequest == null)
		{
			return credentialRequestMessageEntity;
		}		
		credentialRequestMessageEntity.setTypeId(credentialRequest.getTypeId());
		credentialRequestMessageEntity.setValue(credentialRequest.getValue());
		credentialRequestMessageEntity.setDescription(credentialRequest.getDescription());
		credentialRequestMessageEntity.setParentCredentialId(credentialRequest.getParentId());
		credentialRequestMessageEntity.setUserEncryptKey(credentialRequest.getEncryptKey());
		return credentialRequestMessageEntity;
	}

	@Override
	public GetCredentialMessageEntity mapGetCredentialMessageEntity(String userid,String categoryId, HttpServletRequest httpRequest) {
		GetCredentialMessageEntity getCredentialMessageEntity=new GetCredentialMessageEntity();
		getCredentialMessageEntity.setUserId(userid);
		getCredentialMessageEntity.setCategoryId(categoryId);
		return getCredentialMessageEntity;
	}

	@Override
	public List<Credential> mapCredential(GetCredentialsMessageEntity getCredentialsMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CredentialResponse mapCredentialsResponse(CredentialResponseMessageEntity credentialsResMessageEntity, CredentialRequestMessageEntity credentialMessageEntity) {
		CredentialResponse credentialsResponse=new CredentialResponse();
		if(credentialsResMessageEntity == null)
		{
			return credentialsResponse;
		}
		if(credentialsResMessageEntity.getId() != null)
		{
			credentialsResponse.setId(credentialsResMessageEntity.getId().toString());
		}
		if (credentialsResMessageEntity.getResultMessages() == null) {
			return credentialsResponse;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : credentialsResMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(String.format(resultMessageMS.getErrorCode(),credentialMessageEntity.getHttpMethod()));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		credentialsResponse.setResultMessages(resultMessages);		
		
		return	credentialsResponse;
	}



	@Override
	public UpdateCredentialResponse mapUpdateCredentialResponse(
			UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity,
			UpdateCredentialMessageEntity updateCredentialMessageEntity) {
		UpdateCredentialResponse updateCredentialResponse=new UpdateCredentialResponse();
		if(updateCredentialResponseMessageEntity == null)
		{
			return updateCredentialResponse;
		}		
		if (updateCredentialResponseMessageEntity.getResultMessages() == null) {
			return updateCredentialResponse;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : updateCredentialResponseMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(String.format(resultMessageMS.getErrorCode(),updateCredentialMessageEntity.getHttpMethod()));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		updateCredentialResponse.setResultMessages(resultMessages);		
		
		return	updateCredentialResponse;
	}

	@Override
	public DeleteCredentialMessageEntity mapDeleteCredentialRequestMessageEntity(String userid,String categoryId,String credentialId, HttpServletRequest httpRequest) {
		DeleteCredentialMessageEntity deleteCredentialRequestMessageEntity=new DeleteCredentialMessageEntity();
		deleteCredentialRequestMessageEntity.setUserId(userid);
		deleteCredentialRequestMessageEntity.setCategoryId(categoryId);
		deleteCredentialRequestMessageEntity.setCredentialId(credentialId);		
		return deleteCredentialRequestMessageEntity;
	}

	@Override
	public DeleteCredentialResponse mapDeleteCredentialResponse(
			DeleteCredentialResMsgEntity deleteCredentialResponseMessageEntity,
			DeleteCredentialMessageEntity deleteCredentialMessageEntity) {
		DeleteCredentialResponse deleteCredentialResponse=new DeleteCredentialResponse();
		if(deleteCredentialResponseMessageEntity == null || deleteCredentialResponseMessageEntity.getResultMessages() == null)
		{
			return deleteCredentialResponse;
		}		
		
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : deleteCredentialResponseMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(String.format(resultMessageMS.getErrorCode(),deleteCredentialMessageEntity.getHttpMethod()));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		deleteCredentialResponse.setResultMessages(resultMessages);		
		
		return	deleteCredentialResponse;
	}

	@Override
	public CategoryRequestMessageEntity mapCategoryRequestMessageEntity(CategoryRequest categoryRequest, String userid,HttpServletRequest httpRequest) {
		CategoryRequestMessageEntity categoryRequestMessageEntity=new CategoryRequestMessageEntity();
		categoryRequestMessageEntity.setUserId(userid);
		categoryRequestMessageEntity.setName(categoryRequest.getName());
		categoryRequestMessageEntity.setDescription(categoryRequest.getDescription());		
		return categoryRequestMessageEntity;
	}

	@Override
	public CategoryResponse mapCategoryResponse(CategoryResponseMessageEntity categoryResponseMessageEntity,CategoryRequestMessageEntity categoryMessageEntity) {
		CategoryResponse categoryResponse=new CategoryResponse();
		if(categoryResponseMessageEntity == null)
		{
			return categoryResponse;
		}
		if(categoryMessageEntity.getId() != null)
		{
			categoryResponse.setId(categoryMessageEntity.getId().toString());
		}
		if (categoryResponseMessageEntity.getResultMessages() == null) {
			return categoryResponse;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : categoryResponseMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(String.format(resultMessageMS.getErrorCode(),categoryMessageEntity.getHttpMethod()));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		categoryResponse.setResultMessages(resultMessages);		
		
		return	categoryResponse;
	}

	@Override
	public DeleteCategoryRequestMessageEntity mapDeleteCategoryRequestMessageEntity(String userid, String categoryId,HttpServletRequest httpRequest) {
		DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity=new DeleteCategoryRequestMessageEntity();
		deleteCategoryRequestMessageEntity.setUserId(userid);
		deleteCategoryRequestMessageEntity.setCategoryId(categoryId);
		return deleteCategoryRequestMessageEntity;
	}

	@Override
	public DeleteCategoryResponseModel mapDeleteCategoryResponse(
			DeleteCategoryResponseMessageEntity deleteCategoryResponseMessageEntity,
			DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		DeleteCategoryResponseModel deleteCategoryResponse=new DeleteCategoryResponseModel();
		if(deleteCategoryResponseMessageEntity == null || deleteCategoryResponseMessageEntity.getResultMessages() == null)
		{
			return deleteCategoryResponse;
		}		
		
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : deleteCategoryResponseMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(String.format(resultMessageMS.getErrorCode(),deleteCategoryRequestMessageEntity.getHttpMethod()));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		deleteCategoryResponse.setResultMessages(resultMessages);		
		
		return	deleteCategoryResponse;
	}

	@Override
	public UpdateCategoryMessageEntity mapUpdateCategoryRequestMessageEntity(
			UpdateCategoryRequestModel updateCategoryRequest, String userid, String categoryId,
			HttpServletRequest httpRequest) {
		UpdateCategoryMessageEntity updateCategoryMessageEntity=new UpdateCategoryMessageEntity();
		updateCategoryMessageEntity.setUserId(userid);
		updateCategoryMessageEntity.setCategoryId(categoryId);
		if(updateCategoryRequest ==null)
		{
			return updateCategoryMessageEntity;
		}
		updateCategoryMessageEntity.setName(updateCategoryRequest.getName());
		updateCategoryMessageEntity.setDescription(updateCategoryRequest.getDescription());
		return updateCategoryMessageEntity;
	}

	@Override
	public UpdateCategoryResponseModel mapUpdateCategoryResponse(
			UpdateCategoryResponseMessageEntity updateCategoryResponseMessageEntity,
			UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		UpdateCategoryResponseModel updateCategoryResponse=new UpdateCategoryResponseModel();
		if(updateCategoryResponseMessageEntity == null || updateCategoryResponseMessageEntity.getResultMessages() == null)
		{
			return updateCategoryResponse;
		}		
		
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : updateCategoryResponseMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(String.format(resultMessageMS.getErrorCode(),updateCategoryMessageEntity.getHttpMethod()));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		updateCategoryResponse.setResultMessages(resultMessages);		
		
		return	updateCategoryResponse;
	}

	@Override
	public CredentialTypeRequestMessageEntity mapCredentialTypeRequestMessageEntity(CreateCredentialTypeRequestModel credentialTypeRequest, String userid, HttpServletRequest httpRequest) {
		CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity=new CredentialTypeRequestMessageEntity();
		credentialTypeRequestMessageEntity.setUserId(userid);
		credentialTypeRequestMessageEntity.setName(credentialTypeRequest.getName());
		credentialTypeRequestMessageEntity.setDescription(credentialTypeRequest.getDescription());
		credentialTypeRequestMessageEntity.setIsDuplicationAllowed(credentialTypeRequest.getIsDuplicationAllowed());
		credentialTypeRequestMessageEntity.setIsSubitemAllowed(credentialTypeRequest.getIsSubitemAllowed());		
		return credentialTypeRequestMessageEntity;
	}


	@Override
	public UpdateCredentialTypeMessageEntity mapUpdateCredentialRequestMessageEntity(
			UpdateCredentialTypeRequestModel updateCredentialTypeRequest, String userid, String credentialId,
			HttpServletRequest httpRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateCredentialTypeResponseModel mapUpdateCredentialTypeResponse(
			UpdateCredentialResponseMessageEntity updateCredentialResponseMessageEntity,
			UpdateCredentialTypeMessageEntity updateCredentialTypeMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteCredentialTypeResponseModel mapDeleteCredentialTypeResponse(
			DeleteCredentialTypeResMsgEntity deleteCredentialTypeResMsgEntity,
			DeleteCredentialTypeReqMsgEntity deleteCredentialTypeReqMsgEntity) {
		DeleteCredentialTypeResponseModel deleteCredentialTypeResponse=new DeleteCredentialTypeResponseModel();
	
		if(deleteCredentialTypeReqMsgEntity.getResultMessages()== null)
		{
			return deleteCredentialTypeResponse;	
		}
		
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : deleteCredentialTypeReqMsgEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(String.format(resultMessageMS.getErrorCode(),deleteCredentialTypeReqMsgEntity.getHttpMethod(),"DeleteCredentialType"));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		deleteCredentialTypeResponse.setResultMessages(resultMessages);
		return deleteCredentialTypeResponse;
	}

	@Override
	public DeleteCredentialTypeReqMsgEntity mapDeleteCredentialTypeRequestMessageEntity(String userid,
			String credentialTypeId, HttpServletRequest httpRequest) {
		DeleteCredentialTypeReqMsgEntity deleteCredentialTypeRequestMessageEntity=new DeleteCredentialTypeReqMsgEntity();
		deleteCredentialTypeRequestMessageEntity.setUserId(userid);
		deleteCredentialTypeRequestMessageEntity.setCredentialTypeId(credentialTypeId);
		deleteCredentialTypeRequestMessageEntity.setHttpRequest(httpRequest);
		return deleteCredentialTypeRequestMessageEntity;
	}

	@Override
	public GetCategoryMessageEntity mapGetCategoryMessageEntity(String userid, HttpServletRequest httpRequest) {
		GetCategoryMessageEntity getCategoryMessageEntity=new GetCategoryMessageEntity();
		getCategoryMessageEntity.setUserId(userid);
		return getCategoryMessageEntity;
	}

	@Override
	public GetCredentialValueMessageEntity mapGetCredentialValueMessageEntity(String userid,String categoryId,String credentialId,HttpServletRequest httpRequest,GetCredentialValueRequest getCredentialValueRequest) {
		GetCredentialValueMessageEntity getCredentialValueMessageEntity=new GetCredentialValueMessageEntity();
		getCredentialValueMessageEntity.setUserId(userid);
		getCredentialValueMessageEntity.setCredentialId(credentialId);
		getCredentialValueMessageEntity.setCategoryId(categoryId);
		if(getCredentialValueRequest == null)
		{
			return getCredentialValueMessageEntity;
		}
		getCredentialValueMessageEntity.setKey(getCredentialValueMessageEntity.getKey());
		
		return getCredentialValueMessageEntity;
	}

	@Override
	public GetCredentialByUserIdMessageEntity mapGetCredentialByUserIdMessageEntity(String userid) {
		GetCredentialByUserIdMessageEntity getCredentialByUserIdMessageEntity=new GetCredentialByUserIdMessageEntity();
		getCredentialByUserIdMessageEntity.setUserId(userid);
		return getCredentialByUserIdMessageEntity;
	}

	@Override
	public CredentialTypeByUserIdMsgEntity mapCredentialTypeByUserIdMsgEntity(String userid) {
		CredentialTypeByUserIdMsgEntity credentialTypeByUserIdMsgEntity=new CredentialTypeByUserIdMsgEntity();
		credentialTypeByUserIdMsgEntity.setUserId(userid);
		return credentialTypeByUserIdMsgEntity;
	}

	@Override
	public CreateCredentialTypeMsgEntity mapCreateCredentialTypeMsgEntity(CreateCredentialTypeRequestModel credentialTypeRequest,
			String userid, HttpServletRequest httpRequest) {
		CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity=new CreateCredentialTypeMsgEntity();
		createCredentialTypeMsgEntity.setUserId(userid);		
		if(credentialTypeRequest == null)
		{
			return createCredentialTypeMsgEntity;
		}
		createCredentialTypeMsgEntity.setName(credentialTypeRequest.getName());
		createCredentialTypeMsgEntity.setDescription(credentialTypeRequest.getDescription());
		createCredentialTypeMsgEntity.setIsDuplicationAllowed(credentialTypeRequest.getIsDuplicationAllowed());
		createCredentialTypeMsgEntity.setIsSubitemAllowed(credentialTypeRequest.getIsSubitemAllowed());
		return createCredentialTypeMsgEntity;
	}



	@Override
	public CreateCredentialTypeResponseModel mapCredentialTypeResponse(
			CreateCredentialTypeResMsgEntity createCredentialTypeResMsgEntity,
			CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		CreateCredentialTypeResponseModel createCredentialTypeResponse=new CreateCredentialTypeResponseModel();
		
		if(createCredentialTypeResMsgEntity == null)
		{
			return createCredentialTypeResponse;
		}		
		if(createCredentialTypeResMsgEntity.getId() !=null)
		{
			createCredentialTypeResponse.setId(KatavuccolServiceUtility.getString(createCredentialTypeResMsgEntity.getId()));
		}
		
		if(createCredentialTypeResMsgEntity.getResultMessages() == null)
		{
			return	createCredentialTypeResponse;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (ResultMessage resultMessageMS : createCredentialTypeResMsgEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(MessageFormat.format(resultMessageMS.getErrorCode(),createCredentialTypeMsgEntity.getHttpMethod(),"CreateCredentialType"));
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		createCredentialTypeResponse.setResultMessages(resultMessages);		
		
		return	createCredentialTypeResponse;
	}

	@Override
	public CreateCredentialTypeResponseModel mapCredentialTypeResponse(
			CredentialTypeResponseMessageEntity credentialTypeResponseMessageEntity,
			CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CredentialTypeByUserIdMsgEntity mapCredentialTypeByUserIdMsgEntity(String userid, String id) {
		CredentialTypeByUserIdMsgEntity credentialTypeByUserIdMsgEntity=new CredentialTypeByUserIdMsgEntity();
		credentialTypeByUserIdMsgEntity.setUserId(userid);
		credentialTypeByUserIdMsgEntity.setId(id);
		return credentialTypeByUserIdMsgEntity;
	}
	*/
}
