/**
 * 
 */
package seahorse.internal.business.coldfishservice.postprocessors;

import seahorse.internal.business.coldfishservice.dal.datacontracts.IncomeCategoryDAO;
import seahorse.internal.business.coldfishservice.datacontracts.DeleteIncomeCategoryMessageEntity;
import seahorse.internal.business.coldfishservice.datacontracts.IncomeCategoryMessageEntity;

/**
 * @author sajanmje
 *
 */
public class ColdFishServicePostProcessorMapper implements IColdFishServicePostProcessorMapper {

	@Override
	public IncomeCategoryDAO mapIncomeCategoryDAO(DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity) {
		IncomeCategoryDAO incomeCategoryDAO=new IncomeCategoryDAO();
		incomeCategoryDAO.setUserId(deleteIncomeCategoryMessageEntity.getIncomeCategoryMessageEntity().getParsedUserId());
		incomeCategoryDAO.setIncomeMonth(deleteIncomeCategoryMessageEntity.getIncomeCategoryMessageEntity().getIncomeMonth());
		incomeCategoryDAO.setIncomeYear(deleteIncomeCategoryMessageEntity.getIncomeCategoryMessageEntity().getIncomeYear());
		return incomeCategoryDAO;
	}

	@Override
	public DeleteIncomeCategoryMessageEntity mapDeleteIncomeCategoryMessageEntity(IncomeCategoryDAO resultIncomeCategoryDAO) {
		DeleteIncomeCategoryMessageEntity deleteIncomeCategoryMessageEntity=new DeleteIncomeCategoryMessageEntity();
		deleteIncomeCategoryMessageEntity.setParsedId(resultIncomeCategoryDAO.getId());
		IncomeCategoryMessageEntity incomeCategoryMessageEntity=new IncomeCategoryMessageEntity();
		incomeCategoryMessageEntity.setParsedUserId(resultIncomeCategoryDAO.getUserId());
		incomeCategoryMessageEntity.setIncomeMonth(resultIncomeCategoryDAO.getIncomeMonth());
		incomeCategoryMessageEntity.setIncomeYear(resultIncomeCategoryDAO.getIncomeYear());
		deleteIncomeCategoryMessageEntity.setIncomeCategoryMessageEntity(incomeCategoryMessageEntity);
		return deleteIncomeCategoryMessageEntity;				
	}

}
