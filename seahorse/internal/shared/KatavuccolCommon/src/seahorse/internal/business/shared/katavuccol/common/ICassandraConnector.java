package seahorse.internal.business.shared.katavuccol.common;
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
