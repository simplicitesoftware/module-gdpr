package com.simplicite.objects.SimGdpr;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;

/**
 * Business object SimPacPvdApp
 */
public class GdprPacPvdApp extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getUserKeyLabel(String[] row) {
		return getFieldValue("simPacPvdEntType", row);
	}
}
