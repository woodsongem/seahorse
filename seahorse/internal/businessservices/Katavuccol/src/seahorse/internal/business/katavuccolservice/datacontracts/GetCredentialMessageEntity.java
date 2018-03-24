/**
 * 
 */
package seahorse.internal.business.katavuccolservice.datacontracts;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.katavuccolservice.common.datacontracts.BaseMessageEntity;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.CredentialDAO;

/**
 * @author sajanmje
 *
 */
public class GetCredentialMessageEntity extends BaseMessageEntity {

	private String userId;
	private UUID parsedUserId;
	private List<CredentialDAO>  credentialDAO;
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the parsedUserId
	 */
	public UUID getParsedUserId() {
		return parsedUserId;
	}
	/**
	 * @param parsedUserId the parsedUserId to set
	 */
	public void setParsedUserId(UUID parsedUserId) {
		this.parsedUserId = parsedUserId;
	}
	/**
	 * @return the credentialDAO
	 */
	public List<CredentialDAO> getCredentialDAO() {
		return credentialDAO;
	}
	/**
	 * @param credentialDAO the credentialDAO to set
	 */
	public void setCredentialDAO(List<CredentialDAO> credentialDAO) {
		this.credentialDAO = credentialDAO;
	}
	
}
