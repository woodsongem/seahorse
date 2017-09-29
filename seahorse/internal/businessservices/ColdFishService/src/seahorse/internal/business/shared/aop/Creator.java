/**
 * 
 */
package seahorse.internal.business.shared.aop;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author admin
 *
 */
public class Creator {

	private Creator() {
		throw new IllegalStateException("Creator class");
	}

	private static Injector injector = null;

	public static Injector init() {
		Guice.createInjector(new ReportModule());
		injector = addNewExtension(new ShardModules());
		return injector;
	}

	public static Injector addNewExtension(AbstractModule abstractModule) {
		if (injector == null) {
			init();
		}

		injector = injector.createChildInjector(abstractModule);
		return injector;
	}

	public static <T> T getInstance(Class<T> type) {
		return injector.getInstance(type);
	}

}
