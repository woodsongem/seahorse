package seahorse.internal.business.shared.katavuccol.common;
/**
 * 
 */

import java.io.InputStream;
import java.util.Properties;

import com.google.inject.Inject;

/**
 * @author sajanmje
 *
 */
public class ReadPropertiesFile implements IReadPropertiesFile {

	@Inject
	public ReadPropertiesFile() {
		// Do nothing because of any object is not required
	}

	public String getProperties(String key) throws Exception {
		Properties properties = new Properties();
		// Get the inputStream
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("service.properties");
		try {
			properties.load(inputStream);
		} catch (Exception e) {
			throw e;
		}
		return properties.getProperty(key);

	}

}
