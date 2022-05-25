package com.simplicite.objects.SimGdpr;

import java.util.*;
import com.simplicite.util.*;

/**
 * Business object GdprActorPac
 */
public class GdprActorPac extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void postLoad() {
		
		//SHOULD BE DONE IN initList ?
		Grant g = getGrant();
		if(isHomeInstance() && g.hasResponsibility("GDPR_USER")){
    		setSearchSpec("t_gdpr_actor_pac_actor_id.usr_login =" + "'" + g.getLogin() + "'");
		}
	}
	
	
	/**
	 * Check that there isn't already a Responsible for the Process 
	 */
	@Override
	public List<String> preValidate() {
		List<String> msgs = new ArrayList<>();
		Grant g = getGrant();
		
		if("RESP".equals(getFieldValue("gdprActorType"))){
			String exists = g.simpleQuery("select count(*) from gdpr_actor_pac where gdpr_actor_pac_actor_id = "+getFieldValue("gdprActorPacPacId")+" and gdpr_actor_type = 'RESP'");
			if(Integer.parseInt(exists) > 0)
				msgs.add(Message.formatSimpleError("Il existe déjà un responsable pour ce traitement"));
		}
		return msgs;
	}
	
}
