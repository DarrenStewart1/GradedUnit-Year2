package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * user interface based application for a games retailer to create invoice and
 * manage stock
 * 
 * @author Darren Stewart - 538981
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/LogInScene.fxml"));
			
			Scene scene = new Scene(root);
			
			scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			
			primaryStage.show();
			
			primaryStage.setResizable(false);
			
			primaryStage.setTitle("Log in");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
