package seahorse.internal.business.coldfishservice.constants;
/**
 * 
 */


/**
 * @author sajanmje
 *
 */
public interface ICustomerServiceErrorCode {
	
	String inValidLoginDetailMessageEntityErrorCode();
	
	String emptyUserNameErrorCode();
	
	String emptyPasswordErrorCode();

	String inValidUserNameErrorCode();

	String inValidPasswordErrorCode();
	
	String inValidUsernameAndPassword(); 
	String internalError();
}
