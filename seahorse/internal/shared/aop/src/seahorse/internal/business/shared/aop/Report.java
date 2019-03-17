package seahorse.internal.business.shared.aop;
/**
 * 
 */


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author admin
 *
 */

@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD)
public @interface Report {

}
