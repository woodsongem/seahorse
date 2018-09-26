package seahorse.internal.business.katavuccol.common;
/**
 * 
 */


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

/**
 * @author sajanmje
 *
 */
public class ReadPropertiesFile implements IReadPropertiesFile {
	
	
	@Inject
	public ReadPropertiesFile()
	{
		// Do nothing because of any object is not required
	}

	@InjectLogger
	Logger logger;
	
	public  String getProperties(String key ) {
		Properties properties = new Properties();
		 // Get the inputStream
        InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream("KatavuccolService.properties");
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			logger.error("Error while reading property file=",e);			
		}
		return properties.getProperty(key);		
		
	}

}
