/**
 * 
 */
package seahorse.internal.business.shared.katavuccol.common;

import seahorse.internal.business.shared.katavuccol.common.datacontracts.IDelete;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.IGet;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.IPost;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.IPut;
import seahorse.internal.business.shared.katavuccol.common.datacontracts.ResultResponse;

/**
 * @author SMJE
 *
 */
public interface IKatavuccolClient {

	ResultResponse Get(IGet get);
	ResultResponse Post(IPost get);
	ResultResponse Put(IPut get);
	ResultResponse Delete(IDelete get);
	
}
