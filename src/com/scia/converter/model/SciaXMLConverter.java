package com.scia.converter.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.scia.converter.bean.DataSummary;
import com.scia.converter.bean.Node;
import com.scia.converter.bean.Part;
import com.scia.converter.exception.SciaXMLConverterException;
import com.scia.converter.util.SciaXMLConstants;
import com.scia.converter.util.SciaXMLUtils;
import com.scia.converter.xml.rqnet.Column;
import com.scia.converter.xml.rqnet.DataSet;
import com.scia.converter.xml.rqnet.Elevation;
import com.scia.converter.xml.rqnet.FrameLine;
import com.scia.converter.xml.rqnet.Level;
import com.scia.converter.xml.scia.Project;

public class SciaXMLConverter {

	private DataSet rqNetXML;
	private Project sciaXML;
	
	public SciaXMLConverter() {
		super();
	}

	public void convertFiles() throws SciaXMLConverterException{
		Double columnHeight = getColumnHeight();
		Double clearBay = getClearBay();
		Double columnSpace = getColumnSpace();
		List<Double> levelElevations = getLevelElevations();
		
		System.out.println("Column Height = " + columnHeight);
		System.out.println("Clear Bay = " + clearBay);
		System.out.println("Column Space = " + columnSpace);
		System.out.println("Level Elevations = " + levelElevations);
		
		convertColumns(columnHeight, clearBay, columnSpace);
//		convertFrontBeams(clearBay, levelElevations);
//		convertBackBeams(clearBay, columnSpace, levelElevations);
	}
	
	private Double getColumnHeight() throws SciaXMLConverterException{
		Double maxColumnHeight = 0.0;
		
		if (this.rqNetXML != null){
			ArrayList<Double> columnsH = new ArrayList<Double>();
			List<Column> columns = this.rqNetXML.getColumns();
			
			if (columns != null && columns.size() > 0){
				for (Column column : columns) {
					Double parsedValue = SciaXMLUtils.parseValue(column.getColumnHeight());
					if (parsedValue != 0){
						columnsH.add(parsedValue);
					}
				}
			}
			
			if (columnsH != null && columnsH.size() > 0){
				Collections.sort(columnsH);
				maxColumnHeight = columnsH.get(columnsH.size() - 1);
			}
		}else{
			throw new SciaXMLConverterException();
		}
	
		return SciaXMLUtils.inches2Meters(maxColumnHeight);
	}
	
	private Double getClearBay() throws SciaXMLConverterException{
		Double clearBay = 0.0;
		
		if (this.rqNetXML != null){
			ArrayList<Double> clearBays = new ArrayList<Double>();
			List<Elevation> elevations = this.rqNetXML.getElevations();
			
			if (elevations != null && elevations.size() > 0){
				for (Elevation elevation : elevations) {
					Double parsedValue = SciaXMLUtils.parseValue(elevation.getClearBay());
					if (parsedValue != 0){
						clearBays.add(parsedValue);
					}
				}
			}
			
			if (clearBays != null && clearBays.size() > 0){
				Collections.sort(clearBays);
				clearBay = clearBays.get(clearBays.size() - 1);
			}
		}else{
			throw new SciaXMLConverterException();
		}
	
		return SciaXMLUtils.inches2Meters(clearBay);
	}
	
	private Double  getColumnSpace() throws SciaXMLConverterException{
		Double columnSpace = 0.0;
		
		if (this.rqNetXML != null){
			ArrayList<Double> columnSpaces = new ArrayList<Double>();
			List<FrameLine> framelines = this.rqNetXML.getFramelines();
			
			if (framelines != null && framelines.size() > 0){
				for (FrameLine frameline : framelines) {
					Double parsedValue = SciaXMLUtils.parseValue(frameline.getColumnSpace());
					if (parsedValue != 0){
						columnSpaces.add(parsedValue);
					}
				}
			}
			
			if (columnSpaces != null && columnSpaces.size() > 0){
				Collections.sort(columnSpaces);
				columnSpace = columnSpaces.get(columnSpaces.size() - 1);
			}
		}else{
			throw new SciaXMLConverterException();
		}
	
		return SciaXMLUtils.inches2Meters(columnSpace);
	}
	
	private List<Double> getLevelElevations() throws SciaXMLConverterException{
		ArrayList<Double> levalElevations = new ArrayList<Double>();
		
		if (this.rqNetXML != null){
			List<Level> levels = this.rqNetXML.getLevels();
			
			if (levels != null && levels.size() > 0){
				for (Level level : levels) {
					Double parsedValue = SciaXMLUtils.parseValue(level.getLevelElevation());
					if (parsedValue != 0){
						levalElevations.add(SciaXMLUtils.inches2Meters(parsedValue));
					}
				}
			}
			
			if (levalElevations != null && levalElevations.size() > 0){
				Collections.sort(levalElevations);
			}
		}else{
			throw new SciaXMLConverterException();
		}
	
		return levalElevations;
	}
	
