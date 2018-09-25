/**
 * 
 */
package seahorse.internal.business.shared.katavuccol;

import seahorse.internal.business.shared.aop.datacontracts.IDelete;
import seahorse.internal.business.shared.aop.datacontracts.IGet;
import seahorse.internal.business.shared.aop.datacontracts.IPost;
import seahorse.internal.business.shared.aop.datacontracts.IPut;
import seahorse.internal.business.shared.aop.datacontracts.ResultResponse;

/**
 * @author SMJE
 *
 */
public interface IKatavuccolClient {

	ResultResponse Get(IGet get);
	ResultResponse Get(IPost get);
	ResultResponse Get(IPut get);
	ResultResponse Get(IDelete get);
}
