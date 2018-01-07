/**
 * 
 */

package seahorse.internal.business.shared.aop;

/**
 * @author admin
 *
 */
public class AopConstant {
	private AopConstant() {
		throw new IllegalStateException("AopConstant class");
	}

	public static final String CALLSTARTED = "CallStarted";
	public static final String CALLENDED = "CallEnded";
	public static final String CALLSTATUS = "CallStatus";
	public static final String METHODNAME = "MethodName";
	public static final String DURATION = "Duration";
	public static final String CLASSNAME = "ClassName";
	public static final String APPLICATIONTRACKING = "ApplicationTracking";
	public static final String AOPAPPLICATIONTRACKING = "AopApplicationTracking";
	public static final String HOSTNAME = "HostName";
}