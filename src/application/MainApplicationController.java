package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Main controller for the application used to create methods that are assigned
 * to buttons in the user information
 * 
 * @author Darren Stewart
 *
 */

public class MainApplicationController implements Initializable {

	@FXML
	private TextField productIDTxt, quantityTxt, customerIDTxt, productTxt, quantityBoughtTxt;

	@FXML
	private Pane logInPane, welcomePagePane, produceInvoicePane, updateStockPane, salesReportPane, stockReportPane,
			displayInformationPane;

	@FXML
	private Button displayCustomerButton, displayProductButton, displaySupplierButton, displayInvoiceButton;

	@FXML
	private Label displayInfoLbl;

	@FXML
	private Button produceInvoiceButton;

	@FXML
	private ComboBox<String> displayInfoBox;

	@FXML
	private TableColumn<Customer, String> customerIdCol, firstNameCol, lastNameCol, addressCol, emailAddressCol,
			phoneNumberCol;

	@FXML
	private TableColumn<Product, String> productIDCol, productNameColl, stockCol, costCol, releaseDateCol,
			productImageCol, platformCol, descriptionCol;

	@FXML

	private TableColumn<Invoice, String> invoiceIDCol, customerFirstNameCol, customerLastNameCol, customerAddressCol,
			customerEmailCol, nameOfProductCol, quantitySoldCol, totalBeforeVatCol, totalAfterVatCol, vatTotalCol;

	@FXML
	private TableView<Customer> customerTableView;

	@FXML
	private TableView<Product> productTableView;

	@FXML
	private TableView<Product> productUpdateTableView;

	@FXML
	private TableColumn<Product, String> productID, productNameCol, quantityCol;

	@FXML
	private TableColumn<Supplier, String> supplierIdCol, supplierNameCol, supplierAddressCol;

	@FXML
	private TableView<Supplier> supplierTableView;

	@FXML
	private TableView<Invoice> invoiceTableView;

	ObservableList<String> displayInformationList = FXCollections.observableArrayList("Customer", "Product", "Supplier",
			"Invoice");

	ObservableList<Customer> customerList = FXCollections.observableArrayList();

	ObservableList<Supplier> supplierList = FXCollections.observableArrayList();

	ObservableList<Product> productList = FXCollections.observableArrayList();

	ObservableList<Product> productUpdateList = FXCollections.observableArrayList();

	ObservableList<Invoice> invoiceList = FXCollections.observableArrayList();

	Connection connection;
	PreparedStatement ps;
	ResultSet rs;

