package com.simplicite.objects.SimGdpr;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;

/**
 * Business object GdprProcessingActivity
 */
public class GdprProcessingActivity extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void initCreate() {
		
		getField("gdprPacDateMaj").setVisibility(ObjectField.VIS_NOT);
		getFieldArea("GdprProcessingActivity-4").setVisible(false);
		getFieldArea("GdprProcessingActivity-5").setVisible(false);
		getFieldArea("GdprProcessingActivity-6").setVisible(false);
		getFieldArea("GdprProcessingActivity-7").setVisible(false);
		getFieldArea("GdprProcessingActivity-8").setVisible(false);
	}
	
	@Override
	public void initUpdate() {
		
		getField("gdprPacDateMaj").setVisibility(ObjectField.VIS_BOTH);
		getFieldArea("GdprProcessingActivity-4").setVisible(true);
		getFieldArea("GdprProcessingActivity-5").setVisible(true);
		getFieldArea("GdprProcessingActivity-6").setVisible(true);
		getFieldArea("GdprProcessingActivity-7").setVisible(true);
		getFieldArea("GdprProcessingActivity-8").setVisible(true);
	}
	
	@Override
	public List<String> preValidate() {
		
		List<String> msgs = new ArrayList<>();
		
		if(isNew()){
	        setFieldValue("gdprPacRef", Tool.getCurrentMonth() + "-" + "0000");
		}
		return msgs;
	}
	
	@Override
	public String preCreate() {
		
		String numDossier = getGrant().simpleQuery("select count(*) from gdpr_processing_activity");
	    String num = ("0000" + numDossier).substring(numDossier.length());
	    setFieldValue("gdprPacRef", Tool.getCurrentMonth() + "-" + num);
	
		setFieldValue("gdprPacDateCrea", Tool.getCurrentDate());
	    setFieldValue("gdprPacDateMaj", Tool.getCurrentDate());
			
		return null;
	}
	
	/**
	 * User creating processing activity is by default the owner
	 */ 
	@Override
	public String postCreate() {
		
		Grant g = getGrant();
		
		ObjectDB actorPacObject = g.getTmpObject("GdprActorPac");
		actorPacObject.setFieldValue("gdprActorPacActorId", g.getUserUniqueId());
		actorPacObject.setFieldValue("gdprActorPacPacId", getRowId());
		actorPacObject.setFieldValue("gdprActorType", "RESP");
		actorPacObject.create();
		
		return null;
	}
	
	@Override
	public String preSave() {
		
		Grant g = getGrant();
		
		setFieldValue("gdprPacCompFinal", checkCompletionOfArea("GdprProcessingActivity-5"));
		setFieldValue("gdprPacCompSecurity", checkCompletionOfArea("GdprProcessingActivity-6"));
		
		//Check in the N-N there is a reference to the current Processing activity
		Integer countActor = Integer.parseInt(g.simpleQuery("select count(*) from gdpr_actor_pac where gdpr_actor_pac_pac_id = "+getRowId()));
		setFieldValue("gdprPacCompActor", countActor>0);
		
		Integer countData = Integer.parseInt(g.simpleQuery("select count(*) from gdpr_pac_pvd where pacpvd_pac_id = "+getRowId()));
		setFieldValue("gdprPacCompData", countData>0);
		
		Integer countDest = Integer.parseInt(g.simpleQuery("select count(*) from gdpr_recep_pac where gdpr_recep_pac_pac_id = "+getRowId()));
		setFieldValue("gdprPacCompDest", countDest>0);		
		
		List<String> completionList = new ArrayList<>();
		completionList.add(getFieldValue("gdprPacCompFinal"));
		completionList.add(getFieldValue("gdprPacCompActor"));
		completionList.add(getFieldValue("gdprPacCompSecurity"));
		completionList.add(getFieldValue("gdprPacCompData"));
		completionList.add(getFieldValue("gdprPacCompDest"));
		
		double globalCompletion = 0;
		for(String item : completionList){
			if(item == "1")
				globalCompletion++;
		}
		
		double compPercentage = (globalCompletion/5)*100;
		setFieldValue("gdprPacCompGlobal", compPercentage);
		
		return null;
	}
	
	/**
	 * Count fields in area, compare that number to the number of fields that have a value
	 */ 
	private boolean checkCompletionOfArea(String faName){
		
		List<ObjectField> fields = getFieldArea(faName).getFields();
		int nbFieldsInArea = fields.size();
		int nbFieldsCompleted = 0;
		for(ObjectField field : fields){
			AppLog.info(field.getName(), getGrant());
			String fieldValue = field.getValue();
			if(!"".equals(fieldValue)){
				nbFieldsCompleted ++;	
			}
		}
		AppLog.info(faName, getGrant());
		AppLog.info(String.valueOf(nbFieldsInArea), getGrant());
		AppLog.info(String.valueOf(nbFieldsCompleted), getGrant());
		return nbFieldsCompleted == nbFieldsInArea;
		
	}
	
}
