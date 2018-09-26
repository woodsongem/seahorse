/**
 * 
 */
package seahorse.internal.business.shared.katavuccol.common;

import com.google.inject.Inject;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.Result;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultStatus;

/**
 * @author sajanmje
 *
 */
public class Katavuccolredis implements Ikatavuccolredis {

	final IReadPropertiesFile readPropertiesFile;

	@Inject
	public Katavuccolredis(ReadPropertiesFile readPropertiesFile) {
		this.readPropertiesFile = readPropertiesFile;
	}

	public Result setvalue(String key, Object value) {
		String data = KatavuccolServiceUtility.getString(value);
		String redisServer = null;
		String redisServerPort;
		try {
			redisServer = readPropertiesFile.getProperties(KatavuccolConstant.REDISSERVER);
			redisServerPort = readPropertiesFile.getProperties(KatavuccolConstant.REDISSERVERPORT);
		} catch (Exception e) {
		
		}

		JedisPool pool = new JedisPool(new JedisPoolConfig(), redisServer);
		/// Jedis implements Closeable. Hence, the jedis instance will be auto-closed
		/// after the last statement.
		try (Jedis jedis = pool.getResource()) {
			String status = jedis.set(key, data);
			jedis.expire(key, 86400);
		}

		return new Result(ResultStatus.SUCCESS);
	}

	public String getvalue(String key) {
		String redisServer = null;
		String redisServerPort;
		try {
			redisServer = readPropertiesFile.getProperties(KatavuccolConstant.REDISSERVER);
			redisServerPort = readPropertiesFile.getProperties(KatavuccolConstant.REDISSERVERPORT);
		} catch (Exception e) {
		
		}

		JedisPool pool = new JedisPool(new JedisPoolConfig(), redisServer);
		/// Jedis implements Closeable. Hence, the jedis instance will be auto-closed
		/// after the last statement.
		try (Jedis jedis = pool.getResource()) {
			return jedis.get(key);
		}
	}
}
