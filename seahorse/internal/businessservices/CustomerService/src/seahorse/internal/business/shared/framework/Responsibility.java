/**
 * 
 */
package seahorse.internal.business.shared.framework;

/**
 * @author sajanmje
 *
 */
public class Responsibility {

	private String packagename;
	private String classname;
	private String methodname;
	private Boolean failedtocontinue;
	private int order;
	private Boolean isapplicableforparallel;
	/**
	 * @return the classname
	 */
	public String getClassname() {
		return classname;
	}
	/**
	 * @param classname the classname to set
	 */
	public void setClassName(String classname) {
		this.classname = classname;
	}
	/**
	 * @return the methodname
	 */
	public String getMethodName() {
		return methodname;
	}
	/**
	 * @param methodname the methodname to set
	 */
	public void setMethodName(String methodname) {
		this.methodname = methodname;
	}
	/**
	 * @return the packagename
	 */
	public String getPackagename() {
		return packagename;
	}
	/**
	 * @param packagename the packagename to set
	 */
	public void setPackageName(String packagename) {
		this.packagename = packagename;
	}
	/**
	 * @return the failedtocontinue
	 */
	public Boolean getFailedtocontinue() {
		return failedtocontinue;
	}
	/**
	 * @param failedtocontinue the failedtocontinue to set
	 */
	public void setFailedtocontinue(Boolean failedtocontinue) {
		this.failedtocontinue = failedtocontinue;
	}
	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}
	/**
	 * @return the isapplicableforparallel
	 */
	public Boolean getIsapplicableforparallel() {
		return isapplicableforparallel;
	}
	/**
	 * @param isapplicableforparallel the isapplicableforparallel to set
	 */
	public void setIsapplicableforparallel(Boolean isapplicableforparallel) {
		this.isapplicableforparallel = isapplicableforparallel;
	}
	
	public String GetClassNamewithNameSpace()
	{
		return this.getPackagename() + "." + this.getClassname();
	}
}
