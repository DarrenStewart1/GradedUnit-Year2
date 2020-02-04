package application;

/**
 * Class that encapsulates the data about a Customers
 * 
 * @author Darren Stewart
 *
 */
public class Customer {

	private String firstName;
	private String lastName;
	private String address;
	public String emailAddress;
	public String phoneNumber;
	public int customerID;

	/**
	 * Creates a new customer
	 * 
	 * @param firstName         holds the first name of the customer
	 * @param lastName     holds the last name of the customer
	 * @param address      holds the address of the customer
	 * @param emailAddress holds the email address of the customer
	 * @param phoneNumber  holds the phone number of the customer
	 * @param customerID   holds the customers id
	 */
	public Customer(String firstName, String lastName, String address, String emailAddress, String phoneNumber,
			int customerID) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.customerID = customerID;

	}

	/**
	 * @return the address of the customer
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * set the address of the customer
	 * 
	 * @param address the address of the customer
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the email address of the customer
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Set the email address of the customer
	 * 
	 * @param emailAddress the email address of the customer
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the phone number of the customer
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Set the phone number of the customer
	 * 
	 * @param phoneNumber the phone number of the customer
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the id of the customer
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * Set the value of the customers id
	 * 
	 * @param customerID the id of the customer
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	/**
	 * @return the first name of the customer
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * set the value of the first name of the customer
	 * 
	 * @param firstName the first name of the customer
	 */
	public void setName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the last name of the customer
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * set the last name of the customer
	 * 
	 * @param lastName the last name of the customer
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
