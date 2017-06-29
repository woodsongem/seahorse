package seahorse.internal.business.applicationservice.datacontracts;

import java.util.Date;
import java.util.List;

import seahorse.internal.business.applicationservice.common.datacontracts.ApplicationDecision;
import seahorse.internal.business.applicationservice.common.datacontracts.Gender;

public class ApplicationDetailMessageEntity extends BaseMessageEntity {

	private String _id;
	private NameMessageEntity _nameMessageEntity;
	private String _userName;
	private Date _dateOfBirth;
	private ApplicationDecision _decision;
	private String _rejectReason;	
	private Gender _gender;
	private Date MarriageDate;	
	private List<NationalIdentifierMessageEntity> nationalIdentifierMessageEntities;
	private List<EmailAddressMessageEntity> _emailAddressMessageEntity;
	private List<PhoneMessageEntity> _phoneMessageEntity;
	private List<AddressMessageEntity> _addressMessageEntity;
	private List<UserSecurityQuestionMessageEntity> userSecurityQuestionMessageEntity;
	



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
	public NameMessageEntity getNameMessageEntity() {
		return _nameMessageEntity;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setNameMessageEntity(NameMessageEntity name) {
		_nameMessageEntity = name;
	}

	/**
	 * @return the emailAddressMessageEntity
	 */
	public List<EmailAddressMessageEntity> getEmailAddressMessageEntity() {
		return _emailAddressMessageEntity;
	}

	/**
	 * @param emailAddressMessageEntity
	 *            the emailAddressMessageEntity to set
	 */
	public void setEmailAddressMessageEntity(List<EmailAddressMessageEntity> emailAddressMessageEntity) {
		_emailAddressMessageEntity = emailAddressMessageEntity;
	}

	/**
	 * @return the phoneMessageEntity
	 */
	public List<PhoneMessageEntity> getPhoneMessageEntity() {
		return _phoneMessageEntity;
	}

	/**
	 * @param phoneMessageEntity
	 *            the phoneMessageEntity to set
	 */
	public void setPhoneMessageEntity(List<PhoneMessageEntity> phoneMessageEntity) {
		_phoneMessageEntity = phoneMessageEntity;
	}

	/**
	 * @return the addressMessageEntity
	 */
	public List<AddressMessageEntity> getAddressMessageEntity() {
		return _addressMessageEntity;
	}

	/**
	 * @param addressMessageEntity
	 *            the addressMessageEntity to set
	 */
	public void setAddressMessageEntity(List<AddressMessageEntity> addressMessageEntity) {
		_addressMessageEntity = addressMessageEntity;
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
	public List<NationalIdentifierMessageEntity> getNationalIdentifierMessageEntity() {
		return nationalIdentifierMessageEntities;
	}

	/**
	 * @param nationalIdentifierTypes
	 *            the nationalIdentifierTypes to set
	 */
	public void setNationalIdentifierMessageEntity(List<NationalIdentifierMessageEntity> _nationalIdentifierMessageEntity) {
		nationalIdentifierMessageEntities = _nationalIdentifierMessageEntity;
	}

	/**
	 * @return the marriageDate
	 */
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
	public Gender getGender() {
		return _gender;
	}

	/**
	 * @param _gender
	 *            the _gender to set
	 */
	public void setGender(Gender _gender) {
		this._gender = _gender;
	}

	/**
	 * @return the userSecurityQuestionMessageEntity
	 */
	public List<UserSecurityQuestionMessageEntity> getUserSecurityQuestionMessageEntity() {
		return userSecurityQuestionMessageEntity;
	}

	/**
	 * @param userSecurityQuestionMessageEntity the userSecurityQuestionMessageEntity to set
	 */
	public void setUserSecurityQuestionMessageEntity(List<UserSecurityQuestionMessageEntity> userSecurityQuestionMessageEntity) {
		this.userSecurityQuestionMessageEntity = userSecurityQuestionMessageEntity;
	}
}
