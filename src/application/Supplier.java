package application;

/**
 * Class that encapsulates the data about a supplier
 * 
 * @author Darren Stewart
 *
 */
public class Supplier {

	String supplierName;
	String supplierAddress;
	int SupplierID;

	/**
	 * Create a new supplier
	 * 
	 * @param supplierID      the id of the supplier
	 * @param supplierName    the name of the supplier
	 * @param supplierAddress the address of the supplier
	 */
	public Supplier(int supplierID, String supplierName, String supplierAddress) {
		this.SupplierID = supplierID;
		this.supplierAddress = supplierAddress;
		this.supplierName = supplierName;
	}

	/**
	 * @return the name of the supplier
	 */
	public String getSupplierName() {
		return supplierName;
	}

	/**
	 * Set the name of the supplier
	 * 
	 * @param supplierName the name of the supplier
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	/**
	 * @return the address of the supplier
	 */
	public String getSupplierAddress() {
		return supplierAddress;
	}

	/**
	 * Set the address of the supplier
	 * 
	 * @param supplierAddress the address of the supplier
	 */
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	/**
	 * @return the id of the supplier
	 */
	public int getSupplierID() {
		return SupplierID;
	}

	/**
	 * Set the id of the supplier
	 * 
	 * @param supplierID the id of the supplier
	 */
	public void setSupplierID(int supplierID) {
		SupplierID = supplierID;
	}

}
