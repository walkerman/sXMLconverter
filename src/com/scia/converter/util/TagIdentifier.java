package com.scia.converter.util;

public class TagIdentifier {

	private static Integer nodeIdentifier = 1000;
	private static Integer partIdentifier = 0;
	
	public static String getNodeIdentifier() {
		return String.valueOf(nodeIdentifier);
	}
	public static String getNodeName() {
		return SciaXMLConstants.INDEX_NODE + nodeIdentifier++;
	}
	public static String getPartIdentifier() {
		return String.valueOf(partIdentifier);
	}
	public static String getPartName() {
		return SciaXMLConstants.INDEX_BEAM + partIdentifier++;
	}
}
