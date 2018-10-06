/**
 * 
 */
package seahorse.internal.business.shared.katavuccol.common.datacontracts;

import java.util.Map;

/**
 * @author SMJE
 *
 */
public interface IGet {
	String getEndpoint();
	String getUrl();
	Map<String, String> getHeaders();
	void setHeaders(Map<String, String> headers);
}
