package com.simplicite.objects.SimGdpr;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;

/**
 * Business object SimPIA
 */
public class GdprPia extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getUserKeyLabel(String[] row) {
		return getFieldValue("simPIAname");
	}
	
	@Override
	public String preCreate() {
		
		String numPIA = getGrant().getNextIdForColumn(getDBName(), "row_id");
	    String num = ("0000" + numPIA).substring(numPIA.length());
	    setFieldValue("simPIAid", Tool.getCurrentMonth() + "-" + num);
		return null;
	}
	
	@Override
	public List<String> preValidate() {
		List<String> msgs = new ArrayList<String>();

		if (isNew()) {
	        setFieldValue("simPIAid", Tool.getCurrentMonth() + "-" + "0000");
	    }
	    StringBuilder impacts = new StringBuilder();
	    impacts.append(this.getFieldValue("simPIAaccesImpact"));
	    impacts.append("\n");
	    impacts.append(this.getFieldValue("simPIAmodifImpact"));
	    impacts.append("\n");
	    impacts.append(this.getFieldValue("simPIAdispImpact"));
		setFieldValue("simPIArecapImpacts", impacts);
		
		StringBuilder menaces = new StringBuilder();
	    menaces.append(this.getFieldDisplayValue("simPIAaccesMenace").replace("/", "\n"));
	    menaces.append("\n");
	    menaces.append(this.getFieldDisplayValue("simPIAmodifsMenace").replace("/", "\n"));
	    menaces.append("\n");
	    menaces.append(this.getFieldDisplayValue("simPIAdispMenaces").replace("/", "\n"));
		setFieldValue("simPIArecapMenaces", menaces);
	
		StringBuilder mesures = new StringBuilder();
		String mD = this.getFieldDisplayValue("simPIAmesuresDonnee").replace("/", "\n");
		String mS = this.getFieldDisplayValue("simPIAmesuresSecuSys").replace("/", "\n");
		String mO = this.getFieldDisplayValue("simPIAmesuresOrga").replace("/", "\n");
		mesures.append(mD);
		mesures.append("\n");
		mesures.append(mS);
		mesures.append("\n");
		mesures.append(mO);
		setFieldValue("simPIArecapMesures", mesures);
		return msgs;
	}
	
	@Override
	public String preSave() {
		if("NONVALID".equals(getFieldValue("simPIAstate")) || "SIMPLVALID".equals(getFieldValue("simPIAstate")) || "SIGNVALID".equals(getFieldValue("simPIAstate")))
			{
				setFieldValue("simPIAdateValidation", Tool.getCurrentDate());
			}
			
		//return Message.formatInfo("INFO_CODE", "Message", "fieldName");
		//return Message.formatWarning("WARNING_CODE", "Message", "fieldName");
		//return Message.formatError("ERROR_CODE", "Message", "fieldName");
		return null;
	}
	
	@Override
	public void initCreate() {
		areaVis(this, false);
	}
	
	@Override
	public void initUpdate() {
		
		areaVis(this, true);
	
		if(!getGrant().hasResponsibility("SIM_RGPD_ADMIN") && (!isNotDraft(this)))
		{
			getFieldArea("SimPIA-Validation").setVisible(false);
		}
		else
			getFieldArea("SimPIA-Validation").setVisible(true);
	}
	
	public void areaVis(ObjectDB obj, boolean state){
		obj.getFieldArea("SimPIA-contexte").setVisible(state);
		obj.getFieldArea("SimPIA-Risques").setVisible(state);
		obj.getFieldArea("SimPIA-Principes").setVisible(state);
		obj.getFieldArea("SimPIA-Validation").setVisible(state);
	}
	
	public boolean isNotDraft(ObjectDB obj){
		
		if("ENAVAL".equals(obj.getFieldValue("simPIAstate")) || "NONVALID".equals(obj.getFieldValue("simPIAstate")) || "SIMPLVALID".equals(obj.getFieldValue("simPIAstate")) || "SIGNVALID".equals(obj.getFieldValue("simPIAstate"))){
			return true;
		} 
		else{
			return false;
		}
			
		
	}
	
}
/*




SimPIA.isNotDraft = function(obj){
	if("ENAVAL".equals(obj.getFieldValue("simPIAstate")) || "NONVALID".equals(obj.getFieldValue("simPIAstate")) || "SIMPLVALID".equals(obj.getFieldValue("simPIAstate")) || "SIGNVALID".equals(obj.getFieldValue("simPIAstate"))){
		console.log("isnotdraft");
		return true
	} 
	else{
		console.log("isdraft");
		return false;
	}
		
}*/