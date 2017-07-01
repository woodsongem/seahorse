/**
 * 
 */
package seahorse.internal.business.applicationservice.common;

import com.datastax.driver.core.Session;

/**
 * @author sajanmje
 *
 */
public interface ICassandraConnector {
	void connect(final String node, final int port);
	Session getSession();
	void close();
}
