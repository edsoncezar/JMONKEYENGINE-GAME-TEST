/**
 * unitType.java
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

public class unitType extends com.jmex.xml.xml.Node {

	public unitType(unitType node) {
		super(node);
	}

	public unitType(org.w3c.dom.Node node) {
		super(node);
	}

	public unitType(org.w3c.dom.Document doc) {
		super(doc);
	}

	public unitType(com.jmex.xml.xml.Document doc, String namespaceURI, String prefix, String name) {
		super(doc, namespaceURI, prefix, name);
	}
	
	public void adjustPrefix() {
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "meter" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "meter", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "name" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "name", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
	}
	public void setXsiType() {
 		org.w3c.dom.Element el = (org.w3c.dom.Element) domNode;
		el.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:type", "unit");
	}

	public static int getmeterMinCount() {
		return 0;
	}

	public static int getmeterMaxCount() {
		return 1;
	}

	public int getmeterCount() {
		return getDomChildCount(Attribute, null, "meter");
	}

	public boolean hasmeter() {
		return hasDomChild(Attribute, null, "meter");
	}

	public float2 newmeter() {
		return new float2();
	}

	public float2 getmeterAt(int index) throws Exception {
		return new float2(getDomNodeValue(getDomChildAt(Attribute, null, "meter", index)));
	}

	public org.w3c.dom.Node getStartingmeterCursor() throws Exception {
		return getDomFirstChild(Attribute, null, "meter" );
	}

	public org.w3c.dom.Node getAdvancedmeterCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Attribute, null, "meter", curNode );
	}

	public float2 getmeterValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new float2(getDomNodeValue(curNode));
	}

	public float2 getmeter() throws Exception 
 {
		return getmeterAt(0);
	}

	public void removemeterAt(int index) {
		removeDomChildAt(Attribute, null, "meter", index);
	}

	public void removemeter() {
		removemeterAt(0);
	}

	public org.w3c.dom.Node addmeter(float2 value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Attribute, null, "meter", value.toString());
	}

	public org.w3c.dom.Node addmeter(String value) throws Exception {
		return addmeter(new float2(value));
	}

	public void insertmeterAt(float2 value, int index) {
		insertDomChildAt(Attribute, null, "meter", index, value.toString());
	}

	public void insertmeterAt(String value, int index) throws Exception {
		insertmeterAt(new float2(value), index);
	}

	public void replacemeterAt(float2 value, int index) {
		replaceDomChildAt(Attribute, null, "meter", index, value.toString());
	}

	public void replacemeterAt(String value, int index) throws Exception {
		replacemeterAt(new float2(value), index);
	}

	public static int getnameMinCount() {
		return 0;
	}

	public static int getnameMaxCount() {
		return 1;
	}

	public int getnameCount() {
		return getDomChildCount(Attribute, null, "name");
	}

	public boolean hasname() {
		return hasDomChild(Attribute, null, "name");
	}

	public SchemaNMToken newname() {
		return new SchemaNMToken();
	}

	public SchemaNMToken getnameAt(int index) throws Exception {
		return new SchemaNMToken(getDomNodeValue(getDomChildAt(Attribute, null, "name", index)));
	}

	public org.w3c.dom.Node getStartingnameCursor() throws Exception {
		return getDomFirstChild(Attribute, null, "name" );
	}

	public org.w3c.dom.Node getAdvancednameCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Attribute, null, "name", curNode );
	}

	public SchemaNMToken getnameValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new SchemaNMToken(getDomNodeValue(curNode));
	}

	public SchemaNMToken getname() throws Exception 
 {
		return getnameAt(0);
	}

	public void removenameAt(int index) {
		removeDomChildAt(Attribute, null, "name", index);
	}

	public void removename() {
		removenameAt(0);
	}

	public org.w3c.dom.Node addname(SchemaNMToken value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Attribute, null, "name", value.toString());
	}

	public org.w3c.dom.Node addname(String value) throws Exception {
		return addname(new SchemaNMToken(value));
	}

	public void insertnameAt(SchemaNMToken value, int index) {
		insertDomChildAt(Attribute, null, "name", index, value.toString());
	}

	public void insertnameAt(String value, int index) throws Exception {
		insertnameAt(new SchemaNMToken(value), index);
	}

	public void replacenameAt(SchemaNMToken value, int index) {
		replaceDomChildAt(Attribute, null, "name", index, value.toString());
	}

	public void replacenameAt(String value, int index) throws Exception {
		replacenameAt(new SchemaNMToken(value), index);
	}

}
