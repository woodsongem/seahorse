/**
 * 
 */
package seahorse.internal.business.shared.aop.datacontracts;

import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;

/**
 * @author SMJE
 *
 */
public class ResultResponse extends Result {

	private String responseText;

	/**
	 * @return the responseText
	 */
	public String getResponseText() {
		return responseText;
	}

	/**
	 * @param responseText the responseText to set
	 */
	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

}
