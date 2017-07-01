/**
 * 
 */
package seahorse.internal.business.shared.aop;

import java.lang.reflect.Field;

import org.apache.logging.log4j.Logger;

import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

/**
 * @author admin
 *
 */
public class Log4JTypeListener implements TypeListener {

	@Override
	public <T> void hear(TypeLiteral<T> typeLiteral, TypeEncounter<T> typeEncounter) {
		Class<?> clazz = typeLiteral.getRawType();
		while (clazz != null) {
			for (Field field : clazz.getDeclaredFields()) {
				if (field.getType() == Logger.class && field.isAnnotationPresent(InjectLogger.class)) {
					typeEncounter.register(new Log4JMembersInjector<T>(field));
				}
			}
			clazz = clazz.getSuperclass();
		}

	}

}
