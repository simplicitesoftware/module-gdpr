package com.simplicite.objects.SimGdpr;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;

/**
 * Business object SimPacPvdEnt
 */
public class GdprPacPvdEnt extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public String getUserKeyLabel(String[] row) {
		String label = getFieldValue("simPacPvdEntType", row);
		return label;
	}
}
