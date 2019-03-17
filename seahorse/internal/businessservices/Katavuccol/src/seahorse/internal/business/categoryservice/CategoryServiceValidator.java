/**
 * 
 */
package seahorse.internal.business.categoryservice;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import seahorse.internal.business.categoryservice.datacontracts.*;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.profileservice.IProfileServiceValidator;

/**
 * @author admin
 *
 */
public class CategoryServiceValidator implements ICategoryServiceValidator {
	
	private final IKatavuccolServiceErrorCode katavuccolServiceErrorCode;
	private final IProfileServiceValidator profileServiceValidator;

	@Inject
	public CategoryServiceValidator(IKatavuccolServiceErrorCode katavuccolServiceErrorCode,
			IProfileServiceValidator profileServiceValidator) {
		this.katavuccolServiceErrorCode = katavuccolServiceErrorCode;
		this.profileServiceValidator = profileServiceValidator;
	}

	@Override
	public Result validateCreateCategory(CreateCategoryMessageEntity categoryRequestMessageEntity) {
		Result result;

		result = isCategoryRequestMessageEntityValid(categoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isUserIdValid(categoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isNameValid(categoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		return new Result(ResultStatus.SUCCESS);
	}

	public Result isCategoryRequestMessageEntityValid(CreateCategoryMessageEntity categoryRequestMessageEntity) {
		Result result = new Result(ResultStatus.SUCCESS);

		if (categoryRequestMessageEntity == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "CategoryRequestMessageEntity is null",
					"CategoryRequestMessageEntity", katavuccolServiceErrorCode.createCredentialTypeMsgEntityIsEmpty());
		}

		return result;
	}

	public Result isCategoryIdValid(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		if (deleteCategoryRequestMessageEntity.getCategoryId() == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "CategoryId is null", "CategoryId",
					katavuccolServiceErrorCode.deleteCategoryIdEmptyErrorCode());
		}
		if (KatavuccolServiceUtility.isValidUUID(deleteCategoryRequestMessageEntity.getCategoryId())) {
			deleteCategoryRequestMessageEntity
					.setParsedCategoryId(UUID.fromString(deleteCategoryRequestMessageEntity.getCategoryId()));
			return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS, "", "", "");
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "CategoryId is inValid", "CategoryId",
				katavuccolServiceErrorCode.deleteCategoryIdInValidErrorCode());
	}

	public Result isUserIdValid(CreateCategoryMessageEntity categoryRequestMessageEntity) {
		Result result;

		result = isUserIdValid(categoryRequestMessageEntity.getUserId(),
				katavuccolServiceErrorCode.createCategoryInValidUserIdErrorCode(),
				katavuccolServiceErrorCode.createCategoryEmptyUserIdErrorCode());
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		categoryRequestMessageEntity.setParsedUserId(UUID.fromString(categoryRequestMessageEntity.getUserId()));
		categoryRequestMessageEntity.setCreatedBy(categoryRequestMessageEntity.getParsedUserId());
		return result;
	}

	public Result isUserIdValid(String userId, String errorCode, String nullErrorCode) {
		Result result = new Result();
		result.setResultStatus(ResultStatus.SUCCESS);
		if (StringUtils.isBlank(userId)) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UserId is null", "UserId", nullErrorCode);
		}

