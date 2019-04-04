package it.polito.tdp.anagrammi.controller;
	
import it.polito.tdp.anagrammi.model.Model;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application 
{
	private AnagrammiController controller;
	@Override
	public void start(Stage primaryStage) 
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Anagrammi.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
			
			controller = loader.getController();

			/*
			 * Create and set the model here!
			 */
			Model model = new Model();
			controller.setModel(model);
		
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
