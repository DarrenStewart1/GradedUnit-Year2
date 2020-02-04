package application;

import java.sql.Blob;
import java.sql.Date;

import javafx.scene.image.Image;



/**
 * Class that encapsulates the data about a Product
 * @author Darren Stewart
 *
 */

public class Product {
	
	public int productID;
	public String productName;
	public int productQuantity;
	public float costOfUnit;
	public String productReleaseDate;
	public Blob productImg;
	public String productPlatForm;
	public String productDescription;
	
	
	
	/**
	 * Create a new product
	 * 
	 * @param productID the id of the product 
	 * @param productName the name of the product
	 * @param productQuantity the quantity of the product in stock
	 * @param costOfUnit the cost of the product
	 * @param productReleaseDate the release date of the product
	 * @param productImg an image of the product
	 * @param productPlatForm the platform that the product is on
	 * @param productDescription a description of the product
	 */
	public Product(int productID , String productName ,int productQuantity, float costOfUnit , String productReleaseDate  ,
			String productPlatForm , String productDescription)
	{
		this.productID = productID;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.costOfUnit = costOfUnit;
		this.productReleaseDate = productReleaseDate;
		this.productImg = productImg;
		this.productPlatForm = productPlatForm;
		this.productDescription = productDescription;
	}
	
	
	/**
	 * Creates a product that only contains the id name and quantity of the product in stock
	 * @param productID the id of the product 
	 * @param productName the name of the product
	 * @param productQuantity the quantity of the product in stock
	 */
	public Product(int productID , String productName , int productQuantity)
	{
		this.productID = productID;
		this.productName = productName;
		this.productQuantity = productQuantity;
		
	}
	
	
	/**
	 * @return the amount of stock of the product
	 */
	public int getProductQuantity() {
		return productQuantity;
	}

	/**
	 * Set the stock level of the product
	 * @param productQuantity the stock level of the product
	 */
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}


	
	/**
	 * @return the product id
	 */
	public int getProductID() {
		return productID;
	}

	/**
	 * Set the id of the product
	 * @param productID the id of the product
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}

	/**
	 * @return the name of the product
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Set the name of the product
	 * @param productName the name of the product
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the cost of the product
	 */
	public float getCostOfUnit() {
		return costOfUnit;
	}

	/**
	 * Set the cost of the product
	 * @param costOfUnit the cost of the product
	 */
	public void setCostOfUnit(float costOfUnit) {
		this.costOfUnit = costOfUnit;
	}

	/**
	 * @return the release date of the product
	 */
	public String getProductReleaseDate() {
		return productReleaseDate;
	}

	/**
	 * Set the release date of the product
	 * @param productReleaseDate the release date of the product
	 */
	public void setProductReleaseDate(String productReleaseDate) {
		this.productReleaseDate = productReleaseDate;
	}

	/**
	 * @return an image of the product
	 */
	public Blob getProductImg() {
		return productImg;
	}

	/**
	 * set the product image
	 * @param productImg the product image
	 */
	public void setProductImg(Blob productImg) {
		this.productImg = productImg;
	}

	/**
	 * 
	 * @return the platform the product is sold on
	 */
	public String getProductPlatForm() {
		return productPlatForm;
	}

	/**
	 * Set the platform the product is sold on
	 * @param productPlatForm the platform the product is sold on
	 */
	public void setProductPlatForm(String productPlatForm) {
		this.productPlatForm = productPlatForm;
	}

	/**
	 * @return a description of the product
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * Set the description of the product
	 * @param productDescription a description of the product
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

}
