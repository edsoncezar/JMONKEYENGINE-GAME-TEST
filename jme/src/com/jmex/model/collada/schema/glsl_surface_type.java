/**
 * glsl_surface_type.java
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


public class glsl_surface_type extends fx_surface_common {

	public glsl_surface_type(glsl_surface_type node) {
		super(node);
	}

	public glsl_surface_type(org.w3c.dom.Node node) {
		super(node);
	}

	public glsl_surface_type(org.w3c.dom.Document doc) {
		super(doc);
	}

	public glsl_surface_type(com.jmex.xml.xml.Document doc, String namespaceURI, String prefix, String name) {
		super(doc, namespaceURI, prefix, name);
	}
	
	public void adjustPrefix() {
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "generator" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "generator", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new generatorType2(tmpNode).adjustPrefix();
		}

		super.adjustPrefix();
	}
	public void setXsiType() {
 		org.w3c.dom.Element el = (org.w3c.dom.Element) domNode;
		el.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:type", "glsl_surface_type");
	}

	public static int getgeneratorMinCount() {
		return 0;
	}

	public static int getgeneratorMaxCount() {
		return 1;
	}

	public int getgeneratorCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "generator");
	}

	public boolean hasgenerator() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "generator");
	}

	public generatorType2 newgenerator() {
		return new generatorType2(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "generator"));
	}

	public generatorType2 getgeneratorAt(int index) throws Exception {
		return new generatorType2(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "generator", index));
	}

	public org.w3c.dom.Node getStartinggeneratorCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "generator" );
	}

	public org.w3c.dom.Node getAdvancedgeneratorCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "generator", curNode );
	}

	public generatorType2 getgeneratorValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new generatorType2(curNode);
	}

	public generatorType2 getgenerator() throws Exception 
 {
		return getgeneratorAt(0);
	}

	public void removegeneratorAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "generator", index);
	}

	public void removegenerator() {
		removegeneratorAt(0);
	}

	public org.w3c.dom.Node addgenerator(generatorType2 value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "generator", value);
	}

	public void insertgeneratorAt(generatorType2 value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "generator", index, value);
	}

	public void replacegeneratorAt(generatorType2 value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "generator", index, value);
	}

}
