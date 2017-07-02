/**
 * 
 */
package seahorse.internal.business.applicationservice.constants;

/**
 * @author sajanmje
 *
 */
public class QueryConstants {

	private QueryConstants() {
		throw new IllegalAccessError("QueryConstants class");
	}

	public static final String getPhoneByIdQuery = "SELECT id, area_code, country_code, created_by, created_date, fullnumber, modified_by, modified_date, number, status, type, verified FROM seahorsedev.ch_phone where id={0} and status ='ACTIVE'";

	public static final String getEmailAddressByIdQuery = "SELECT id, created_by, created_date, emailid, isprimary, modified_by, modified_date, status, verified FROM seahorsedev.ch_email where id={0} and status ='ACTIVE'";

	public static final String GetApplicationByApplicationIdQuery = "SELECT id, aadhar_cardnumber, application_type_id, chaddress_id, chemail_id, chphone_id, chusersecurityquestion_id, created_by, created_date, date_of_birth, death_date, decision, firstname, lastname, marriage_date, middlename, modified_by, modified_date, pan_no, password, reason, reference_no, ssn, username FROM seahorsedev.ch_application where id={0}";

	public static final String GetApplicationByDecisionQuery = "SELECT id, aadhar_cardnumber, application_type_id, chaddress_id, chemail_id, chphone_id, chusersecurityquestion_id, created_by, created_date, date_of_birth, death_date, decision, firstname, lastname, marriage_date, middlename, modified_by, modified_date, pan_no, password, reason, reference_no, ssn, username FROM seahorsedev.ch_application where decision={0}";

	public static final String GetApplicationByReferenceNoQuery = "SELECT id, aadhar_cardnumber, application_type_id, chaddress_id, chemail_id, chphone_id, chusersecurityquestion_id, created_by, created_date, date_of_birth, death_date, decision, firstname, lastname, marriage_date, middlename, modified_by, modified_date, pan_no, password, reason, reference_no, ssn, username FROM seahorsedev.ch_application where reference_no={0}";

	public static final String getUserSecurityQuestionQuery = "SELECT id, application_id, created_by, created_date, modified_by, modified_date, security_answer, security_question, status FROM seahorsedev.ch_usersecurityquestion where application_id={0} and status ='ACTIVE'";

}
