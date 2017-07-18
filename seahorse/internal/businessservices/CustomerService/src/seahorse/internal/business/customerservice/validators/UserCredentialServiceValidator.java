/**
 * 
 */
package seahorse.internal.business.customerservice.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.Logger;
import org.jasypt.util.password.StrongPasswordEncryptor;

import com.google.inject.Inject;

import seahorse.internal.business.applicationservice.utilities.CustomerServiceUtility;
import seahorse.internal.business.customerservice.common.IReadPropertiesFile;
import seahorse.internal.business.customerservice.common.SeahorseUtilities;
import seahorse.internal.business.customerservice.constants.Constant;
import seahorse.internal.business.customerservice.constants.ICustomerServiceErrorCode;
import seahorse.internal.business.customerservice.datacontracts.LoginDetailMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultStatus;
import seahorse.internal.business.shared.aop.InjectLogger;
import seahorse.internal.business.shared.framework.IChainofResponsiblity;
import seahorse.internal.business.shared.framework.Responsibility;

/**
 * @author sajanmje
 *
 */
public class UserCredentialServiceValidator implements IUserCredentialServiceValidator {

	private final ICustomerServiceErrorCode customerServiceErrorCode;
	private final IReadPropertiesFile readPropertiesFile;
	private final IChainofResponsiblity chainofResponsiblity;
	@InjectLogger
	Logger logger;

	@Inject
	public UserCredentialServiceValidator(ICustomerServiceErrorCode customerServiceErrorCode,
			IReadPropertiesFile readPropertiesFile, IChainofResponsiblity chainofResponsiblity) {
		this.customerServiceErrorCode = customerServiceErrorCode;
		this.readPropertiesFile = readPropertiesFile;
		this.chainofResponsiblity = chainofResponsiblity;
	}

	@Override
	public ResultMessageEntity ValidateLogin(LoginDetailMessageEntity loginDetailMessageEntity) {

		List<Responsibility> responsibilities = new ArrayList<>();
		Responsibility responsiblity = new Responsibility();
		responsiblity.setClassName(Constant.UserCredentialValidatorsClassName);
		responsiblity.setPackageName(Constant.UserCredentialValidatorsPackage);
		responsiblity.setMethodName("IsLoginDetailMessageEntityValid");
		responsibilities.add(responsiblity);

		responsiblity = new Responsibility();
		responsiblity.setClassName(Constant.UserCredentialValidatorsClassName);
		responsiblity.setPackageName(Constant.UserCredentialValidatorsPackage);
		responsiblity.setMethodName("IsProductItemValid");
		responsibilities.add(responsiblity);

		responsiblity = new Responsibility();
		responsiblity.setClassName(Constant.UserCredentialValidatorsClassName);
		responsiblity.setPackageName(Constant.UserCredentialValidatorsPackage);
		responsiblity.setMethodName("IsUserNameValid");
		responsibilities.add(responsiblity);

		responsiblity = new Responsibility();
		responsiblity.setClassName(Constant.UserCredentialValidatorsClassName);
		responsiblity.setPackageName(Constant.UserCredentialValidatorsPackage);
		responsiblity.setMethodName("IsPasswordValid");
		responsibilities.add(responsiblity);

		responsiblity = new Responsibility();
		responsiblity.setClassName(Constant.UserCredentialValidatorsClassName);
		responsiblity.setPackageName(Constant.UserCredentialValidatorsPackage);
		responsiblity.setMethodName("IsPasswordEncryptionValid");
		responsibilities.add(responsiblity);

		return chainofResponsiblity.ExecuteResponsibilities(loginDetailMessageEntity, responsibilities);
	}

	public ResultMessageEntity IsLoginDetailMessageEntityValid(LoginDetailMessageEntity loginDetailMessageEntity) {

		if (loginDetailMessageEntity == null) {
			return CustomerServiceUtility.GetResultMessageEntity(
					customerServiceErrorCode.InValidLoginDetailMessageEntityErrorCode(), "LoginDetailMessageEntity",
					ResultStatus.Error);
		}

		return CustomerServiceUtility.GetResultMessageEntity("", "", ResultStatus.Success);
	}

	public ResultMessageEntity IsUserNameValid(LoginDetailMessageEntity loginDetailMessageEntity) {

		if (SeahorseUtilities.isNullOrWhitespace(loginDetailMessageEntity.getUsername())) {
			return CustomerServiceUtility.GetResultMessageEntity(customerServiceErrorCode.EmptyUserNameErrorCode(),
					"UserName", ResultStatus.Error);
		}

		String usernamePATTERN = "";
		Pattern pattern = Pattern.compile(usernamePATTERN);
		Matcher matcher = pattern.matcher(loginDetailMessageEntity.getUsername());
		if (matcher.matches()) {
			return CustomerServiceUtility.GetResultMessageEntity("", "", ResultStatus.Success);
		}
		return CustomerServiceUtility.GetResultMessageEntity(customerServiceErrorCode.InValidUserNameErrorCode(),
				"UserName", ResultStatus.Error);
	}

	public ResultMessageEntity IsPasswordValid(LoginDetailMessageEntity loginDetailMessageEntity) {
		if (SeahorseUtilities.isNullOrWhitespace(loginDetailMessageEntity.getPassword())) {
			return CustomerServiceUtility.GetResultMessageEntity(customerServiceErrorCode.EmptyPasswordErrorCode(),
					"Password", ResultStatus.Error);
		}
		String password_PATTERN = "";
		Pattern pattern = Pattern.compile(password_PATTERN);
		Matcher matcher = pattern.matcher(loginDetailMessageEntity.getPassword());
		if (matcher.matches()) {
			return CustomerServiceUtility.GetResultMessageEntity("", "", ResultStatus.Success);
		}
		return CustomerServiceUtility.GetResultMessageEntity(customerServiceErrorCode.InValidPasswordErrorCode(),
				"Password", ResultStatus.Error);
	}

	public ResultMessageEntity IsPasswordEncryptionValid(LoginDetailMessageEntity loginDetailMessageEntity) {
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		loginDetailMessageEntity
				.setEncryptedpassword(passwordEncryptor.encryptPassword(loginDetailMessageEntity.getPassword()));

		return CustomerServiceUtility.GetResultMessageEntity("", "", ResultStatus.Success);
	}

	public ResultMessageEntity IsProductItemValid(LoginDetailMessageEntity loginDetailMessageEntity) {
		if (loginDetailMessageEntity.getProductitem() != null && loginDetailMessageEntity.getProductitem().isEmpty()) {
			loginDetailMessageEntity.setProductitem(Constant.DefaultProductItem);
		}
		return CustomerServiceUtility.GetResultMessageEntity("", "", ResultStatus.Success);
	}
}
