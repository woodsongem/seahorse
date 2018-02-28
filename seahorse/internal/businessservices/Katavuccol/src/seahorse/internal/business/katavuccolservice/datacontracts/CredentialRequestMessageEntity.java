/**
 * 
 */
package seahorse.internal.business.katavuccolservice.datacontracts;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

/**
 * @author sajanmje
 *
 */
public class CredentialRequestMessageEntity {

	private String categoryId;
	private String typeId;
	private String value;	
	private String userId;
	private UUID parsedUserId;
	private UUID parsedCategoryId;
	private UUID parsedTypeId;
	private UUID id;
	private HttpServletRequest httpRequest;
	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the typeid
	 */
	public String getTypeId() {
		return typeId;
	}
	/**
	 * @param typeid the typeid to set
	 */
	public void setTypeId(String typeid) {
		this.typeId = typeid;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
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
	 * @return the parsedCategoryId
	 */
	public UUID getParsedCategoryId() {
		return parsedCategoryId;
	}
	/**
	 * @param parsedCategoryId the parsedCategoryId to set
	 */
	public void setParsedCategoryId(UUID parsedCategoryId) {
		this.parsedCategoryId = parsedCategoryId;
	}
	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	/**
	 * @return the httpRequest
	 */
	public HttpServletRequest getHttpRequest() {
		return httpRequest;
	}
	/**
	 * @param httpRequest the httpRequest to set
	 */
	public void setHttpRequest(HttpServletRequest httpRequest) {
		this.httpRequest = httpRequest;
	}
	/**
	 * @return the parsedTypeId
	 */
	public UUID getParsedTypeId() {
		return parsedTypeId;
	}
	/**
	 * @param parsedTypeId the parsedTypeId to set
	 */
	public void setParsedTypeId(UUID parsedTypeId) {
		this.parsedTypeId = parsedTypeId;
	}
}
