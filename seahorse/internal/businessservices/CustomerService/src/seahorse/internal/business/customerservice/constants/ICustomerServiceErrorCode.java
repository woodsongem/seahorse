/**
 * 
 */

package seahorse.internal.business.customerservice.constants;

/**
 * @author sajanmje
 *
 */
public interface ICustomerServiceErrorCode {
	
	String InValidLoginDetailMessageEntityErrorCode();
	
	String EmptyUserNameErrorCode();
	
	String EmptyPasswordErrorCode();

	String InValidUserNameErrorCode();

	String InValidPasswordErrorCode();
	
	String InValidUsernameAndPassword(); 
}
