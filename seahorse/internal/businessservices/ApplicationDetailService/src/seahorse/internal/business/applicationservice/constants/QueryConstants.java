/**
 * 
 */
package seahorse.internal.business.applicationservice.constants;

/**
 * @author sajanmje
 *
 */
public class QueryConstants {
	
	public static String GetApplicationByApplicationIdQuery="SELECT id, aadhar_cardnumber, application_type_id, chaddress_id, chemail_id, chphone_id, chusersecurityquestion_id, created_by, created_date, date_of_birth, death_date, decision, firstname, lastname, marriage_date, middlename, modified_by, modified_date, pan_no, password, reason, reference_no, ssn, username FROM seahorsedev.ch_application where id={0}";
	
	public static String GetApplicationByDecisionQuery="SELECT id, aadhar_cardnumber, application_type_id, chaddress_id, chemail_id, chphone_id, chusersecurityquestion_id, created_by, created_date, date_of_birth, death_date, decision, firstname, lastname, marriage_date, middlename, modified_by, modified_date, pan_no, password, reason, reference_no, ssn, username FROM seahorsedev.ch_application where decision={0}";
	
	public static String GetApplicationByReferenceNoQuery="SELECT id, aadhar_cardnumber, application_type_id, chaddress_id, chemail_id, chphone_id, chusersecurityquestion_id, created_by, created_date, date_of_birth, death_date, decision, firstname, lastname, marriage_date, middlename, modified_by, modified_date, pan_no, password, reason, reference_no, ssn, username FROM seahorsedev.ch_application where reference_no={0}";

}
