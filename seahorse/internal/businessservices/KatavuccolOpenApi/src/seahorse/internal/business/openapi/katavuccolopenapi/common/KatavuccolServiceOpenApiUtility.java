/**
 * 
 */
package seahorse.internal.business.openapi.katavuccolopenapi.common;

import seahorse.internal.business.shared.katavuccol.common.KatavuccolServiceUtility;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;

/**
 * @author SMJE
 *
 */
public class KatavuccolServiceOpenApiUtility {

	public static OutPutResponse getOutPutResponse(String errorCode, String paramterName, ResultStatus resultStatus) {
		OutPutResponse outPutResponse = new OutPutResponse();
		outPutResponse.setResultStatus(resultStatus);
		outPutResponse.setResultMessage(KatavuccolServiceUtility.getResultMessage(errorCode, paramterName, resultStatus));
		return outPutResponse;
	}
}
