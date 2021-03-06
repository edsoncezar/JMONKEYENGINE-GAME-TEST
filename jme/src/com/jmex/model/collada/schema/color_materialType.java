/**
 * color_materialType.java
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


public class color_materialType extends com.jmex.xml.xml.Node {

	public color_materialType(color_materialType node) {
		super(node);
	}

	public color_materialType(org.w3c.dom.Node node) {
		super(node);
	}

	public color_materialType(org.w3c.dom.Document doc) {
		super(doc);
	}

	public color_materialType(com.jmex.xml.xml.Document doc, String namespaceURI, String prefix, String name) {
		super(doc, namespaceURI, prefix, name);
	}
	
	public void adjustPrefix() {
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "face" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "face", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new faceType2(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "mode" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "mode", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new modeType(tmpNode).adjustPrefix();
		}
	}
	public void setXsiType() {
 		org.w3c.dom.Element el = (org.w3c.dom.Element) domNode;
		el.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:type", "color_material");
	}

	public static int getfaceMinCount() {
		return 1;
	}

	public static int getfaceMaxCount() {
		return 1;
	}

	public int getfaceCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "face");
	}

	public boolean hasface() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "face");
	}

	public faceType2 newface() {
		return new faceType2(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "face"));
	}

	public faceType2 getfaceAt(int index) throws Exception {
		return new faceType2(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "face", index));
	}

	public org.w3c.dom.Node getStartingfaceCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "face" );
	}

	public org.w3c.dom.Node getAdvancedfaceCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "face", curNode );
	}

	public faceType2 getfaceValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new faceType2(curNode);
	}

	public faceType2 getface() throws Exception 
 {
		return getfaceAt(0);
	}

	public void removefaceAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "face", index);
	}

	public void removeface() {
		removefaceAt(0);
	}

	public org.w3c.dom.Node addface(faceType2 value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "face", value);
	}

	public void insertfaceAt(faceType2 value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "face", index, value);
	}

	public void replacefaceAt(faceType2 value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "face", index, value);
	}

	public static int getmodeMinCount() {
		return 1;
	}

	public static int getmodeMaxCount() {
		return 1;
	}

	public int getmodeCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "mode");
	}

	public boolean hasmode() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "mode");
	}

	public modeType newmode() {
		return new modeType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "mode"));
	}

	public modeType getmodeAt(int index) throws Exception {
		return new modeType(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "mode", index));
	}

	public org.w3c.dom.Node getStartingmodeCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "mode" );
	}

	public org.w3c.dom.Node getAdvancedmodeCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "mode", curNode );
	}

	public modeType getmodeValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new modeType(curNode);
	}

	public modeType getmode() throws Exception 
 {
		return getmodeAt(0);
	}

	public void removemodeAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "mode", index);
	}

	public void removemode() {
		removemodeAt(0);
	}

	public org.w3c.dom.Node addmode(modeType value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "mode", value);
	}

	public void insertmodeAt(modeType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "mode", index, value);
	}

	public void replacemodeAt(modeType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "mode", index, value);
	}

}
