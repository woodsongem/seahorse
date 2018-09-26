/**
 * 
 */
package seahorse.internal.business.katavuccol.common;

import seahorse.internal.business.katavuccol.common.datacontracts.Result;

/**
 * @author sajanmje
 *
 */
public interface Ikatavuccolredis  {

	String getvalue(String key);
	
	Result setvalue(String key,Object value);
}
