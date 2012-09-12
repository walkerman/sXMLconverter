package com.scia.converter.bean;

import java.util.ArrayList;
import java.util.List;

public class DataSummary {
	
	public static List<Part> finalParts;
	public static List<Node> finalNodes;
	public static Integer partsIndex;
	public static Integer nodesIndex;
	
	static{
		if (finalParts == null)
			DataSummary.finalParts = new ArrayList<Part>();
		if (finalNodes == null)
			DataSummary.finalNodes = new ArrayList<Node>();
		if (partsIndex == null)
			DataSummary.partsIndex = 0;
		if (nodesIndex == null)
			DataSummary.nodesIndex = 0;
	}
}
