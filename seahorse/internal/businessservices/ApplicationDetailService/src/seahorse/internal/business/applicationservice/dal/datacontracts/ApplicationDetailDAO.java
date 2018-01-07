/**
 * 
 */
package seahorse.internal.business.applicationservice.dal.datacontracts;

import java.util.Date;
import java.util.List;

import com.datastax.driver.core.LocalDate;

import seahorse.internal.business.applicationservice.common.datacontracts.ApplicationDecision;
import seahorse.internal.business.applicationservice.common.datacontracts.Gender;

/**
 * @author admin
 *
 */
public class ApplicationDetailDAO extends BaseDAO {
	
	private String _id;
	
	private NameDAO _nameDAO;
	
	private List<EmailAddressDAO> _emailAddressDAO;
	
	private List<PhoneDAO> _phoneDAO;
	
	private List<AddressDAO>  _addressDAO;
	
	private String  _userName;
	
	private LocalDate _dateOfBirth;
	
	private ApplicationDecision _decision;
	
	private String _rejectReason;
	
	private List<NationalIdentifierDAO> NationalIdentifiersDAO;
	
	private Gender _gender;
	
	private Date MarriageDate;

	/**
	 * @return the id
	 */
 	public String getId() {
		return _id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		_id = id;
	}

	/**
	 * @return the name
	 */
	public NameDAO getNameDAO() {
		return _nameDAO;
	}

	/**
	 * @param name the name to set
	 */
	public void setNameDAO(NameDAO name) {
		_nameDAO = name;
	}

	/**
	 * @return the emailAddressDAO
	 */
	public List<EmailAddressDAO> getEmailAddressDAO() {
		return _emailAddressDAO;
	}

	/**
	 * @param emailAddressDAO the emailAddressDAO to set
	 */
	public void setEmailAddressDAO(List<EmailAddressDAO> emailAddressDAO) {
		_emailAddressDAO = emailAddressDAO;
	}

	/**
	 * @return the phoneDAO
	 */
	public List<PhoneDAO> getPhoneDAO() {
		return _phoneDAO;
	}

	/**
	 * @param phoneDAO the phoneDAO to set
	 */
	public void setPhoneDAO(List<PhoneDAO> phoneDAO) {
		_phoneDAO = phoneDAO;
	}

	/**
	 * @return the addressDAO
	 */
	public List<AddressDAO> getAddressDAO() {
		return _addressDAO;
	}

	/**
	 * @param addressDAO the addressDAO to set
	 */
	public void setAddressDAO(List<AddressDAO> addressDAO) {
		_addressDAO = addressDAO;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return _userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		_userName = userName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return _dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		_dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the decision
	 */
	public ApplicationDecision getDecision() {
		return _decision;
	}

	/**
	 * @param decision the decision to set
	 */
	public void setDecision(ApplicationDecision decision) {
		_decision = decision;
	}

	/**
	 * @return the rejectReason
	 */
	public String getRejectReason() {
		return _rejectReason;
	}

	/**
	 * @param rejectReason the rejectReason to set
	 */
	public void setRejectReason(String rejectReason) {
		_rejectReason = rejectReason;
	}

	/**
	 * @return the nationalIdentifierTypes
	 */
	public List<NationalIdentifierDAO> getNationalIdentifiers() {
		return NationalIdentifiersDAO;
	}

	/**
	 * @param nationalIdentifierTypes the nationalIdentifierTypes to set
	 */
	public void setNationalIdentifiers(List<NationalIdentifierDAO> nationalIdentifiersDAO) {
		NationalIdentifiersDAO = nationalIdentifiersDAO;
	}

	/**
	 * @return the marriageDate
	 */
	public Date getMarriageDate() {
		return MarriageDate;
	}

	/**
	 * @param marriageDate the marriageDate to set
	 */
	public void setMarriageDate(Date marriageDate) {
		MarriageDate = marriageDate;
	}

	/**
	 * @return the _gender
	 */
	public Gender getgender() {
		return _gender;
	}

	/**
	 * @param _gender the _gender to set
	 */
	public void setgender(Gender _gender) {
		this._gender = _gender;
	}
	
	

}
