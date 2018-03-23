/**
 * 
 */
package seahorse.internal.business.katavuccolservice.common;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;

/**
 * @author sajanmje
 *
 */
public interface Ikatavuccolredis  {

	String getvalue(String key);
	
	Result setvalue(String key,Object value);
}
