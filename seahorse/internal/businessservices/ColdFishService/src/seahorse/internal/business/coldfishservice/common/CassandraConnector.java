/**
 * 
 */

package seahorse.internal.business.coldfishservice.common;

import static java.lang.System.out;
import org.apache.commons.lang3.StringUtils;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import com.google.inject.Inject;

import seahorse.internal.business.coldfishservice.constants.Constant;

/**
 * @author sajanmje
 *
 */

/**
 * 
 * Class used for connecting to Cassandra database.
 * 
 */
public class CassandraConnector implements ICassandraConnector {

	final IReadPropertiesFile readPropertiesFile;

	@Inject
	public CassandraConnector(ReadPropertiesFile readPropertiesFile) {
		this.readPropertiesFile = readPropertiesFile;
	}

	/** Cassandra Cluster. */

	private Cluster cluster;

	/** Cassandra Session. */

	private Session session;

	/**
	 * 
	 * Connect to Cassandra Cluster specified by provided node IP
	 * 
	 * address and port number.
	 *
	 * 
	 * 
	 * @param node
	 *            Cluster node IP address.
	 * 
	 * @param port
	 *            Port of cluster host.
	 * 
	 */

	public void connect(String node, int port) {

		if (node == null) {
			node = getNode();
		}
		if (port == 0) {
			port = getPort();
		}

		this.cluster = Cluster.builder().addContactPoint(node).withPort(port).build();				
		session = cluster.connect();
	}

	/**
	 * 
	 * Provide my Session.
	 *
	 * 
	 * 
	 * @return My session.
	 * 
	 */

	public Session getSession() {
		return this.session;
	}

	/** Close cluster. */

	public void close() {
		cluster.close();
	}

	private String getNode() {
		return readPropertiesFile.getProperties(Constant.CASSANDRASERVE);
	}

	private int getPort() {
		String port = readPropertiesFile.getProperties(Constant.CASSANDRAPORT);
		if (StringUtils.isNumeric(port)) {
			return Integer.parseInt(port);
		}
		throw new NullPointerException("port is null or not int value in property file");
	}
}
