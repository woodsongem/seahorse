package seahorse.internal.business.coldfishservice.Constants;
/**
 * 
 */


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
	String InternalError();
}
