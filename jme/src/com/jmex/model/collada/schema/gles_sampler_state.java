/**
 * gles_sampler_state.java
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

import com.jmex.xml.types.SchemaFloat;
import com.jmex.xml.types.SchemaNCName;
import com.jmex.xml.types.SchemaShort;

public class gles_sampler_state extends com.jmex.xml.xml.Node {

	public gles_sampler_state(gles_sampler_state node) {
		super(node);
	}

	public gles_sampler_state(org.w3c.dom.Node node) {
		super(node);
	}

	public gles_sampler_state(org.w3c.dom.Document doc) {
		super(doc);
	}

	public gles_sampler_state(com.jmex.xml.xml.Document doc, String namespaceURI, String prefix, String name) {
		super(doc, namespaceURI, prefix, name);
	}
	
	public void adjustPrefix() {
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "sid" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "sid", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_s" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_s", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_t" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_t", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "minfilter" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "minfilter", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "magfilter" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "magfilter", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "mipfilter" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "mipfilter", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_maxlevel" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_maxlevel", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_bias" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_bias", tmpNode )
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
		el.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:type", "gles_sampler_state");
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

	public static int getwrap_sMinCount() {
		return 0;
	}

	public static int getwrap_sMaxCount() {
		return 1;
	}

	public int getwrap_sCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_s");
	}

	public boolean haswrap_s() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_s");
	}

	public gles_sampler_wrap newwrap_s() {
		return new gles_sampler_wrap();
	}

	public gles_sampler_wrap getwrap_sAt(int index) throws Exception {
		return new gles_sampler_wrap(getDomNodeValue(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_s", index)));
	}

	public org.w3c.dom.Node getStartingwrap_sCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_s" );
	}

	public org.w3c.dom.Node getAdvancedwrap_sCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_s", curNode );
	}

	public gles_sampler_wrap getwrap_sValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new gles_sampler_wrap(getDomNodeValue(curNode));
	}

	public gles_sampler_wrap getwrap_s() throws Exception 
 {
		return getwrap_sAt(0);
	}

	public void removewrap_sAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_s", index);
	}

	public void removewrap_s() {
		removewrap_sAt(0);
	}

	public org.w3c.dom.Node addwrap_s(gles_sampler_wrap value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_s", value.toString());
	}

	public org.w3c.dom.Node addwrap_s(String value) throws Exception {
		return addwrap_s(new gles_sampler_wrap(value));
	}

	public void insertwrap_sAt(gles_sampler_wrap value, int index) {
		insertDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_s", index, value.toString());
	}

	public void insertwrap_sAt(String value, int index) throws Exception {
		insertwrap_sAt(new gles_sampler_wrap(value), index);
	}

	public void replacewrap_sAt(gles_sampler_wrap value, int index) {
		replaceDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_s", index, value.toString());
	}

	public void replacewrap_sAt(String value, int index) throws Exception {
		replacewrap_sAt(new gles_sampler_wrap(value), index);
	}

	public static int getwrap_tMinCount() {
		return 0;
	}

	public static int getwrap_tMaxCount() {
		return 1;
	}

	public int getwrap_tCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_t");
	}

	public boolean haswrap_t() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_t");
	}

	public gles_sampler_wrap newwrap_t() {
		return new gles_sampler_wrap();
	}

	public gles_sampler_wrap getwrap_tAt(int index) throws Exception {
		return new gles_sampler_wrap(getDomNodeValue(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_t", index)));
	}

	public org.w3c.dom.Node getStartingwrap_tCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_t" );
	}

	public org.w3c.dom.Node getAdvancedwrap_tCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_t", curNode );
	}

	public gles_sampler_wrap getwrap_tValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new gles_sampler_wrap(getDomNodeValue(curNode));
	}

	public gles_sampler_wrap getwrap_t() throws Exception 
 {
		return getwrap_tAt(0);
	}

	public void removewrap_tAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_t", index);
	}

	public void removewrap_t() {
		removewrap_tAt(0);
	}

	public org.w3c.dom.Node addwrap_t(gles_sampler_wrap value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_t", value.toString());
	}

	public org.w3c.dom.Node addwrap_t(String value) throws Exception {
		return addwrap_t(new gles_sampler_wrap(value));
	}

	public void insertwrap_tAt(gles_sampler_wrap value, int index) {
		insertDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_t", index, value.toString());
	}

	public void insertwrap_tAt(String value, int index) throws Exception {
		insertwrap_tAt(new gles_sampler_wrap(value), index);
	}

	public void replacewrap_tAt(gles_sampler_wrap value, int index) {
		replaceDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "wrap_t", index, value.toString());
	}

	public void replacewrap_tAt(String value, int index) throws Exception {
		replacewrap_tAt(new gles_sampler_wrap(value), index);
	}

	public static int getminfilterMinCount() {
		return 0;
	}

	public static int getminfilterMaxCount() {
		return 1;
	}

	public int getminfilterCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "minfilter");
	}

	public boolean hasminfilter() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "minfilter");
	}

	public fx_sampler_filter_common newminfilter() {
		return new fx_sampler_filter_common();
	}

	public fx_sampler_filter_common getminfilterAt(int index) throws Exception {
		return new fx_sampler_filter_common(getDomNodeValue(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "minfilter", index)));
	}

	public org.w3c.dom.Node getStartingminfilterCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "minfilter" );
	}

	public org.w3c.dom.Node getAdvancedminfilterCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "minfilter", curNode );
	}

	public fx_sampler_filter_common getminfilterValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new fx_sampler_filter_common(getDomNodeValue(curNode));
	}

	public fx_sampler_filter_common getminfilter() throws Exception 
 {
		return getminfilterAt(0);
	}

	public void removeminfilterAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "minfilter", index);
	}

	public void removeminfilter() {
		removeminfilterAt(0);
	}

	public org.w3c.dom.Node addminfilter(fx_sampler_filter_common value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "minfilter", value.toString());
	}

	public org.w3c.dom.Node addminfilter(String value) throws Exception {
		return addminfilter(new fx_sampler_filter_common(value));
	}

	public void insertminfilterAt(fx_sampler_filter_common value, int index) {
		insertDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "minfilter", index, value.toString());
	}

	public void insertminfilterAt(String value, int index) throws Exception {
		insertminfilterAt(new fx_sampler_filter_common(value), index);
	}

	public void replaceminfilterAt(fx_sampler_filter_common value, int index) {
		replaceDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "minfilter", index, value.toString());
	}

	public void replaceminfilterAt(String value, int index) throws Exception {
		replaceminfilterAt(new fx_sampler_filter_common(value), index);
	}

	public static int getmagfilterMinCount() {
		return 0;
	}

	public static int getmagfilterMaxCount() {
		return 1;
	}

	public int getmagfilterCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "magfilter");
	}

	public boolean hasmagfilter() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "magfilter");
	}

	public fx_sampler_filter_common newmagfilter() {
		return new fx_sampler_filter_common();
	}

	public fx_sampler_filter_common getmagfilterAt(int index) throws Exception {
		return new fx_sampler_filter_common(getDomNodeValue(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "magfilter", index)));
	}

	public org.w3c.dom.Node getStartingmagfilterCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "magfilter" );
	}

	public org.w3c.dom.Node getAdvancedmagfilterCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "magfilter", curNode );
	}

	public fx_sampler_filter_common getmagfilterValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new fx_sampler_filter_common(getDomNodeValue(curNode));
	}

	public fx_sampler_filter_common getmagfilter() throws Exception 
 {
		return getmagfilterAt(0);
	}

	public void removemagfilterAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "magfilter", index);
	}

	public void removemagfilter() {
		removemagfilterAt(0);
	}

	public org.w3c.dom.Node addmagfilter(fx_sampler_filter_common value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "magfilter", value.toString());
	}

	public org.w3c.dom.Node addmagfilter(String value) throws Exception {
		return addmagfilter(new fx_sampler_filter_common(value));
	}

	public void insertmagfilterAt(fx_sampler_filter_common value, int index) {
		insertDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "magfilter", index, value.toString());
	}

	public void insertmagfilterAt(String value, int index) throws Exception {
		insertmagfilterAt(new fx_sampler_filter_common(value), index);
	}

	public void replacemagfilterAt(fx_sampler_filter_common value, int index) {
		replaceDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "magfilter", index, value.toString());
	}

	public void replacemagfilterAt(String value, int index) throws Exception {
		replacemagfilterAt(new fx_sampler_filter_common(value), index);
	}

	public static int getmipfilterMinCount() {
		return 0;
	}

	public static int getmipfilterMaxCount() {
		return 1;
	}

	public int getmipfilterCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipfilter");
	}

	public boolean hasmipfilter() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipfilter");
	}

	public fx_sampler_filter_common newmipfilter() {
		return new fx_sampler_filter_common();
	}

	public fx_sampler_filter_common getmipfilterAt(int index) throws Exception {
		return new fx_sampler_filter_common(getDomNodeValue(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipfilter", index)));
	}

	public org.w3c.dom.Node getStartingmipfilterCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipfilter" );
	}

	public org.w3c.dom.Node getAdvancedmipfilterCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "mipfilter", curNode );
	}

	public fx_sampler_filter_common getmipfilterValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new fx_sampler_filter_common(getDomNodeValue(curNode));
	}

	public fx_sampler_filter_common getmipfilter() throws Exception 
 {
		return getmipfilterAt(0);
	}

	public void removemipfilterAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipfilter", index);
	}

	public void removemipfilter() {
		removemipfilterAt(0);
	}

	public org.w3c.dom.Node addmipfilter(fx_sampler_filter_common value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipfilter", value.toString());
	}

	public org.w3c.dom.Node addmipfilter(String value) throws Exception {
		return addmipfilter(new fx_sampler_filter_common(value));
	}

	public void insertmipfilterAt(fx_sampler_filter_common value, int index) {
		insertDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipfilter", index, value.toString());
	}

	public void insertmipfilterAt(String value, int index) throws Exception {
		insertmipfilterAt(new fx_sampler_filter_common(value), index);
	}

	public void replacemipfilterAt(fx_sampler_filter_common value, int index) {
		replaceDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipfilter", index, value.toString());
	}

	public void replacemipfilterAt(String value, int index) throws Exception {
		replacemipfilterAt(new fx_sampler_filter_common(value), index);
	}

	public static int getmipmap_maxlevelMinCount() {
		return 0;
	}

	public static int getmipmap_maxlevelMaxCount() {
		return 1;
	}

	public int getmipmap_maxlevelCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_maxlevel");
	}

	public boolean hasmipmap_maxlevel() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_maxlevel");
	}

	public SchemaShort newmipmap_maxlevel() {
		return new SchemaShort();
	}

	public SchemaShort getmipmap_maxlevelAt(int index) throws Exception {
		return new SchemaShort(getDomNodeValue(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_maxlevel", index)));
	}

	public org.w3c.dom.Node getStartingmipmap_maxlevelCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_maxlevel" );
	}

	public org.w3c.dom.Node getAdvancedmipmap_maxlevelCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_maxlevel", curNode );
	}

	public SchemaShort getmipmap_maxlevelValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new SchemaShort(getDomNodeValue(curNode));
	}

	public SchemaShort getmipmap_maxlevel() throws Exception 
 {
		return getmipmap_maxlevelAt(0);
	}

	public void removemipmap_maxlevelAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_maxlevel", index);
	}

	public void removemipmap_maxlevel() {
		removemipmap_maxlevelAt(0);
	}

	public org.w3c.dom.Node addmipmap_maxlevel(SchemaShort value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_maxlevel", value.toString());
	}

	public org.w3c.dom.Node addmipmap_maxlevel(String value) throws Exception {
		return addmipmap_maxlevel(new SchemaShort(value));
	}

	public void insertmipmap_maxlevelAt(SchemaShort value, int index) {
		insertDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_maxlevel", index, value.toString());
	}

	public void insertmipmap_maxlevelAt(String value, int index) throws Exception {
		insertmipmap_maxlevelAt(new SchemaShort(value), index);
	}

	public void replacemipmap_maxlevelAt(SchemaShort value, int index) {
		replaceDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_maxlevel", index, value.toString());
	}

	public void replacemipmap_maxlevelAt(String value, int index) throws Exception {
		replacemipmap_maxlevelAt(new SchemaShort(value), index);
	}

	public static int getmipmap_biasMinCount() {
		return 0;
	}

	public static int getmipmap_biasMaxCount() {
		return 1;
	}

	public int getmipmap_biasCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_bias");
	}

	public boolean hasmipmap_bias() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_bias");
	}

	public SchemaFloat newmipmap_bias() {
		return new SchemaFloat();
	}

	public SchemaFloat getmipmap_biasAt(int index) throws Exception {
		return new SchemaFloat(getDomNodeValue(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_bias", index)));
	}

	public org.w3c.dom.Node getStartingmipmap_biasCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_bias" );
	}

	public org.w3c.dom.Node getAdvancedmipmap_biasCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_bias", curNode );
	}

	public SchemaFloat getmipmap_biasValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new SchemaFloat(getDomNodeValue(curNode));
	}

	public SchemaFloat getmipmap_bias() throws Exception 
 {
		return getmipmap_biasAt(0);
	}

	public void removemipmap_biasAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_bias", index);
	}

	public void removemipmap_bias() {
		removemipmap_biasAt(0);
	}

	public org.w3c.dom.Node addmipmap_bias(SchemaFloat value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_bias", value.toString());
	}

	public org.w3c.dom.Node addmipmap_bias(String value) throws Exception {
		return addmipmap_bias(new SchemaFloat(value));
	}

	public void insertmipmap_biasAt(SchemaFloat value, int index) {
		insertDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_bias", index, value.toString());
	}

	public void insertmipmap_biasAt(String value, int index) throws Exception {
		insertmipmap_biasAt(new SchemaFloat(value), index);
	}

	public void replacemipmap_biasAt(SchemaFloat value, int index) {
		replaceDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "mipmap_bias", index, value.toString());
	}

	public void replacemipmap_biasAt(String value, int index) throws Exception {
		replacemipmap_biasAt(new SchemaFloat(value), index);
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
