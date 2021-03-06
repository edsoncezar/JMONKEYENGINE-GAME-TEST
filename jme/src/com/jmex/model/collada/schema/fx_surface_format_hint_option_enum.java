/**
 * fx_surface_format_hint_option_enum.java
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

public class fx_surface_format_hint_option_enum extends SchemaString {
	public static final int ESRGB_GAMMA = 0; /* SRGB_GAMMA */
	public static final int ENORMALIZED3 = 1; /* NORMALIZED3 */
	public static final int ENORMALIZED4 = 2; /* NORMALIZED4 */
	public static final int ECOMPRESSABLE = 3; /* COMPRESSABLE */

	public static String[] sEnumValues = {
		"SRGB_GAMMA",
		"NORMALIZED3",
		"NORMALIZED4",
		"COMPRESSABLE",
	};

	public fx_surface_format_hint_option_enum() {
		super();
	}

	public fx_surface_format_hint_option_enum(String newValue) {
		super(newValue);
		validate();
	}

	public fx_surface_format_hint_option_enum(SchemaString newValue) {
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
			throw new com.jmex.xml.xml.XmlException("Value of fx_surface_format_hint_option_enum is invalid.");
	}
}