	/* method that will be used to populate the table column with the values form the database
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		customerIdCol.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
		emailAddressCol.setCellValueFactory(new PropertyValueFactory<>("EmailAddress"));
		phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));

		supplierIdCol.setCellValueFactory(new PropertyValueFactory<>("supplierID"));
		supplierNameCol.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
		supplierAddressCol.setCellValueFactory(new PropertyValueFactory<>("supplierAddress"));

		productID.setCellValueFactory(new PropertyValueFactory<>("productID"));
		productNameCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
		quantityCol.setCellValueFactory(new PropertyValueFactory<>("productQuantity"));

		productIDCol.setCellValueFactory(new PropertyValueFactory<>("productID"));
		productNameColl.setCellValueFactory(new PropertyValueFactory<>("productName"));
		stockCol.setCellValueFactory(new PropertyValueFactory<>("productQuantity"));
		costCol.setCellValueFactory(new PropertyValueFactory<>("costOfUnit"));
		releaseDateCol.setCellValueFactory(new PropertyValueFactory<>("productReleaseDate"));
		productImageCol.setCellValueFactory(new PropertyValueFactory<>("productImg"));
		platformCol.setCellValueFactory(new PropertyValueFactory<>("productPlatForm"));
		descriptionCol.setCellValueFactory(new PropertyValueFactory<>("productDescription"));

		invoiceIDCol.setCellValueFactory(new PropertyValueFactory<>("invoiceID"));
		customerFirstNameCol.setCellValueFactory(new PropertyValueFactory<>("customerFirstName"));
		customerLastNameCol.setCellValueFactory(new PropertyValueFactory<>("customerLastName"));
		customerAddressCol.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
		customerEmailCol.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));
		nameOfProductCol.setCellValueFactory(new PropertyValueFactory<>("nameOfProduct"));
		totalBeforeVatCol.setCellValueFactory(new PropertyValueFactory<>("totalBeforeVat"));
		totalAfterVatCol.setCellValueFactory(new PropertyValueFactory<>("totalAfterVat"));
		vatTotalCol.setCellValueFactory(new PropertyValueFactory<>("totalVat"));
		quantitySoldCol.setCellValueFactory(new PropertyValueFactory<>("quantitySold"));

		displayInfoBox.setItems(displayInformationList);

		productUpdateTableView.setItems(productUpdateList);
		customerTableView.setItems(customerList);
		productTableView.setItems(productList);
		supplierTableView.setItems(supplierList);

		invoiceTableView.setItems(invoiceList);

	}

	/**
	 * method that is used to change the table that is being viewed depending on the
	 * value that is in the drop down menu box in the display infomration page
	 */
	@FXML
	public void displayInfoChoice() {

		if (displayInfoBox.getValue().equals("Customer")) {

			hideInfoDisplays();
			displayCustomerButton.setVisible(true);
			customerTableView.setVisible(true);
		} else if (displayInfoBox.getValue().equals("Product")) {

			hideInfoDisplays();
			displayProductButton.setVisible(true);
			productTableView.setVisible(true);
		} else if (displayInfoBox.getValue().equals("Supplier")) {

			hideInfoDisplays();
			displaySupplierButton.setVisible(true);
			supplierTableView.setVisible(true);

		} else if (displayInfoBox.getValue().equals("Invoice")) {
			System.out.println("Invoice");
			hideInfoDisplays();
			displayInvoiceButton.setVisible(true);
			invoiceTableView.setVisible(true);
		}

	}

	/**
	 * Clears the information that is currently displayed in the text fields of the
	 * create invoice table
	 */
	@FXML
	public void clearTextField() {
		customerIDTxt.clear();
		productTxt.clear();
		quantityBoughtTxt.clear();

	}

	/**
	 * clears the information that is being displayed in the tables that display the
	 * information
	 */
	@FXML
	public void clearTable() {

		productIDTxt.clear();
		quantityTxt.clear();

		customerTableView.getItems().clear();
		productUpdateTableView.getItems().clear();
		supplierTableView.getItems().clear();
		productTableView.getItems().clear();
		invoiceTableView.getItems().clear();
	}

	/**
	 * closes all the other panes in the system then opens the produce invoice pane
	 */
	@FXML
	public void openProduceInvoice() {
		closeAllPanes();
		produceInvoicePane.setVisible(true);

	}

	/**
	 * closes all the other panes in the system then opens the welcome page pane
	 */
	@FXML
	public void openWelcomePage() {

		closeAllPanes();
		welcomePagePane.setVisible(true);
	}

	/**
	 * closes all the other panes in the system then opens the produce invoice pane
	 */
	@FXML
	public void openUpdateStockPage() {

		closeAllPanes();
		updateStockPane.setVisible(true);
	}

	/**
	 * closes all the other panes in the system then opens the sales report pane
	 */
	@FXML
	public void openSalesReportPage() {

		closeAllPanes();
		salesReportPane.setVisible(true);
	}

	/**
	 * closes all the other panes in the system then opens the stock report pane
	 */
	@FXML
	public void openStockReportPage() {

		closeAllPanes();
		stockReportPane.setVisible(true);
	}

	/**
	 * closes all the other panes in the system then opens the display information
	 * pane
	 */
	@FXML
	public void openDisplayInformationPage() {

		closeAllPanes();

		displayInformationPane.setVisible(true);
	}

	/**
	 * sets the value of the buttons and tables that are in the display information
	 * pane to be hidden
	 */
	public void hideInfoDisplays() {
		
		displayCustomerButton.setVisible(false);
		displayProductButton.setVisible(false);
		displaySupplierButton.setVisible(false);
		displayInvoiceButton.setVisible(false);
		customerTableView.setVisible(false);
		productTableView.setVisible(false);
		supplierTableView.setVisible(false);
		invoiceTableView.setVisible(false);
	}

