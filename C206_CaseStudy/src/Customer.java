public class Customer {

	private String customername;
	private int customernumber;
	public Customer(String customername, int customernumber) {
		this.customername = customername;
		this.customernumber = customernumber;
	}
	
	public void addName(String customername) {
		this.customername = customername;
	}
	
	public void addNumber(int customernumber) {
		this.customernumber = customernumber;
	}
	
	public String getName() {
		return customername;
	}
	
	public int getNumber() {
		return customernumber;
	}
	public String toString() {
		String output = "";
		output =String.format("%-10s %10d\n", getName(), getNumber() );
		return output;
	}
	
}