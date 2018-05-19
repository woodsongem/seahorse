/**
 * 
 */
package seahorse.internal.business.coldfishservice.datacontracts;

import java.util.UUID;

/**
 * @author sajanmje
 *
 */
public class DeleteIncomeCategoryMessageEntity {

	private UUID paredId;
	private String id;
	private IncomeCategoryMessageEntity incomeCategoryMessageEntity;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the paredId
	 */
	public UUID getParsedId() {
		return paredId;
	}

	/**
	 * @param paredId the paredId to set
	 */
	public void setParsedId(UUID paredId) {
		this.paredId = paredId;
	}

	/**
	 * @return the incomeCategoryMessageEntity
	 */
	public IncomeCategoryMessageEntity getIncomeCategoryMessageEntity() {
		return incomeCategoryMessageEntity;
	}

	/**
	 * @param incomeCategoryMessageEntity the incomeCategoryMessageEntity to set
	 */
	public void setIncomeCategoryMessageEntity(IncomeCategoryMessageEntity incomeCategoryMessageEntity) {
		this.incomeCategoryMessageEntity = incomeCategoryMessageEntity;
	}	
}
