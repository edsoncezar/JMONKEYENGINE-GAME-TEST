/**
 * fx_stenciltarget_common.java
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

import com.jmex.xml.types.SchemaInteger;
import com.jmex.xml.types.SchemaNCName;
import com.jmex.xml.types.SchemaType;

public class fx_stenciltarget_common extends com.jmex.xml.xml.Node {

	public fx_stenciltarget_common(fx_stenciltarget_common node) {
		super(node);
	}

	public fx_stenciltarget_common(org.w3c.dom.Node node) {
		super(node);
	}

	public fx_stenciltarget_common(org.w3c.dom.Document doc) {
		super(doc);
	}

	public fx_stenciltarget_common(com.jmex.xml.xml.Document doc, String namespaceURI, String prefix, String name) {
		super(doc, namespaceURI, prefix, name);
	}
	

	public SchemaNCName getValue() {
		return new SchemaNCName(getDomNodeValue(domNode));
	}

	public void setValue(SchemaType value) {
		setDomNodeValue(domNode, value.toString());
	}

	public void assign(SchemaType value) {
		setValue(value);
	}

	public void adjustPrefix() {
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "index" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "index", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "face" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "face", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "mip" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "mip", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "slice" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "slice", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
	}
	public void setXsiType() {
 		org.w3c.dom.Element el = (org.w3c.dom.Element) domNode;
		el.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:type", "fx_stenciltarget_common");
	}

	public static int getindexMinCount() {
		return 0;
	}

	public static int getindexMaxCount() {
		return 1;
	}

	public int getindexCount() {
		return getDomChildCount(Attribute, null, "index");
	}

	public boolean hasindex() {
		return hasDomChild(Attribute, null, "index");
	}

	public SchemaInteger newindex() {
		return new SchemaInteger();
	}

	public SchemaInteger getindexAt(int index) throws Exception {
		return new SchemaInteger(getDomNodeValue(getDomChildAt(Attribute, null, "index", index)));
	}

	public org.w3c.dom.Node getStartingindexCursor() throws Exception {
		return getDomFirstChild(Attribute, null, "index" );
	}

	public org.w3c.dom.Node getAdvancedindexCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Attribute, null, "index", curNode );
	}

	public SchemaInteger getindexValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new SchemaInteger(getDomNodeValue(curNode));
	}

	public SchemaInteger getindex() throws Exception 
 {
		return getindexAt(0);
	}

	public void removeindexAt(int index) {
		removeDomChildAt(Attribute, null, "index", index);
	}

	public void removeindex() {
		removeindexAt(0);
	}

	public org.w3c.dom.Node addindex(SchemaInteger value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Attribute, null, "index", value.toString());
	}

	public org.w3c.dom.Node addindex(String value) throws Exception {
		return addindex(new SchemaInteger(value));
	}

	public void insertindexAt(SchemaInteger value, int index) {
		insertDomChildAt(Attribute, null, "index", index, value.toString());
	}

	public void insertindexAt(String value, int index) throws Exception {
		insertindexAt(new SchemaInteger(value), index);
	}

	public void replaceindexAt(SchemaInteger value, int index) {
		replaceDomChildAt(Attribute, null, "index", index, value.toString());
	}

	public void replaceindexAt(String value, int index) throws Exception {
		replaceindexAt(new SchemaInteger(value), index);
	}

	public static int getfaceMinCount() {
		return 0;
	}

	public static int getfaceMaxCount() {
		return 1;
	}

	public int getfaceCount() {
		return getDomChildCount(Attribute, null, "face");
	}

	public boolean hasface() {
		return hasDomChild(Attribute, null, "face");
	}

	public fx_surface_face_enum newface() {
		return new fx_surface_face_enum();
	}

	public fx_surface_face_enum getfaceAt(int index) throws Exception {
		return new fx_surface_face_enum(getDomNodeValue(getDomChildAt(Attribute, null, "face", index)));
	}

	public org.w3c.dom.Node getStartingfaceCursor() throws Exception {
		return getDomFirstChild(Attribute, null, "face" );
	}

	public org.w3c.dom.Node getAdvancedfaceCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Attribute, null, "face", curNode );
	}

	public fx_surface_face_enum getfaceValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new fx_surface_face_enum(getDomNodeValue(curNode));
	}

	public fx_surface_face_enum getface() throws Exception 
 {
		return getfaceAt(0);
	}

	public void removefaceAt(int index) {
		removeDomChildAt(Attribute, null, "face", index);
	}

	public void removeface() {
		removefaceAt(0);
	}

	public org.w3c.dom.Node addface(fx_surface_face_enum value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Attribute, null, "face", value.toString());
	}

	public org.w3c.dom.Node addface(String value) throws Exception {
		return addface(new fx_surface_face_enum(value));
	}

	public void insertfaceAt(fx_surface_face_enum value, int index) {
		insertDomChildAt(Attribute, null, "face", index, value.toString());
	}

	public void insertfaceAt(String value, int index) throws Exception {
		insertfaceAt(new fx_surface_face_enum(value), index);
	}

	public void replacefaceAt(fx_surface_face_enum value, int index) {
		replaceDomChildAt(Attribute, null, "face", index, value.toString());
	}

	public void replacefaceAt(String value, int index) throws Exception {
		replacefaceAt(new fx_surface_face_enum(value), index);
	}

	public static int getmipMinCount() {
		return 0;
	}

	public static int getmipMaxCount() {
		return 1;
	}

	public int getmipCount() {
		return getDomChildCount(Attribute, null, "mip");
	}

	public boolean hasmip() {
		return hasDomChild(Attribute, null, "mip");
	}

	public SchemaInteger newmip() {
		return new SchemaInteger();
	}

	public SchemaInteger getmipAt(int index) throws Exception {
		return new SchemaInteger(getDomNodeValue(getDomChildAt(Attribute, null, "mip", index)));
	}

	public org.w3c.dom.Node getStartingmipCursor() throws Exception {
		return getDomFirstChild(Attribute, null, "mip" );
	}

	public org.w3c.dom.Node getAdvancedmipCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Attribute, null, "mip", curNode );
	}

	public SchemaInteger getmipValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new SchemaInteger(getDomNodeValue(curNode));
	}

	public SchemaInteger getmip() throws Exception 
 {
		return getmipAt(0);
	}

	public void removemipAt(int index) {
		removeDomChildAt(Attribute, null, "mip", index);
	}

	public void removemip() {
		removemipAt(0);
	}

	public org.w3c.dom.Node addmip(SchemaInteger value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Attribute, null, "mip", value.toString());
	}

	public org.w3c.dom.Node addmip(String value) throws Exception {
		return addmip(new SchemaInteger(value));
	}

	public void insertmipAt(SchemaInteger value, int index) {
		insertDomChildAt(Attribute, null, "mip", index, value.toString());
	}

	public void insertmipAt(String value, int index) throws Exception {
		insertmipAt(new SchemaInteger(value), index);
	}

	public void replacemipAt(SchemaInteger value, int index) {
		replaceDomChildAt(Attribute, null, "mip", index, value.toString());
	}

	public void replacemipAt(String value, int index) throws Exception {
		replacemipAt(new SchemaInteger(value), index);
	}

	public static int getsliceMinCount() {
		return 0;
	}

	public static int getsliceMaxCount() {
		return 1;
	}

	public int getsliceCount() {
		return getDomChildCount(Attribute, null, "slice");
	}

	public boolean hasslice() {
		return hasDomChild(Attribute, null, "slice");
	}

	public SchemaInteger newslice() {
		return new SchemaInteger();
	}

	public SchemaInteger getsliceAt(int index) throws Exception {
		return new SchemaInteger(getDomNodeValue(getDomChildAt(Attribute, null, "slice", index)));
	}

	public org.w3c.dom.Node getStartingsliceCursor() throws Exception {
		return getDomFirstChild(Attribute, null, "slice" );
	}

	public org.w3c.dom.Node getAdvancedsliceCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Attribute, null, "slice", curNode );
	}

	public SchemaInteger getsliceValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new SchemaInteger(getDomNodeValue(curNode));
	}

	public SchemaInteger getslice() throws Exception 
 {
		return getsliceAt(0);
	}

	public void removesliceAt(int index) {
		removeDomChildAt(Attribute, null, "slice", index);
	}

	public void removeslice() {
		removesliceAt(0);
	}

	public org.w3c.dom.Node addslice(SchemaInteger value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Attribute, null, "slice", value.toString());
	}

	public org.w3c.dom.Node addslice(String value) throws Exception {
		return addslice(new SchemaInteger(value));
	}

	public void insertsliceAt(SchemaInteger value, int index) {
		insertDomChildAt(Attribute, null, "slice", index, value.toString());
	}

	public void insertsliceAt(String value, int index) throws Exception {
		insertsliceAt(new SchemaInteger(value), index);
	}

	public void replacesliceAt(SchemaInteger value, int index) {
		replaceDomChildAt(Attribute, null, "slice", index, value.toString());
	}

	public void replacesliceAt(String value, int index) throws Exception {
		replacesliceAt(new SchemaInteger(value), index);
	}

}
