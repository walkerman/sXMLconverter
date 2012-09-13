package com.scia.converter.controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

import com.scia.converter.bean.DataSummary;
import com.scia.converter.bean.Node;
import com.scia.converter.bean.Part;
import com.scia.converter.exception.SciaXMLConverterException;
import com.scia.converter.model.SciaXMLConverter;
import com.scia.converter.util.SciaXMLConstants;
import com.scia.converter.util.SciaXMLFileManager;
import com.scia.converter.view.SciaXMLConverterStarter;

public class SciaXMLConverterController implements Initializable{
	
	public static final String fxml = "SciaXMLConverter.fxml";
	public static Stage stage;
	
	@FXML
	TextField fileIn;
	@FXML
	TextField fileOut;
	@FXML
	ProgressBar progress;
	
	@FXML
	public void chooseFileIn(){		
		FileChooser fc = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("RQNet Files", "*.xml");
		fc.getExtensionFilters().add(extFilter);
        
		File f = fc.showOpenDialog(null);
		
		if (f != null){
			try {
				SciaXMLFileManager.convertRQNetFile(f);
				this.fileIn.setText(f.getAbsolutePath());
				this.progress.setProgress(1.0);
			} catch (SciaXMLConverterException e) {
				JOptionPane.showMessageDialog(null, SciaXMLConstants.NOT_A_VALID_FILE,SciaXMLConstants.SCIAXML_VALIDATION,JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	@FXML
	public void chooseFileOut(){		
		FileChooser fc = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Scia Engineer File", "*.xml");
		fc.getExtensionFilters().add(extFilter);
        
		File f = fc.showSaveDialog(null);
				
		if (f != null){
			this.fileOut.setText(f.getAbsolutePath());
		}
	}
	
	@FXML
	public void onCancel(){		
		JOptionPane.setDefaultLocale(Locale.US);
		if (JOptionPane.showConfirmDialog(null, SciaXMLConstants.CONFIRMATION_MESSAGE) == 0)
			SciaXMLConverterController.stage.close();
	}
	
	@FXML
	public void onConvert(){
		DataSummary.finalNodes = new ArrayList<Node>();
		DataSummary.finalParts = new ArrayList<Part>();
		
		File fileOut = new File(this.fileOut.getText());
		DataSummary.sciaXML = fileOut;
		
		if ("".equals(this.fileIn.getText().toString())){
			JOptionPane.showMessageDialog(null, SciaXMLConstants.NO_INPUT_FILE_CHOOSED,SciaXMLConstants.SCIAXML_VALIDATION,JOptionPane.ERROR_MESSAGE);
		} else if ("".equals(this.fileOut.getText().toString())){
			JOptionPane.showMessageDialog(null, SciaXMLConstants.NO_OUTPUT_FILE_CHOOSED,SciaXMLConstants.SCIAXML_VALIDATION,JOptionPane.ERROR_MESSAGE);
		}else{
			SciaXMLConverter converter = new SciaXMLConverter();
			
			if (DataSummary.rqNetXML != null){
				try {
					converter.convertFiles();
					
					JOptionPane.showMessageDialog(null,  SciaXMLConstants.CONVERTION_OK,SciaXMLConstants.SCIAXML_VALIDATION,JOptionPane.INFORMATION_MESSAGE);
				} catch (SciaXMLConverterException e) {
					JOptionPane.showMessageDialog(null, SciaXMLConstants.NOT_A_VALID_FILE,SciaXMLConstants.SCIAXML_VALIDATION,JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	@FXML
	public void onExit(){
		JOptionPane.setDefaultLocale(Locale.US);
		if (JOptionPane.showConfirmDialog(null, SciaXMLConstants.CONFIRMATION_MESSAGE) == 0)
			SciaXMLConverterController.stage.close();
	}
	
	@FXML
	public void onAbout(){
		JOptionPane.setDefaultLocale(Locale.US);
		JOptionPane.showMessageDialog(null, SciaXMLConstants.UNDER_CONTRUCTION);
	}
	
	public static void loadPage(){
		try{
			AnchorPane page = (AnchorPane) FXMLLoader.load(SciaXMLConverterStarter.class.getResource(fxml));
	        
	        Scene scene = new Scene(page);
	        SciaXMLConverterController.stage.setScene(scene);
	        SciaXMLConverterController.stage.setTitle("SciaXMLConverter");
	        SciaXMLConverterController.stage.setResizable(false);
	        SciaXMLConverterController.stage.show();
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

	@Override
	protected void finalize() throws Throwable {
		JOptionPane.setDefaultLocale(Locale.US);
		if (JOptionPane.showConfirmDialog(null, SciaXMLConstants.CONFIRMATION_MESSAGE) == 0){
			SciaXMLConverterController.stage.close();
			super.finalize();
		}
	}
    
    
}
