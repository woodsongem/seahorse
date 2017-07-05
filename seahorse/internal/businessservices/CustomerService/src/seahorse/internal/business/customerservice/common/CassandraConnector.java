/**
 * 
 */

package seahorse.internal.business.customerservice.common;

import static java.lang.System.out;
import org.apache.commons.lang3.StringUtils;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import com.google.inject.Inject;
import seahorse.internal.business.customerservice.constants.Constant;

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

	final IReadPropertiesFile _readPropertiesFile;

	@Inject
	public CassandraConnector(ReadPropertiesFile readPropertiesFile) {
		this._readPropertiesFile = readPropertiesFile;
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
		final Metadata metadata = cluster.getMetadata();
		out.printf("Connected to cluster: %s\n", metadata.getClusterName());
		for (final Host host : metadata.getAllHosts()) {
			out.printf("Datacenter: %s; Host: %s; Rack: %s\n", host.getDatacenter(), host.getAddress(), host.getRack());
		}
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
		return _readPropertiesFile.GetProperties(Constant.CassandraServe);
	}

	private int getPort() {
		String port = _readPropertiesFile.GetProperties(Constant.CassandraPort);
		if (StringUtils.isNumeric(port)) {
			return Integer.parseInt(port);
		}
		throw new NullPointerException("port is null or not int value in property file");
	}
}
