/**
 * 
 */
package seahorse.internal.business.credentialtypeservice;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import com.google.common.collect.FluentIterable;
import com.google.inject.Inject;

import seahorse.internal.business.credentialtypeservice.datacontracts.CreateCredentialTypeMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByIdMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeByUserIdMsgEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.CredentialTypeRequestMessageEntity;
import seahorse.internal.business.credentialtypeservice.datacontracts.DeleteCredentialTypeReqMsgEntity;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialTypeDAO;
import seahorse.internal.business.profileservice.datacontracts.UserProfileMsgEntity;

/**
 * @author admin
 *
 */
public class CredentialTypeServiceVerifier implements ICredentialTypeServiceVerifier {

	private final IBaseCredentialTypeService baseCredentialTypeService;
	private final IKatavuccolServiceErrorCode katavuccolServiceErrorCode;
	private final ICredentialTypeServiceRepository credentialTypeServiceRepository;

	@Inject
	public CredentialTypeServiceVerifier(IBaseCredentialTypeService baseCredentialTypeService,
			IKatavuccolServiceErrorCode katavuccolServiceErrorCode,
			ICredentialTypeServiceRepository credentialTypeServiceRepository) {
		this.baseCredentialTypeService = baseCredentialTypeService;
		this.katavuccolServiceErrorCode = katavuccolServiceErrorCode;
		this.credentialTypeServiceRepository = credentialTypeServiceRepository;
	}

	@Override
	public Result verifyGetCredentialTypeByUserId(CredentialTypeByUserIdMsgEntity credentialTypeByUserId) {
		Result result = isUserIdValid(credentialTypeByUserId);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		return result;
	}

	@Override
	public Result verifyCreateCredentialType(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		Result result;

		result = isUserIdValid(createCredentialTypeMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		result = isNameValid(createCredentialTypeMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS, "", "", "");
	}

	@Override
	public Result verifyDeleteCredentialType(DeleteCredentialTypeReqMsgEntity deleteCredentialTypeReqMsgEntity) {
		Result result;
		result = isUserIdValid(deleteCredentialTypeReqMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		result = isCredentialTypeIdValid(deleteCredentialTypeReqMsgEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS, "", "", "");
	}

	@Override
	public Result isUserIdValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		UserProfileMsgEntity userMessageEntity = baseCredentialTypeService.getUserDetailByUserId(createCredentialTypeMsgEntity.getParsedUserId());
		if (userMessageEntity == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UserId is invalid", "UserId",katavuccolServiceErrorCode.userIdNotFound());
		}

		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result verifyGetCredentialTypeById(CredentialTypeByIdMsgEntity credentialTypeByIdMsgEntity) {
		return null;
	}

	public Result isUserIdValid(CredentialTypeByUserIdMsgEntity credentialTypeByUserId) {
		UserProfileMsgEntity userMessageEntity = baseCredentialTypeService
				.getUserDetailByUserId(credentialTypeByUserId.getParsedUserId());
		if (userMessageEntity == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UserId is null", "UserId",
					katavuccolServiceErrorCode.userIdNotFound());
		}

		return new Result(ResultStatus.SUCCESS);
	}

	public Result isNameValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		List<CredentialTypeDAO> CredentialTypeDAOs = credentialTypeServiceRepository
				.getCredentialTypeDAOByUserId(createCredentialTypeMsgEntity.getParsedUserId(), false);
		List<CredentialTypeDAO> filterCredentialTypeDAOs = FluentIterable.from(CredentialTypeDAOs)
				.filter(x -> KatavuccolServiceUtility.isEqual(x.getName(), createCredentialTypeMsgEntity.getName()))
				.toList();
		if (filterCredentialTypeDAOs.isEmpty()) {
			return new Result(ResultStatus.SUCCESS);
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Duplicate credential Name is not allowed",
				"Name", katavuccolServiceErrorCode.nameDuplicatedNotAllowed());

	}

	public Result IsDefaultNameValid(CreateCredentialTypeMsgEntity createCredentialTypeMsgEntity) {
		List<CredentialTypeDAO> CredentialTypeDAOs = credentialTypeServiceRepository.getDefaultCredentialTypeDAO();
		List<CredentialTypeDAO> filterCredentialTypeDAOs = FluentIterable.from(CredentialTypeDAOs)
				.filter(x -> KatavuccolServiceUtility.isEqual(x.getName(), createCredentialTypeMsgEntity.getName()))
				.toList();
		if (filterCredentialTypeDAOs.isEmpty()) {
			return new Result(ResultStatus.SUCCESS);
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Duplicate credential Name is not allowed",
				"Name", katavuccolServiceErrorCode.nameDuplicatedNotAllowed());

	}

	@Override
	public Result isUserIdValid(CredentialTypeRequestMessageEntity credentialTypeRequestMessageEntity) {
		UserProfileMsgEntity userMessageEntity = baseCredentialTypeService
				.getUserDetailByUserId(credentialTypeRequestMessageEntity.getParsedUserId());
		if (userMessageEntity == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UserId is null", "UserId",
					katavuccolServiceErrorCode.userIdNotFound());
		}

		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isUserIdValid(DeleteCredentialTypeReqMsgEntity deleteCredentialTypeReqMsgEntity) {
		UserProfileMsgEntity userMessageEntity = baseCredentialTypeService
				.getUserDetailByUserId(deleteCredentialTypeReqMsgEntity.getParsedUserId());
		if (userMessageEntity == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UserId is null", "UserId",
					katavuccolServiceErrorCode.userIdNotFound());
		}

		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isCredentialTypeIdValid(DeleteCredentialTypeReqMsgEntity deleteCredentialTypeReqMsgEntity) {
		CredentialTypeDAO credentialTypeDAO = credentialTypeServiceRepository.getCredentialTypeDAOByUserIdAndId(
				deleteCredentialTypeReqMsgEntity.getParsedUserId(),
				deleteCredentialTypeReqMsgEntity.getParsedCredentialTypeId());

		if (credentialTypeDAO == null) {
			deleteCredentialTypeReqMsgEntity.setHttpStatus(Status.NOT_FOUND);
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Credential type is not found", "UserId",
					katavuccolServiceErrorCode.CredentialTypeIsNotFound());
		}

		return new Result(ResultStatus.SUCCESS);
	}

}
