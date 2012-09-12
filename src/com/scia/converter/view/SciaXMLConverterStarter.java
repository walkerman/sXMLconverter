package com.scia.converter.view;

import javafx.application.Application;
import javafx.stage.Stage;

import com.scia.converter.controller.SciaXMLConverterController;

public class SciaXMLConverterStarter extends Application{
	
    public static void main (String[] args){
    	Application.launch(SciaXMLConverterStarter.class, (java.lang.String[])null);
    }

	@Override
    public void start(Stage primaryStage) {
    	try {
    		loadSplash();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
    }
	
	public void loadSplash(){
		SciaXMLConverterController.stage = new Stage();
		SciaXMLConverterController.loadPage();
		SciaXMLConverterController.stage.show();
	}
	
}
