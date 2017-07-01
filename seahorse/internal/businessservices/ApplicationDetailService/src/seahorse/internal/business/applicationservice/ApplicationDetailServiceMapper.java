/**
 * 
 */
package seahorse.internal.business.applicationservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.inject.Inject;

import seahorse.internal.business.applicationservice.common.datacontracts.PhoneType;
import seahorse.internal.business.applicationservice.dal.datacontracts.AddressDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.ApplicationDetailDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.EmailAddressDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.NameDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.NationalIdentifierDAO;
import seahorse.internal.business.applicationservice.dal.datacontracts.PhoneDAO;
import seahorse.internal.business.applicationservice.datacontracts.AddressMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.ApplicationDetailMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.EmailAddressMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.NameMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.NationalIdentifierMessageEntity;
import seahorse.internal.business.applicationservice.datacontracts.PhoneMessageEntity;
import seahorse.internal.business.applicationservice.utilities.ApplicationServiceUtility;

/**
 * @author admin
 *
 */
public class ApplicationDetailServiceMapper implements IApplicationDetailServiceMapper {
	@Inject
	ApplicationDetailServiceMapper() {

	}

	@Override
	public ApplicationDetailMessageEntity MapApplicationDetailMessageEntity(ApplicationDetailDAO applicationDetailDAO) {

		ApplicationDetailMessageEntity applicationDetailMessageEntity = new ApplicationDetailMessageEntity();
		if (applicationDetailDAO == null)
			return applicationDetailMessageEntity;
		if (applicationDetailDAO.getAddressDAO() != null) {
			applicationDetailMessageEntity.setAddressMessageEntity(MapAddressMessageEntity(applicationDetailDAO.getAddressDAO()));
		}

		applicationDetailMessageEntity.setCreatedBy(applicationDetailDAO.getCreatedBy());
		applicationDetailMessageEntity.setCreatedDate(applicationDetailDAO.getCreatedDate());
		if (applicationDetailDAO.getDateOfBirth() != null) {
			applicationDetailMessageEntity.setDateOfBirth(new Date(applicationDetailDAO.getDateOfBirth().getMillisSinceEpoch()));
		}
		applicationDetailMessageEntity.setDecision(applicationDetailDAO.getDecision());
		if(applicationDetailDAO.getEmailAddressDAO() !=null){
			applicationDetailMessageEntity.setEmailAddressMessageEntity(MapEmailAddressMessageEntities(applicationDetailDAO.getEmailAddressDAO()));
		}
		applicationDetailMessageEntity.setGender(applicationDetailDAO.getgender());
		applicationDetailMessageEntity.setId(applicationDetailDAO.getId());
		applicationDetailMessageEntity.setMarriageDate(applicationDetailDAO.getMarriageDate());
		if(applicationDetailDAO.getNameDAO() != null){
			applicationDetailMessageEntity.setNameMessageEntity(MapNameMessageEntity(applicationDetailDAO.getNameDAO()));
		}
		
		if(applicationDetailDAO.getNationalIdentifiers() != null){
			applicationDetailMessageEntity.setNationalIdentifierMessageEntity(MapNationalIdentifierMessageEntities(applicationDetailDAO.getNationalIdentifiers()));
		}
		if(applicationDetailDAO.getPhoneDAO() != null){
			applicationDetailMessageEntity.setPhoneMessageEntity(MapPhoneMessageEntity(applicationDetailDAO.getPhoneDAO()));
		}
		applicationDetailMessageEntity.setRejectReason(applicationDetailDAO.getRejectReason());
		applicationDetailMessageEntity.setUserName(applicationDetailDAO.getUserName());

		return applicationDetailMessageEntity;
	}

