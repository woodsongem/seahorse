/**
 * 
 */
package seahorse.internal.business.applicationservice.verifiers;

import com.google.inject.Inject;

import seahorse.internal.business.applicationservice.common.IReadPropertiesFile;

/**
 * @author sajanmje
 *
 */
public class ApplicationServiceVerifier implements IApplicationServiceVerifier {

private final IReadPropertiesFile _readPropertiesFile;
	
	@Inject
	public ApplicationServiceVerifier(IReadPropertiesFile readPropertiesFile)
	{
		this._readPropertiesFile=readPropertiesFile;
	}
}
