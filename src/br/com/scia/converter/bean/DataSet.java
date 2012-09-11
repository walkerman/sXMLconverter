package br.com.scia.converter.bean;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("DataSetProjectExport")
public class DataSet {
	@XStreamImplicit(itemFieldName="tblProjectSPElev")
	private List<Elevation> tblProjectSPElev;
	
	@XStreamImplicit(itemFieldName="tblProjectSPElevBayLevel")
	private List<Level> tblProjectSPElevBayLevel;
	
	@XStreamImplicit(itemFieldName="tblProjectSPElevBayLoad")
	private List<Load> tblProjectSPElevBayLoad;
	
	@XStreamImplicit(itemFieldName="tblProjectSPElevFL")
	private List<FrameLine> tblProjectSPElevFL;
	
	@XStreamImplicit(itemFieldName="tblProjectSPElevFLBracing")
	private List<Bracing> tblProjectSPElevFLBracing;
	
	@XStreamImplicit(itemFieldName="tblProjectSPElevFLColumn")
	private List<Column> tblProjectSPElevFLColumn;
	
	@XStreamImplicit(itemFieldName="tblProjectSPElevFLOption")
	private List<Option> tblProjectSPElevFLOption;
	
	@XStreamImplicit(itemFieldName="tblProjectSPElevFLPanel")
	private List<Panel> tblProjectSPElevFLPanel;

	public List<Elevation> getTblProjectSPElev() {
		return tblProjectSPElev;
	}

	public void setTblProjectSPElev(List<Elevation> tblProjectSPElev) {
		this.tblProjectSPElev = tblProjectSPElev;
	}

	public List<Level> getTblProjectSPElevBayLevel() {
		return tblProjectSPElevBayLevel;
	}

	public void setTblProjectSPElevBayLevel(List<Level> tblProjectSPElevBayLevel) {
		this.tblProjectSPElevBayLevel = tblProjectSPElevBayLevel;
	}

	public List<Load> getTblProjectSPElevBayLoad() {
		return tblProjectSPElevBayLoad;
	}

	public void setTblProjectSPElevBayLoad(List<Load> tblProjectSPElevBayLoad) {
		this.tblProjectSPElevBayLoad = tblProjectSPElevBayLoad;
	}

	public List<FrameLine> getTblProjectSPElevFL() {
		return tblProjectSPElevFL;
	}

	public void setTblProjectSPElevFL(List<FrameLine> tblProjectSPElevFL) {
		this.tblProjectSPElevFL = tblProjectSPElevFL;
	}

	public List<Bracing> getTblProjectSPElevFLBracing() {
		return tblProjectSPElevFLBracing;
	}

	public void setTblProjectSPElevFLBracing(List<Bracing> tblProjectSPElevFLBracing) {
		this.tblProjectSPElevFLBracing = tblProjectSPElevFLBracing;
	}

	public List<Column> getTblProjectSPElevFLColumn() {
		return tblProjectSPElevFLColumn;
	}

	public void setTblProjectSPElevFLColumn(List<Column> tblProjectSPElevFLColumn) {
		this.tblProjectSPElevFLColumn = tblProjectSPElevFLColumn;
	}

	public List<Option> getTblProjectSPElevFLOption() {
		return tblProjectSPElevFLOption;
	}

	public void setTblProjectSPElevFLOption(List<Option> tblProjectSPElevFLOption) {
		this.tblProjectSPElevFLOption = tblProjectSPElevFLOption;
	}

	public List<Panel> getTblProjectSPElevFLPanel() {
		return tblProjectSPElevFLPanel;
	}

	public void setTblProjectSPElevFLPanel(List<Panel> tblProjectSPElevFLPanel) {
		this.tblProjectSPElevFLPanel = tblProjectSPElevFLPanel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataSet [\n tblProjectSPElev [size] = ");
		builder.append(tblProjectSPElev.size());
		builder.append(",\n tblProjectSPElevBayLevel [size] = ");
		builder.append(tblProjectSPElevBayLevel.size());
		builder.append(",\n tblProjectSPElevBayLoad [size] = ");
		builder.append(tblProjectSPElevBayLoad.size());
		builder.append(",\n tblProjectSPElevFL [size] = ");
		builder.append(tblProjectSPElevFL.size());
		builder.append(",\n tblProjectSPElevFLBracing [size] = ");
		builder.append(tblProjectSPElevFLBracing.size());
		builder.append(",\n tblProjectSPElevFLColumn [size] = ");
		builder.append(tblProjectSPElevFLColumn.size());
		builder.append(",\n tblProjectSPElevFLOption [size] = ");
		builder.append(tblProjectSPElevFLOption.size());
		builder.append(",\n tblProjectSPElevFLPanel [size] = ");
		builder.append(tblProjectSPElevFLPanel.size());
		builder.append("\n]");
		
		return builder.toString();
	}	
	
	
	
}
