/**
 * 
 */
package seahorse.internal.business.coldfishservice.dal;

/**
 * @author sajanmje
 *
 */
public class QueryConstants {
	
	private QueryConstants() {
		throw new IllegalStateException("QueryConstants class");
	}

	public static final String GETINCOMETYPEBYUSERIDQUERY = "SELECT userid, status, id, category,incometypecategory, createdby, createddate, description, modifiedby, modifieddate, name FROM coldfish_dev.incometype where userid={0}";
	public static final String GETINCOMETYPEQUERY = "SELECT userid, status, id, category, incometypecategory, createdby, createddate, description, modifiedby, modifieddate, name  FROM coldfish_dev.incometype where category=''{0}''";
	public static final String CREATEINCOMETYPEQUERY="INSERT INTO coldfish_dev.incometype (userid, status, id, category, createdby, createddate, description, name) VALUES({0}, ''{1}'', {2}, ''{3}'', ''{4}'', ''{5}'',''{6}'', ''{7}'')";
	public static final String GETUSERCREDENTIALQUERY = "SELECT id, username, password, createdby, createddate, modifiedby, modifieddate, productitemid, status FROM coldfish_dev.usercredential where id={0}";
	public static final String GETINCOMEDETAILBYIDQUERY = "SELECT id, category, createdby, createddate, description, incometypecategory, modifiedby, modifieddate, name, status, userid FROM coldfish_dev.incometype where id= {0}";
	public static final String CREATEINCOMEDETAILQUERY = "INSERT INTO coldfish_dev.incomedetails (id, amount, createdby, createddate, description, incometypeid, status, userid) VALUES({0},{1},''{2}'',''{3}'',''{4}'',{5},''{6}'',{7})";
	public static final String GETINCOMEDETAILBYUSERIDQUERY = "SELECT id, amount, createdby, createddate, description, incometypeid, modifiedby, modifieddate, status, userid FROM coldfish_dev.incomedetails where userid= {0}";
	public static final String GETDEFAULTINCOMETYPEQUERY = "SELECT id, category, createdby, createddate, description, incometypecategory, modifiedby, modifieddate, name, status, userid FROM coldfish_dev.incometype where type=''{0}'')";
	public static final String GETINCOMECATEGORYBYUSERIDQUERY = "SELECT id, createdby, createddate, description, modifiedby, modifieddate, name, status, type, userid FROM coldfish_dev.incomecategory where userid= {0}";
	public static final String CREATEINCOMECATEGORYQUERY = "INSERT INTO coldfish_dev.incomecategory (id, createdby, createddate, description, name, status, type, userid) VALUES({0}, ''{1}'', ''{2}'', ''{3}'', ''{4}'', ''{5}'', ''{6}'', {7})"; 
}