	private List<PhoneMessageEntity> MapPhoneMessageEntity(List<PhoneDAO> phonesDAO) {
		List<PhoneMessageEntity> phoneMessageEntities = new ArrayList<>();
		for (PhoneDAO phoneDAO : phonesDAO) {
			PhoneMessageEntity phoneMessageEntity = new PhoneMessageEntity();
			phoneMessageEntity.setId(phoneDAO.getId());
			phoneMessageEntity.setPhoneNumber(phoneDAO.getPhoneNumber());
			phoneMessageEntity.setAreaCode(phoneDAO.getAreaCode());
			phoneMessageEntity.setNumber(phoneDAO.getNumber());
			if (ApplicationServiceUtility.TryPhoneTypeParse(phoneDAO.getPhoneType())) {
				phoneMessageEntity.setPhoneType(PhoneType.valueOf(phoneDAO.getPhoneType()));
			}
			phoneMessageEntity.setStatus(phoneDAO.getStatus());
			phoneMessageEntities.add(phoneMessageEntity);
		}
		return phoneMessageEntities;
	}

	private List<NationalIdentifierMessageEntity> MapNationalIdentifierMessageEntities(
			List<NationalIdentifierDAO> nationalIdentifiersDAO) {
		List<NationalIdentifierMessageEntity> nationalIdentifierMessageEntities = new ArrayList<>();
		for (NationalIdentifierDAO nationalIdentifierDAO : nationalIdentifiersDAO) {
			NationalIdentifierMessageEntity nationalIdentifierMessageEntity = new NationalIdentifierMessageEntity();
			nationalIdentifierMessageEntity.setId(nationalIdentifierDAO.getId());
			nationalIdentifierMessageEntity.setStatus(nationalIdentifierDAO.getStatus());
			nationalIdentifierMessageEntity.setType(nationalIdentifierDAO.getType());
			nationalIdentifierMessageEntities.add(nationalIdentifierMessageEntity);
		}

		return nationalIdentifierMessageEntities;
	}

	private NameMessageEntity MapNameMessageEntity(NameDAO nameDAO) {
		NameMessageEntity nameMessageEntity = new NameMessageEntity();
		nameMessageEntity.setfirstName(nameDAO.getfirstName());
		nameMessageEntity.setmiddleName(nameDAO.getmiddleName());
		nameMessageEntity.setlastName(nameDAO.getmiddleName());
		nameMessageEntity.setprefix(nameDAO.getprefix());
		return nameMessageEntity;

	}

	private List<EmailAddressMessageEntity> MapEmailAddressMessageEntities(List<EmailAddressDAO> emailAddressesDAO) {

		List<EmailAddressMessageEntity> emailAddressMessageEntities = new ArrayList<>();
		for (EmailAddressDAO emailAddressDAO : emailAddressesDAO) {
			EmailAddressMessageEntity emailAddressMessageEntity = new EmailAddressMessageEntity();
			emailAddressMessageEntity.setid(emailAddressDAO.getId());
			emailAddressMessageEntity.setemailAddress(emailAddressDAO.getEmailAddress());
			emailAddressMessageEntity.setstatus(emailAddressDAO.getStatus());
			emailAddressMessageEntities.add(emailAddressMessageEntity);
		}
		return emailAddressMessageEntities;

	}

	private List<AddressMessageEntity> MapAddressMessageEntity(List<AddressDAO> addressesDAO) {
		List<AddressMessageEntity> addressMessageEntities = new ArrayList<>();
		for (AddressDAO addressDAO : addressesDAO) {
			AddressMessageEntity addressMessageEntity = new AddressMessageEntity();
			addressMessageEntity.setAddressLine1(addressDAO.getAddressLine1());
			addressMessageEntity.setAddressLine2(addressDAO.getAddressLine2());
			addressMessageEntity.setCityId(addressDAO.getCityId());
			addressMessageEntity.setcityName(addressDAO.getCityName());
			addressMessageEntity.setCountryId(addressDAO.getCountryId());
			addressMessageEntity.setCountryName(addressDAO.getCountryName());
			addressMessageEntity.setCreatedBy(addressDAO.getCreatedBy());
			addressMessageEntity.setCreatedDate(addressDAO.getCreatedDate());
			if (addressDAO.getId() != null) {
				addressMessageEntity.setId(addressDAO.getId().toString());
			}			
			addressMessageEntity.setStateId(addressDAO.getStateId());
			addressMessageEntity.setStateName(addressDAO.getStateName());
			addressMessageEntity.setstatus(addressDAO.getStatus());
			addressMessageEntity.setZipCode(addressDAO.getZipCode());
			addressMessageEntities.add(addressMessageEntity);
		}

		return addressMessageEntities;

	}

}
