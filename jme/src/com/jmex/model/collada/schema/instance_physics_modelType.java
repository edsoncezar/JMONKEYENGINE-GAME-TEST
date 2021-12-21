/**
 * instance_physics_modelType.java
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
import com.jmex.xml.types.SchemaString;

public class instance_physics_modelType extends com.jmex.xml.xml.Node {

	public instance_physics_modelType(instance_physics_modelType node) {
		super(node);
	}

	public instance_physics_modelType(org.w3c.dom.Node node) {
		super(node);
	}

	public instance_physics_modelType(org.w3c.dom.Document doc) {
		super(doc);
	}

	public instance_physics_modelType(com.jmex.xml.xml.Document doc, String namespaceURI, String prefix, String name) {
		super(doc, namespaceURI, prefix, name);
	}
	
	public void adjustPrefix() {
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "url" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "url", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "sid" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "sid", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "name" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "name", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "parent" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "parent", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_force_field" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_force_field", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new InstanceWithExtra(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_body" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_body", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new instance_rigid_bodyType(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_constraint" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_constraint", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new instance_rigid_constraintType(tmpNode).adjustPrefix();
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
		el.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:type", "instance_physics_model");
	}

	public static int geturlMinCount() {
		return 1;
	}

	public static int geturlMaxCount() {
		return 1;
	}

	public int geturlCount() {
		return getDomChildCount(Attribute, null, "url");
	}

	public boolean hasurl() {
		return hasDomChild(Attribute, null, "url");
	}

	public SchemaString newurl() {
		return new SchemaString();
	}

	public SchemaString geturlAt(int index) throws Exception {
		return new SchemaString(getDomNodeValue(getDomChildAt(Attribute, null, "url", index)));
	}

	public org.w3c.dom.Node getStartingurlCursor() throws Exception {
		return getDomFirstChild(Attribute, null, "url" );
	}

	public org.w3c.dom.Node getAdvancedurlCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Attribute, null, "url", curNode );
	}

	public SchemaString geturlValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new SchemaString(getDomNodeValue(curNode));
	}

	public SchemaString geturl() throws Exception 
 {
		return geturlAt(0);
	}

	public void removeurlAt(int index) {
		removeDomChildAt(Attribute, null, "url", index);
	}

	public void removeurl() {
		removeurlAt(0);
	}

	public org.w3c.dom.Node addurl(SchemaString value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Attribute, null, "url", value.toString());
	}

	public org.w3c.dom.Node addurl(String value) throws Exception {
		return addurl(new SchemaString(value));
	}

	public void inserturlAt(SchemaString value, int index) {
		insertDomChildAt(Attribute, null, "url", index, value.toString());
	}

	public void inserturlAt(String value, int index) throws Exception {
		inserturlAt(new SchemaString(value), index);
	}

	public void replaceurlAt(SchemaString value, int index) {
		replaceDomChildAt(Attribute, null, "url", index, value.toString());
	}

	public void replaceurlAt(String value, int index) throws Exception {
		replaceurlAt(new SchemaString(value), index);
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

	public SchemaNCName newname() {
		return new SchemaNCName();
	}

	public SchemaNCName getnameAt(int index) throws Exception {
		return new SchemaNCName(getDomNodeValue(getDomChildAt(Attribute, null, "name", index)));
	}

	public org.w3c.dom.Node getStartingnameCursor() throws Exception {
		return getDomFirstChild(Attribute, null, "name" );
	}

	public org.w3c.dom.Node getAdvancednameCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Attribute, null, "name", curNode );
	}

	public SchemaNCName getnameValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new SchemaNCName(getDomNodeValue(curNode));
	}

	public SchemaNCName getname() throws Exception 
 {
		return getnameAt(0);
	}

	public void removenameAt(int index) {
		removeDomChildAt(Attribute, null, "name", index);
	}

	public void removename() {
		removenameAt(0);
	}

	public org.w3c.dom.Node addname(SchemaNCName value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Attribute, null, "name", value.toString());
	}

	public org.w3c.dom.Node addname(String value) throws Exception {
		return addname(new SchemaNCName(value));
	}

	public void insertnameAt(SchemaNCName value, int index) {
		insertDomChildAt(Attribute, null, "name", index, value.toString());
	}

	public void insertnameAt(String value, int index) throws Exception {
		insertnameAt(new SchemaNCName(value), index);
	}

	public void replacenameAt(SchemaNCName value, int index) {
		replaceDomChildAt(Attribute, null, "name", index, value.toString());
	}

	public void replacenameAt(String value, int index) throws Exception {
		replacenameAt(new SchemaNCName(value), index);
	}

	public static int getparentMinCount() {
		return 0;
	}

	public static int getparentMaxCount() {
		return 1;
	}

	public int getparentCount() {
		return getDomChildCount(Attribute, null, "parent");
	}

	public boolean hasparent() {
		return hasDomChild(Attribute, null, "parent");
	}

	public SchemaString newparent() {
		return new SchemaString();
	}

	public SchemaString getparentAt(int index) throws Exception {
		return new SchemaString(getDomNodeValue(getDomChildAt(Attribute, null, "parent", index)));
	}

	public org.w3c.dom.Node getStartingparentCursor() throws Exception {
		return getDomFirstChild(Attribute, null, "parent" );
	}

	public org.w3c.dom.Node getAdvancedparentCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Attribute, null, "parent", curNode );
	}

	public SchemaString getparentValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new SchemaString(getDomNodeValue(curNode));
	}

	public SchemaString getparent() throws Exception 
 {
		return getparentAt(0);
	}

	public void removeparentAt(int index) {
		removeDomChildAt(Attribute, null, "parent", index);
	}

	public void removeparent() {
		removeparentAt(0);
	}

	public org.w3c.dom.Node addparent(SchemaString value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Attribute, null, "parent", value.toString());
	}

	public org.w3c.dom.Node addparent(String value) throws Exception {
		return addparent(new SchemaString(value));
	}

	public void insertparentAt(SchemaString value, int index) {
		insertDomChildAt(Attribute, null, "parent", index, value.toString());
	}

	public void insertparentAt(String value, int index) throws Exception {
		insertparentAt(new SchemaString(value), index);
	}

	public void replaceparentAt(SchemaString value, int index) {
		replaceDomChildAt(Attribute, null, "parent", index, value.toString());
	}

	public void replaceparentAt(String value, int index) throws Exception {
		replaceparentAt(new SchemaString(value), index);
	}

	public static int getinstance_force_fieldMinCount() {
		return 0;
	}

	public static int getinstance_force_fieldMaxCount() {
		return Integer.MAX_VALUE;
	}

	public int getinstance_force_fieldCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_force_field");
	}

	public boolean hasinstance_force_field() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_force_field");
	}

	public InstanceWithExtra newinstance_force_field() {
		return new InstanceWithExtra(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "instance_force_field"));
	}

	public InstanceWithExtra getinstance_force_fieldAt(int index) throws Exception {
		return new InstanceWithExtra(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_force_field", index));
	}

	public org.w3c.dom.Node getStartinginstance_force_fieldCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_force_field" );
	}

	public org.w3c.dom.Node getAdvancedinstance_force_fieldCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_force_field", curNode );
	}

	public InstanceWithExtra getinstance_force_fieldValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new InstanceWithExtra(curNode);
	}

	public InstanceWithExtra getinstance_force_field() throws Exception 
 {
		return getinstance_force_fieldAt(0);
	}

	public void removeinstance_force_fieldAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_force_field", index);
	}

	public void removeinstance_force_field() {
		while (hasinstance_force_field())
			removeinstance_force_fieldAt(0);
	}

	public org.w3c.dom.Node addinstance_force_field(InstanceWithExtra value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "instance_force_field", value);
	}

	public void insertinstance_force_fieldAt(InstanceWithExtra value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "instance_force_field", index, value);
	}

	public void replaceinstance_force_fieldAt(InstanceWithExtra value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "instance_force_field", index, value);
	}

	public static int getinstance_rigid_bodyMinCount() {
		return 0;
	}

	public static int getinstance_rigid_bodyMaxCount() {
		return Integer.MAX_VALUE;
	}

	public int getinstance_rigid_bodyCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_body");
	}

	public boolean hasinstance_rigid_body() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_body");
	}

	public instance_rigid_bodyType newinstance_rigid_body() {
		return new instance_rigid_bodyType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_body"));
	}

	public instance_rigid_bodyType getinstance_rigid_bodyAt(int index) throws Exception {
		return new instance_rigid_bodyType(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_body", index));
	}

	public org.w3c.dom.Node getStartinginstance_rigid_bodyCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_body" );
	}

	public org.w3c.dom.Node getAdvancedinstance_rigid_bodyCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_body", curNode );
	}

	public instance_rigid_bodyType getinstance_rigid_bodyValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new instance_rigid_bodyType(curNode);
	}

	public instance_rigid_bodyType getinstance_rigid_body() throws Exception 
 {
		return getinstance_rigid_bodyAt(0);
	}

	public void removeinstance_rigid_bodyAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_body", index);
	}

	public void removeinstance_rigid_body() {
		while (hasinstance_rigid_body())
			removeinstance_rigid_bodyAt(0);
	}

	public org.w3c.dom.Node addinstance_rigid_body(instance_rigid_bodyType value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_body", value);
	}

	public void insertinstance_rigid_bodyAt(instance_rigid_bodyType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_body", index, value);
	}

	public void replaceinstance_rigid_bodyAt(instance_rigid_bodyType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_body", index, value);
	}

	public static int getinstance_rigid_constraintMinCount() {
		return 0;
	}

	public static int getinstance_rigid_constraintMaxCount() {
		return Integer.MAX_VALUE;
	}

	public int getinstance_rigid_constraintCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_constraint");
	}

	public boolean hasinstance_rigid_constraint() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_constraint");
	}

	public instance_rigid_constraintType newinstance_rigid_constraint() {
		return new instance_rigid_constraintType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_constraint"));
	}

	public instance_rigid_constraintType getinstance_rigid_constraintAt(int index) throws Exception {
		return new instance_rigid_constraintType(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_constraint", index));
	}

	public org.w3c.dom.Node getStartinginstance_rigid_constraintCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_constraint" );
	}

	public org.w3c.dom.Node getAdvancedinstance_rigid_constraintCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_constraint", curNode );
	}

	public instance_rigid_constraintType getinstance_rigid_constraintValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new instance_rigid_constraintType(curNode);
	}

	public instance_rigid_constraintType getinstance_rigid_constraint() throws Exception 
 {
		return getinstance_rigid_constraintAt(0);
	}

	public void removeinstance_rigid_constraintAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_constraint", index);
	}

	public void removeinstance_rigid_constraint() {
		while (hasinstance_rigid_constraint())
			removeinstance_rigid_constraintAt(0);
	}

	public org.w3c.dom.Node addinstance_rigid_constraint(instance_rigid_constraintType value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_constraint", value);
	}

	public void insertinstance_rigid_constraintAt(instance_rigid_constraintType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_constraint", index, value);
	}

	public void replaceinstance_rigid_constraintAt(instance_rigid_constraintType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "instance_rigid_constraint", index, value);
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
