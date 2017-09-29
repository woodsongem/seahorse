/**
 * 
 */
package seahorse.internal.business.coldfishservice.datacontracts;

import java.util.UUID;

import seahorse.internal.business.coldfishservice.common.datacontracts.BaseMessageEntity;

/**
 * @author sajanmje
 *
 */
public class IncomeTypeMessageEntity extends BaseMessageEntity {
	
	private String category;

	private UUID id;

	private String name;
	
	private String userId;
	
	private String description;
	
	private UUID parsedUserId;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UUID getParsedUserId() {
		return parsedUserId;
	}

	public void setParsedUserId(UUID parsedUserId) {
		this.parsedUserId = parsedUserId;
	}
}
