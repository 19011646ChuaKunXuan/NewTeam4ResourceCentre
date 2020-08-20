public class Customer {

	private String name;
	private int number;
	public Customer(String name, int number) {
		this.name = name;
		this.number = number;
	}
	
	public void addName(String name) {
		this.name = name;
	}
	
	public void addNumber(int number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumber() {
		return number;
	}
	public String toString() {
		String output = "";
		output =String.format("%-10s %10d\n", getName(), getNumber() );
		return output;
	}
	
}