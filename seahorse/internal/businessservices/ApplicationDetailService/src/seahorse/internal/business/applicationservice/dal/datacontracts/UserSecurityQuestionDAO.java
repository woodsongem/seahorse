/**
 * 
 */
package seahorse.internal.business.applicationservice.dal.datacontracts;

import java.util.UUID;

/**
 * @author sajanmje
 *
 */
public class UserSecurityQuestionDAO extends BaseDAO {
	
	private UUID id;
	private UUID applicationId;
	private String securityAnswer;
	private String securityQuestion;
	private String status;
	
	/**
	 * @return the _id
	 */
	public UUID getId() {
		return id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void setId(UUID uuid) {
		this.id = uuid;
	}
	/**
	 * @return the applicationId
	 */
	
	public UUID getApplicationId() {
		return applicationId;
	}
	
	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(UUID applicationId) {
		this.applicationId = applicationId;
	}
	
	/**
	 * @return the securityAnswer
	 */
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	
	/**
	 * @param securityAnswer the securityAnswer to set
	 */
	public void setSecurityAnswer(String securityAnswer) {
		securityAnswer = securityAnswer;
	}
	/**
	 * @return the securityQuestion
	 */
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	/**
	 * @param securityQuestion the securityQuestion to set
	 */
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
