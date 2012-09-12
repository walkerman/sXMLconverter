package com.scia.converter.xml.rqnet;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("DataSetProjectExport")
public class DataSet {
	@XStreamImplicit(itemFieldName="tblProjectSPElev")
	private List<Elevation> elevations;
	
	@XStreamImplicit(itemFieldName="tblProjectSPElevBayLevel")
	private List<Level> levels;
	
	@XStreamImplicit(itemFieldName="tblProjectSPElevBayLoad")
	private List<Load> loads;
	
	@XStreamImplicit(itemFieldName="tblProjectSPElevFL")
	private List<FrameLine> framelines;
	
	@XStreamImplicit(itemFieldName="tblProjectSPElevFLBracing")
	private List<Bracing> bracings;
	
	@XStreamImplicit(itemFieldName="tblProjectSPElevFLColumn")
	private List<Column> columns;
	
	@XStreamImplicit(itemFieldName="tblProjectSPElevFLOption")
	private List<Option> options;
	
	@XStreamImplicit(itemFieldName="tblProjectSPElevFLPanel")
	private List<Panel> panels;

	public List<Elevation> getElevations() {
		return elevations;
	}

	public void setElevations(List<Elevation> elevations) {
		this.elevations = elevations;
	}

	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}

	public List<Load> getLoads() {
		return loads;
	}

	public void setLoads(List<Load> loads) {
		this.loads = loads;
	}

	public List<FrameLine> getFramelines() {
		return framelines;
	}

	public void setFramelines(List<FrameLine> framelines) {
		this.framelines = framelines;
	}

	public List<Bracing> getBracings() {
		return bracings;
	}

	public void setBracings(List<Bracing> bracings) {
		this.bracings = bracings;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public List<Panel> getPanels() {
		return panels;
	}

	public void setPanels(List<Panel> panels) {
		this.panels = panels;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataSet [\n tblProjectSPElev [size] = ");
		builder.append(elevations.size());
		builder.append(",\n tblProjectSPElevBayLevel [size] = ");
		builder.append(levels.size());
		builder.append(",\n tblProjectSPElevBayLoad [size] = ");
		builder.append(loads.size());
		builder.append(",\n tblProjectSPElevFL [size] = ");
		builder.append(framelines.size());
		builder.append(",\n tblProjectSPElevFLBracing [size] = ");
		builder.append(bracings.size());
		builder.append(",\n tblProjectSPElevFLColumn [size] = ");
		builder.append(columns.size());
		builder.append(",\n tblProjectSPElevFLOption [size] = ");
		builder.append(options.size());
		builder.append(",\n tblProjectSPElevFLPanel [size] = ");
		builder.append(panels.size());
		builder.append("\n]");
		
		return builder.toString();
	}	
}
