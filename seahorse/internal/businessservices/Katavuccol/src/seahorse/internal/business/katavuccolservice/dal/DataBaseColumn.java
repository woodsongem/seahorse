/**
 * 
 */

package seahorse.internal.business.katavuccolservice.dal;

/**
 * @author sajanmje
 *
 */
public class DataBaseColumn {

	
	private DataBaseColumn() {
		throw new IllegalStateException("DataBaseColumn class");
	}

	//common
	public static final String ID = "id";
	public static final String STATUS = "status";
	public static final String CREATEDDATE="createddate";
	public static final String CREATEDBY="createdby";
	public static final String MODIFIEDBY="modifiedby";
	public static final String MODIFIEDDATE="modifieddate";
	public static final String USERID="userid";
	public static final String IPADDRESS="ipaddress";
	
	//income type	
	public static final String INCOMETYPE_USERID="userid";
	public static final String INCOMETYPE_STATUS="status";
	public static final String INCOMETYPE_CATEGORY="category";
	public static final String INCOMETYPE_CREATEDBY="createdby";
	public static final String INCOMETYPE_CREATEDDATE="createddate";
	public static final String INCOMETYPE_DESCRIPTION="description";
	public static final String INCOMETYPE_MODIFIEDBY="modifiedby";
	public static final String INCOMETYPE_MODIFIEDDATE="modifieddate";
	public static final String INCOMETYPE_NAME="name";
	public static final String INCOMETYPE_INCOMETYPECATEGORY="incometypecategory";
	
	//credential	
	public static final String CREDENTIAL_CATEGORYID = "categoryid";
	public static final String CREDENTIAL_CREDENTIAL_TYPEID = "credentialtypeid";
	public static final String CREDENTIAL_DESCRIPTION = "description";
	public static final String CREDENTIAL_PARENTID = "parentid";
	public static final String CREDENTIAL_VALUE = "value";
	public static final String CREDENTIAL_USERENCRYPTKEY = "userencryptkey";
	public static final String CREDENTIAL_ENCRYPTKEY = "encryptkey";
	
	//Income Details
	
	public static final String INCOMEDETAIL_AMOUNT="amount";		
	public static final String INCOMEDETAIL_DESCRIPTION="description";
	public static final String INCOMEDETAIL_INCOMETYPEID="incometypeid";
	
	//Category 	
	public static final String CATEGORY_NAME="name";
	public static final String CATEGORY_DESCRIPTION="description";
	public static final String CATEGORY_INCOMEMONTH="incomemonth";
	public static final String CATEGORY_INCOMEYEAR="incomeyear";
	public static final String CATEGORY_PARENTID="parentid";
	public static final String CATEGORY_AMOUNT="amount";
	
	//Credential Type
	public static final String CREDENTIALTYPE_NAME = "name";
	public static final String CREDENTIALTYPE_DESCRIPTION = "description";
	public static final String CREDENTIALTYPE_ISDUPLICATIONALLOWED = "isduplicationallowed";
	public static final String CREDENTIALTYPE_ISSUBITEMALLOWED = "issubitemallowed";
	public static final String CREDENTIALTYPE_TYPE = "type";
	
	//user credential
	public static final String USERCREDENTIAL_USERNAME = "username";
	
}
