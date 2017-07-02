/**
 * 
 */
package seahorse.internal.business.applicationservice.dal;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.google.inject.Inject;

import seahorse.internal.business.applicationservice.constants.DataBaseColumn;
import seahorse.internal.business.applicationservice.constants.QueryConstants;
import seahorse.internal.business.applicationservice.dal.datacontracts.AddressDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.ApplicationDetailDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.EmailAddressDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.PhoneDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.UserSecurityQuestionDAO;

/**
 * @author admin
 *
 */
public class ApplicationDetailRepositoryMapper implements IApplicationDetailRepositoryMapper {
	@Inject
	ApplicationDetailRepositoryMapper() {

	}

	@Override
	public ApplicationDetailDAO mapGetApplicationByApplicationId(Row applicationResult) {
		ApplicationDetailDAO applicationDetailDAO = new ApplicationDetailDAO();
		applicationDetailDAO.setDateOfBirth(applicationResult.getDate(DataBaseColumn.DateOfBirth));
		applicationDetailDAO.setCreatedBy(applicationResult.getString(DataBaseColumn.CreatedBy));
		return applicationDetailDAO;
	}

	@Override
	public String getApplicationByApplicationIdQuery(String applicationId) {

		Object[] args = { applicationId };
		return new MessageFormat(QueryConstants.GetApplicationByApplicationIdQuery).format(args);

	}

	public EmailAddressDAO mapEmailAddressDAO(Row emailAddress) {
		EmailAddressDAO emailAddressDAO = new EmailAddressDAO();
		emailAddressDAO.setEmailAddress(emailAddress.getString(DataBaseColumn.EmailId));
		emailAddressDAO.setId(emailAddress.getUUID(DataBaseColumn.Id));
		emailAddressDAO.setIsPrimary(emailAddress.getBool(DataBaseColumn.IsPrimary));
		emailAddressDAO.setStatus(emailAddress.getString(DataBaseColumn.Status));
		emailAddressDAO.setVerified(emailAddress.getString(DataBaseColumn.Verified));
		return emailAddressDAO;
	}

	public PhoneDAO mapPhoneDAO(Row phoneResult) {
		PhoneDAO phoneDAO = new PhoneDAO();
		phoneDAO.setId(phoneResult.getUUID(DataBaseColumn.Id));
		phoneDAO.setAreaCode(phoneResult.getString(DataBaseColumn.AreaCode));
		phoneDAO.setNumber(phoneResult.getString(DataBaseColumn.Number));
		phoneDAO.setPhoneType(phoneResult.getString(DataBaseColumn.Type));
		phoneDAO.setStatus(phoneResult.getString(DataBaseColumn.Status));
		phoneDAO.setVerified(phoneResult.getString(DataBaseColumn.Verified));
		phoneDAO.setCountryCode(phoneResult.getString(DataBaseColumn.CountryCode));
		phoneDAO.setFullPhoneNumber(phoneResult.getString(DataBaseColumn.FullPhoneNumber));
		return phoneDAO;
	}

	public AddressDAO mapAddressDAO(Row addressResult) {
		AddressDAO addressDAO = new AddressDAO();
		addressDAO.setAddressLine1(addressResult.getString(DataBaseColumn.AddressLine1));
		addressDAO.setAddressLine2(addressResult.getString(DataBaseColumn.AddressLine2));
		addressDAO.setId(addressResult.getUUID(DataBaseColumn.Id));
		addressDAO.setStatus(addressResult.getString(DataBaseColumn.Status));
		addressDAO.setZipCode(addressResult.getString(DataBaseColumn.ZipCode));
		addressDAO.setCityName(addressResult.getString(DataBaseColumn.CityName));
		addressDAO.setCountryName(addressResult.getString(DataBaseColumn.CountryName));
		return addressDAO;
	}

	@Override
	public String getEmailAddressByIdQuery(UUID emailid) {
		Object[] args = { emailid };
		return new MessageFormat(QueryConstants.getEmailAddressByIdQuery).format(args);
	}

	@Override
	public String getPhoneByIdQuery(UUID phoneid) {
		Object[] args = { phoneid };
		return new MessageFormat(QueryConstants.getPhoneByIdQuery).format(args);
	}

	@Override
	public String getUserSecurityQuestionQuery(UUID userSecurityQuestionId) {
		Object[] args = { userSecurityQuestionId };
		return new MessageFormat(QueryConstants.getUserSecurityQuestionQuery).format(args);
	}

	@Override
	public UserSecurityQuestionDAO mapUserSecurityQuestionDAO(Row userSecurityResult) {
		UserSecurityQuestionDAO userSecurityQuestionDAO=new UserSecurityQuestionDAO();
		userSecurityQuestionDAO.setApplicationId(userSecurityResult.getUUID(DataBaseColumn.ApplicationId));
		userSecurityQuestionDAO.setSecurityAnswer(userSecurityResult.getString(DataBaseColumn.SecurityAnswer));
		userSecurityQuestionDAO.setSecurityQuestion(userSecurityResult.getString(DataBaseColumn.SecurityQuestion));
		userSecurityQuestionDAO.setStatus(userSecurityResult.getString(DataBaseColumn.Status));
		return userSecurityQuestionDAO;
	}

}
