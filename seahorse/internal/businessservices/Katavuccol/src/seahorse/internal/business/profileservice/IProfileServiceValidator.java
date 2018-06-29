/**
 * 
 */
package seahorse.internal.business.profileservice;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;

/**
 * @author admin
 *
 */
public interface IProfileServiceValidator {

	Result isUserIdValid(String userId);
}
