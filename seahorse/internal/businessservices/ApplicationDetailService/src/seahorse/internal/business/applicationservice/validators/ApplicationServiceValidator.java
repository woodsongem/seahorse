/**
 * 
 */
package seahorse.internal.business.applicationservice.validators;

import java.util.UUID;

import com.google.inject.Inject;

import seahorse.internal.business.applicationservice.common.IReadPropertiesFile;
import seahorse.internal.business.applicationservice.constants.ApplicationServiceErrorCode;
import seahorse.internal.business.applicationservice.constants.IApplicationServiceErrorCode;
import seahorse.internal.business.applicationservice.datacontracts.ResultMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.ResultStatus;
import seahorse.internal.business.applicationservice.utilities.ApplicationServiceUtility;

/**
 * @author sajanmje
 *
 */
public class ApplicationServiceValidator implements IApplicationServiceValidator {

	private final IReadPropertiesFile readPropertiesFile;
	private final IApplicationServiceErrorCode applicationServiceErrorCode;

	@Inject
	public ApplicationServiceValidator(IReadPropertiesFile readPropertiesFile,IApplicationServiceErrorCode applicationServiceErrorCode) {
		this.readPropertiesFile = readPropertiesFile;
		this.applicationServiceErrorCode=applicationServiceErrorCode;
	}

	@Override
	public ResultMessageEntity ValidateApplicationByApplicationId(String applicationId) {

		return IsApplicationIdValid(applicationId);
	}

	public ResultMessageEntity IsApplicationIdValid(String applicationId) {		
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		try {
			UUID.fromString(applicationId);
		} catch(Exception ex)  {
			resultMessageEntity.SetResultStatus(ResultStatus.Error);
			resultMessageEntity.SetResultMessages(ApplicationServiceUtility.GetResultMessage(applicationServiceErrorCode.InValidApplicationIdErrorCode(), "ApplicationId"));
			return resultMessageEntity;
		}
		resultMessageEntity.SetResultStatus(ResultStatus.Success);
		return resultMessageEntity;
	}
}
