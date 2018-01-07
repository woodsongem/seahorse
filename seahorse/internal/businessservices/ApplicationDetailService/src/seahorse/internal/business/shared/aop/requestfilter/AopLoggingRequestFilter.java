/**
 * 
 */
package seahorse.internal.business.shared.aop.requestfilter;

import java.io.IOException;
import java.util.UUID;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

import seahorse.internal.business.shared.aop.AopConstant;
import seahorse.internal.business.shared.aop.datacontracts.AopApplicationTracking;
import seahorse.internal.business.shared.aop.datacontracts.ApplicationTracking;

/**
 * @author admin
 *
 */
public class AopLoggingRequestFilter implements ContainerRequestFilter {
	// get log4j
	private static final Logger logger = LogManager.getLogger(AopLoggingRequestFilter.class);

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		String applicationTrackingDetail = requestContext.getHeaderString(AopConstant.ApplicationTracking);
		if (applicationTrackingDetail == null)
			return;
		ObjectMapper mapper = new ObjectMapper();
		ApplicationTracking applicationTracking = null;
		try {
			applicationTracking = mapper.readValue(applicationTrackingDetail, ApplicationTracking.class);

		} catch (Exception ex) {
			logger.error("Error in ApplicationTracking conversion=" + ex);
		}
		AopApplicationTracking aopApplicationTracking = new AopApplicationTracking();
		
		if (applicationTracking == null)
		{
			UUID uuid = UUID.randomUUID();
			aopApplicationTracking.setTrackingid(uuid.toString());
		}
		else
			aopApplicationTracking.setTrackingid(applicationTracking.getTrackingId());
		
		requestContext.setProperty(AopConstant.AopApplicationTracking, aopApplicationTracking);
	}
}
