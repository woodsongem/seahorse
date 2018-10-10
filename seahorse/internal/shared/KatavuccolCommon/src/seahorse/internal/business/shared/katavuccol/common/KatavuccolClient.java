/**
 * 
 */
package seahorse.internal.business.shared.katavuccol.common;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.IDelete;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.IGet;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.IPost;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.IPut;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultResponse;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;

/**
 * @author SMJE
 *
 */
public class KatavuccolClient implements IKatavuccolClient {
	private Client client = ClientBuilder.newClient();
	private final IReadPropertiesFile readPropertiesFile;

	@Inject
	public KatavuccolClient(IReadPropertiesFile readPropertiesFile) {
		this.readPropertiesFile = readPropertiesFile;
	}

	@Override
	public ResultResponse Get(IGet get) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultResponse Post(IPost post) {
		ResultResponse resultResponse = new ResultResponse();
		resultResponse.setResultStatus(ResultStatus.SUCCESS);
		try {

			String endpoint = readPropertiesFile.getProperties(post.getEndPoint());
			String url = endpoint + post.getUrl();
			Response response = client.target(url).request(MediaType.APPLICATION_JSON)
					.post(Entity.entity(post.getRequest(), MediaType.APPLICATION_JSON));
			String responseString = response.readEntity(String.class);
			 response.getStatusInfo();
			resultResponse.setResponseText(responseString);

		} catch (Exception ex) {
			resultResponse.setResultStatus(ResultStatus.ERROR);
		}

		return resultResponse;
	}

	@Override
	public ResultResponse Put(IPut get) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultResponse Delete(IDelete get) {
		// TODO Auto-generated method stub
		return null;
	}

}
