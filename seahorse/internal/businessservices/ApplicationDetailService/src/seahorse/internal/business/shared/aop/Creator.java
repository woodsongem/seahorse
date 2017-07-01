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

	private static Injector injector = null;

	public static Injector Init() {
		Guice.createInjector(new ReportModule());
		injector = AddNewExtension(new ShardModules());
		return injector;
	}

	public static Injector AddNewExtension(AbstractModule abstractModule) {
		if (injector == null) {
			Init();
		}

		injector = injector.createChildInjector(abstractModule);
		return injector;
	}

	public static <T> T GetInstance(Class<T> type) {
		return injector.getInstance(type);
	}

}
