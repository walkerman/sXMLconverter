package com.scia.converter.util;

public class SciaXMLConstants {
	
	// Measure Units Conversion
	public static final Double INCH2METER = 0.0254;
	
	// Scia XML Containers
	// Nodes
	public static final String STRUCT_NODE = "StructNode";
	public static final String STRUCT_NODE_TITLE = "EP_DSG_Elements.EP_StructNode.1";
	public static final String STRUCT_NODE_ID = "{39A7F468-A0D4-4DFF-8E5C-5843E1807D13}";
	public static final String STRUCT_NODE_HEADER_H0 = "Name";
	public static final String STRUCT_NODE_HEADER_H1 = "Coord X";
	public static final String STRUCT_NODE_HEADER_H2 = "Coord Y";
	public static final String STRUCT_NODE_HEADER_H3 = "Coord Z";
	public static final String STRUCT_NODE_TABLE = "EP_DSG_Elements.EP_StructNode.1";
	public static final String STRUCT_NODE_TABLE_ID = "C4D79AFB-6512-4D56-BD04-E1BEA1C3B085";
	public static final String STRUCT_NODE_TABLE_NAME = "Node";
	
	// Beams
	public static final String BEAM = "Beam";
	public static final String BEAM_TITLE = "EP_DSG_Elements.EP_Beam.1";
	public static final String BEAM_ID = "{ECB5D684-7357-11D4-9F6C-00104BC3B443}";
	public static final String BEAM_HEADER_H0 = "Name";
	public static final String BEAM_HEADER_H1 = "Beg. node";
	public static final String BEAM_HEADER_H2 = "End node";
	public static final String BEAM_HEADER_H3 = "CrossSection";
	public static final String BEAM_HEADER_H4 = "FEM type";
	public static final String BEAM_HEADER_H5 = "Member system-line at";
	public static final String BEAM_HEADER_H6 = "ey";
	public static final String BEAM_HEADER_H7 = "ez";
	public static final String BEAM_HEADER_H8 = "LCS Rotation";
	public static final String BEAM_HEADER_H9 = "Layer";
	public static final String BEAM_HEADER_H10 = "Perp. alignment";
	public static final String BEAM_HEADER_H11 = "Eccentricity y";
	public static final String BEAM_HEADER_H12 = "Eccentricity z";
	public static final String BEAM_TABLE = "EP_DSG_Elements.EP_Beam.1";
	public static final String BEAM_TABLE_ID = "C803A5AE-8F20-4D47-BC52-1685A71CB594";
	public static final String BEAM_TABLE_NAME = "Member 1D";
	public static final String BEAM_OBJECT_FEM_TYPE_V = "0";
	public static final String BEAM_OBJECT_FEM_TYPE_T = "standard";
	public static final String BEAM_OBJECT_SYSTEM_LINE_V = "1";
	public static final String BEAM_OBJECT_SYSTEM_LINE_T = "centre";
	public static final String BEAM_OBJECT_EY_V = "0";
	public static final String BEAM_OBJECT_EZ_V = "0";
	
	// Scia XML Default Values
	public static final String ENCODING = "<?xml version=\"1.0\" encoding=\"UTF-16\" standalone=\"yes\"?>";
	public static final String XMLNS = "http://www.scia.cz";
	public static final String DEF = ".def";
	public static final String XML = ".xml";
	public static final String DEFAULT_DEF_FILE = "default.xml.def";
	public static final String DEFAULT_COLUMN_TYPE = "";
	
	
	// Validation Messages
	public static final String SCIAXML_VALIDATION = "SciaXMLConverter Validation";
	public static final String UNDER_CONTRUCTION = "Under Construction";
	public static final String CONFIRMATION_MESSAGE = "Are you sure you want to leave SciaXMLConverter?";
	public static final String NOT_A_VALID_FILE = "This is not a valid file. Please choose a different one.";
	public static final String NO_INPUT_FILE_CHOOSED = "Please choose the input file.";
	public static final String NO_OUTPUT_FILE_CHOOSED = "Please set the output file.";
	public static final String CONVERTION_ISSUES = "Problems to convert files. Please check the scia.log file.";
}