	/**
	 * method that closes all the pages that the system uses to insure that pages
	 * are not open at the same time when a new page is opened
	 */
	public void closeAllPanes() {
		
		produceInvoicePane.setVisible(false);
		welcomePagePane.setVisible(false);
		updateStockPane.setVisible(false);
		salesReportPane.setVisible(false);
		stockReportPane.setVisible(false);
		displayInformationPane.setVisible(false);

	}

	/**
	 * Exits the application
	 */
	@FXML
	public void exitApplication() {
		System.exit(0);
	}

	/**
	 * @param event the event which is required to happen for the method to be
	 *              carried out
	 * 
	 *              logs the user out by returning the user to the login screen of
	 *              the application
	 * 
	 */
	@FXML
	public void logOff(MouseEvent event) {
		try {
			Node node = (Node) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();

			stage.close();

			Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/LogInScene.fxml")));
						
			stage.setScene(scene);
			
			stage.show();
			
			stage.setTitle("Welcome Page");
		}
		catch (IOException e) {
			DataBaseSystem.showErrorMessage("Something went wrong please try again", null, "Error");
		}

	}

	/**
	 * method that will create the invoice for the user then store the information
	 * in a database the system will calculate the vat that is required to be added
	 * onto the purchase
	 */
	@FXML
	public void createInvoice() {

		try {
			dataBaseConnect();
			int customerID = Integer.parseInt(customerIDTxt.getText().toString());
			int productID = Integer.parseInt(productTxt.getText().toString());
			int quantityBought = Integer.parseInt(quantityBoughtTxt.getText().toString());

			// query that will get the information that is required from the two tables and
			// join the information to create the invoice for the user id that was entered
			// and the product that the user wants to purchase

			String sqlQuery = ("Select first_name , last_name , Address , Email_address ,  product_name , Cost_of_unit , Quantity_in_Stock from customers  join products WHERE customer_id = ? AND product_id = ? AND Quantity_in_Stock > 0");

			ps = connection.prepareStatement(sqlQuery);

			ps.setInt(1, customerID);
			ps.setInt(2, productID);

			rs = ps.executeQuery();

			// insures that the quantity that is in stock is more than the amount that the
			// user wants to purchase
			if (rs.getInt(7) < quantityBought) {

			} else if (quantityBought <= 0) {
				DataBaseSystem.showErrorMessage("Could not create invoice quantity cannot be below 0", null, "Error");
			}

			else

			if (rs.next()) {

				// query that will update the stock to remove the amount of the item that the
				// user purchased from the product that was purchased only if the product id is
				// above 0
				String sqlQuery2 = ("UPDATE products SET Quantity_in_Stock = Quantity_in_Stock - ? WHERE product_id = ? AND quantity_in_Stock > 0");

				ps = connection.prepareStatement(sqlQuery2);

				ps.setInt(1, quantityBought);
				ps.setInt(2, productID);

				ps.executeUpdate();

				float totalBeforeVat = rs.getFloat(6) * quantityBought;

				float totalVat = totalBeforeVat * 20 / 100;

				float totalAfterVat = totalBeforeVat + totalVat;

				// query that will create a new invoice with the values that are retrieve from
				// the first query when add them to the invoice table in the database

				String sqlQuery3 = "INSERT INTO Invoices (Customer_first_name , Customer_last_name , Customer_address , Customer_email , Name_of_product , Quantity_sold , total_before_vat , total_after_vat , Vat_total) VALUES ("
						+ "'" + rs.getString(1) + "'" + ",'" + rs.getString(2) + "'" + ",'" + rs.getString(3) + "'"
						+ ",'" + rs.getString(4) + "'" + ",'" + rs.getString(5) + "'" + ",'" + quantityBought + "'"
						+ ",'" + totalBeforeVat + "'" + ",'" + totalAfterVat + "'" + ",'" + totalVat + "')";

				ps = connection.prepareStatement(sqlQuery3);

				ps.executeUpdate();

				System.out.println(rs.getString(1) + " " + rs.getString(2) + rs.getString(3) + rs.getString(4)
						+ rs.getString(5) + rs.getInt(6) + quantityBought);
			} else
				DataBaseSystem.showErrorMessage("Something went wrong please try again", null, "Error");

		} catch (SQLException e) {

			DataBaseSystem.showErrorMessage("System Error System could not access database at this time", null, "Error");
			e.printStackTrace();

		} catch (NumberFormatException e) {
			DataBaseSystem.showErrorMessage("Invalid data entered please enter a valid number", null, "Error");
		}

		finally {

			try {
				System.out.println("dbclosed");
				connection.close();
			} catch (SQLException e) {

				DataBaseSystem.showErrorMessage("System Error System could not access database at this time", null, "Error");
				e.printStackTrace();
			}
		}

	}

