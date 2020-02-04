package application;

/**
 * Class that encapsulates the data about a invoices
 * 
 * @author Darren Stewart
 *
 */
public class Invoice {

	public int invoiceID;
	public String customerFirstName;
	public String customerLastName;
	public String customerAddress;
	public String customerEmail;
	public String nameOfProduct;
	public float totalBeforeVat;
	public float totalAfterVat;
	public float totalVat;
	public int quantitySold;

	/**
	 * Creates a new invoice
	 * 
	 * @param invoiceID         holds the value of the invoice id
	 * @param customerFirstName holds the value of the customers first name
	 * @param customerLastName  holds the value of the customers last name
	 * @param customerAddress   holds the value of the customers address
	 * @param customerEmail     holds the value of the customers email address
	 * @param nameOfProduct     holds the value of the products name
	 * @param quantitySold      holds the value of the quantity of the product
	 *                          purchased
	 * @param totalBeforeVat    holds the value of the total cost of the purchase
	 *                          before vat is added
	 * @param totalAfterVat     holds the value of the total cost of the purchase
	 *                          after vat has been added
	 * @param totalVat          holds the value of the vat that needs to be added
	 *                          onto the purchase
	 */
	public Invoice(int invoiceID, String customerFirstName, String customerLastName, String customerAddress,
			String customerEmail, String nameOfProduct, int quantitySold, float totalBeforeVat, float totalAfterVat,
			float totalVat) {

		this.invoiceID = invoiceID;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.nameOfProduct = nameOfProduct;
		this.totalBeforeVat = totalBeforeVat;
		this.totalAfterVat = totalAfterVat;
		this.totalVat = totalVat;
		this.quantitySold = quantitySold;

	}

	/**
	 * @return the id of the invoice
	 */
	public int getInvoiceID() {
		return invoiceID;
	}

	/**
	 * set the invoice id
	 * 
	 * @param invoiceID the id of the invoice
	 */
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}

	/**
	 * 
	 * @return the first name of the customer
	 */
	public String getCustomerFirstName() {
		return customerFirstName;
	}

	/**
	 * set the customers first name
	 * 
	 * @param customerFirstName the first name of the customer
	 */
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	/**
	 * @return the customers last name
	 */
	public String getCustomerLastName() {
		return customerLastName;
	}

	/**
	 * set the customers last name
	 * 
	 * @param customerLastName the customers last name
	 */
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	/**
	 * 
	 * @return the customers address
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}

	/**
	 * set the customers address
	 * 
	 * @param customerAddress the address of the customer
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	/**
	 * @return the email address of the customer
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * set the email address of the customer
	 * 
	 * @param customerEmail the customers email address
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * @return the name of the product
	 */
	public String getNameOfProduct() {
		return nameOfProduct;
	}

	/**
	 * set the name of the product
	 * 
	 * @param nameOfProduct the name of the product
	 */
	public void setNameOfProduct(String nameOfProduct) {
		this.nameOfProduct = nameOfProduct;
	}

	/**
	 * @return the total purchase cost before vat is added
	 */
	public float getTotalBeforeVat() {
		return totalBeforeVat;
	}

	/**
	 * set the total before vat
	 * 
	 * @param totalBeforeVat the total before vat
	 */
	public void setTotalBeforeVat(float totalBeforeVat) {
		this.totalBeforeVat = totalBeforeVat;
	}

	/**
	 * @return the total after vat is added
	 */
	public float getTotalAfterVat() {
		return totalAfterVat;
	}

	/**
	 * Set the total after vat is added
	 * 
	 * @param totalAfterVat the total after vat is added
	 */
	public void setTotalAfterVat(float totalAfterVat) {
		this.totalAfterVat = totalAfterVat;
	}

	/**
	 * @return the amount of vat needed to be paid
	 */
	public float getTotalVat() {
		return totalVat;
	}

	/**
	 * set the total vat
	 * 
	 * @param totalVat the total vat required to be paid
	 */
	public void setTotalVat(float totalVat) {
		this.totalVat = totalVat;
	}

	/**
	 * 
	 * @return the quantity of the product that has been sold
	 */
	public int getQuantitySold() {
		return quantitySold;
	}

	/**
	 * Set the quantity of the product sold
	 * 
	 * @param quantitySold the quantity of the product sold
	 */
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}

}
