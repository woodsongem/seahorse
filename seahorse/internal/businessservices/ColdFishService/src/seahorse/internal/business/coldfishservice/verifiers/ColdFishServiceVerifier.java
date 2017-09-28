/**
 * 
 */
package seahorse.internal.business.coldfishservice.verifiers;

import java.util.List;
import org.apache.logging.log4j.Logger;
import com.google.inject.Inject;
import seahorse.internal.business.coldfishservice.common.datacontracts.IColdFishServiceErrorCode;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultMessageEntity;
import seahorse.internal.business.coldfishservice.common.datacontracts.ResultStatus;
import seahorse.internal.business.coldfishservice.dal.IColdFishServiceRepository;
import seahorse.internal.business.coldfishservice.dal.datacontracts.IncometypeDAO;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeTypeMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.coldfishservice.processors.datacontracts.UserCredentialMessageEntity;
import seahorse.internal.business.coldfishservice.utilities.ColdFishServiceUtility;
import seahorse.internal.business.shared.aop.InjectLogger;

/**
 * @author sajanmje
 *
 */
public class ColdFishServiceVerifier implements IColdFishServiceVerifier {

	private final IColdFishServiceVerifierMapper coldFishServiceVerifierMapper;
	private final IColdFishServiceErrorCode coldFishServiceErrorCode;
	private final IColdFishServiceRepository coldFishServiceRepository;

	@InjectLogger
	Logger logger;

	@Inject
	public ColdFishServiceVerifier(IColdFishServiceVerifierMapper coldFishServiceVerifierMapper,
			IColdFishServiceErrorCode coldFishServiceErrorCode, IColdFishServiceRepository coldFishServiceRepository) {
		this.coldFishServiceVerifierMapper = coldFishServiceVerifierMapper;
		this.coldFishServiceErrorCode = coldFishServiceErrorCode;
		this.coldFishServiceRepository = coldFishServiceRepository;

	}

	@Override
	public ResultMessageEntity VerifyCreateIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = IsUserIdValid(incomeTypeMessageEntity);
		if (resultMessageEntity.GetResultStatus() != ResultStatus.Success) {
			return resultMessageEntity;
		}

		resultMessageEntity = IsNameValid(incomeTypeMessageEntity);
		if (resultMessageEntity.GetResultStatus() != ResultStatus.Success) {
			return resultMessageEntity;
		}

		return ColdFishServiceUtility.GetResultMessageEntity("", "", ResultStatus.Success);
	}

	public ResultMessageEntity IsUserIdValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		LoginDetailMessageEntity loginDetailMessageEntity = coldFishServiceVerifierMapper
				.MapLoginDetailMessageEntity(incomeTypeMessageEntity);
		UserCredentialMessageEntity userCredentialMessageEntity = coldFishServiceRepository
				.getUserCredential(loginDetailMessageEntity);
		if (userCredentialMessageEntity == null) {
			resultMessageEntity.SetResultStatus(ResultStatus.Error);
			resultMessageEntity.SetResultMessages(
					ColdFishServiceUtility.GetResultMessage(coldFishServiceErrorCode.InValidUserIdErrorCode(), null));
			return resultMessageEntity;
		}
		return resultMessageEntity;
	}

	public ResultMessageEntity IsNameValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {

		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		resultMessageEntity.SetResultStatus(ResultStatus.Success);
		List<IncometypeDAO> incometypeDAOs = coldFishServiceRepository.getDefaultIncometype();

		if (incometypeDAOs != null && incometypeDAOs.stream()
				.anyMatch(x -> x.Name.equals(incomeTypeMessageEntity.name) && x.Status.equals("ACTIVE"))) {
			
			return ColdFishServiceUtility.GetResultMessageEntity(
					coldFishServiceErrorCode.DuplicateIncomeTypeInDefault(), "IncomeTypeMessageEntity.Name",
					ResultStatus.Error);
		}
		incometypeDAOs = coldFishServiceRepository.getIncometypeByUserId(incomeTypeMessageEntity.UserId);

		if (incometypeDAOs != null && incometypeDAOs.stream()
				.anyMatch(x -> x.Name.equals(incomeTypeMessageEntity.name) && x.Status.equals("ACTIVE"))) {
			
			return ColdFishServiceUtility.GetResultMessageEntity(coldFishServiceErrorCode.DuplicateIncomeType(),
					"IncomeTypeMessageEntity.Name", ResultStatus.Error);
		}
		return resultMessageEntity;
	}
}
