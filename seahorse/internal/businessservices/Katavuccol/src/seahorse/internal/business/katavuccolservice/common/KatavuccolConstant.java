/**
 * 
 */
package seahorse.internal.business.katavuccolservice.common;
/**
 * @author sajanmje
 *
 */
public class KatavuccolConstant {
	
	private KatavuccolConstant() {
		throw new IllegalAccessError("Constant class");
	}

	public static final String CASSANDRAPORT = "KatavuccolService.CassandraPort";
	public static final String CASSANDRASERVE = "KatavuccolService.CassandraServer";
	public static final String CASSANDRAKEYSPACENAME = "KatavuccolService.KeySpaceName";
	public static final String DEFAULTPRODUCTITEM = "Seahorse";	
	public static final String DEFAULT = "DEFAULT";
	public static final String IPADDRESS="ipaddress";
	
	public static final String REDISSERVER = "KatavuccolService.RedisServer";
	public static final String REDISSERVERPORT = "KatavuccolService.RedisServerPort";
	public static final String REDIS_CREDENTIALTYPE="RedisCredentialType";
	
	public static final String USERCREDENTIALVALIDATORSPACKAGE="seahorse.internal.business.customerservice.validators";
	public static final String USERCREDENTIALVALIDATORSCLASSNAME="UserCredentialServiceValidator";
	public static final String USERCREDENTIALVERIFIERSCLASSNAME = "UserCredentialServiceVerifier";
	public static final String USERCREDENTIALVERIFIERSPACKAGE = "seahorse.internal.business.customerservice.verifiers";
	public static final String USERCREDENTIALSERVICEHELPERPACKAGE = "seahorse.internal.business.customerservice.helpers";
	public static final String USERCREDENTIALSERVICEHELPERCLASSNAME = "UserCredentialServiceHelper";
	public static final String INACTIVESTATUS = "INACTIVE";
	public static final String ACTIVESTATUS = "ACTIVE";
	public static final String DATEFORMAT = "yyyy-mm-dd HH:mm:ssZ";
	public static final String CREDENTIAL_ENCRYPT_KEY = "credentialencryptkey";
	public static final String CREDENTIAL_ENCRYPT_VALUE = "credentialencryptvalue";
	
	
	
}
