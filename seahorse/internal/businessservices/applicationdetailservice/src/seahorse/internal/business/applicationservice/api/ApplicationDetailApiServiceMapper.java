/**
 * 
 */
package seahorse.internal.business.applicationservice.api;

import java.util.ArrayList;
import java.util.List;

import seahorse.internal.business.applicationservice.api.datacontracts.Address;
import seahorse.internal.business.applicationservice.api.datacontracts.ApplicationDetail;
import seahorse.internal.business.applicationservice.api.datacontracts.ApplicationDetailResponse;
import seahorse.internal.business.applicationservice.api.datacontracts.EmailAddress;
import seahorse.internal.business.applicationservice.api.datacontracts.Name;
import seahorse.internal.business.applicationservice.api.datacontracts.NationalIdentifier;
import seahorse.internal.business.applicationservice.api.datacontracts.Phone;
import seahorse.internal.business.applicationservice.datacontracts.AddressMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.ApplicationDetailMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.ApplicationDetailResponseMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.EmailAddressMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.NameMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.NationalIdentifierMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.PhoneMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.ResultStatus;

/**
 * @author admin
 *
 */
public class ApplicationDetailApiServiceMapper implements IApplicationDetailApiServiceMapper {

	@Override
	public ApplicationDetail MapApplicationDetail(ApplicationDetailMessageEntity applicationDetailMessageEntity) {

		if (applicationDetailMessageEntity == null)
			return null;

		ApplicationDetail applicationDetail = new ApplicationDetail();

		if (applicationDetailMessageEntity.GetResultStatus() != ResultStatus.Success) {
			return applicationDetail;
		}

		if (applicationDetailMessageEntity.getAddressMessageEntity() != null) {
			applicationDetail.setAddress(MapAddressess(applicationDetailMessageEntity.getAddressMessageEntity()));
		}
		if (applicationDetailMessageEntity.getEmailAddressMessageEntity() != null) {
			applicationDetail
					.setEmailAddress(MapEmailAddresses(applicationDetailMessageEntity.getEmailAddressMessageEntity()));
		}
		if (applicationDetailMessageEntity.getPhoneMessageEntity() != null) {
			applicationDetail.setPhone(MapPhones(applicationDetailMessageEntity.getPhoneMessageEntity()));
		}
		if (applicationDetailMessageEntity.getNationalIdentifierMessageEntity() != null) {
			applicationDetail.setNationalIdentifier(MapNationalIdentifiers(applicationDetailMessageEntity.getNationalIdentifierMessageEntity()));
		}
		applicationDetail.setCreatedBy(applicationDetailMessageEntity.getCreatedBy());
		applicationDetail.setCreatedDate(applicationDetailMessageEntity.getCreatedDate());
		applicationDetail.setDateOfBirth(applicationDetailMessageEntity.getDateOfBirth());
		applicationDetail.setDecision(applicationDetailMessageEntity.getDecision());
		applicationDetail.setgender(applicationDetailMessageEntity.getGender());
		applicationDetail.setId(applicationDetailMessageEntity.getId());
		applicationDetail.setMarriageDate(applicationDetailMessageEntity.getMarriageDate());

		if (applicationDetailMessageEntity.getNameMessageEntity() != null) {
			applicationDetail.setName(MapName(applicationDetailMessageEntity.getNameMessageEntity()));
		}
		applicationDetail.setRejectReason(applicationDetailMessageEntity.getRejectReason());
		if (applicationDetailMessageEntity.getUserName() != null) {
			applicationDetail.setUserName(applicationDetailMessageEntity.getUserName());
		}

		return applicationDetail;
	}

	private Name MapName(NameMessageEntity nameMessageEntity) {
		Name name = new Name();
		name.setfirstName(nameMessageEntity.getfirstName());
		name.setmiddleName(nameMessageEntity.getmiddleName());
		name.setlastName(nameMessageEntity.getmiddleName());
		name.setprefix(nameMessageEntity.getprefix());
		return name;
	}

	private List<NationalIdentifier> MapNationalIdentifiers(
			List<NationalIdentifierMessageEntity> nationalIdentifierMessageEntities) {
		List<NationalIdentifier> nationalIdentifiers = new ArrayList<>();
		for (NationalIdentifierMessageEntity nationalIdentifierMessageEntity : nationalIdentifierMessageEntities) {
			NationalIdentifier nationalIdentifier = new NationalIdentifier();
			nationalIdentifier.setId(nationalIdentifierMessageEntity.getId());
			nationalIdentifier.setStatus(nationalIdentifierMessageEntity.getStatus());
			nationalIdentifier.setType(nationalIdentifierMessageEntity.getType());
			nationalIdentifiers.add(nationalIdentifier);
		}

		return nationalIdentifiers;
	}

	private List<Phone> MapPhones(List<PhoneMessageEntity> phoneMessageEntities) {
		List<Phone> phones = new ArrayList<>();
		for (PhoneMessageEntity phoneMessageEntity : phoneMessageEntities) {
			Phone phone = new Phone();
			phone.setid(phoneMessageEntity.getId());
			phone.setphoneNumber(phoneMessageEntity.getPhoneNumber());
			phone.setareaCode(phoneMessageEntity.getAreaCode());
			phone.setNumber(phoneMessageEntity.getNumber());
			phone.setphoneType(phoneMessageEntity.getPhoneType().toString());
			phone.setstatus(phoneMessageEntity.getStatus());
			phones.add(phone);
		}
		return phones;
	}

	private List<EmailAddress> MapEmailAddresses(List<EmailAddressMessageEntity> emailAddressMessageEntities) {
		List<EmailAddress> emailAddresses = new ArrayList<>();
		for (EmailAddressMessageEntity emailAddressMessageEntity : emailAddressMessageEntities) {
			EmailAddress emailAddress = new EmailAddress();
			emailAddress.setid(emailAddressMessageEntity.getid());
			emailAddress.setemailAddress(emailAddressMessageEntity.getemailAddress());
			emailAddress.setstatus(emailAddressMessageEntity.getstatus());
			emailAddresses.add(emailAddress);
		}
		return emailAddresses;
	}

	private List<Address> MapAddressess(List<AddressMessageEntity> _addressMessageEntites) {
		List<Address> _addresses = new ArrayList<>();
		for (AddressMessageEntity _addressMessageEntity : _addressMessageEntites) {
			Address _address = new Address();
			_address.setaddressLine1(_addressMessageEntity.getAddressLine1());
			_address.setaddressLine2(_addressMessageEntity.getAddressLine2());
			_address.setcityId(_addressMessageEntity.getCityId());
			_address.setcityName(_addressMessageEntity.getCityName());
			_address.setcountryId(_addressMessageEntity.getCountryId());
			_address.setcountryName(_addressMessageEntity.getCountryName());
			_address.setid(_addressMessageEntity.getId());
			_address.setstateId(_addressMessageEntity.getstateId());
			_address.setstateName(_addressMessageEntity.getStateName());
			_address.setstatus(_addressMessageEntity.getstatus());
			_address.setzipCode(_addressMessageEntity.getZipCode());
			_addresses.add(_address);
		}

		return _addresses;

	}

	@Override
	public ApplicationDetailMessageEntity MapApplicationDetailMessageEntity(ApplicationDetail applicationDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApplicationDetailResponse MapApplicationDetailResponse(
			ApplicationDetailResponseMessageEntity _applicationDetailResponseMessageEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
