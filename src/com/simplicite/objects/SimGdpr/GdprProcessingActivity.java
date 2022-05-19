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
	public String getUserKeyLabel(String[] row) {
		return getFieldValue("simPacName", row) + " (" + getFieldValue("simPcsName", row)+")";
	}
	
	@Override
	public void initCreate() {
		
		getField("simPacDateMaj").setVisible(ObjectField.VIS_NOT);
		getFieldArea("SimProcessingActivity-4").setVisible(false);
		getFieldArea("SimProcessingActivity-5").setVisible(false);
		getFieldArea("SimProcessingActivity-6").setVisible(false);
		getFieldArea("SimProcessingActivity-7").setVisible(false);
		getFieldArea("SimProcessingActivity-8").setVisible(false);
	}
	
	@Override
	public void initUpdate() {
		
		getField("simPacDateMaj").setVisible(ObjectField.VIS_BOTH);
		getFieldArea("SimProcessingActivity-4").setVisible(true);
		getFieldArea("SimProcessingActivity-5").setVisible(true);
		getFieldArea("SimProcessingActivity-6").setVisible(true);
		getFieldArea("SimProcessingActivity-7").setVisible(true);
		getFieldArea("SimProcessingActivity-8").setVisible(true);
	}
	
	@Override
	public List<String> preValidate() {
		
		List<String> msgs = new ArrayList<>();
		
		if(isNew()){
	        setFieldValue("simPacRef", Tool.getCurrentMonth() + "-" + "0000");
		}
		return msgs;
	}
	
	@Override
	public String preCreate() {
		
		String numDossier = getGrant().simpleQuery("select count(*) from sim_processingactivity");
	    String num = ("0000" + numDossier).substring(numDossier.length());
	    setFieldValue("simPacRef", Tool.getCurrentMonth() + "-" + num);
	
		setFieldValue("simPacDateCrea", Tool.getCurrentDate());
	    setFieldValue("simPacDateMaj", Tool.getCurrentDate());
			
		return null;
	}
	
	/**
	 * User creating processing activity is by default the owner
	 */ 
	@Override
	public String postCreate() {
		
		Grant g = getGrant();
		
		ObjectDB actorPacObject = g.getTmpObject("SimActorPac");
		actorPacObject.setFieldValue("simActorPacActorId", g.getUserUniqueId());
		actorPacObject.setFieldValue("simActorPacPacId", getRowId());
		actorPacObject.setFieldValue("simActorType", "RESP");
		actorPacObject.create();
		
		return null;
	}
	
	@Override
	public String preUpdate() {
		
		Grant g = getGrant();
		
		setFieldValue("simPacCompFinal", checkCompletionOfArea("SimProcessingActivity-5"));
		setFieldValue("simPacCompFinal", checkCompletionOfArea("SimProcessingActivity-6"));
		
		//Check in the N-N there is a reference to the current Processing activity
		Integer countActor = Integer.parseInt(g.simpleQuery("select count(*) from SIM_ACTORPAC where SIM_ACTORPACPAC_ID = "+getRowId()));
		setFieldValue("simPacCompActor", countActor>0);
		
		Integer countData = Integer.parseInt(g.simpleQuery("select count(*) from SIM_PAC_PVD where PACPVD_PAC_ID = "+getRowId()));
		setFieldValue("simPacCompData", countData>0);
		
		Integer countDest = Integer.parseInt(g.simpleQuery("select count(*) from SIM_RECEPPAC where SIM_RECEPPACPAC_ID = "+getRowId()));
		setFieldValue("simPacCompDest", countDest>0);		
		
		List<String> completionList = new ArrayList<>();
		completionList.add(getFieldValue("simPacCompFinal"));
		completionList.add(getFieldValue("simPacCompActor"));
		completionList.add(getFieldValue("simPacCompSecurity"));
		completionList.add(getFieldValue("simPacCompData"));
		completionList.add(getFieldValue("simPacCompDest"));
		
		int globalCompletion = 0;
		for(String item : completionList){
			if(item == "1")
				globalCompletion++;
		}
		
		int compPercentage = (globalCompletion/5)*100;
		setFieldValue("simPacCompGlobal", compPercentage);
		
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
			String fieldValue = field.getValue();
			if(!"".equals(fieldValue)){
				nbFieldsCompleted ++;	
			}
		}
		return nbFieldsCompleted == nbFieldsInArea;
		
	}
	
}