		if (KatavuccolServiceUtility.isValidUUID(userId)) {
			return result;
		}

		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Invalid user id", "UserId", errorCode);
	}

	public Result isNameValid(CreateCategoryMessageEntity categoryRequestMessageEntity) {
		Result result = new Result(ResultStatus.SUCCESS);

		if (StringUtils.isEmpty(categoryRequestMessageEntity.getName())) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "categoryRequestMessageEntity is null",
					"CategoryRequestMessageEntity", katavuccolServiceErrorCode.createCategoryNameIsEmptyErrorCode());
		}

		return result;
	}

	@Override
	public Result validateDeleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		Result result;

		result = isDeleteCategoryRequestMessageEntityValid(deleteCategoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		result = isUserIdValid(deleteCategoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		result = isCategoryIdValid(deleteCategoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isDeleteCategoryRequestMessageEntityValid(
			DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		Result result = new Result(ResultStatus.SUCCESS);

		if (deleteCategoryRequestMessageEntity == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "DeleteCategoryRequestMessageEntity is null",
					"DeleteCategoryRequestMessageEntity",
					katavuccolServiceErrorCode.deleteCategoryRequestMessageEntityIsEmptyErrorCode());
		}

		return result;
	}

	@Override
	public Result isUserIdValid(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		Result result;

		result = isUserIdValid(deleteCategoryRequestMessageEntity.getUserId(),
				katavuccolServiceErrorCode.deleteCategoryInValidUserIdErrorCode(),
				katavuccolServiceErrorCode.deleteCategoryEmptyUserIdErrorCode());
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		deleteCategoryRequestMessageEntity
				.setParsedUserId(UUID.fromString(deleteCategoryRequestMessageEntity.getUserId()));
		deleteCategoryRequestMessageEntity.setModifiedBy(deleteCategoryRequestMessageEntity.getParsedUserId());
		return result;
	}

	@Override
	public Result validateUpdateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		Result result;

		result = isUpdateCategoryMessageEntityValid(updateCategoryMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isUserIdValid(updateCategoryMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		result = isCategoryIdValid(updateCategoryMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isUserIdValid(UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		Result result;

		result = isUserIdValid(updateCategoryMessageEntity.getUserId(),
				katavuccolServiceErrorCode.updateCategoryInValidUserIdErrorCode(),
				katavuccolServiceErrorCode.updateCategoryEmptyUserIdErrorCode());
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		updateCategoryMessageEntity.setParsedUserId(UUID.fromString(updateCategoryMessageEntity.getUserId()));
		updateCategoryMessageEntity.setModifiedBy(updateCategoryMessageEntity.getParsedUserId());
		return result;
	}

	@Override
	public Result isUpdateCategoryMessageEntityValid(UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		Result result = new Result(ResultStatus.SUCCESS);

		if (updateCategoryMessageEntity == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "UpdateCategoryMessageEntity is null",
					"UpdateCategoryMessageEntity",
					katavuccolServiceErrorCode.updateCategoryMessageEntityIsEmptyErrorCode());
		}

		return result;
	}

	@Override
	public Result isCategoryIdValid(UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		if (updateCategoryMessageEntity.getCategoryId() == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "CategoryId is null", "CategoryId",
					katavuccolServiceErrorCode.updateCategoryIdEmptyErrorCode());
		}
		if (KatavuccolServiceUtility.isValidUUID(updateCategoryMessageEntity.getCategoryId())) {
			updateCategoryMessageEntity
					.setParsedCategoryId(UUID.fromString(updateCategoryMessageEntity.getCategoryId()));
			return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS, "", "", "");
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "CategoryId is inValid", "CategoryId",
				katavuccolServiceErrorCode.updateCategoryInCategoryIdInValidErrorCode());
	}

	@Override
	public Result validateGetCategory(GetCategoryMessageEntity getCategoryMessageEntity) {
		Result result;

		result = isGetCategoryMessageEntityValid(getCategoryMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		result = isUserIdValid(getCategoryMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isGetCategoryMessageEntityValid(GetCategoryMessageEntity getCategoryMessageEntity) {
		Result result = new Result(ResultStatus.SUCCESS);

		if (getCategoryMessageEntity == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "GetCategoryMessageEntity is null",
					"GetCategoryMessageEntity", katavuccolServiceErrorCode.getCategoryMessageEntityIsEmptyErrorCode());
		}

		return result;
	}

	@Override
	public Result isUserIdValid(GetCategoryMessageEntity getCategoryMessageEntity) {
		Result result;

		result = isUserIdValid(getCategoryMessageEntity.getUserId(),
				katavuccolServiceErrorCode.getCategoryInValidUserIdErrorCode(),
				katavuccolServiceErrorCode.getCategoryEmptyUserIdErrorCode());
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		getCategoryMessageEntity.setParsedUserId(UUID.fromString(getCategoryMessageEntity.getUserId()));
		getCategoryMessageEntity.setModifiedBy(getCategoryMessageEntity.getParsedUserId());
		return result;
	}
}
