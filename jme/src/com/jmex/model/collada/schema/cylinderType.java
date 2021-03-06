/**
 * cylinderType.java
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


public class cylinderType extends com.jmex.xml.xml.Node {

	public cylinderType(cylinderType node) {
		super(node);
	}

	public cylinderType(org.w3c.dom.Node node) {
		super(node);
	}

	public cylinderType(org.w3c.dom.Document doc) {
		super(doc);
	}

	public cylinderType(com.jmex.xml.xml.Document doc, String namespaceURI, String prefix, String name) {
		super(doc, namespaceURI, prefix, name);
	}
	
	public void adjustPrefix() {
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "height" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "height", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "radius" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "radius", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "extra" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "extra", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new extraType(tmpNode).adjustPrefix();
		}
	}
	public void setXsiType() {
 		org.w3c.dom.Element el = (org.w3c.dom.Element) domNode;
		el.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:type", "cylinder");
	}

	public static int getheightMinCount() {
		return 1;
	}

	public static int getheightMaxCount() {
		return 1;
	}

	public int getheightCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "height");
	}

	public boolean hasheight() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "height");
	}

	public float2 newheight() {
		return new float2();
	}

	public float2 getheightAt(int index) throws Exception {
		return new float2(getDomNodeValue(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "height", index)));
	}

	public org.w3c.dom.Node getStartingheightCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "height" );
	}

	public org.w3c.dom.Node getAdvancedheightCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "height", curNode );
	}

	public float2 getheightValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new float2(getDomNodeValue(curNode));
	}

	public float2 getheight() throws Exception 
 {
		return getheightAt(0);
	}

	public void removeheightAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "height", index);
	}

	public void removeheight() {
		removeheightAt(0);
	}

	public org.w3c.dom.Node addheight(float2 value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "height", value.toString());
	}

	public org.w3c.dom.Node addheight(String value) throws Exception {
		return addheight(new float2(value));
	}

	public void insertheightAt(float2 value, int index) {
		insertDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "height", index, value.toString());
	}

	public void insertheightAt(String value, int index) throws Exception {
		insertheightAt(new float2(value), index);
	}

	public void replaceheightAt(float2 value, int index) {
		replaceDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "height", index, value.toString());
	}

	public void replaceheightAt(String value, int index) throws Exception {
		replaceheightAt(new float2(value), index);
	}

	public static int getradiusMinCount() {
		return 1;
	}

	public static int getradiusMaxCount() {
		return 1;
	}

	public int getradiusCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "radius");
	}

	public boolean hasradius() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "radius");
	}

	public float22 newradius() {
		return new float22();
	}

	public float22 getradiusAt(int index) throws Exception {
		return new float22(getDomNodeValue(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "radius", index)));
	}

	public org.w3c.dom.Node getStartingradiusCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "radius" );
	}

	public org.w3c.dom.Node getAdvancedradiusCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "radius", curNode );
	}

	public float22 getradiusValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new float22(getDomNodeValue(curNode));
	}

	public float22 getradius() throws Exception 
 {
		return getradiusAt(0);
	}

	public void removeradiusAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "radius", index);
	}

	public void removeradius() {
		removeradiusAt(0);
	}

	public org.w3c.dom.Node addradius(float22 value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "radius", value.toString());
	}

	public org.w3c.dom.Node addradius(String value) throws Exception {
		return addradius(new float22(value));
	}

	public void insertradiusAt(float22 value, int index) {
		insertDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "radius", index, value.toString());
	}

	public void insertradiusAt(String value, int index) throws Exception {
		insertradiusAt(new float22(value), index);
	}

	public void replaceradiusAt(float22 value, int index) {
		replaceDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "radius", index, value.toString());
	}

	public void replaceradiusAt(String value, int index) throws Exception {
		replaceradiusAt(new float22(value), index);
	}

	public static int getextraMinCount() {
		return 0;
	}

	public static int getextraMaxCount() {
		return Integer.MAX_VALUE;
	}

	public int getextraCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "extra");
	}

	public boolean hasextra() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "extra");
	}

	public extraType newextra() {
		return new extraType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "extra"));
	}

	public extraType getextraAt(int index) throws Exception {
		return new extraType(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "extra", index));
	}

	public org.w3c.dom.Node getStartingextraCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "extra" );
	}

	public org.w3c.dom.Node getAdvancedextraCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "extra", curNode );
	}

	public extraType getextraValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new extraType(curNode);
	}

	public extraType getextra() throws Exception 
 {
		return getextraAt(0);
	}

	public void removeextraAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "extra", index);
	}

	public void removeextra() {
		while (hasextra())
			removeextraAt(0);
	}

	public org.w3c.dom.Node addextra(extraType value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "extra", value);
	}

	public void insertextraAt(extraType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "extra", index, value);
	}

	public void replaceextraAt(extraType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "extra", index, value);
	}

}
