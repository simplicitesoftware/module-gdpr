package com.simplicite.objects.SimGdpr;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;

/**
 * Business object SimActorPac
 */
public class GdprActorPac extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void postLoad() {
		
		/** LEGACY
		Grant g = getGrant();
		boolean[] rights = g.changeAccess("User", true, true, true, true);
		ObjectDB user = g.getTmpObject("User");
		
		user.resetFilters();
		user.resetValues();
		
		user.setFieldFilter("usr_login", g.getLogin());
		List<String[]> users = user.search();
		
		if(users != null){
			
		}*/
		
		//SHOULD BE DONE IN initList ?
		Grant g = getGrant();
		if(isHomeInstance() && g.hasResponsibility("SIM_GDPR_USER")){
    		setSearchSpec("t_simActorPacActorId.usr_login =" + "'" + g.getLogin() + "'");
		}
	}
	
	/**
	 * Label displayed is : FirstName LastName UserType
	 */
	@Override
	public String getUserKeyLabel(String[] row) {
		String label = getFieldValue("usr_first_name", row) + " " + getFieldValue("usr_last_name", row) + " " + getFieldDisplayValue("simActorType", row);
		return label;
	}
	
	/**
	 * Check that there isn't already a Responsable for the Process 
	 */
	@Override
	public List<String> preValidate() {
		List<String> msgs = new ArrayList<>();
		Grant g = getGrant();
		
		if("RESP".equals(getFieldValue("simActorType"))){
			String exists = g.simpleQuery("select count(*) from SIM_ACTORPAC where SIM_ACTORPACPAC_ID = "+getFieldValue("simActorPacPacId")+" and ACTOR_TYPE = 'RESP'");
			if(Integer.parseInt(exists) > 0)
				msgs.add(Message.formatSimpleError("Il existe déjà un responsable pour ce traitement"));
		}
		return msgs;
	}
	
	@Override
	public String preUpdate() {
		
		Grant g = getGrant();
		List<ObjectField> fields = getFields();
		int completion = 0;
		int size = fields.size();
		
		for(ObjectField field : fields){
			String fieldValue = field.getValue();
			if(!Tool.isEmpty(fieldValue)){
				completion++;
			}
		}
		
		int comp = (completion/size)*100;
		if(comp>95) comp = 100;
		setFieldValue("simProgress", comp);
		
		return null;
	}
	
}
