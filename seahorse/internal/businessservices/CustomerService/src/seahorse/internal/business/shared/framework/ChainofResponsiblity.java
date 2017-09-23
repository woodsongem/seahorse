/**
 * 
 */
package seahorse.internal.business.shared.framework;

import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.Logger;

import seahorse.internal.business.customerservice.datacontracts.ResultMessageEntity;
import seahorse.internal.business.customerservice.datacontracts.ResultStatus;
import seahorse.internal.business.shared.aop.InjectLogger;

/**
 * @author sajanmje
 *
 */
public class ChainofResponsiblity implements IChainofResponsiblity {

	@InjectLogger
	Logger logger;

	private ResultMessageEntity resultMessageEntity;

	public ResultMessageEntity ExecuteResponsibilities(Object request, List<Responsibility> responsibilities) {

		resultMessageEntity = new ResultMessageEntity();

		responsibilities.stream().filter(x -> !x.getIsapplicableforparallel()).forEach(responsiblity -> {
			ResultMessageEntity resultMessageEntityRes = ExecuteResponsiblity(responsiblity, request);
			if (resultMessageEntityRes == null || resultMessageEntityRes.GetResultStatus() != ResultStatus.Success) {
				resultMessageEntity = resultMessageEntityRes;
			}
		});

		/*
		 * responsibilityExec=supplierResponsibilities.get().filter(x ->
		 * !x.getIsapplicableforparallel()); if (responsibilityExec.count() > 0)
		 * { List<Responsibility> nonParaResponsibilities =
		 * responsibilityExec.collect(Collectors.toList()); // Execute non
		 * parallel responsibilities for (Responsibility responsiblity :
		 * nonParaResponsibilities) {
		 * 
		 * try { resultMessageEntity = ExecuteResponsiblity(responsiblity,
		 * request); if (resultMessageEntity.GetResultStatus() !=
		 * ResultStatus.Success) { return resultMessageEntity; }
		 * 
		 * } catch (Exception ex) { logger.
		 * error("Error in ChainofResponsiblity::ExecuteResponsibilities and error Message={0}"
		 * , ex); } } }
		 * 
		 * // Execute parallel responsibilities
		 * responsibilities.parallelStream().filter(x ->
		 * x.getIsapplicableforparallel()).forEach(responsiblity -> { try {
		 * ExecuteResponsiblity(responsiblity, request);
		 * 
		 * } catch (Exception ex) { logger.
		 * error("Error in ChainofResponsiblity::ExecuteResponsibilities and error Message={0}"
		 * , ex); } });
		 */

		return resultMessageEntity;
	}

	public ResultMessageEntity ExecuteResponsiblity(Responsibility responsiblity, Object request) {
		ResultMessageEntity resultMessageEntity = new ResultMessageEntity();
		try {
			Class[] parameter = new Class[1];
			parameter[0] = request.getClass();
			Class<?> cls = Class.forName(responsiblity.GetClassNamewithNameSpace());
			Object obj = cls.newInstance();
			Method method = cls.getDeclaredMethod(responsiblity.getMethodName(), parameter);
			Object response = method.invoke(obj, request);
			resultMessageEntity = (ResultMessageEntity) response;

		} catch (Exception ex) {
			logger.error("Error in ChainofResponsiblity::ExecuteResponsiblity and error Message={0}", ex);
		}
		return resultMessageEntity;
	}

}
