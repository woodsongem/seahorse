/**
 * 
 */
package seahorse.internal.business.shared.katavuccol.common;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;

/**
 * @author sajanmje
 *
 */
public interface Ikatavuccolredis  {

	String getvalue(String key);
	
	Result setvalue(String key,Object value);
}
