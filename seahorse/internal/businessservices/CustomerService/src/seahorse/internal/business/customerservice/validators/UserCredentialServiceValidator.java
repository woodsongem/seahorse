/**
 * 
 */
package seahorse.internal.business.customerservice.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seahorse.internal.business.applicationservice.utilities.CustomerServiceUtility;
import seahorse.internal.business.customerservice.common.IReadPropertiesFile;
import seahorse.internal.business.customerservice.common.SeahorseUtilities;
import seahorse.internal.business.customerservice.constants.CustomerServiceErrorCode;
import seahorse.internal.business.customerservice.constants.ICustomerServiceErrorCode;
import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultStatus;

/**
 * @author sajanmje
 *
 */
public class UserCredentialServiceValidator implements IUserCredentialServiceValidator {

	private ICustomerServiceErrorCode customerServiceErrorCode;
	private IReadPropertiesFile readPropertiesFile;

	public UserCredentialServiceValidator(ICustomerServiceErrorCode customerServiceErrorCode,
			IReadPropertiesFile readPropertiesFile) {
		this.customerServiceErrorCode = customerServiceErrorCode;
		this.readPropertiesFile = readPropertiesFile;
	}

	@Override
	public ResultMessageEntity ValidateLogin(LoginDetailMessageEntity loginDetailMessageEntity) {
		ResultMessageEntity resultMessageEntity=new ResultMessageEntity();
		
		return resultMessageEntity;
	}

	public ResultMessageEntity IsLoginDetailMessageEntityValid(LoginDetailMessageEntity loginDetailMessageEntity) {

		if (loginDetailMessageEntity == null) {
			return CustomerServiceUtility.GetResultMessageEntity(customerServiceErrorCode.InValidLoginDetailMessageEntityErrorCode(), "LoginDetailMessageEntity",ResultStatus.Error);
		}

		return CustomerServiceUtility.GetResultMessageEntity("", "", ResultStatus.Success);
	}

	public ResultMessageEntity IsUserNameValid(LoginDetailMessageEntity loginDetailMessageEntity) {
		
		if (SeahorseUtilities.isNullOrWhitespace(loginDetailMessageEntity.getUsername())) {
			return CustomerServiceUtility.GetResultMessageEntity(customerServiceErrorCode.EmptyUserNameErrorCode(),"UserName", ResultStatus.Error);
		}

		String usernamePATTERN = "";
		Pattern pattern = Pattern.compile(usernamePATTERN);
		Matcher matcher = pattern.matcher(loginDetailMessageEntity.getUsername());
		if (matcher.matches()) {
			return CustomerServiceUtility.GetResultMessageEntity("", "", ResultStatus.Success);
		}
		return CustomerServiceUtility.GetResultMessageEntity(customerServiceErrorCode.InValidUserNameErrorCode(), "UserName",ResultStatus.Error);
	}

	public ResultMessageEntity IsPasswordValid(LoginDetailMessageEntity loginDetailMessageEntity) {
		if (SeahorseUtilities.isNullOrWhitespace(loginDetailMessageEntity.getPassword())) {
			return CustomerServiceUtility.GetResultMessageEntity(customerServiceErrorCode.EmptyPasswordErrorCode(),"Password", ResultStatus.Error);
		}
		String password_PATTERN = "";
		Pattern pattern = Pattern.compile(password_PATTERN);
		Matcher matcher = pattern.matcher(loginDetailMessageEntity.getPassword());
		if (matcher.matches()) {
			return CustomerServiceUtility.GetResultMessageEntity("", "", ResultStatus.Success);
		}
		return CustomerServiceUtility.GetResultMessageEntity(customerServiceErrorCode.InValidPasswordErrorCode(), "Password",ResultStatus.Error);
	}

}
