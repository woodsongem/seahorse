/**
 * 
 */
package seahorse.internal.business.customerservice.dal.datacontracts;

import java.util.Date;
import java.util.UUID;

/**
 * @author sajanmje
 *
 */
public class LoginHistoryDAO extends BaseDAO { 
	private UUID id;
	private UUID userid;
	private Date logintime;
	private String ipaddress;
	private String logtype;
	
	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	/**
	 * @return the userid
	 */
	public UUID getUserId() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserId(UUID userid) {
		this.userid = userid;
	}
	/**
	 * @return the logintime
	 */
	public Date getLoginTime() {
		return logintime;
	}
	/**
	 * @param logintime the logintime to set
	 */
	public void setLoginTime(Date logintime) {
		this.logintime = logintime;
	}
	/**
	 * @return the ipaddress
	 */
	public String getIpAddress() {
		return ipaddress;
	}
	/**
	 * @param ipaddress the ipaddress to set
	 */
	public void setIpAddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	/**
	 * @return the logtype
	 */
	public String getLogType() {
		return logtype;
	}
	/**
	 * @param logtype the logtype to set
	 */
	public void setLogtype(String logtype) {
		this.logtype = logtype;
	}	
}
