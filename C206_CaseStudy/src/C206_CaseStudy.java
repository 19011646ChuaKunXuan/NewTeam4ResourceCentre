import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		// ArrayList for customer - kun xuan
		ArrayList<Customer> customerList = new ArrayList<Customer>();

		// ArrayList for TransactionList and archiveList -soon chuan
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		ArrayList<Transaction> archiveList = new ArrayList<Transaction>();

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

	// inputting info for new transaction before adding -soon chuan
	public static Transaction inputTransaction() {

		String staffName = Helper.readString("Enter handling Staff: ");
		String itemTransacted = Helper.readString("Enter description > ");
		String actionTaken = Helper.readString("Enter description > ");

		Transaction tt = new Transaction(staffName, itemTransacted, actionTaken);
		return tt;

	}

	// adding new transaction to list -soon chuan
	public static void addTransaction(ArrayList<Transaction> transactionList, Transaction tt) {

		transactionList.add(tt);
		System.out.println("New transaction added");

	}

	// Viewing all transactions in list -soon chuan
	public static String retrieveAllTransaction(ArrayList<Transaction> transactionList) {
		String output = "";

		for (int i = 0; i < transactionList.size(); i++) {

			output += String.format("%-10s %-30s %-10s\n", transactionList.get(i).toString());
		}
		return output;
	}

	public static void viewAllTransaction(ArrayList<Transaction> transactionList) {

		String output = String.format("%-10s %-30s %-10s\n", "Handling Staff", "Item Transacted", "Action Taken");
		output += retrieveAllTransaction(transactionList);
		System.out.println(output);
	}

	// Archiving selected transaction -soon chuan
	public static void archiveTransaction(ArrayList<Transaction> transactionList, ArrayList<Transaction> archiveList) {

		int choice = Helper.readInt("Select which transaction to archive: ") - 1;
		Transaction selected = transactionList.get(choice);
		archiveList.add(selected);
		transactionList.remove(choice);

	}

	// adding product to arrayList - ShengEn
	public static void addProduct(ArrayList<product> productList) {
		ArrayList<String> productList1 = new ArrayList<String>();
		String productName = Helper.readString("Enter a product to add > ");
		String category = Helper.readString("Enter category of product (meat or veg?) > ");
		double price = Helper.readDouble("Enter price of product > ");
		String product1 = Helper.readString(productName);
		productList1.add(product1);
	}

	// view product and category - ShengEn
	public static void viewProduct(ArrayList<product> productList) {
		for (int i = 0; i < productList.size(); i++) {
			product p = productList.get(i);
			System.out.println(String.format("%-20s %s  %-20s\n", "productName", "category", "price"));
		}
	}

	// delete product - ShengEn
	public static void deleteProduct(ArrayList<product> productList) {
		String product2 = Helper.readString("Enter a product to delete > ");
		for (int j = 0; j < productList.size(); j++) {
			productList.remove(product2);
			System.out.println("Item has been deleted!");
		}

	}

	// View Procedure - Leonard
	public static String ViewProcedure(ArrayList<Procedure> procedureList) {
		String output = "";
		for (int i = 0; i < procedureList.size(); i++) {
			output += String.format("%-84s \n", procedureList.get(i).toString());
		}
		return output;
	}

	// add procedure and category - Leonard
	public static Procedure AddProcedure() {
		String Category = Helper.readString("Enter category > ");
		String Name = Helper.readString("Enter name > ");

		Procedure p = new Procedure(Category, Name);
		return p;

	}

	public static void addProcedure(ArrayList<Procedure> procedureList, Procedure p) {
		procedureList.add(p);
		System.out.println("Procedure Added");
	}

	// Delete Procedure - Leonard
	public static void RemoveProcedure(ArrayList<Procedure> procedureList) {
		C206_CaseStudy.ViewProcedure(procedureList);
		String dcategory = Helper.readString("Enter a procedure to delete > ");
		boolean check = true;
		int i = 0;

		while (i < procedureList.size()) {
			if (procedureList.get(i).equals(dcategory)) {
				check = true;
				break;
			} else {
				check = false;
			}
			i++;
		}
		if (check == true) {
			procedureList.remove(i);
			System.out.println("Successfully deleted procedure");
		} else {
			System.out.println("Failed to delete procedure");

		}

	}

}