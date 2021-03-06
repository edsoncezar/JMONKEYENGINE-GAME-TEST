/**
 * physics_sceneType.java
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

import com.jmex.xml.types.SchemaID;
import com.jmex.xml.types.SchemaNCName;

public class physics_sceneType extends com.jmex.xml.xml.Node {

	public physics_sceneType(physics_sceneType node) {
		super(node);
	}

	public physics_sceneType(org.w3c.dom.Node node) {
		super(node);
	}

	public physics_sceneType(org.w3c.dom.Document doc) {
		super(doc);
	}

	public physics_sceneType(com.jmex.xml.xml.Document doc, String namespaceURI, String prefix, String name) {
		super(doc, namespaceURI, prefix, name);
	}
	
	public void adjustPrefix() {
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "id" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "id", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Attribute, null, "name" );
				tmpNode != null;
				tmpNode = getDomNextChild( Attribute, null, "name", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, false);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "asset" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "asset", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new assetType(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_force_field" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_force_field", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new InstanceWithExtra(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_physics_model" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_physics_model", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new instance_physics_modelType(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "technique_common" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "technique_common", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new technique_commonType6(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "technique" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "technique", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new techniqueType5(tmpNode).adjustPrefix();
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
		el.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:type", "physics_scene");
	}

	public static int getidMinCount() {
		return 0;
	}

	public static int getidMaxCount() {
		return 1;
	}

	public int getidCount() {
		return getDomChildCount(Attribute, null, "id");
	}

	public boolean hasid() {
		return hasDomChild(Attribute, null, "id");
	}

	public SchemaID newid() {
		return new SchemaID();
	}

	public SchemaID getidAt(int index) throws Exception {
		return new SchemaID(getDomNodeValue(getDomChildAt(Attribute, null, "id", index)));
	}

	public org.w3c.dom.Node getStartingidCursor() throws Exception {
		return getDomFirstChild(Attribute, null, "id" );
	}

	public org.w3c.dom.Node getAdvancedidCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Attribute, null, "id", curNode );
	}

	public SchemaID getidValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new SchemaID(getDomNodeValue(curNode));
	}

	public SchemaID getid() throws Exception 
 {
		return getidAt(0);
	}

	public void removeidAt(int index) {
		removeDomChildAt(Attribute, null, "id", index);
	}

	public void removeid() {
		removeidAt(0);
	}

	public org.w3c.dom.Node addid(SchemaID value) {
		if( value.isNull() )
			return null;

		return  appendDomChild(Attribute, null, "id", value.toString());
	}

	public org.w3c.dom.Node addid(String value) throws Exception {
		return addid(new SchemaID(value));
	}

	public void insertidAt(SchemaID value, int index) {
		insertDomChildAt(Attribute, null, "id", index, value.toString());
	}

	public void insertidAt(String value, int index) throws Exception {
		insertidAt(new SchemaID(value), index);
	}

	public void replaceidAt(SchemaID value, int index) {
		replaceDomChildAt(Attribute, null, "id", index, value.toString());
	}

	public void replaceidAt(String value, int index) throws Exception {
		replaceidAt(new SchemaID(value), index);
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

	public static int getassetMinCount() {
		return 0;
	}

	public static int getassetMaxCount() {
		return 1;
	}

	public int getassetCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "asset");
	}

	public boolean hasasset() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "asset");
	}

	public assetType newasset() {
		return new assetType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "asset"));
	}

	public assetType getassetAt(int index) throws Exception {
		return new assetType(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "asset", index));
	}

	public org.w3c.dom.Node getStartingassetCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "asset" );
	}

	public org.w3c.dom.Node getAdvancedassetCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "asset", curNode );
	}

	public assetType getassetValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new assetType(curNode);
	}

	public assetType getasset() throws Exception 
 {
		return getassetAt(0);
	}

	public void removeassetAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "asset", index);
	}

	public void removeasset() {
		removeassetAt(0);
	}

	public org.w3c.dom.Node addasset(assetType value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "asset", value);
	}

	public void insertassetAt(assetType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "asset", index, value);
	}

	public void replaceassetAt(assetType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "asset", index, value);
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

	public static int getinstance_physics_modelMinCount() {
		return 0;
	}

	public static int getinstance_physics_modelMaxCount() {
		return Integer.MAX_VALUE;
	}

	public int getinstance_physics_modelCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_physics_model");
	}

	public boolean hasinstance_physics_model() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_physics_model");
	}

	public instance_physics_modelType newinstance_physics_model() {
		return new instance_physics_modelType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "instance_physics_model"));
	}

	public instance_physics_modelType getinstance_physics_modelAt(int index) throws Exception {
		return new instance_physics_modelType(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_physics_model", index));
	}

	public org.w3c.dom.Node getStartinginstance_physics_modelCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_physics_model" );
	}

	public org.w3c.dom.Node getAdvancedinstance_physics_modelCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_physics_model", curNode );
	}

	public instance_physics_modelType getinstance_physics_modelValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new instance_physics_modelType(curNode);
	}

	public instance_physics_modelType getinstance_physics_model() throws Exception 
 {
		return getinstance_physics_modelAt(0);
	}

	public void removeinstance_physics_modelAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "instance_physics_model", index);
	}

	public void removeinstance_physics_model() {
		while (hasinstance_physics_model())
			removeinstance_physics_modelAt(0);
	}

	public org.w3c.dom.Node addinstance_physics_model(instance_physics_modelType value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "instance_physics_model", value);
	}

	public void insertinstance_physics_modelAt(instance_physics_modelType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "instance_physics_model", index, value);
	}

	public void replaceinstance_physics_modelAt(instance_physics_modelType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "instance_physics_model", index, value);
	}

	public static int gettechnique_commonMinCount() {
		return 1;
	}

	public static int gettechnique_commonMaxCount() {
		return 1;
	}

	public int gettechnique_commonCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "technique_common");
	}

	public boolean hastechnique_common() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "technique_common");
	}

	public technique_commonType6 newtechnique_common() {
		return new technique_commonType6(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "technique_common"));
	}

	public technique_commonType6 gettechnique_commonAt(int index) throws Exception {
		return new technique_commonType6(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "technique_common", index));
	}

	public org.w3c.dom.Node getStartingtechnique_commonCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "technique_common" );
	}

	public org.w3c.dom.Node getAdvancedtechnique_commonCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "technique_common", curNode );
	}

	public technique_commonType6 gettechnique_commonValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new technique_commonType6(curNode);
	}

	public technique_commonType6 gettechnique_common() throws Exception 
 {
		return gettechnique_commonAt(0);
	}

	public void removetechnique_commonAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "technique_common", index);
	}

	public void removetechnique_common() {
		removetechnique_commonAt(0);
	}

	public org.w3c.dom.Node addtechnique_common(technique_commonType6 value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "technique_common", value);
	}

	public void inserttechnique_commonAt(technique_commonType6 value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "technique_common", index, value);
	}

	public void replacetechnique_commonAt(technique_commonType6 value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "technique_common", index, value);
	}

	public static int gettechniqueMinCount() {
		return 0;
	}

	public static int gettechniqueMaxCount() {
		return Integer.MAX_VALUE;
	}

	public int gettechniqueCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "technique");
	}

	public boolean hastechnique() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "technique");
	}

	public techniqueType5 newtechnique() {
		return new techniqueType5(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "technique"));
	}

	public techniqueType5 gettechniqueAt(int index) throws Exception {
		return new techniqueType5(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "technique", index));
	}

	public org.w3c.dom.Node getStartingtechniqueCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "technique" );
	}

	public org.w3c.dom.Node getAdvancedtechniqueCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "technique", curNode );
	}

	public techniqueType5 gettechniqueValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new techniqueType5(curNode);
	}

	public techniqueType5 gettechnique() throws Exception 
 {
		return gettechniqueAt(0);
	}

	public void removetechniqueAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "technique", index);
	}

	public void removetechnique() {
		while (hastechnique())
			removetechniqueAt(0);
	}

	public org.w3c.dom.Node addtechnique(techniqueType5 value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "technique", value);
	}

	public void inserttechniqueAt(techniqueType5 value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "technique", index, value);
	}

	public void replacetechniqueAt(techniqueType5 value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "technique", index, value);
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
