package application;

import java.sql.Connection;
import java.sql.DriverManager;

import javafx.scene.control.Alert;

/**
 * Class that creates a connection to a database
 * 
 * @author Darren Stewart
 *
 */
public class DataBaseSystem {

	Connection connection = null;

	/**
	 * creates the connection with the database using a jdbc connector to go to the
	 * file location that the database is stored in
	 * 
	 * @return the connection of the database
	 */
	public static Connection connectdb() {
		try {

			Connection connection = DriverManager
					.getConnection("jdbc:sqlite:C:\\gradedunit_538981\\dbfile\\games_retailer.db");

			return connection;
		} catch (Exception e) {
			showErrorMessage("no connection to data base found please open phpmyadmin", null,
					"No data base connection");
			return null;
		}
	}

	/**
	 * creates an error message that pops up when a condition is not met
	 * 
	 * @param info   holds the information that is going to be shown in the error
	 *               message
	 * @param header holds the header of the error message
	 * @param title  holds the title of the error message
	 */
	public static void showErrorMessage(String info, String header, String title) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setContentText(info);
		alert.setHeaderText(header);
		alert.showAndWait();
	}
}
