package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Controller for the log in page allows the user to log into the system to gain
 * access to more features of the application
 * 
 * @author Darren Stewart
 *
 */

public class LogInPageController {

	@FXML
	private TextField txtUserName;

	@FXML
	private PasswordField txtPassword;
	@FXML
	private Label errorLbl;

	@FXML
	Pane welcomePagePane;

	Connection connection;
	PreparedStatement ps;
	ResultSet rs;

	/**
	 * method that opens a connection in the database
	 */
	public void dataBaseConnect() {
		connection = DataBaseSystem.connectdb();
	}

	/**
	 * @param event method that will allow a user to log into the system this
	 *              functions by allowing the user to entered their login details
	 *              and the system will check the database for information that
	 *              matches what the user entered if the user gave valid information
	 *              a new scene is opened that contains the main application if the
	 *              user gives invalid information an error message is displayed
	 */
	@FXML
	public void logIn(MouseEvent event) {

		try {

			dataBaseConnect();

			String userName = txtUserName.getText().toString();
			String password = txtPassword.getText().toString();

			String sqlQuery = "SELECT `Employee_ID`, `Password` FROM `employees` WHERE `Employee_ID` = ? AND `Password` = ?";

			ps = connection.prepareStatement(sqlQuery);
			ps.setString(1, userName);
			ps.setString(2, password);

			rs = ps.executeQuery();

			if (rs.next()) {

				Node node = (Node) event.getSource();
				Stage stage = (Stage) node.getScene().getWindow();

				stage.close();

				Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/MainApplicationScene.fxml")));
				stage.setScene(scene);
				stage.show();
				stage.setTitle("Welcome Page");

				errorLbl.setVisible(true);

			} else {
				errorLbl.setVisible(true);

			}

		} catch (Exception e)

		{

			DataBaseSystem.showErrorMessage("Error when logging in please try again", null, "Error");

			e.printStackTrace();
		} finally {
			
			try {
				connection.close();
				System.out.println("db closed");
			} catch (SQLException e) {

				DataBaseSystem.showErrorMessage("Table could not be found", null, "Error");

				e.printStackTrace();
			}
		}

	}

	/**
	 * method that clears the information in the user name and password fields on
	 * the login page
	 */
	@FXML
	public void clearLogIn() {

		txtPassword.clear();
		txtUserName.clear();
		errorLbl.setVisible(false);
	}

}
