/**
 * 
 */
package seahorse.internal.business.katavuccolservice.common;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.inject.Inject;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import seahorse.internal.business.katavuccolservice.common.IReadPropertiesFile;
import seahorse.internal.business.katavuccolservice.common.ReadPropertiesFile;
import seahorse.internal.business.katavuccolservice.common.datacontracts.Result;
import seahorse.internal.business.katavuccolservice.common.datacontracts.ResultStatus;

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
	
	
	public Result setvalue(String key,Object value)
	{		
		String data=KatavuccolServiceUtility.getString(value);
		String redisServer =readPropertiesFile.getProperties(KatavuccolConstant.REDISSERVER);
		String redisServerPort =readPropertiesFile.getProperties(KatavuccolConstant.REDISSERVERPORT);
		
		JedisPool pool = new JedisPool(new JedisPoolConfig(), redisServer);
		/// Jedis implements Closeable. Hence, the jedis instance will be auto-closed after the last statement.
		try (Jedis jedis = pool.getResource()) {
			String status=jedis.set(key, data);
		}	
		
		return new Result(ResultStatus.SUCCESS);
	}
	
	public Result getvalue(String key)
	{		
		String redisServer =readPropertiesFile.getProperties(KatavuccolConstant.REDISSERVER);
		String redisServerPort =readPropertiesFile.getProperties(KatavuccolConstant.REDISSERVERPORT);
		
		JedisPool pool = new JedisPool(new JedisPoolConfig(), redisServer);
		/// Jedis implements Closeable. Hence, the jedis instance will be auto-closed after the last statement.
		try (Jedis jedis = pool.getResource()) {
			String data=jedis.get(key);
			Gson gson=new Gson();
			//gson.fromJson(data, typeOfT)
		}		
		return new Result(ResultStatus.SUCCESS);
	}
}
