package br.com.scia.converter.test;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import br.com.scia.converter.bean.DataSet;

import com.thoughtworks.xstream.XStream;

public class Main {
	public static void main(String[] args) {
		XStream stream = new XStream();
		stream.processAnnotations(DataSet.class);
		
		URL xmlFile = Main.class.getResource("SimpleJob.xml");
		
		try {
			File imageFile = new File(xmlFile.toURI());
			
			DataSet m2 = (DataSet) stream.fromXML(imageFile);
			
			System.out.println(m2.toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}	
	}
}
