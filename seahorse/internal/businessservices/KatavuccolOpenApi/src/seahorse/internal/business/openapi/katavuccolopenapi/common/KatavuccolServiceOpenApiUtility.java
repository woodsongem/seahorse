/**
 * 
 */
package seahorse.internal.business.openapi.katavuccolopenapi.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import seahorse.internal.business.shared.katavuccol.common.KatavuccolServiceUtility;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.OutPutResponse;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;

/**
 * @author SMJE
 *
 */
public class KatavuccolServiceOpenApiUtility {

	private static Gson gson_object;

	public static OutPutResponse getOutPutResponse(String errorCode, String paramterName, ResultStatus resultStatus) {
		OutPutResponse outPutResponse = new OutPutResponse();
		outPutResponse.setResultStatus(resultStatus);
		outPutResponse.setResultMessage(KatavuccolServiceUtility.getResultMessage(errorCode, paramterName, resultStatus));
		return outPutResponse;
	}

	public static Gson getGson() {
		if (gson_object == null) {
			GsonBuilder gsonBuilder = new GsonBuilder();
			// gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.);
			gson_object = gsonBuilder.create();
		}

		return gson_object;
	}
}
