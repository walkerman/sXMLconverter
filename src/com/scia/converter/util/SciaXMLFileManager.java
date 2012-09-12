package com.scia.converter.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.channels.FileChannel;

import com.scia.converter.bean.DataSummary;
import com.scia.converter.exception.SciaXMLConverterException;
import com.scia.converter.xml.rqnet.DataSet;
import com.scia.converter.xml.scia.Project;
import com.thoughtworks.xstream.XStream;

public class SciaXMLFileManager {

	public static void convertRQNetFile (File file) throws SciaXMLConverterException{
		try{
			XStream stream = new XStream();
			stream.processAnnotations(DataSet.class);
			DataSummary.rqNetXML = (DataSet) stream.fromXML(file);
			System.out.println(DataSummary.rqNetXML.toString());
		}catch (Exception e) {
			throw new SciaXMLConverterException();			
		}
	}
	
	public static void project2XML(Project p, File f) throws SciaXMLConverterException {
		try {
			if (p != null && f != null) {
				XStream xs = new XStream();
				xs.autodetectAnnotations(true);
				xs.setMode(XStream.NO_REFERENCES);

				String xml = SciaXMLConstants.ENCODING + xs.toXML(p);

				OutputStream stream = new FileOutputStream(f);
				Writer fw = new OutputStreamWriter(stream, "UTF-16");

				fw.write(xml);
				fw.flush();
				fw.close();
				
				generateDefFile(f);
			} else {
				throw new SciaXMLConverterException(
						"Impossível gerar o arquivo final. Verifique os parâmetros de entrada.");
			}
		} catch (IOException e) {
			throw new SciaXMLConverterException(e.getMessage());
		}
	}

	private static void generateDefFile(File f) throws SciaXMLConverterException{
		try{
			if (f != null){
				File origem = new File(SciaXMLFileManager.class.getResource(SciaXMLConstants.DEFAULT_DEF_FILE).getFile());
				File destino = new File(f.getAbsoluteFile()+SciaXMLConstants.DEF);
				copyFile(origem, destino);
			}else{
				throw new SciaXMLConverterException("Impossível gerar o arquivo final. Verifique os parâmetros de entrada.");
			}
		}catch (IOException e) {
			throw new SciaXMLConverterException(e.getMessage());
		}
	}

	private static void copyFile(File sourceFile, File destFile)
			throws IOException {
		if (!destFile.exists()) {
			destFile.createNewFile();
		}

		FileChannel source = null;
		FileChannel destination = null;
		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		} finally {
			if (source != null) {
				source.close();
			}
			if (destination != null) {
				destination.close();
			}
		}
	}
}
