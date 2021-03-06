/**
 * ref_attachmentType.java
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

public class ref_attachmentType extends com.jmex.xml.xml.Node {

	public ref_attachmentType(ref_attachmentType node) {
		super(node);
	}

	public ref_attachmentType(org.w3c.dom.Node node) {
		super(node);
	}

	public ref_attachmentType(org.w3c.dom.Document doc) {
		super(doc);
	}

	public ref_attachmentType(com.jmex.xml.xml.Document doc, String namespaceURI, String prefix, String name) {
		super(doc, namespaceURI, prefix, name);
	}
	
	public void adjustPrefix() {
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "rigid_body" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "rigid_body", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "translate" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "translate", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new TargetableFloat3(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "rotate" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "rotate", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new rotateType(tmpNode).adjustPrefix();
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
		el.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:type", "ref_attachment");
	}

	public static int getrigid_bodyMinCount() {
		return 0;
	}

	public static int getrigid_bodyMaxCount() {
		return 1;
	}

	public int getrigid_bodyCount() {
		return getDomChildCount(Attribute, null, "rigid_body");
	}

	public boolean hasrigid_body() {
		return hasDomChild(Attribute, null, "rigid_body");
	}

	public SchemaString newrigid_body() {
		return new SchemaString();
	}

	public SchemaString getrigid_bodyAt(int index) throws Exception {
		return new SchemaString(getDomNodeValue(getDomChildAt(Attribute, null, "rigid_body", index)));
	}

	public org.w3c.dom.Node getStartingrigid_bodyCursor() throws Exception {
		return getDomFirstChild(Attribute, null, "rigid_body" );
	}

	public org.w3c.dom.Node getAdvancedrigid_bodyCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Attribute, null, "rigid_body", curNode );
	}

	public SchemaString getrigid_bodyValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new SchemaString(getDomNodeValue(curNode));
	}

	public SchemaString getrigid_body() throws Exception 
 {
		return getrigid_bodyAt(0);
	}

	public void removerigid_bodyAt(int index) {
		removeDomChildAt(Attribute, null, "rigid_body", index);
	}

	public void removerigid_body() {
		removerigid_bodyAt(0);
	}

	public org.w3c.dom.Node addrigid_body(SchemaString value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Attribute, null, "rigid_body", value.toString());
	}

	public org.w3c.dom.Node addrigid_body(String value) throws Exception {
		return addrigid_body(new SchemaString(value));
	}

	public void insertrigid_bodyAt(SchemaString value, int index) {
		insertDomChildAt(Attribute, null, "rigid_body", index, value.toString());
	}

	public void insertrigid_bodyAt(String value, int index) throws Exception {
		insertrigid_bodyAt(new SchemaString(value), index);
	}

	public void replacerigid_bodyAt(SchemaString value, int index) {
		replaceDomChildAt(Attribute, null, "rigid_body", index, value.toString());
	}

	public void replacerigid_bodyAt(String value, int index) throws Exception {
		replacerigid_bodyAt(new SchemaString(value), index);
	}

	public static int gettranslateMinCount() {
		return 1;
	}

	public static int gettranslateMaxCount() {
		return 1;
	}

	public int gettranslateCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "translate");
	}

	public boolean hastranslate() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "translate");
	}

	public TargetableFloat3 newtranslate() {
		return new TargetableFloat3(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "translate"));
	}

	public TargetableFloat3 gettranslateAt(int index) throws Exception {
		return new TargetableFloat3(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "translate", index));
	}

	public org.w3c.dom.Node getStartingtranslateCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "translate" );
	}

	public org.w3c.dom.Node getAdvancedtranslateCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "translate", curNode );
	}

	public TargetableFloat3 gettranslateValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new TargetableFloat3(curNode);
	}

	public TargetableFloat3 gettranslate() throws Exception 
 {
		return gettranslateAt(0);
	}

	public void removetranslateAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "translate", index);
	}

	public void removetranslate() {
		removetranslateAt(0);
	}

	public org.w3c.dom.Node addtranslate(TargetableFloat3 value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "translate", value);
	}

	public void inserttranslateAt(TargetableFloat3 value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "translate", index, value);
	}

	public void replacetranslateAt(TargetableFloat3 value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "translate", index, value);
	}

	public static int getrotateMinCount() {
		return 1;
	}

	public static int getrotateMaxCount() {
		return 1;
	}

	public int getrotateCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "rotate");
	}

	public boolean hasrotate() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "rotate");
	}

	public rotateType newrotate() {
		return new rotateType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "rotate"));
	}

	public rotateType getrotateAt(int index) throws Exception {
		return new rotateType(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "rotate", index));
	}

	public org.w3c.dom.Node getStartingrotateCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "rotate" );
	}

	public org.w3c.dom.Node getAdvancedrotateCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "rotate", curNode );
	}

	public rotateType getrotateValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new rotateType(curNode);
	}

	public rotateType getrotate() throws Exception 
 {
		return getrotateAt(0);
	}

	public void removerotateAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "rotate", index);
	}

	public void removerotate() {
		removerotateAt(0);
	}

	public org.w3c.dom.Node addrotate(rotateType value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "rotate", value);
	}

	public void insertrotateAt(rotateType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "rotate", index, value);
	}

	public void replacerotateAt(rotateType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "rotate", index, value);
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
