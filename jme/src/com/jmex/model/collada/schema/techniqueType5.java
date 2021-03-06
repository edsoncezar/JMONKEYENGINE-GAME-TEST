/**
 * techniqueType5.java
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

import com.jmex.xml.types.SchemaNMToken;

public class techniqueType5 extends com.jmex.xml.xml.Node {

	public techniqueType5(techniqueType5 node) {
		super(node);
	}

	public techniqueType5(org.w3c.dom.Node node) {
		super(node);
	}

	public techniqueType5(org.w3c.dom.Document doc) {
		super(doc);
	}

	public techniqueType5(com.jmex.xml.xml.Document doc, String namespaceURI, String prefix, String name) {
		super(doc, namespaceURI, prefix, name);
	}
	
	public void adjustPrefix() {
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "profile" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "profile", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
	}
	public void setXsiType() {
 		org.w3c.dom.Element el = (org.w3c.dom.Element) domNode;
		el.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:type", "technique");
	}

	public static int getprofileMinCount() {
		return 1;
	}

	public static int getprofileMaxCount() {
		return 1;
	}

	public int getprofileCount() {
		return getDomChildCount(Attribute, null, "profile");
	}

	public boolean hasprofile() {
		return hasDomChild(Attribute, null, "profile");
	}

	public SchemaNMToken newprofile() {
		return new SchemaNMToken();
	}

	public SchemaNMToken getprofileAt(int index) throws Exception {
		return new SchemaNMToken(getDomNodeValue(getDomChildAt(Attribute, null, "profile", index)));
	}

	public org.w3c.dom.Node getStartingprofileCursor() throws Exception {
		return getDomFirstChild(Attribute, null, "profile" );
	}

	public org.w3c.dom.Node getAdvancedprofileCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Attribute, null, "profile", curNode );
	}

	public SchemaNMToken getprofileValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new SchemaNMToken(getDomNodeValue(curNode));
	}

	public SchemaNMToken getprofile() throws Exception 
 {
		return getprofileAt(0);
	}

	public void removeprofileAt(int index) {
		removeDomChildAt(Attribute, null, "profile", index);
	}

	public void removeprofile() {
		removeprofileAt(0);
	}

	public org.w3c.dom.Node addprofile(SchemaNMToken value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Attribute, null, "profile", value.toString());
	}

	public org.w3c.dom.Node addprofile(String value) throws Exception {
		return addprofile(new SchemaNMToken(value));
	}

	public void insertprofileAt(SchemaNMToken value, int index) {
		insertDomChildAt(Attribute, null, "profile", index, value.toString());
	}

	public void insertprofileAt(String value, int index) throws Exception {
		insertprofileAt(new SchemaNMToken(value), index);
	}

	public void replaceprofileAt(SchemaNMToken value, int index) {
		replaceDomChildAt(Attribute, null, "profile", index, value.toString());
	}

	public void replaceprofileAt(String value, int index) throws Exception {
		replaceprofileAt(new SchemaNMToken(value), index);
	}

}
