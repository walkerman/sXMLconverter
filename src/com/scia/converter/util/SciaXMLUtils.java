package com.scia.converter.util;

import java.io.File;

import com.scia.converter.exception.SciaXMLConverterException;
import com.scia.converter.xml.scia.Project;

public class SciaXMLUtils {

	public static Double parseValue (String value){
		Double doubleValue = 0.0;
		if (value != null && !"".equals(value)){
			doubleValue = Double.parseDouble(value);
		}
		return doubleValue;
	}
	
	public static Double inches2Meters(Double inchValue){
		Double meterValue = 0.0;
		if (inchValue != null && inchValue != 0.0){
			meterValue = (inchValue* SciaXMLConstants.INCH2METER);
		}
		return meterValue;
	}
	
	public static void generateProject(File f) {
		Project p = new Project(f.getName()+SciaXMLConstants.XML);
		
		try {
			SciaXMLFileManager.project2XML(p, new File(f.getAbsolutePath()+SciaXMLConstants.XML));
		} catch (SciaXMLConverterException e) {
			e.printStackTrace();
		}
	}
}
