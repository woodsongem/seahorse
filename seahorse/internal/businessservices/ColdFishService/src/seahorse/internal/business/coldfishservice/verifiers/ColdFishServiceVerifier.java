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
import seahorse.internal.business.coldfishservice.dal.datacontracts.UserCredentialDAO;
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
	public ResultMessageEntity verifyCreateIncomeType(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		ResultMessageEntity resultMessageEntity;

		resultMessageEntity = isUserIdValid(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		resultMessageEntity = isNameValid(incomeTypeMessageEntity);
		if (resultMessageEntity.getResultStatus() != ResultStatus.SUCCESS) {
			return resultMessageEntity;
		}

		return ColdFishServiceUtility.getResultMessageEntity("", "", ResultStatus.SUCCESS);
	}

	public ResultMessageEntity isUserIdValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		LoginDetailMessageEntity loginDetailMessageEntity = coldFishServiceVerifierMapper.mapLoginDetailMessageEntity(incomeTypeMessageEntity);
		UserCredentialDAO userCredentialDAO = coldFishServiceRepository.getUserCredential(loginDetailMessageEntity);
		if (userCredentialDAO == null) {
			resultMessageEntity.setResultStatus(ResultStatus.ERROR);
			resultMessageEntity.setResultMessages(ColdFishServiceUtility.getResultMessage(coldFishServiceErrorCode.inValidUserIdErrorCode(), null));
			return resultMessageEntity;
		}
		UserCredentialMessageEntity userCredentialMessageEntity=coldFishServiceVerifierMapper.MapUserCredentialMessageEntity(userCredentialDAO);
		incomeTypeMessageEntity.setUserCredentialDetails(userCredentialMessageEntity);
		return resultMessageEntity;
	}

	public ResultMessageEntity isNameValid(IncomeTypeMessageEntity incomeTypeMessageEntity) {

		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		resultMessageEntity.setResultStatus(ResultStatus.SUCCESS);
		List<IncometypeDAO> incometypeDAOs = coldFishServiceRepository.getDefaultIncometype();

		if (incometypeDAOs != null && incometypeDAOs.stream()
				.anyMatch(x -> x.getName().equals(incomeTypeMessageEntity.getName()) && x.getStatus().equals("ACTIVE"))) {

			return ColdFishServiceUtility.getResultMessageEntity(
					coldFishServiceErrorCode.duplicateIncomeTypeInDefault(), "IncomeTypeMessageEntity.Name",
					ResultStatus.ERROR);
		}
		incometypeDAOs = coldFishServiceRepository.getIncometypeByUserId(incomeTypeMessageEntity.getUserId());

		if (incometypeDAOs != null && incometypeDAOs.stream()
				.anyMatch(x -> x.getName().equals(incomeTypeMessageEntity.getName()) && x.getStatus().equals("ACTIVE"))) {

			return ColdFishServiceUtility.getResultMessageEntity(coldFishServiceErrorCode.duplicateIncomeType(),
					"IncomeTypeMessageEntity.Name", ResultStatus.ERROR);
		}
		return resultMessageEntity;
	}
}
