package seahorse.internal.business.shared.aop;
/**
 * 
 */


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(CLASS)
@Target({ FIELD, METHOD })
/**
 * @author admin
 *
 */
public @interface Pii {

}
