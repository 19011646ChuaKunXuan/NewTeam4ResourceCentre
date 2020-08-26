// - Kun Xuan
public class Customer {

	private String customername;
	private int customernumber;
	private int bonus;
	
	//Customer
	public Customer(String customername, int customernumber, int bonus) {
		this.customername = customername;
		this.customernumber = customernumber;
		this.bonus = bonus;
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
	
	public int getBonus() {
		return bonus;
	}

	public void addBonus(int bonus) {
		this.bonus += bonus;
	}
	
	public String toString() {
		String output = "";
		output =String.format("%-10s %10d\n", getName(), getNumber() );
		return output;
	}
	
	
	//for transaction link - Soon Chuan
	public Customer(String customername, int customernumber) {
		this.customername = customername;
		this.customernumber = customernumber;
	}
	
}