/**
 * 
 */
package seahorse.internal.business.coldfishservice.constants;
/**
 * @author sajanmje
 *
 */
public class Constant {

	private Constant() {
		throw new IllegalAccessError("Constant class");
	}

	public static final String CASSANDRAPORT = "ColdFishService.CassandraPort";
	public static final String CASSANDRASERVE = "ColdFishService.CassandraServer";
	public static final String DEFAULTPRODUCTITEM = "Seahorse";	
	public static final String DEFAULT = "DEFAULT";
	
	
	public static final String USERCREDENTIALVALIDATORSPACKAGE="seahorse.internal.business.customerservice.validators";
	public static final String USERCREDENTIALVALIDATORSCLASSNAME="UserCredentialServiceValidator";
	public static final String USERCREDENTIALVERIFIERSCLASSNAME = "UserCredentialServiceVerifier";
	public static final String USERCREDENTIALVERIFIERSPACKAGE = "seahorse.internal.business.customerservice.verifiers";
	public static final String USERCREDENTIALSERVICEHELPERPACKAGE = "seahorse.internal.business.customerservice.helpers";
	public static final String USERCREDENTIALSERVICEHELPERCLASSNAME = "UserCredentialServiceHelper";
	public static final String INACTIVESTATUS = "INACTIVE";
	public static final String ACTIVESTATUS = "ACTIVE";
	

}
