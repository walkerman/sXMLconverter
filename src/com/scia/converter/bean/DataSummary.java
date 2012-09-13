package com.scia.converter.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.scia.converter.xml.rqnet.DataSet;

public class DataSummary {
	
	public static DataSet rqNetXML;
	public static File sciaXML;
	public static List<Part> finalParts;
	public static List<Node> finalNodes;
	
	static{
		if (finalParts == null)
			DataSummary.finalParts = new ArrayList<Part>();
		if (finalNodes == null)
			DataSummary.finalNodes = new ArrayList<Node>();
	}
}
