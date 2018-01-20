/**
 * 
 */
package seahorse.internal.business.coldfishservice.postprocessors;

import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeCategoryDAO;
import seahorse.internal.business.coldfishservice.datacontracts.DeleteIncomeCategoryMessageEntity;

/**
 * @author sajanmje
 *
 */
public interface IColdFishServicePostProcessorMapper {

	IncomeCategoryDAO mapIncomeCategoryDAO(DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity);

	DeleteIncomeCategoryMessageEntity mapDeleteIncomeCategoryMessageEntity(IncomeCategoryDAO resultIncomeCategoryDAO);

}