	private void convertColumns(Double columnHeight, Double clearBay, Double columnSpace) throws SciaXMLConverterException{
		
		if (columnHeight > 0 && clearBay > 0 && columnSpace > 0){
		
			Node node1 = new Node();
			node1.setId(""+DataSummary.nodesIndex);
			node1.setName(""+DataSummary.nodesIndex++);
			node1.setX(0.0);
			node1.setY(0.0);
			node1.setZ(0.0);
			
			Node node2 = new Node();
			node2.setId(""+DataSummary.nodesIndex);
			node2.setName(""+DataSummary.nodesIndex++);
			node2.setX(0.0);
			node2.setY(0.0);
			node2.setZ(columnHeight);
			
			Node node3 = new Node();
			node3.setId(""+DataSummary.nodesIndex);
			node3.setName(""+DataSummary.nodesIndex++);
			node3.setX(0.0);
			node3.setY(columnSpace);
			node3.setZ(0.0);
			
			Node node4 = new Node();
			node4.setId(""+DataSummary.nodesIndex);
			node4.setName(""+DataSummary.nodesIndex++);
			node4.setX(0.0);
			node4.setY(columnSpace);
			node4.setZ(columnHeight);
			
			Node node5 = new Node();
			node5.setId(""+DataSummary.nodesIndex);
			node5.setName(""+DataSummary.nodesIndex++);
			node5.setX(clearBay);
			node5.setY(columnSpace);
			node5.setZ(0.0);
			
			Node node6 = new Node();
			node6.setId(""+DataSummary.nodesIndex);
			node6.setName(""+DataSummary.nodesIndex++);
			node6.setX(clearBay);
			node6.setY(columnSpace);
			node6.setZ(columnHeight);
			
			Node node7 = new Node();
			node7.setId(""+DataSummary.nodesIndex);
			node7.setName(""+DataSummary.nodesIndex++);
			node7.setX(clearBay);
			node7.setY(0.0);
			node7.setZ(0.0);
			
			Node node8 = new Node();
			node8.setId(""+DataSummary.nodesIndex);
			node8.setName(""+DataSummary.nodesIndex++);
			node8.setX(clearBay);
			node8.setY(0.0);
			node8.setZ(columnHeight);
			
			Part column1 = new Part();
			column1.setId(""+DataSummary.partsIndex);
			column1.setName(""+DataSummary.partsIndex);
			column1.setType(SciaXMLConstants.DEFAULT_COLUMN_TYPE);
			column1.setInitialNode(node1);
			column1.setFinalNode(node2);
			
			Part column2 = new Part();
			column2.setId(""+DataSummary.partsIndex);
			column2.setName(""+DataSummary.partsIndex);
			column2.setType(SciaXMLConstants.DEFAULT_COLUMN_TYPE);
			column2.setInitialNode(node3);
			column2.setFinalNode(node4);
			
			Part column3 = new Part();
			column3.setId(""+DataSummary.partsIndex);
			column3.setName(""+DataSummary.partsIndex);
			column3.setType(SciaXMLConstants.DEFAULT_COLUMN_TYPE);
			column3.setInitialNode(node5);
			column3.setFinalNode(node6);
			
			Part column4 = new Part();
			column4.setId(""+DataSummary.partsIndex);
			column4.setName(""+DataSummary.partsIndex);
			column4.setType(SciaXMLConstants.DEFAULT_COLUMN_TYPE);
			column4.setInitialNode(node7);
			column4.setFinalNode(node8);
			
			DataSummary.finalNodes.add(node1);
			DataSummary.finalNodes.add(node2);
			DataSummary.finalNodes.add(node3);
			DataSummary.finalNodes.add(node4);
			DataSummary.finalNodes.add(node5);
			DataSummary.finalNodes.add(node6);
			DataSummary.finalNodes.add(node7);
			DataSummary.finalNodes.add(node8);
			
			DataSummary.finalParts.add(column1);
			DataSummary.finalParts.add(column2);
			DataSummary.finalParts.add(column3);
			DataSummary.finalParts.add(column4);
			
		}else{
			throw new SciaXMLConverterException();
		}	
	}
	
	private void convertFrontBeams(Double clearBay, List<Double> levelElevations){}
	private void convertBackBeams(Double clearBay, Double columnSpace, List<Double> levelElevations){}
	
	public DataSet getRqNetXML() {
		return rqNetXML;
	}

	public void setRqNetXML(DataSet rqNetXML) {
		this.rqNetXML = rqNetXML;
	}

	public Project getSciaXML() {
		return sciaXML;
	}

	public void setSciaXML(Project sciaXML) {
		this.sciaXML = sciaXML;
	}	
}
