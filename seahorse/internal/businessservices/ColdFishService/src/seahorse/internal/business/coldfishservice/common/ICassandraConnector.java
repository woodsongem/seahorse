package seahorse.internal.business.coldfishservice.common;
/**
 * 
 */


import com.datastax.driver.core.Session;

/**
 * @author sajanmje
 *
 */
public interface ICassandraConnector {
	void connect(final String node, final int port,final String keyspaceName);
	Session getSession();
	void close();
}
