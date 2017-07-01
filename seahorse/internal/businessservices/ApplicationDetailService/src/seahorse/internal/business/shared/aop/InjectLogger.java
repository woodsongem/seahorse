/**
 * 
 */
package seahorse.internal.business.shared.aop;

import static java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Scope;



/**
 * @author admin
 *
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(FIELD)
public @interface InjectLogger {

}
