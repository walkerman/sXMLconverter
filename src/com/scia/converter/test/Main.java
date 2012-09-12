package com.scia.converter.test;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import com.scia.converter.bean.DataSummary;
import com.scia.converter.exception.SciaXMLConverterException;
import com.scia.converter.model.SciaXMLConverter;
import com.scia.converter.xml.rqnet.DataSet;
import com.scia.converter.xml.scia.Project;
import com.thoughtworks.xstream.XStream;

public class Main {
	public static void main(String[] args) {
		XStream stream = new XStream();
		stream.processAnnotations(DataSet.class);
		
		URL xmlFile = Main.class.getResource("SimpleJob.xml");
		
		try {
			File imageFile = new File(xmlFile.toURI());
			
			DataSummary.rqNetXML = (DataSet) stream.fromXML(imageFile);
			System.out.println(DataSummary.rqNetXML.toString());
			
			SciaXMLConverter converter = new SciaXMLConverter();
			
			try {
				converter.convertFiles();
			} catch (SciaXMLConverterException e) {
				e.printStackTrace();
			}
			
			new Project("C:\\a.xml");
			
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}	
	}
}
