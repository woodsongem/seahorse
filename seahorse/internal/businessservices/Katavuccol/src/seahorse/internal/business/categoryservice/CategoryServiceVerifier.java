/**
 * 
 */
package seahorse.internal.business.categoryservice;

import java.util.List;

import com.google.common.collect.FluentIterable;
import com.google.inject.Inject;

import seahorse.internal.business.categoryservice.datacontracts.*;
import seahorse.internal.business.katavuccolservice.common.IKatavuccolServiceErrorCode;
import seahorse.internal.business.katavuccolservice.common.KatavuccolServiceUtility;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;

/**
 * @author admin
 *
 */
public class CategoryServiceVerifier implements ICategoryServiceVerifier {

	private final IKatavuccolServiceErrorCode katavuccolServiceErrorCode;
	private final ICategoryServiceRepository categoryServiceRepository;
	private final ICategoryServiceMapper categoryServiceMapper;

	@Inject
	public CategoryServiceVerifier(
			IKatavuccolServiceErrorCode katavuccolServiceErrorCode,
			ICategoryServiceRepository categoryServiceRepository, 
			ICategoryServiceMapper categoryServiceMapper) {
		this.katavuccolServiceErrorCode = katavuccolServiceErrorCode;
		this.categoryServiceRepository = categoryServiceRepository;
		this.categoryServiceMapper = categoryServiceMapper;
	}

	@Override
	public Result verifyCreateCategory(CategoryRequestMessageEntity categoryRequestMessageEntity) {
		Result result;

		result = isUserIdValid(categoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		result = isNameValid(categoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS, "", "", "");
	}

	public Result isUserIdValid(CategoryRequestMessageEntity categoryRequestMessageEntity) {
		return new Result(ResultStatus.SUCCESS);
	}

	public Result isNameValid(CategoryRequestMessageEntity categoryRequestMessageEntity) {
		List<CategoryDAO> categoryDAOs = categoryServiceRepository
				.getCategoryDetailByUserId(categoryRequestMessageEntity.getParsedUserId());
		List<CategoryDAO> filterCategoryDAOs = FluentIterable.from(categoryDAOs)
				.filter(x -> KatavuccolServiceUtility.isEqual(x.getName(), categoryRequestMessageEntity.getName()))
				.toList();
		if (filterCategoryDAOs == null || filterCategoryDAOs.isEmpty()) {
			return new Result(ResultStatus.SUCCESS);
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Duplicate category anem is is not allowed",
				"Name", katavuccolServiceErrorCode.categoryNameDuplicateErrorCode());

	}

	@Override
	public Result verifyDeleteCategory(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		Result result;

		result = isUserIdValid(deleteCategoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isCategoryIdValid(deleteCategoryRequestMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS, "", "", "");
	}

	@Override
	public Result isCategoryIdValid(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		CategoryDAO categoryDAO = categoryServiceRepository.getCategoryDetailById(
				deleteCategoryRequestMessageEntity.getParsedCategoryId(),
				deleteCategoryRequestMessageEntity.getParsedUserId());
		if (categoryDAO == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Not able to find categoryid", "CategoryId",
					katavuccolServiceErrorCode.deleteCategoryIdNotFoundErrorCode());
		}
		deleteCategoryRequestMessageEntity.setCategory(categoryServiceMapper.mapCategoryMessageEntity(categoryDAO));

		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isUserIdValid(DeleteCategoryRequestMessageEntity deleteCategoryRequestMessageEntity) {
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result verifyUpdateCategory(UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		Result result;

		result = isUserIdValid(updateCategoryMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}

		result = isCategoryIdValid(updateCategoryMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		result = isNameValid(updateCategoryMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS, "", "", "");
	}

	@Override
	public Result isNameValid(UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		if (updateCategoryMessageEntity.getName() == null) {
			return new Result(ResultStatus.SUCCESS);
		}

		List<CategoryDAO> categoryDAOs = categoryServiceRepository
				.getCategoryDetailByUserId(updateCategoryMessageEntity.getParsedUserId());

		List<CategoryDAO> filterCategoryDAOs = FluentIterable.from(categoryDAOs)
				.filter(x -> KatavuccolServiceUtility.isEqual(x.getName(), updateCategoryMessageEntity.getName()))
				.toList();
		if (filterCategoryDAOs == null || filterCategoryDAOs.isEmpty()) {
			return new Result(ResultStatus.SUCCESS);
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Duplicate category name is is not allowed",
				"Name", katavuccolServiceErrorCode.updateCategoryNameDuplicateErrorCode());
	}

	@Override
	public Result isCategoryIdValid(UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		CategoryDAO categoryDAO = categoryServiceRepository.getCategoryDetailById(
				updateCategoryMessageEntity.getParsedCategoryId(), updateCategoryMessageEntity.getParsedUserId());
		if (categoryDAO == null) {
			return KatavuccolServiceUtility.getResult(ResultStatus.ERROR, "Not able to find categoryid", "CategoryId",
					katavuccolServiceErrorCode.updateCategoryIdNotFoundErrorCode());
		}
		updateCategoryMessageEntity.setCategory(categoryServiceMapper.mapCategoryMessageEntity(categoryDAO));
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result isUserIdValid(UpdateCategoryMessageEntity updateCategoryMessageEntity) {
		return new Result(ResultStatus.SUCCESS);
	}

	@Override
	public Result verifyGetCategory(GetCategoryMessageEntity getCategoryMessageEntity) {
		Result result;

		result = isUserIdValid(getCategoryMessageEntity);
		if (result.getResultStatus() != ResultStatus.SUCCESS) {
			return result;
		}
		return KatavuccolServiceUtility.getResult(ResultStatus.SUCCESS, "", "", "");
	}

	@Override
	public Result isUserIdValid(GetCategoryMessageEntity getCategoryMessageEntity) {
		return new Result(ResultStatus.SUCCESS);
	}
}
