/**
 * 
 */
package seahorse.internal.business.katavuccolservice.datacontracts;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

/**
 * @author sajanmje
 *
 */
public class CredentialsRequestMessageEntity {

	private String username;
	private String password;
	private String name;
	private String url;
	private String userid;
	private UUID id;
	private HttpServletRequest httpRequest;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
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
	 * @return the httpRequest
	 */
	public HttpServletRequest getHttpRequest() {
		return httpRequest;
	}
	/**
	 * @param httpRequest the httpRequest to set
	 */
	public void setHttpRequest(HttpServletRequest httpRequest) {
		this.httpRequest = httpRequest;
	}
	
}
