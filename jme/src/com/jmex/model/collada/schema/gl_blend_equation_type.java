/**
 * gl_blend_equation_type.java
 *
 * This file was generated by XMLSpy 2007sp2 Enterprise Edition.
 *
 * YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
 * OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION.
 *
 * Refer to the XMLSpy Documentation for further details.
 * http://www.altova.com/xmlspy
 */


package com.jmex.model.collada.schema;

import com.jmex.xml.types.SchemaString;

public class gl_blend_equation_type extends SchemaString {
	public static final int EFUNC_ADD = 0; /* FUNC_ADD */
	public static final int EFUNC_SUBTRACT = 1; /* FUNC_SUBTRACT */
	public static final int EFUNC_REVERSE_SUBTRACT = 2; /* FUNC_REVERSE_SUBTRACT */
	public static final int EMIN = 3; /* MIN */
	public static final int EMAX = 4; /* MAX */

	public static String[] sEnumValues = {
		"FUNC_ADD",
		"FUNC_SUBTRACT",
		"FUNC_REVERSE_SUBTRACT",
		"MIN",
		"MAX",
	};

	public gl_blend_equation_type() {
		super();
	}

	public gl_blend_equation_type(String newValue) {
		super(newValue);
		validate();
	}

	public gl_blend_equation_type(SchemaString newValue) {
		super(newValue);
		validate();
	}

	public static int getEnumerationCount() {
		return sEnumValues.length;
	}

	public static String getEnumerationValue(int index) {
		return sEnumValues[index];
	}

	public static boolean isValidEnumerationValue(String val) {
		for (int i = 0; i < sEnumValues.length; i++) {
			if (val.equals(sEnumValues[i]))
				return true;
		}
		return false;
	}

	public void validate() {

		if (!isValidEnumerationValue(toString()))
			throw new com.jmex.xml.xml.XmlException("Value of gl_blend_equation_type is invalid.");
	}
}
