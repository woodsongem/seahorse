/**
 * 
 */
package seahorse.internal.business.shared.katavuccol.common.datacontracts;

import java.util.Map;

/**
 * @author SMJE
 *
 */
public interface IPost {
	String getEndPoint();
	String getUrl();
	Map<String, String> getHeaders();
	Object getRequest();
}
