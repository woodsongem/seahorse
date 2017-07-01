/**
 * 
 */
package seahorse.internal.business.applicationservice.api.datacontracts;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import seahorse.internal.business.applicationservice.common.datacontracts.ApplicationDecision;
import seahorse.internal.business.applicationservice.common.datacontracts.Gender;

/**
 * @author admin
 *
 */
public class ApplicationDetail extends Base {
	
	private String _id;

	private Name _name;

	private List<EmailAddress> _emailAddress;

	private List<Phone> _phone;

	private List<Address> _address;

	private String _userName;

	private Date _dateOfBirth;

	private ApplicationDecision _decision;

	private String _rejectReason;

	private List<NationalIdentifier> NationalIdentifiers;
	
	private List<UserSecurityQuestion> userSecurityQuestion;

	private Gender _gender;
	 
	private Date MarriageDate;

	/**
	 * @return the id
	 */
	public String getId() {
		return _id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		_id = id;
	}

	/**
	 * @return the name
	 */
	public Name getName() {
		return _name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(Name name) {
		_name = name;
	}

	/**
	 * @return the emailAddress
	 */
	public List<EmailAddress> getEmailAddress() {
		return _emailAddress;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(List<EmailAddress> emailAddress) {
		_emailAddress = emailAddress;
	}

	/**
	 * @return the phone
	 */
	public List<Phone> getPhone() {
		return _phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(List<Phone> phone) {
		_phone = phone;
	}

	/**
	 * @return the address
	 */
	public List<Address> getAddress() {
		return _address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(List<Address> address) {
		_address = address;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return _userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		_userName = userName;
	}

	/**
	 * @return the dateOfBirth
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the decision
	 */
	public ApplicationDecision getDecision() {
		return _decision;
	}

	/**
	 * @param decision
	 *            the decision to set
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
	 * @param rejectReason
	 *            the rejectReason to set
	 */
	public void setRejectReason(String rejectReason) {
		_rejectReason = rejectReason;
	}

	/**
	 * @return the nationalIdentifierTypes
	 */
	public List<NationalIdentifier> getNationalIdentifier() {
		return NationalIdentifiers;
	}

	/**
	 * @param nationalIdentifierTypes
	 *            the nationalIdentifierTypes to set
	 */
	public void setNationalIdentifier(List<NationalIdentifier> nationalIdentifiers) {
		NationalIdentifiers = nationalIdentifiers;
	}

	/**
	 * @return the marriageDate
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	public Date getMarriageDate() {
		return MarriageDate;
	}

	/**
	 * @param marriageDate
	 *            the marriageDate to set
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
	 * @param _gender
	 *            the _gender to set
	 */
	public void setgender(Gender _gender) {
		this._gender = _gender;
	}

	/**
	 * @return the userSecurityQuestion
	 */
	public List<UserSecurityQuestion> getUserSecurityQuestion() {
		return userSecurityQuestion;
	}

	/**
	 * @param userSecurityQuestion the userSecurityQuestion to set
	 */
	public void setUserSecurityQuestion(List<UserSecurityQuestion> userSecurityQuestion) {
		this.userSecurityQuestion = userSecurityQuestion;
	}

}
