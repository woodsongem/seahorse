/**
 * 
 */

package seahorse.internal.business.customerservice.common;

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
