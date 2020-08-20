

public class product {
	
	private String productName;
	private double price;
	private String category;
	private String brand;
	private String information;
	
	public product(String productName, double price, String category, String brand, String information) {
		this.productName = productName;
		this.price = price;
		this.category = category;
		this.brand = brand;
		this.information = information;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}
	
}