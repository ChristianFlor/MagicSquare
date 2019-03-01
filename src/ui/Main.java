/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Icesi University (Cali - Colombia)
 * TIC Department- Algorithms and programming II
 * Five Lab
 * @Author: Christian Flor christian.flor1@correo.icesi.edu.co> 
 * @Date: 26 January 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	@Override
	public void start(Stage stage) throws Exception{
		Parent root = 
			FXMLLoader.load(getClass().getResource("MagicSquare.fxml"));
	
	Scene scene = new Scene (root);
	stage.setTitle("MagicSquare");
	stage.setScene(scene);
	stage.show();
	}
	
	public static void main(String []args) {
		launch(args);
	}
}
