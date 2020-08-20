import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		// ArrayList for customer - kun xuan
		ArrayList<Customer> customerList = new ArrayList<Customer>();

	}

	// inputting customer before adding - kun xuan
	private static Customer inputCustomer() {
		String name = Helper.readString("Enter customer name: ");
		int number = Helper.readInt("Enter customr number: ");
		Customer c = new Customer(name, number);
		return c;
	}

	// adding of customer - kun xuan
	public static void addcustomerInfo(ArrayList<Customer> customerList, Customer c) {
		customerList.add(c);
		System.out.println("Customer is added");
	}

	// viewing customers - kun xuan
	public static String retrieveAllCustomerInformation(ArrayList<Customer> customerList) {
		String output = "";
		for (int i = 0; i < customerList.size(); i++) {
			Customer Cust = customerList.get(i);

		}
		return output;
	}

	public static void viewcustomerInfo(ArrayList<Customer> customerList) {
		String output = String.format("%-10s %-10s\n", "Name", "Number");
		for (int i = 0; i < customerList.size(); i++) {
			output += String.format(customerList.get(i).toString());
		}
		System.out.println(output);
	}

	// deleting customers - kun xuan
	public static void deletecustomerInfo(ArrayList<Customer> customerList) {
		C206_CaseStudy.viewcustomerInfo(customerList);
		String dname = Helper.readString("Enter a customer name to delete > ");
		boolean check = true;
		int i = 0;

		while (i < customerList.size()) {
			if (customerList.get(i).getName().equals(dname)) {
				check = true;
				break;
			} else {
				check = false;
			}
			i++;
		}
		if (check == true) {
			customerList.remove(i);
			System.out.println("Customer has been deleted");
		} else {
			System.out.println("Invalid customer");
		}
	}
	
	
	

}