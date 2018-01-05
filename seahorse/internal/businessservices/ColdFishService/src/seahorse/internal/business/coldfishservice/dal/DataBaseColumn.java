/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal;

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
	
	//user credential
	public static final String USERCREDENTIAL_USERNAME = "username";
	
	//Income Details
	
	public static final String INCOMEDETAIL_AMOUNT="amount";		
	public static final String INCOMEDETAIL_DESCRIPTION="description";
	public static final String INCOMEDETAIL_INCOMETYPEID="incometypeid";
	
	//IncomeCategory	
	public static final String INCOMECATEGORY_NAME="name";
	public static final String INCOMECATEGORY_DESCRIPTION="description";
	public static final String INCOMECATEGORY_INCOMEMONTH="incomemonth";
	public static final String INCOMECATEGORY_INCOMEYEAR="incomeyear";
	public static final String INCOMECATEGORY_PARENTID="parentid";
	public static final String INCOMECATEGORY_AMOUNT="amount";
	
	
}
