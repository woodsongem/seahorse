package seahorse.internal.business.shared.aop;
/**
 * 
 */


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.inject.internal.util.Stopwatch;


/**
 * @author admin
 *
 */
public class LoggingEventHandler implements MethodInterceptor {

	
	private static final Logger logger = LogManager.getLogger(LoggingEventHandler.class);

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = invocation.getMethod().getName();
		String className = invocation.getMethod().getDeclaringClass().getName();
		StringBuilder sb = new StringBuilder();			
		sb.append(AopConstant.CALLSTATUS + "=" + AopConstant.CALLSTARTED);
		sb.append(" " + AopConstant.METHODNAME + "=" + methodName);
		sb.append(" " + AopConstant.CLASSNAME + "=" + className);		
		logger.info(sb.toString());
		Stopwatch stopwatch = new Stopwatch();	
		Object resObject = invocation.proceed();		
		sb = new StringBuilder();
		sb.append(AopConstant.CALLSTATUS + "=" + AopConstant.CALLENDED);
		sb.append(" " + AopConstant.METHODNAME + "=" + methodName);
		long dutation = stopwatch.reset();
		sb.append(" " + AopConstant.DURATION + "=" + Long.toString(dutation));
		sb.append(" " + AopConstant.CLASSNAME + "=" + className);
		logger.info(sb.toString());
		return resObject;
	}

}
