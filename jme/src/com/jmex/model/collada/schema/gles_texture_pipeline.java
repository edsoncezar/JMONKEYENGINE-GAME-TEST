/**
 * gles_texture_pipeline.java
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

import com.jmex.xml.types.SchemaNCName;

public class gles_texture_pipeline extends com.jmex.xml.xml.Node {

	public gles_texture_pipeline(gles_texture_pipeline node) {
		super(node);
	}

	public gles_texture_pipeline(org.w3c.dom.Node node) {
		super(node);
	}

	public gles_texture_pipeline(org.w3c.dom.Document doc) {
		super(doc);
	}

	public gles_texture_pipeline(com.jmex.xml.xml.Document doc, String namespaceURI, String prefix, String name) {
		super(doc, namespaceURI, prefix, name);
	}
	
	public void adjustPrefix() {
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "sid" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "sid", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "texcombiner" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "texcombiner", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new gles_texcombiner_command_type(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "texenv" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "texenv", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new gles_texenv_command_type(tmpNode).adjustPrefix();
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
		el.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:type", "gles_texture_pipeline");
	}

	public static int getsidMinCount() {
		return 0;
	}

	public static int getsidMaxCount() {
		return 1;
	}

	public int getsidCount() {
		return getDomChildCount(Attribute, null, "sid");
	}

	public boolean hassid() {
		return hasDomChild(Attribute, null, "sid");
	}

	public SchemaNCName newsid() {
		return new SchemaNCName();
	}

	public SchemaNCName getsidAt(int index) throws Exception {
		return new SchemaNCName(getDomNodeValue(getDomChildAt(Attribute, null, "sid", index)));
	}

	public org.w3c.dom.Node getStartingsidCursor() throws Exception {
		return getDomFirstChild(Attribute, null, "sid" );
	}

	public org.w3c.dom.Node getAdvancedsidCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Attribute, null, "sid", curNode );
	}

	public SchemaNCName getsidValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new SchemaNCName(getDomNodeValue(curNode));
	}

	public SchemaNCName getsid() throws Exception 
 {
		return getsidAt(0);
	}

	public void removesidAt(int index) {
		removeDomChildAt(Attribute, null, "sid", index);
	}

	public void removesid() {
		removesidAt(0);
	}

	public org.w3c.dom.Node addsid(SchemaNCName value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Attribute, null, "sid", value.toString());
	}

	public org.w3c.dom.Node addsid(String value) throws Exception {
		return addsid(new SchemaNCName(value));
	}

	public void insertsidAt(SchemaNCName value, int index) {
		insertDomChildAt(Attribute, null, "sid", index, value.toString());
	}

	public void insertsidAt(String value, int index) throws Exception {
		insertsidAt(new SchemaNCName(value), index);
	}

	public void replacesidAt(SchemaNCName value, int index) {
		replaceDomChildAt(Attribute, null, "sid", index, value.toString());
	}

	public void replacesidAt(String value, int index) throws Exception {
		replacesidAt(new SchemaNCName(value), index);
	}

	public static int gettexcombinerMinCount() {
		return 1;
	}

	public static int gettexcombinerMaxCount() {
		return 1;
	}

	public int gettexcombinerCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "texcombiner");
	}

	public boolean hastexcombiner() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "texcombiner");
	}

	public gles_texcombiner_command_type newtexcombiner() {
		return new gles_texcombiner_command_type(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "texcombiner"));
	}

	public gles_texcombiner_command_type gettexcombinerAt(int index) throws Exception {
		return new gles_texcombiner_command_type(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "texcombiner", index));
	}

	public org.w3c.dom.Node getStartingtexcombinerCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "texcombiner" );
	}

	public org.w3c.dom.Node getAdvancedtexcombinerCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "texcombiner", curNode );
	}

	public gles_texcombiner_command_type gettexcombinerValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new gles_texcombiner_command_type(curNode);
	}

	public gles_texcombiner_command_type gettexcombiner() throws Exception 
 {
		return gettexcombinerAt(0);
	}

	public void removetexcombinerAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "texcombiner", index);
	}

	public void removetexcombiner() {
		removetexcombinerAt(0);
	}

	public org.w3c.dom.Node addtexcombiner(gles_texcombiner_command_type value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "texcombiner", value);
	}

	public void inserttexcombinerAt(gles_texcombiner_command_type value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "texcombiner", index, value);
	}

	public void replacetexcombinerAt(gles_texcombiner_command_type value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "texcombiner", index, value);
	}

	public static int gettexenvMinCount() {
		return 1;
	}

	public static int gettexenvMaxCount() {
		return 1;
	}

	public int gettexenvCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "texenv");
	}

	public boolean hastexenv() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "texenv");
	}

	public gles_texenv_command_type newtexenv() {
		return new gles_texenv_command_type(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "texenv"));
	}

	public gles_texenv_command_type gettexenvAt(int index) throws Exception {
		return new gles_texenv_command_type(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "texenv", index));
	}

	public org.w3c.dom.Node getStartingtexenvCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "texenv" );
	}

	public org.w3c.dom.Node getAdvancedtexenvCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "texenv", curNode );
	}

	public gles_texenv_command_type gettexenvValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new gles_texenv_command_type(curNode);
	}

	public gles_texenv_command_type gettexenv() throws Exception 
 {
		return gettexenvAt(0);
	}

	public void removetexenvAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "texenv", index);
	}

	public void removetexenv() {
		removetexenvAt(0);
	}

	public org.w3c.dom.Node addtexenv(gles_texenv_command_type value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "texenv", value);
	}

	public void inserttexenvAt(gles_texenv_command_type value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "texenv", index, value);
	}

	public void replacetexenvAt(gles_texenv_command_type value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "texenv", index, value);
	}

	public static int getextraMinCount() {
		return 1;
	}

	public static int getextraMaxCount() {
		return 1;
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
