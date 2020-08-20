import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		// example customerList.add(new Customer("Kunxuan", 98765432));

		int option = 0;

		while (option != 4) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an otion > ");
			if (option == 1) {
				Customer c = inputCustomer();
				C206_CaseStudy.addcustomerInfo(customerList, c);
			} else if (option == 2) {
				// View career information
				if (customerList.isEmpty()) {
					System.out.println("Cluster List is empty\n");
				} else {
					C206_CaseStudy.viewcustomerInfo(customerList);
				}

			} else if (option == 3) {
				// Delete career information
				if (customerList.isEmpty()) {
					System.out.println("Cluster List is already empty\n");
				} else {
					C206_CaseStudy.deletecustomerInfo(customerList);
				}

			} else if (option == 4) {
				System.out.println("Bye!");

			} else {
				System.out.println("Invalid option");
			}
		}
	}

	private static Customer inputCustomer() {
		String name = Helper.readString("Enter customer name: ");
		int number = Helper.readInt("Enter customr number: ");
		Customer c = new Customer(name, number);
		return c;
	}

	// ==================== Option 1 Add ====================
	public static void addcustomerInfo(ArrayList<Customer> customerList, Customer c) {
		customerList.add(c);
		System.out.println("Customer is added");
	}

	// ==================== Option 2 View ====================
	public static String retrieveAllCustomerInformation(ArrayList<Customer> customerList) {
		String output = "";
		for (int i = 0; i < customerList.size(); i++) {
			Customer Cust = customerList.get(i);

		}
		return output;
	}

	public static void viewcustomerInfo(ArrayList<Customer> customerList) {
		C206_CaseStudy.setHeader("CUSTOMER LIST");
		String output = String.format("%-10s %-10s\n", "Name", "Number");
		for (int i = 0; i < customerList.size(); i++) {
			output += String.format(customerList.get(i).toString());
		}
		System.out.println(output);
	}

	// ==================== Option 3 Delete ====================
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

	private static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");

	}

	public static void menu() {

		System.out.println("1. Add Career Information");
		System.out.println("2. View Career Information");
		System.out.println("3. Delete Career Information");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
}