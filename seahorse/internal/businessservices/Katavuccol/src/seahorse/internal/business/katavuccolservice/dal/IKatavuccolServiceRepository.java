/**
 * 
 */

package seahorse.internal.business.katavuccolservice.dal;

import java.util.List;
import java.util.UUID;

import seahorse.internal.business.katavuccolservice.dal.datacontracts.CategoryDAO;
import seahorse.internal.business.katavuccolservice.dal.datacontracts.TypeDAO;
/**
 * @author sajanmje
 *
 */
public interface IKatavuccolServiceRepository {
	
	CategoryDAO getCategoryDetailsById(UUID categoryId);
	
	TypeDAO getTypeDetailsById(UUID typeId);
}
