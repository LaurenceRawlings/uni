/**
 * A class that models a product.
 * @author Liam O'Reilly
 *
 */
public class Product {
	protected double price;
	protected int numStock;
	
	/**
	 * Create a new product.
	 * @param price The price of the product in pounds.
	 * @param numStock The amount of the product in stock. 
	 */
	public Product(double price, int numStock) {
		this.price = price;
		this.numStock = numStock;
	}

	/**
	 * Get the price of the product.
	 * @return The price of the product in pounds.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Set the price of the product.
	 * @param price The price of the product in pounds.
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Get the amount of product in stock.
	 * @return The amount of product in stock.
	 */
	public int getNumStock() {
		return numStock;
	}
	
	/**
	 * Set the amount of product in stock.
	 * @param numStock The amount of product in stock.
	 */
	public void setNumStock(int numStock) {
		this.numStock = numStock;
	}
}