/**
 * 
 */

package seahorse.internal.business.customerservice.constants;
/**
 * @author sajanmje
 *
 */
public class Constant {

	private Constant() {
		throw new IllegalAccessError("Constant class");
	}

	public static final String CassandraPort = "ApplicationService.CassandraPort";
	public static final String CassandraServe = "ApplicationService.CassandraServer";
	public static final String DefaultProductItem = "Seahorse";	
	public static final String UserCredentialValidatorsPackage="seahorse.internal.business.customerservice.validators";
	public static final String UserCredentialValidatorsClassName="UserCredentialServiceValidator";
	public static final String UserCredentialVerifiersClassName = "UserCredentialServiceVerifier";
	public static final String UserCredentialVerifiersPackage = "seahorse.internal.business.customerservice.verifiers";
	public static final String UserCredentialServiceHelperPackage = "seahorse.internal.business.customerservice.helpers";
	public static final String UserCredentialServiceHelperClassName = "UserCredentialServiceHelper";

}
