/**
 * 
 */
package seahorse.internal.business.applicationservice.api.datacontracts;

/**
 * @author admin
 *
 */
public class ApplicationDetailResponse extends ResponseBase {
	
	private String _applicationId;

	public String getapplicationId() {
		return _applicationId;
	}

	public void setapplicationId(String _applicationId) {
		this._applicationId = _applicationId;
	}

}
