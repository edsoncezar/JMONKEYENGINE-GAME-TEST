/**
 * accessorType.java
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

public class accessorType extends com.jmex.xml.xml.Node {

	public accessorType(accessorType node) {
		super(node);
	}

	public accessorType(org.w3c.dom.Node node) {
		super(node);
	}

	public accessorType(org.w3c.dom.Document doc) {
		super(doc);
	}

	public accessorType(com.jmex.xml.xml.Document doc, String namespaceURI, String prefix, String name) {
		super(doc, namespaceURI, prefix, name);
	}
	
	public void adjustPrefix() {
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "count" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "count", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "offset" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "offset", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "source" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "source", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "stride" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "stride", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "param" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "param", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new paramType3(tmpNode).adjustPrefix();
		}
	}
	public void setXsiType() {
 		org.w3c.dom.Element el = (org.w3c.dom.Element) domNode;
		el.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:type", "accessor");
	}

	public static int getcountMinCount() {
		return 1;
	}

	public static int getcountMaxCount() {
		return 1;
	}

	public int getcountCount() {
		return getDomChildCount(Attribute, null, "count");
	}

	public boolean hascount() {
		return hasDomChild(Attribute, null, "count");
	}

	public uint newcount() {
		return new uint();
	}

	public uint getcountAt(int index) throws Exception {
		return new uint(getDomNodeValue(getDomChildAt(Attribute, null, "count", index)));
	}

	public org.w3c.dom.Node getStartingcountCursor() throws Exception {
		return getDomFirstChild(Attribute, null, "count" );
	}

	public org.w3c.dom.Node getAdvancedcountCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Attribute, null, "count", curNode );
	}

	public uint getcountValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new uint(getDomNodeValue(curNode));
	}

	public uint getcount() throws Exception 
 {
		return getcountAt(0);
	}

	public void removecountAt(int index) {
		removeDomChildAt(Attribute, null, "count", index);
	}

	public void removecount() {
		removecountAt(0);
	}

	public org.w3c.dom.Node addcount(uint value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Attribute, null, "count", value.toString());
	}

	public org.w3c.dom.Node addcount(String value) throws Exception {
		return addcount(new uint(value));
	}

	public void insertcountAt(uint value, int index) {
		insertDomChildAt(Attribute, null, "count", index, value.toString());
	}

	public void insertcountAt(String value, int index) throws Exception {
		insertcountAt(new uint(value), index);
	}

	public void replacecountAt(uint value, int index) {
		replaceDomChildAt(Attribute, null, "count", index, value.toString());
	}

	public void replacecountAt(String value, int index) throws Exception {
		replacecountAt(new uint(value), index);
	}

	public static int getoffsetMinCount() {
		return 0;
	}

	public static int getoffsetMaxCount() {
		return 1;
	}

	public int getoffsetCount() {
		return getDomChildCount(Attribute, null, "offset");
	}

	public boolean hasoffset() {
		return hasDomChild(Attribute, null, "offset");
	}

	public uint newoffset() {
		return new uint();
	}

	public uint getoffsetAt(int index) throws Exception {
		return new uint(getDomNodeValue(getDomChildAt(Attribute, null, "offset", index)));
	}

	public org.w3c.dom.Node getStartingoffsetCursor() throws Exception {
		return getDomFirstChild(Attribute, null, "offset" );
	}

	public org.w3c.dom.Node getAdvancedoffsetCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Attribute, null, "offset", curNode );
	}

	public uint getoffsetValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new uint(getDomNodeValue(curNode));
	}

	public uint getoffset() throws Exception 
 {
		return getoffsetAt(0);
	}

	public void removeoffsetAt(int index) {
		removeDomChildAt(Attribute, null, "offset", index);
	}

	public void removeoffset() {
		removeoffsetAt(0);
	}

	public org.w3c.dom.Node addoffset(uint value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Attribute, null, "offset", value.toString());
	}

	public org.w3c.dom.Node addoffset(String value) throws Exception {
		return addoffset(new uint(value));
	}

	public void insertoffsetAt(uint value, int index) {
		insertDomChildAt(Attribute, null, "offset", index, value.toString());
	}

	public void insertoffsetAt(String value, int index) throws Exception {
		insertoffsetAt(new uint(value), index);
	}

	public void replaceoffsetAt(uint value, int index) {
		replaceDomChildAt(Attribute, null, "offset", index, value.toString());
	}

	public void replaceoffsetAt(String value, int index) throws Exception {
		replaceoffsetAt(new uint(value), index);
	}

	public static int getsourceMinCount() {
		return 0;
	}

	public static int getsourceMaxCount() {
		return 1;
	}

	public int getsourceCount() {
		return getDomChildCount(Attribute, null, "source");
	}

	public boolean hassource() {
		return hasDomChild(Attribute, null, "source");
	}

	public SchemaString newsource() {
		return new SchemaString();
	}

	public SchemaString getsourceAt(int index) throws Exception {
		return new SchemaString(getDomNodeValue(getDomChildAt(Attribute, null, "source", index)));
	}

	public org.w3c.dom.Node getStartingsourceCursor() throws Exception {
		return getDomFirstChild(Attribute, null, "source" );
	}

	public org.w3c.dom.Node getAdvancedsourceCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Attribute, null, "source", curNode );
	}

	public SchemaString getsourceValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new SchemaString(getDomNodeValue(curNode));
	}

	public SchemaString getsource() throws Exception 
 {
		return getsourceAt(0);
	}

	public void removesourceAt(int index) {
		removeDomChildAt(Attribute, null, "source", index);
	}

	public void removesource() {
		removesourceAt(0);
	}

	public org.w3c.dom.Node addsource(SchemaString value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Attribute, null, "source", value.toString());
	}

	public org.w3c.dom.Node addsource(String value) throws Exception {
		return addsource(new SchemaString(value));
	}

	public void insertsourceAt(SchemaString value, int index) {
		insertDomChildAt(Attribute, null, "source", index, value.toString());
	}

	public void insertsourceAt(String value, int index) throws Exception {
		insertsourceAt(new SchemaString(value), index);
	}

	public void replacesourceAt(SchemaString value, int index) {
		replaceDomChildAt(Attribute, null, "source", index, value.toString());
	}

	public void replacesourceAt(String value, int index) throws Exception {
		replacesourceAt(new SchemaString(value), index);
	}

	public static int getstrideMinCount() {
		return 0;
	}

	public static int getstrideMaxCount() {
		return 1;
	}

	public int getstrideCount() {
		return getDomChildCount(Attribute, null, "stride");
	}

	public boolean hasstride() {
		return hasDomChild(Attribute, null, "stride");
	}

	public uint newstride() {
		return new uint();
	}

	public uint getstrideAt(int index) throws Exception {
		return new uint(getDomNodeValue(getDomChildAt(Attribute, null, "stride", index)));
	}

	public org.w3c.dom.Node getStartingstrideCursor() throws Exception {
		return getDomFirstChild(Attribute, null, "stride" );
	}

	public org.w3c.dom.Node getAdvancedstrideCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Attribute, null, "stride", curNode );
	}

	public uint getstrideValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new uint(getDomNodeValue(curNode));
	}

	public uint getstride() throws Exception 
 {
		return getstrideAt(0);
	}

	public void removestrideAt(int index) {
		removeDomChildAt(Attribute, null, "stride", index);
	}

	public void removestride() {
		removestrideAt(0);
	}

	public org.w3c.dom.Node addstride(uint value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Attribute, null, "stride", value.toString());
	}

	public org.w3c.dom.Node addstride(String value) throws Exception {
		return addstride(new uint(value));
	}

	public void insertstrideAt(uint value, int index) {
		insertDomChildAt(Attribute, null, "stride", index, value.toString());
	}

	public void insertstrideAt(String value, int index) throws Exception {
		insertstrideAt(new uint(value), index);
	}

	public void replacestrideAt(uint value, int index) {
		replaceDomChildAt(Attribute, null, "stride", index, value.toString());
	}

	public void replacestrideAt(String value, int index) throws Exception {
		replacestrideAt(new uint(value), index);
	}

	public static int getparamMinCount() {
		return 0;
	}

	public static int getparamMaxCount() {
		return Integer.MAX_VALUE;
	}

	public int getparamCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "param");
	}

	public boolean hasparam() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "param");
	}

	public paramType3 newparam() {
		return new paramType3(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "param"));
	}

	public paramType3 getparamAt(int index) throws Exception {
		return new paramType3(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "param", index));
	}

	public org.w3c.dom.Node getStartingparamCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "param" );
	}

	public org.w3c.dom.Node getAdvancedparamCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "param", curNode );
	}

	public paramType3 getparamValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new paramType3(curNode);
	}

	public paramType3 getparam() throws Exception 
 {
		return getparamAt(0);
	}

	public void removeparamAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "param", index);
	}

	public void removeparam() {
		while (hasparam())
			removeparamAt(0);
	}

	public org.w3c.dom.Node addparam(paramType3 value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "param", value);
	}

	public void insertparamAt(paramType3 value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "param", index, value);
	}

	public void replaceparamAt(paramType3 value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "param", index, value);
	}

}
