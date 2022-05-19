package com.simplicite.objects.SimGdpr;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;

/**
 * Business object SimActor
 */
public class GdprActor extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void postLoad() {
		//LEGACY
		//	this.setDefaultSearchSpec("t.ROW_MODULE_ID=31");
	}
	
	@Override
	public void initRefSelect(ObjectDB parent) {
		/**LEGACY
		 * 
		 * AppLog.info(parent.getFieldValue("simPacPcsId"), getGrant());
		 */ 
	}
	
}
