/**
 * meshType.java
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


public class meshType extends com.jmex.xml.xml.Node {

	public meshType(meshType node) {
		super(node);
	}

	public meshType(org.w3c.dom.Node node) {
		super(node);
	}

	public meshType(org.w3c.dom.Document doc) {
		super(doc);
	}

	public meshType(com.jmex.xml.xml.Document doc, String namespaceURI, String prefix, String name) {
		super(doc, namespaceURI, prefix, name);
	}
	
	public void adjustPrefix() {
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "source" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "source", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new sourceType(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "vertices" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "vertices", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new verticesType(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "lines" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "lines", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new linesType(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "linestrips" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "linestrips", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new linestripsType(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "polygons" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "polygons", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new polygonsType(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "polylist" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "polylist", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new polylistType(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "triangles" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "triangles", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new trianglesType(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "trifans" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "trifans", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new trifansType(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "tristrips" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "tristrips", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new tristripsType(tmpNode).adjustPrefix();
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
		el.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:type", "mesh");
	}

	public static int getsourceMinCount() {
		return 1;
	}

	public static int getsourceMaxCount() {
		return Integer.MAX_VALUE;
	}

	public int getsourceCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "source");
	}

	public boolean hassource() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "source");
	}

	public sourceType newsource() {
		return new sourceType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "source"));
	}

	public sourceType getsourceAt(int index) throws Exception {
		return new sourceType(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "source", index));
	}

	public org.w3c.dom.Node getStartingsourceCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "source" );
	}

	public org.w3c.dom.Node getAdvancedsourceCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "source", curNode );
	}

	public sourceType getsourceValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new sourceType(curNode);
	}

	public sourceType getsource() throws Exception 
 {
		return getsourceAt(0);
	}

	public void removesourceAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "source", index);
	}

	public void removesource() {
		while (hassource())
			removesourceAt(0);
	}

	public org.w3c.dom.Node addsource(sourceType value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "source", value);
	}

	public void insertsourceAt(sourceType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "source", index, value);
	}

	public void replacesourceAt(sourceType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "source", index, value);
	}

	public static int getverticesMinCount() {
		return 1;
	}

	public static int getverticesMaxCount() {
		return 1;
	}

	public int getverticesCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "vertices");
	}

	public boolean hasvertices() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "vertices");
	}

	public verticesType newvertices() {
		return new verticesType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "vertices"));
	}

	public verticesType getverticesAt(int index) throws Exception {
		return new verticesType(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "vertices", index));
	}

	public org.w3c.dom.Node getStartingverticesCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "vertices" );
	}

	public org.w3c.dom.Node getAdvancedverticesCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "vertices", curNode );
	}

	public verticesType getverticesValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new verticesType(curNode);
	}

	public verticesType getvertices() throws Exception 
 {
		return getverticesAt(0);
	}

	public void removeverticesAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "vertices", index);
	}

	public void removevertices() {
		removeverticesAt(0);
	}

	public org.w3c.dom.Node addvertices(verticesType value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "vertices", value);
	}

	public void insertverticesAt(verticesType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "vertices", index, value);
	}

	public void replaceverticesAt(verticesType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "vertices", index, value);
	}

	public static int getlinesMinCount() {
		return 1;
	}

	public static int getlinesMaxCount() {
		return 1;
	}

	public int getlinesCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "lines");
	}

	public boolean haslines() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "lines");
	}

	public linesType newlines() {
		return new linesType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "lines"));
	}

	public linesType getlinesAt(int index) throws Exception {
		return new linesType(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "lines", index));
	}

	public org.w3c.dom.Node getStartinglinesCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "lines" );
	}

	public org.w3c.dom.Node getAdvancedlinesCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "lines", curNode );
	}

	public linesType getlinesValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new linesType(curNode);
	}

	public linesType getlines() throws Exception 
 {
		return getlinesAt(0);
	}

	public void removelinesAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "lines", index);
	}

	public void removelines() {
		removelinesAt(0);
	}

	public org.w3c.dom.Node addlines(linesType value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "lines", value);
	}

	public void insertlinesAt(linesType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "lines", index, value);
	}

	public void replacelinesAt(linesType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "lines", index, value);
	}

	public static int getlinestripsMinCount() {
		return 1;
	}

	public static int getlinestripsMaxCount() {
		return 1;
	}

	public int getlinestripsCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "linestrips");
	}

	public boolean haslinestrips() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "linestrips");
	}

	public linestripsType newlinestrips() {
		return new linestripsType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "linestrips"));
	}

	public linestripsType getlinestripsAt(int index) throws Exception {
		return new linestripsType(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "linestrips", index));
	}

	public org.w3c.dom.Node getStartinglinestripsCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "linestrips" );
	}

	public org.w3c.dom.Node getAdvancedlinestripsCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "linestrips", curNode );
	}

	public linestripsType getlinestripsValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new linestripsType(curNode);
	}

	public linestripsType getlinestrips() throws Exception 
 {
		return getlinestripsAt(0);
	}

	public void removelinestripsAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "linestrips", index);
	}

	public void removelinestrips() {
		removelinestripsAt(0);
	}

	public org.w3c.dom.Node addlinestrips(linestripsType value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "linestrips", value);
	}

	public void insertlinestripsAt(linestripsType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "linestrips", index, value);
	}

	public void replacelinestripsAt(linestripsType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "linestrips", index, value);
	}

	public static int getpolygonsMinCount() {
		return 1;
	}

	public static int getpolygonsMaxCount() {
		return 1;
	}

	public int getpolygonsCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "polygons");
	}

	public boolean haspolygons() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "polygons");
	}

	public polygonsType newpolygons() {
		return new polygonsType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "polygons"));
	}

	public polygonsType getpolygonsAt(int index) throws Exception {
		return new polygonsType(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "polygons", index));
	}

	public org.w3c.dom.Node getStartingpolygonsCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "polygons" );
	}

	public org.w3c.dom.Node getAdvancedpolygonsCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "polygons", curNode );
	}

	public polygonsType getpolygonsValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new polygonsType(curNode);
	}

	public polygonsType getpolygons() throws Exception 
 {
		return getpolygonsAt(0);
	}

	public void removepolygonsAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "polygons", index);
	}

	public void removepolygons() {
		removepolygonsAt(0);
	}

	public org.w3c.dom.Node addpolygons(polygonsType value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "polygons", value);
	}

	public void insertpolygonsAt(polygonsType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "polygons", index, value);
	}

	public void replacepolygonsAt(polygonsType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "polygons", index, value);
	}

	public static int getpolylistMinCount() {
		return 1;
	}

	public static int getpolylistMaxCount() {
		return 1;
	}

	public int getpolylistCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "polylist");
	}

	public boolean haspolylist() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "polylist");
	}

	public polylistType newpolylist() {
		return new polylistType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "polylist"));
	}

	public polylistType getpolylistAt(int index) throws Exception {
		return new polylistType(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "polylist", index));
	}

	public org.w3c.dom.Node getStartingpolylistCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "polylist" );
	}

	public org.w3c.dom.Node getAdvancedpolylistCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "polylist", curNode );
	}

	public polylistType getpolylistValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new polylistType(curNode);
	}

	public polylistType getpolylist() throws Exception 
 {
		return getpolylistAt(0);
	}

	public void removepolylistAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "polylist", index);
	}

	public void removepolylist() {
		removepolylistAt(0);
	}

	public org.w3c.dom.Node addpolylist(polylistType value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "polylist", value);
	}

	public void insertpolylistAt(polylistType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "polylist", index, value);
	}

	public void replacepolylistAt(polylistType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "polylist", index, value);
	}

	public static int gettrianglesMinCount() {
		return 1;
	}

	public static int gettrianglesMaxCount() {
		return 1;
	}

	public int gettrianglesCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "triangles");
	}

	public boolean hastriangles() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "triangles");
	}

	public trianglesType newtriangles() {
		return new trianglesType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "triangles"));
	}

	public trianglesType gettrianglesAt(int index) throws Exception {
		return new trianglesType(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "triangles", index));
	}

	public org.w3c.dom.Node getStartingtrianglesCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "triangles" );
	}

	public org.w3c.dom.Node getAdvancedtrianglesCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "triangles", curNode );
	}

	public trianglesType gettrianglesValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new trianglesType(curNode);
	}

	public trianglesType gettriangles() throws Exception 
 {
		return gettrianglesAt(0);
	}

	public void removetrianglesAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "triangles", index);
	}

	public void removetriangles() {
		removetrianglesAt(0);
	}

	public org.w3c.dom.Node addtriangles(trianglesType value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "triangles", value);
	}

	public void inserttrianglesAt(trianglesType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "triangles", index, value);
	}

	public void replacetrianglesAt(trianglesType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "triangles", index, value);
	}

	public static int gettrifansMinCount() {
		return 1;
	}

	public static int gettrifansMaxCount() {
		return 1;
	}

	public int gettrifansCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "trifans");
	}

	public boolean hastrifans() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "trifans");
	}

	public trifansType newtrifans() {
		return new trifansType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "trifans"));
	}

	public trifansType gettrifansAt(int index) throws Exception {
		return new trifansType(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "trifans", index));
	}

	public org.w3c.dom.Node getStartingtrifansCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "trifans" );
	}

	public org.w3c.dom.Node getAdvancedtrifansCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "trifans", curNode );
	}

	public trifansType gettrifansValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new trifansType(curNode);
	}

	public trifansType gettrifans() throws Exception 
 {
		return gettrifansAt(0);
	}

	public void removetrifansAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "trifans", index);
	}

	public void removetrifans() {
		removetrifansAt(0);
	}

	public org.w3c.dom.Node addtrifans(trifansType value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "trifans", value);
	}

	public void inserttrifansAt(trifansType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "trifans", index, value);
	}

	public void replacetrifansAt(trifansType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "trifans", index, value);
	}

	public static int gettristripsMinCount() {
		return 1;
	}

	public static int gettristripsMaxCount() {
		return 1;
	}

	public int gettristripsCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "tristrips");
	}

	public boolean hastristrips() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "tristrips");
	}

	public tristripsType newtristrips() {
		return new tristripsType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "tristrips"));
	}

	public tristripsType gettristripsAt(int index) throws Exception {
		return new tristripsType(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "tristrips", index));
	}

	public org.w3c.dom.Node getStartingtristripsCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "tristrips" );
	}

	public org.w3c.dom.Node getAdvancedtristripsCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "tristrips", curNode );
	}

	public tristripsType gettristripsValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new tristripsType(curNode);
	}

	public tristripsType gettristrips() throws Exception 
 {
		return gettristripsAt(0);
	}

	public void removetristripsAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "tristrips", index);
	}

	public void removetristrips() {
		removetristripsAt(0);
	}

	public org.w3c.dom.Node addtristrips(tristripsType value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "tristrips", value);
	}

	public void inserttristripsAt(tristripsType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "tristrips", index, value);
	}

	public void replacetristripsAt(tristripsType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "tristrips", index, value);
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
