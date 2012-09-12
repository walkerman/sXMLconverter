package com.scia.converter.xml.scia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.scia.converter.bean.DataSummary;
import com.scia.converter.bean.Node;
import com.scia.converter.bean.Part;
import com.scia.converter.util.SciaXMLConstants;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("project")
public class Project {
	
	@XStreamAsAttribute
	private String xmlns;
	
	private Definition def;
	
	@XStreamImplicit(itemFieldName="container")
	private List<Container> containers;
	
	@XStreamOmitField
	private String uuid;
	
	public Project(String fileName) {
		
		if (fileName != null){
			this.xmlns = SciaXMLConstants.XMLNS;
			this.def = new Definition(fileName+SciaXMLConstants.DEF);
			this.containers = new ArrayList<Container>();
			this.containers.add(getContainerNos());
			this.containers.add(getContainerPecas());
		}
		
	}
	
	private Container getContainerNos() {
		List<Node> nos= DataSummary.finalNodes;
		Container containerNos = null;
		if (nos != null && nos.size() > 0){
			
			List<Object> objects = new ArrayList<Object>();
			
			for (Node coordenada : nos) {
				Object o = new Object();
				o.setId(coordenada.getId() + this.uuid);
				o.setNm(coordenada.getName()  + this.uuid);
				o.setP0(new ObjectItem(String.valueOf(coordenada.getName()  + this.uuid), null, null, null, null, null));
				o.setP1(new ObjectItem(String.valueOf(coordenada.getX()), null, null, null, null, null));
				o.setP2(new ObjectItem(String.valueOf(coordenada.getY()), null, null, null, null, null));
				o.setP3(new ObjectItem(String.valueOf(coordenada.getZ()), null, null, null, null, null));
				objects.add(o);
			}
			
			Header header = getDefaultStructNodeHeader();
			TableNode tabelaNos = new TableNode(SciaXMLConstants.STRUCT_NODE_TABLE_ID, 
												SciaXMLConstants.STRUCT_NODE_TABLE, 
												SciaXMLConstants.STRUCT_NODE_TABLE_NAME, header, objects);
			
			containerNos = new Container(SciaXMLConstants.STRUCT_NODE_ID, SciaXMLConstants.STRUCT_NODE_TITLE, tabelaNos);
			
		}
		return containerNos;
	}
	
	private Container getContainerPecas() {
		Container containerPecas = null;
		
		List<Object> objects = new ArrayList<Object>();
		objects.addAll(getPecas(DataSummary.finalParts));
			
		Header header = getDefaultBeamHeader();
		TableNode tabelaPecas = new TableNode(SciaXMLConstants.BEAM_TABLE_ID, 
											SciaXMLConstants.BEAM_TABLE, 
											SciaXMLConstants.BEAM_TABLE_NAME, header, objects);
		
		containerPecas = new Container(SciaXMLConstants.BEAM_ID, SciaXMLConstants.BEAM_TITLE, tabelaPecas);
		
		return containerPecas;
	}
		
	private Collection<Object> getPecas(List<Part> pecas) {
		List<Object> retorno = new ArrayList<Object>();
		for (Part peca : pecas) {
			Object o = new Object();
			
			o.setId(peca.getId() + this.uuid);
			o.setNm(peca.getName() + this.uuid);
			o.setP0(new ObjectItem(peca.getId()  + this.uuid, null, null, null, null, null));
			o.setP1(new ObjectItem(null,String.valueOf(peca.getInitialNode().getId()  + this.uuid),String.valueOf(peca.getInitialNode().getId() + this.uuid),null,null,null));
			o.setP2(new ObjectItem(null,String.valueOf(peca.getFinalNode().getId() + this.uuid),String.valueOf(peca.getFinalNode().getId() + this.uuid),null,null,null));
			
			ObjectItem item = new ObjectItem();
			item.setV(peca.getId());
			if (peca.getType() != null){
				String valor = peca.getType();
				item.setN(valor);
			}
			o.setP3(item);			
			
			o.setP4(new ObjectItem(SciaXMLConstants.BEAM_OBJECT_FEM_TYPE_V, null, null, SciaXMLConstants.BEAM_OBJECT_FEM_TYPE_T, null, null));
			o.setP5(new ObjectItem(SciaXMLConstants.BEAM_OBJECT_SYSTEM_LINE_V, null, null, SciaXMLConstants.BEAM_OBJECT_SYSTEM_LINE_T, null, null));
			o.setP6(new ObjectItem(SciaXMLConstants.BEAM_OBJECT_EY_V, null, null, null, null, null));
			o.setP7(new ObjectItem(SciaXMLConstants.BEAM_OBJECT_EZ_V,  null, null, null, null, null));
			
			o.setP8(null); // Is it really necessary?
			
			retorno.add(o);
		}		
		
		return retorno;
	}
	
	private Header getDefaultBeamHeader() {
		Header retorno = new Header();
		retorno.setH0(new HeaderItem(SciaXMLConstants.BEAM_HEADER_H0));
		retorno.setH1(new HeaderItem(SciaXMLConstants.BEAM_HEADER_H1));
		retorno.setH2(new HeaderItem(SciaXMLConstants.BEAM_HEADER_H2));
		retorno.setH3(new HeaderItem(SciaXMLConstants.BEAM_HEADER_H3));
		retorno.setH4(new HeaderItem(SciaXMLConstants.BEAM_HEADER_H4));
		retorno.setH5(new HeaderItem(SciaXMLConstants.BEAM_HEADER_H5));
		retorno.setH6(new HeaderItem(SciaXMLConstants.BEAM_HEADER_H6));
		retorno.setH7(new HeaderItem(SciaXMLConstants.BEAM_HEADER_H7));
		retorno.setH8(new HeaderItem(SciaXMLConstants.BEAM_HEADER_H8));
		retorno.setH9(new HeaderItem(SciaXMLConstants.BEAM_HEADER_H9));
		retorno.setH10(new HeaderItem(SciaXMLConstants.BEAM_HEADER_H10));
		retorno.setH11(new HeaderItem(SciaXMLConstants.BEAM_HEADER_H11));
		retorno.setH12(new HeaderItem(SciaXMLConstants.BEAM_HEADER_H12));
		return retorno;
	}

	private Header getDefaultStructNodeHeader() {
		Header retorno = new Header();
		retorno.setH0(new HeaderItem(SciaXMLConstants.STRUCT_NODE_HEADER_H0));
		retorno.setH1(new HeaderItem(SciaXMLConstants.STRUCT_NODE_HEADER_H1));
		retorno.setH2(new HeaderItem(SciaXMLConstants.STRUCT_NODE_HEADER_H2));
		retorno.setH3(new HeaderItem(SciaXMLConstants.STRUCT_NODE_HEADER_H3));
		return retorno;
	}

	public Project(String xmlns, Definition def, List<Container> containers) {
		this.xmlns = xmlns;
		this.def = def;
		this.containers = containers;
	}

	public Definition getDef() {
		return def;
	}

	public List<Container> getContainers() {
		return containers;
	}

	public void setDef(Definition def) {
		this.def = def;
	}

	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}

	public String getXmlns() {
		return xmlns;
	}

	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

	@Override
	public String toString() {
		return "Project [xmlns=" + xmlns + ", def=" + def + ", container="
				+ containers + "]";
	}
	
}
