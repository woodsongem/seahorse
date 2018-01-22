/**
 * 
 */
package seahorse.internal.business.coldfishservice.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import seahorse.internal.business.coldfishservice.api.datacontracts.DeleteIncomeCategoryResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeCategory;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeCategoryRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeCategoryResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeDetail;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeDetailRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeDetailsResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeType;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeRequest;
import seahorse.internal.business.coldfishservice.api.datacontracts.IncomeTypeResponse;
import seahorse.internal.business.coldfishservice.api.datacontracts.ResultMessage;
import seahorse.internal.business.coldfishservice.common.datacontracts.BaseMessageEntity;
import seahorse.internal.business.coldfishservice.constants.Constant;
import seahorse.internal.business.coldfishservice.datacontracts.DeleteIncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.DeleteIncomeCategoryResponseMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.GetIncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryDetail;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryResponseMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeDetailResponseMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeResponseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceAPIMapper implements IColdFishServiceAPIMapper {

	public IncomeTypeMessageEntity mapIncomeTypeMessageEntity(IncomeTypeRequest incomeTypeRequest) {
		if (incomeTypeRequest == null)
			return null;
		IncomeTypeMessageEntity incomeTypeMessageEntity = new IncomeTypeMessageEntity();
		incomeTypeMessageEntity.setName(incomeTypeRequest.getName());
		incomeTypeMessageEntity.setDescription(incomeTypeRequest.getDescription());
		incomeTypeMessageEntity.setUserId(incomeTypeRequest.getUserId());
		incomeTypeMessageEntity.setCategory(incomeTypeRequest.getCategory());
		return incomeTypeMessageEntity;
	}

	public IncomeTypeResponse mapIncomeTypeResponse(IncomeTypeResponseMessageEntity incomeTypeResponseMessageEntity) {
		IncomeTypeResponse incomeTypeResponse = new IncomeTypeResponse();
		if (incomeTypeResponseMessageEntity.getId() != null) {
			incomeTypeResponse.setId(incomeTypeResponseMessageEntity.getId().toString());
		}		
		if (incomeTypeResponseMessageEntity.getResultMessages() == null) {
			return incomeTypeResponse;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessage resultMessageMS : incomeTypeResponseMessageEntity
				.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(resultMessageMS.getErrorCode());
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		incomeTypeResponse.setResultMessage(resultMessages);
		return incomeTypeResponse;
	}

	@Override
	public List<ResultMessage> mapResultMessages(List<ResultMessage> resultMessages, String httpmethod) {
		if (resultMessages == null)
			return resultMessages;
		for (ResultMessage resultMessage : resultMessages) {
			resultMessage.setErrorCode(resultMessage.getErrorCode().replaceAll("_httpmethod", httpmethod));
		}
		return resultMessages;
	}

	@Override
	public GetIncomeTypeMessageEntity mapGetIncomeTypeMessageEntity(String userid) {
		GetIncomeTypeMessageEntity getIncomeTypeMessageEntity = new GetIncomeTypeMessageEntity();
		getIncomeTypeMessageEntity.setUserId(userid);
		return getIncomeTypeMessageEntity;
	}

	@Override
	public IncomeTypeResponse mapIncomeTypeMessageEntity(List<IncomeTypeMessageEntity> incomeTypeMessageEntitys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IncomeType> mapIncomeTypes(List<IncomeTypeMessageEntity> incomeTypeMessageEntitys) {
		if (incomeTypeMessageEntitys == null || incomeTypeMessageEntitys.isEmpty()) {
			return Collections.emptyList();
		}
		List<IncomeType> incomeTypes = new ArrayList<>();
		for (IncomeTypeMessageEntity incomeTypeMessageEntity : incomeTypeMessageEntitys) {
			IncomeType incomeType = new IncomeType();
			incomeType.setCategory(incomeTypeMessageEntity.getCategory());
			//incomeType.setCreatedBy(incomeTypeMessageEntity.getCreatedBy());
			//incomeType.setCreatedDate(incomeTypeMessageEntity.getCreatedDate());
			incomeType.setDescription(incomeTypeMessageEntity.getDescription());
			if (incomeTypeMessageEntity.getId() != null) {
				incomeType.setId(incomeTypeMessageEntity.getId().toString());
			}
			incomeType.setName(incomeTypeMessageEntity.getName());
			incomeType.setStatus(incomeTypeMessageEntity.getStatus());
			incomeType.setUserId(incomeTypeMessageEntity.getUserId());
			incomeType.setIncometypecategory(incomeTypeMessageEntity.getIncometypecategory());
			incomeTypes.add(incomeType);
		}

		return incomeTypes;
	}

	@Override
	public IncomeDetailMessageEntity mapIncomeDetailMessageEntity(IncomeDetailRequest incomeDetailRequest) {
		if(incomeDetailRequest==null)
		{
			return null;
		}
		IncomeDetailMessageEntity incomeDetailMessageEntity=new IncomeDetailMessageEntity();
		incomeDetailMessageEntity.setAmount(incomeDetailRequest.getAmount());		
		incomeDetailMessageEntity.setDescription(incomeDetailRequest.getDescription());
		incomeDetailMessageEntity.setIncomeTypeId(incomeDetailRequest.getIncomeTypeId());
		incomeDetailMessageEntity.setUserId(incomeDetailRequest.getUserId());
		incomeDetailMessageEntity.setName(incomeDetailRequest.getName());		
		return incomeDetailMessageEntity;		
	}

	@Override
	public IncomeDetailsResponse mapIncomeDetailsResponse(IncomeDetailResponseMessageEntity incomeDetailResponseMessageEntity) {
		if(incomeDetailResponseMessageEntity == null)
		{
			return null;
		}
		IncomeDetailsResponse incomeDetailsResponse=new IncomeDetailsResponse();
		if(incomeDetailResponseMessageEntity.getId() !=null)
		{
			incomeDetailsResponse.setId(incomeDetailResponseMessageEntity.getId().toString());
		}
				
		if (incomeDetailResponseMessageEntity.getResultMessages() == null) {
			return incomeDetailsResponse;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessage resultMessageMS : incomeDetailResponseMessageEntity
				.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(resultMessageMS.getErrorCode());
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		incomeDetailsResponse.setResultMessage(resultMessages);
		
		return incomeDetailsResponse;
	}

	@Override
	public GetIncomeDetailMessageEntity mapGetincomeDetailMessageEntity(String userid) {
		GetIncomeDetailMessageEntity getIncomeDetailMessageEntity=new GetIncomeDetailMessageEntity();
		getIncomeDetailMessageEntity.setUserId(userid);
		return getIncomeDetailMessageEntity;		
	}

	@Override
	public List<IncomeDetail> mapIncomeDetail(List<IncomeDetailMessageEntity> incomeDetailMessageEntitys) {
		List<IncomeDetail> incomeDetails=new ArrayList<>();
		if(incomeDetailMessageEntitys== null)
		{
			return incomeDetails;
		}
		for (IncomeDetailMessageEntity incomeDetailMessageEntity : incomeDetailMessageEntitys) {
			IncomeDetail incomeDetail=new IncomeDetail();
			incomeDetail.setAmount(incomeDetailMessageEntity.getAmount());
			incomeDetail.setCategory(incomeDetailMessageEntity.getCategory());
			incomeDetail.setDescription(incomeDetailMessageEntity.getDescription());
			incomeDetail.setId(incomeDetailMessageEntity.getId().toString());
			incomeDetail.setStatus(incomeDetailMessageEntity.getStatus());
			incomeDetail.setIncomeTypeName(incomeDetailMessageEntity.getIncomeTypeName());			
			incomeDetails.add(incomeDetail);
		}		
		return incomeDetails;
	}

	@Override
	public IncomeCategoryMessageEntity mapIncomeCategoryMessageEntity(IncomeCategoryRequest incomeCategoryRequest,Map<String, String> headers) {
		if(incomeCategoryRequest==null)
		{
			return null; 
		}
		IncomeCategoryMessageEntity incomeCategoryMessageEntity=new IncomeCategoryMessageEntity();
		incomeCategoryMessageEntity.setDescription(incomeCategoryRequest.getDescription());
		incomeCategoryMessageEntity.setName(incomeCategoryRequest.getName());
		incomeCategoryMessageEntity.setUserId(incomeCategoryRequest.getUserId());
		incomeCategoryMessageEntity.setIncomeMonth(incomeCategoryRequest.getIncomeMonth());
		incomeCategoryMessageEntity.setIncomeYear(incomeCategoryRequest.getIncomeyear());
		incomeCategoryMessageEntity.setStatus(incomeCategoryRequest.getStatus());
		incomeCategoryMessageEntity.setAmount(incomeCategoryRequest.getAmount());
		incomeCategoryMessageEntity.setParentid(incomeCategoryRequest.getParentid());
		
		BaseMessageEntity baseMessageEntity=new BaseMessageEntity();
		for (Map.Entry<String, String> entry : headers.entrySet())
		{
			if(Constant.IPADDRESS==	entry.getKey())
			{
				baseMessageEntity.setIpAddress(entry.getValue());
			}			
		}
		
		return incomeCategoryMessageEntity;
	}

	@Override
	public IncomeCategoryResponse mapIncomeCategoryResponse(IncomeCategoryResponseMessageEntity incomeCategoryResponseMessageEntity) {
		IncomeCategoryResponse incomeCategoryResponse = new IncomeCategoryResponse();
		if(incomeCategoryResponseMessageEntity==null)
		{
			return incomeCategoryResponse;
		}
		
		if (incomeCategoryResponseMessageEntity.getId() != null) {
			incomeCategoryResponse.setId(incomeCategoryResponseMessageEntity.getId().toString());
		}
		
		if (incomeCategoryResponseMessageEntity.getResultMessages() == null) {
			return incomeCategoryResponse;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessage resultMessageMS : incomeCategoryResponseMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(resultMessageMS.getErrorCode());
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		incomeCategoryResponse.setResultMessage(resultMessages);
		return incomeCategoryResponse;
	}

	@Override
	public DeleteIncomeCategoryMessageEntity mapDeleteIncomeCategoryMessageEntity(String incomecategoryid,Map<String, String> headers) {		
		DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity=new DeleteIncomeCategoryMessageEntity();
		if(StringUtils.isBlank(incomecategoryid))
		{
			return deleteIncomeCategoryMessageEntity;
		}
		deleteIncomeCategoryMessageEntity.setId(incomecategoryid);
		return deleteIncomeCategoryMessageEntity;
	}

	@Override
	public DeleteIncomeCategoryResponse mapDeleteIncomeCategoryResponse(DeleteIncomeCategoryResponseMessageEntity deleteIncomeCategoryResponseMessageEntity) {
		DeleteIncomeCategoryResponse deleteIncomeCategoryResponse=new DeleteIncomeCategoryResponse();
		if(deleteIncomeCategoryResponseMessageEntity==null)
		{
			return deleteIncomeCategoryResponse;
		}
		if (deleteIncomeCategoryResponseMessageEntity.getResultMessages() == null) {
			return deleteIncomeCategoryResponse;
		}
		List<ResultMessage> resultMessages = new ArrayList<>();
		for (seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessage resultMessageMS : deleteIncomeCategoryResponseMessageEntity.getResultMessages()) {
			ResultMessage resultMessage = new ResultMessage();
			resultMessage.setErrorCode(resultMessageMS.getErrorCode());
			resultMessage.setParameter(resultMessageMS.getParameter());
			resultMessages.add(resultMessage);
		}
		deleteIncomeCategoryResponse.setResultMessage(resultMessages);
		return deleteIncomeCategoryResponse;		
	}

	@Override
	public GetIncomeCategoryMessageEntity mapGetIncomeCategory(String userid, int incomeyear, String incomemonth,Map<String, String> headers) {	
		GetIncomeCategoryMessageEntity getIncomeCategoryMessageEntity=new GetIncomeCategoryMessageEntity();
		getIncomeCategoryMessageEntity.setUserId(userid);
		getIncomeCategoryMessageEntity.setIncomeMonth(incomemonth);
		getIncomeCategoryMessageEntity.setIncomeYear(incomeyear);
		getIncomeCategoryMessageEntity.setHeaders(headers);
		return getIncomeCategoryMessageEntity;
	}

	@Override
	public List<IncomeCategory> mapIncomeCategory(List<IncomeCategoryMessageEntity> incomeCategoryMessageEntities) {
		List<IncomeCategory> incomeCategorys=new ArrayList<>();
		if(incomeCategoryMessageEntities.isEmpty())
		{
			return incomeCategorys;
		}
		for (IncomeCategoryMessageEntity incomeCategoryMessageEntity : incomeCategoryMessageEntities) {
			IncomeCategory incomeCategory1=new IncomeCategory();
			incomeCategory1.setAmount(incomeCategoryMessageEntity.getAmount());
			incomeCategory1.setDescription(incomeCategoryMessageEntity.getDescription());
			incomeCategory1.setCreatedDate(incomeCategoryMessageEntity.getCreatedDate());
			incomeCategory1.setId(incomeCategoryMessageEntity.getId().toString());
			incomeCategory1.setIncomeMonth(incomeCategoryMessageEntity.getIncomeMonth());
			incomeCategory1.setIncomeYear(incomeCategoryMessageEntity.getIncomeYear());
			incomeCategory1.setModifiedDate(incomeCategoryMessageEntity.getModifiedDate());
			incomeCategory1.setName(incomeCategoryMessageEntity.getName());			
			incomeCategory1.setParentId(incomeCategoryMessageEntity.getParsedParentid().toString());
			incomeCategory1.setStatus(incomeCategoryMessageEntity.getStatus());
			incomeCategory1.setUserId(incomeCategoryMessageEntity.getParsedUserId().toString());			
			incomeCategorys.add(incomeCategory1);
		}
		return incomeCategorys;
	}
}
