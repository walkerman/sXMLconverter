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
import com.scia.converter.util.TagIdentifier;
import com.scia.converter.xml.rqnet.Column;
import com.scia.converter.xml.rqnet.Elevation;
import com.scia.converter.xml.rqnet.FrameLine;
import com.scia.converter.xml.rqnet.Level;

public class SciaXMLConverter {
	
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
		convertFrontBeams(clearBay, levelElevations);
		convertBackBeams(clearBay, columnSpace, levelElevations);
		
		SciaXMLUtils.generateProject(DataSummary.sciaXML);
	}
	
	private Double getColumnHeight() throws SciaXMLConverterException{
		Double maxColumnHeight = 0.0;
		
		if (DataSummary.rqNetXML != null){
			ArrayList<Double> columnsH = new ArrayList<Double>();
			List<Column> columns = DataSummary.rqNetXML.getColumns();
			
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
		
		if (DataSummary.rqNetXML != null){
			ArrayList<Double> clearBays = new ArrayList<Double>();
			List<Elevation> elevations = DataSummary.rqNetXML.getElevations();
			
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
		
		if (DataSummary.rqNetXML != null){
			ArrayList<Double> columnSpaces = new ArrayList<Double>();
			List<FrameLine> framelines = DataSummary.rqNetXML.getFramelines();
			
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
		
		if (DataSummary.rqNetXML != null){
			List<Level> levels = DataSummary.rqNetXML.getLevels();
			
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
			node1.setId(TagIdentifier.getNodeIdentifier());
			node1.setName(TagIdentifier.getNodeName());
			node1.setX(0.0);
			node1.setY(0.0);
			node1.setZ(0.0);
			
			Node node2 = new Node();
			node2.setId(TagIdentifier.getNodeIdentifier());
			node2.setName(TagIdentifier.getNodeName());
			node2.setX(0.0);
			node2.setY(0.0);
			node2.setZ(columnHeight);
			
			Node node3 = new Node();
			node3.setId(TagIdentifier.getNodeIdentifier());
			node3.setName(TagIdentifier.getNodeName());
			node3.setX(0.0);
			node3.setY(columnSpace);
			node3.setZ(0.0);
			
			Node node4 = new Node();
			node4.setId(TagIdentifier.getNodeIdentifier());
			node4.setName(TagIdentifier.getNodeName());
			node4.setX(0.0);
			node4.setY(columnSpace);
			node4.setZ(columnHeight);
			
			Node node5 = new Node();
			node5.setId(TagIdentifier.getNodeIdentifier());
			node5.setName(TagIdentifier.getNodeName());
			node5.setX(clearBay);
			node5.setY(columnSpace);
			node5.setZ(0.0);
			
			Node node6 = new Node();
			node6.setId(TagIdentifier.getNodeIdentifier());
			node6.setName(TagIdentifier.getNodeName());
			node6.setX(clearBay);
			node6.setY(columnSpace);
			node6.setZ(columnHeight);
			
			Node node7 = new Node();
			node7.setId(TagIdentifier.getNodeIdentifier());
			node7.setName(TagIdentifier.getNodeName());
			node7.setX(clearBay);
			node7.setY(0.0);
			node7.setZ(0.0);
			
			Node node8 = new Node();
			node8.setId(TagIdentifier.getNodeIdentifier());
			node8.setName(TagIdentifier.getNodeName());
			node8.setX(clearBay);
			node8.setY(0.0);
			node8.setZ(columnHeight);
			
			Part column1 = new Part();
			column1.setId(TagIdentifier.getPartIdentifier());
			column1.setName(TagIdentifier.getPartName());
			column1.setType(SciaXMLConstants.DEFAULT_COLUMN_TYPE);
			column1.setInitialNode(node1);
			column1.setFinalNode(node2);
			
			Part column2 = new Part();
			column2.setId(TagIdentifier.getPartIdentifier());
			column2.setName(TagIdentifier.getPartName());
			column2.setType(SciaXMLConstants.DEFAULT_COLUMN_TYPE);
			column2.setInitialNode(node3);
			column2.setFinalNode(node4);
			
			Part column3 = new Part();
			column3.setId(TagIdentifier.getPartIdentifier());
			column3.setName(TagIdentifier.getPartName());
			column3.setType(SciaXMLConstants.DEFAULT_COLUMN_TYPE);
			column3.setInitialNode(node5);
			column3.setFinalNode(node6);
			
			Part column4 = new Part();
			column4.setId(TagIdentifier.getPartIdentifier());
			column4.setName(TagIdentifier.getPartName());
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
	
	private void convertFrontBeams(Double clearBay, List<Double> levelElevations){
		if (levelElevations != null && levelElevations.size() > 0){
			
			for (Double levelHeight : levelElevations) {
				Node node1 = new Node();
				node1.setId(TagIdentifier.getNodeIdentifier());
				node1.setName(TagIdentifier.getNodeName());
				node1.setX(0.0);
				node1.setY(0.0);
				node1.setZ(levelHeight);
				
				Node node2 = new Node();
				node2.setId(TagIdentifier.getNodeIdentifier());
				node2.setName(TagIdentifier.getNodeName());
				node2.setX(clearBay);
				node2.setY(0.0);
				node2.setZ(levelHeight);
				
				Part beam = new Part();
				beam.setId(TagIdentifier.getPartIdentifier());
				beam.setName(TagIdentifier.getPartName());
				beam.setType(SciaXMLConstants.DEFAULT_BEAM_TYPE);
				beam.setInitialNode(node1);
				beam.setFinalNode(node2);
				
				DataSummary.finalNodes.add(node1);
				DataSummary.finalNodes.add(node2);
				
				DataSummary.finalParts.add(beam);
			}
		}
	}
	
	private void convertBackBeams(Double clearBay, Double columnSpace, List<Double> levelElevations){
		if (levelElevations != null && levelElevations.size() > 0){
			
			for (Double levelHeight : levelElevations) {
				Node node1 = new Node();
				node1.setId(TagIdentifier.getNodeIdentifier());
				node1.setName(TagIdentifier.getNodeName());
				node1.setX(0.0);
				node1.setY(columnSpace);
				node1.setZ(levelHeight);
				
				Node node2 = new Node();
				node2.setId(TagIdentifier.getNodeIdentifier());
				node2.setName(TagIdentifier.getNodeName());
				node2.setX(clearBay);
				node2.setY(columnSpace);
				node2.setZ(levelHeight);
				
				Part beam = new Part();
				beam.setId(TagIdentifier.getPartIdentifier());
				beam.setName(TagIdentifier.getPartName());
				beam.setType(SciaXMLConstants.DEFAULT_BEAM_TYPE);
				beam.setInitialNode(node1);
				beam.setFinalNode(node2);
				
				DataSummary.finalNodes.add(node1);
				DataSummary.finalNodes.add(node2);
				
				DataSummary.finalParts.add(beam);
			}
		}
	}
}