	/**
	 * method that will allow the user to enter the product id of an item then view
	 * the stock level of that item
	 */
	@FXML
	public void displayStockLevel() {

		try {

			dataBaseConnect();

			int productID = Integer.parseInt(productIDTxt.getText().toString());

			// finds the product id and name product for the product id that the user
			// entered
			String sqlQuery = "SELECT Product_id , Product_name , Quantity_in_Stock FROM products WHERE product_id = ?";

			ps = connection.prepareStatement(sqlQuery);

			ps.setInt(1, productID);

			rs = ps.executeQuery();

			productUpdateList.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3)));

			System.out.println(rs.getString(1) + "  " + rs.getInt(2));

			if (rs.getInt(3) > 20) {

				quantityCol.setStyle("-fx-background-color:lightgreen");

			} else if (rs.getInt(3) < 20) {

				quantityCol.setStyle("-fx-background-color:yellow");

			} else if (rs.getInt(3) == 0) {

				quantityCol.setStyle("-fx-background-color:red");

			}

			connection.close();

		} catch (SQLException e) {

			DataBaseSystem.showErrorMessage("Table could not be found", null, "Error");
			e.printStackTrace();

		} catch (NumberFormatException f) {
			DataBaseSystem.showErrorMessage("Invalid data entered please enter valid data", null, "Error");
		} finally {

			try {
				System.out.println("dbclosed");

				connection.close();
			} catch (SQLException e) {

				DataBaseSystem.showErrorMessage("Error with database", null, "Error");
				e.printStackTrace();
			}
		}

	}

	/**
	 * method that will take a value that was entered by the user to update date the
	 * stock level of an item which the user wants to update the method will display
	 * the old value of the item first then allow the user to update the stock level
	 * then display the information in a table format
	 *
	 */
	@FXML
	public void updateStockLevel() {
		try {
			dataBaseConnect();

			int productID = Integer.parseInt(productIDTxt.getText().toString());

			int quantity = Integer.parseInt(quantityTxt.getText().toString());

			if (quantity >= 0 && quantity <= 100) {

				String sqlQuery = "UPDATE products SET Quantity_in_Stock = ? WHERE product_id = ?";

				ps = connection.prepareStatement(sqlQuery);

				ps.setInt(1, quantity);

				ps.setInt(2, productID);

				ps.executeUpdate();

				String sqlQuerySelect = "SELECT Product_id , Product_name , Quantity_in_Stock FROM products WHERE product_id = ?";

				ps = connection.prepareStatement(sqlQuerySelect);

				ps.setInt(1, productID);
				rs = ps.executeQuery();

				productUpdateList.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3)));

				ps.close();

			} else
				DataBaseSystem.showErrorMessage("number entered is out of range please enter a value between 0 and 100",
						null, "Error");

		} catch (SQLException e) {
			DataBaseSystem.showErrorMessage("Error with the database please try again", null, "Error");
			e.printStackTrace();
		} catch (NumberFormatException e) {

			DataBaseSystem.showErrorMessage("Value entered is not a number", null, "Error");
		}

		finally {
			
			try {
				System.out.println("dbclosed");

				
				connection.close();
			} catch (SQLException e) {

				DataBaseSystem.showErrorMessage("Table could not be found", null, "Error");
				
				e.printStackTrace();
			}
		}
	}

	/**
	 * method that retrieves information about the products sold and saves the
	 * information in an array list and displays the information from the array list
	 * into a table
	 */
	@FXML
	public void displayProductInfo() {

		try {
			
			productTableView.getItems().clear();
			
			dataBaseConnect();

			String sqlQuery = "SELECT * FROM products";

			ps = connection.prepareStatement(sqlQuery);

			rs = ps.executeQuery();

			while (rs.next()) {

				productList.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4),
						rs.getString(5), rs.getString(7), rs.getString(8)));

			}

			connection.close();

		} catch (SQLException e) {
			DataBaseSystem.showErrorMessage("Table could not be found", null, "Error");
			e.printStackTrace();
		} 
		finally {

			
			try {
				System.out.println("dbclosed");

				connection.close();
			} 
			catch (SQLException e) {
				DataBaseSystem.showErrorMessage("Table could not be found", null, "Error");

				e.printStackTrace();
			}
		}

	}

	/**
	 * method that retrieves information about the customers stored and saves the
	 * information in an array list and displays the information from the array list
	 * into a table
	 */
	@FXML
	public void displayCustomerInfo() {
		try {
			
			customerTableView.getItems().clear();
			
			dataBaseConnect();

			String sqlQuery = "SELECT * FROM customers";

			ps = connection.prepareStatement(sqlQuery);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				customerList.add(new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6)));

			}

			connection.close();
		}

		catch (Exception e) {
			DataBaseSystem.showErrorMessage("Information could not be displayed at this time", null, "Error");
			e.printStackTrace();
		} 
		finally {
			
			try {
				System.out.println("dbclosed");
				connection.close();

			} catch (SQLException e) {

				DataBaseSystem.showErrorMessage("Table could not be found", null, "Error");

				e.printStackTrace();
			}
		}

	}

	/**
	 * method that retrieves information about the suppliers that the company uses
	 * and saves the information in an array list and displays the information from
	 * the array list into a table
	 */
	@FXML
	public void displaySupplierInfo() {

		try {
			supplierTableView.getItems().clear();
			
			dataBaseConnect();

			String sqlQuery = "SELECT * FROM Suppliers";

			ps = connection.prepareStatement(sqlQuery);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				supplierList.add(new Supplier(rs.getInt(1), rs.getString(2), rs.getString(3)));

			}

		}

		catch (Exception e) {
			DataBaseSystem.showErrorMessage("Information could not be displayed at this time", null, "Error");
		} finally {

			try {

				System.out.println("dbclosed");
				connection.close();
			} catch (SQLException e) {

				DataBaseSystem.showErrorMessage("Table could not be found", null, "Error");

				e.printStackTrace();
			}
		}

	}

	/**
	 * method that retrieves information about the invoices that are stored in the
	 * system and saves them to an array list and displays them to the screen
	 */
	@FXML
	public void displayInvoiceInfo() {

		try {
			invoiceTableView.getItems().clear();
			dataBaseConnect();

			String sqlQuery = "SELECT * FROM Invoices";

			ps = connection.prepareStatement(sqlQuery);

			rs = ps.executeQuery();
			while (rs.next()) {

				invoiceList.add(
						new Invoice(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
								rs.getString(6), rs.getInt(7), rs.getFloat(8), rs.getFloat(9), rs.getFloat(10)));

			}

		}

		catch (Exception e) {
			
			DataBaseSystem.showErrorMessage("Error with displaying the table please try again", null, "Error");
			
			e.printStackTrace();
		} finally {

			try {
				System.out.println("dbclosed");
				
				connection.close();
				
			} catch (SQLException e) {

				DataBaseSystem.showErrorMessage("Table could not be found", null, "Error");
				
				e.printStackTrace();
			}
		}

	}

	/**
	 * method that is used to call the connection to open the connection to the
	 * database
	 */
	public void dataBaseConnect() {
		connection = DataBaseSystem.connectdb();
	}

}
