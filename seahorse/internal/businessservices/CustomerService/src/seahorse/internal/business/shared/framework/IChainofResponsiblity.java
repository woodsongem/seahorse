/**
 * 
 */
package seahorse.internal.business.shared.framework;

import java.util.List;

import seahorse.internal.business.customerservice.datacontracts.ResultMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IChainofResponsiblity {
	
	ResultMessageEntity ExecuteResponsibilities(Object request, List<Responsibility> responsibilities);
	
	ResultMessageEntity ExecuteResponsiblity(Responsibility responsiblity, Object request) ;
}
