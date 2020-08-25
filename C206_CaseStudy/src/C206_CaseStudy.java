import java.util.ArrayList;

public class C206_CaseStudy {
	
	//MENU CODES
	private static final int OPTION_CUSTOMER = 1;
	private static final int OPTION_TRANSACTION = 2;
	private static final int OPTION_PRODUCT = 3;
	private static final int OPTION_PROCEDURE = 4;
	private static final int OPTION_QUIT = 5;

	public static void main(String[] args) {

		// ArrayList for customer - kun xuan
		ArrayList<Customer> customerList = new ArrayList<Customer>();

		// ArrayList for TransactionList and archiveList -soon chuan
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		ArrayList<Transaction> archiveList = new ArrayList<Transaction>();
		
		//ArrayList for Procedure - Leonard
		ArrayList<Procedure> procedureList = new ArrayList<Procedure>();
		
		//ArrayList for Product - ShengEn
		ArrayList<product> productList = new ArrayList<product>();
		
		
		
		
		//MENU CODES - soon chuan
		int option = 0;
		int option2 = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			
			//For Customer
			if (option == OPTION_CUSTOMER) {
				//show customer menu
				C206_CaseStudy.customerMenu();
				option2 = Helper.readInt("Enter option to select action > ");
				
				if (option2 == 1) {
					//add customer
					Customer c = inputCustomer();
					C206_CaseStudy.addcustomerInfo(customerList, c);
					
				} else if (option2 == 2) {
					//view customer
					C206_CaseStudy.viewcustomerInfo(customerList);
					
				} else if (option2 == 3) {
					//delete customer
					C206_CaseStudy.deletecustomerInfo(customerList);
					
				} else {
					System.out.println("Invalid option");
				}
				
			//For Transaction
			} else if (option == OPTION_TRANSACTION) {
				// menu		
				C206_CaseStudy.transactionMenu();
				
				option2 = Helper.readInt("Enter option to select action > ");

				if (option2 == 1) {
					// Add transaction
					Transaction t = inputTransaction();
					C206_CaseStudy.addTransaction(transactionList, t);

				} else if (option2 == 2) {
					// View transactions
					C206_CaseStudy.viewAllTransaction(transactionList);

				} else if (option2 == 3) {
					//archive transaction
					C206_CaseStudy.viewAllTransaction(transactionList);
					C206_CaseStudy.archiveTransaction(transactionList, archiveList);
					
				} else if (option2 == 4) {
					//update transaction
					C206_CaseStudy.viewAllTransaction(transactionList);
					C206_CaseStudy.updateTransaction(transactionList);
					
				} else {
					System.out.println("Invalid option");
				}
				
			//For Product
			} else if (option == OPTION_PRODUCT) {
				// add product
				C206_CaseStudy.productMenu();
				
				option2 = Helper.readInt("Enter option to select action > ");

				if (option2 == 1) {
					// add product
					C206_CaseStudy.addProduct(productList);
				
				} else if (option2 == 2) {
					// view product
					C206_CaseStudy.viewProduct(productList);
					
				} else if (option2 == 3) {
					//delete product
					C206_CaseStudy.deleteProduct(productList);
					
				} else {
					System.out.println("Invalid option");
				}
				
			//For Procedure
			} else if (option == OPTION_PROCEDURE) {
				// menu
				C206_CaseStudy.procedureMenu();
				
				option2 = Helper.readInt("Enter option to select action >  ");
				
				if (option2 == 1) {
					// add procedure
					Procedure p = C206_CaseStudy.AddProcedure();
					C206_CaseStudy.addProcedure(procedureList, p);
				
				} else if (option2 == 2) {
					// view procedure
					C206_CaseStudy.ViewProcedure(procedureList);
					
				} else if (option2 == 3) {
					//delete procedure
					C206_CaseStudy.RemoveProcedure(procedureList);
					
				} else {
					System.out.println("Invalid option");
				}

			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

}

	
	// inputting customer before adding - kun xuan
		private static Customer inputCustomer() {
			String name = Helper.readString("Enter customer name: ");
			int number = Helper.readInt("Enter customr number: ");
			int bonus = Helper.readInt("Enter customer points: ");
			Customer c = new Customer(name, number, bonus);
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
			String output = String.format("%-10s %-10s %-10s\n", "Name", "Number", "Points");
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

	    // returning customer info - Kun Xuan
		public static void returncustomerInfo(ArrayList<Customer> customerList) {
			Customer highestBonusPoints = customerList.get(0);
			for (int i = 0; i < customerList.size(); i++) {
				Customer cus = customerList.get(i);
				if (cus.getBonus() > highestBonusPoints.getBonus()) {
					highestBonusPoints = cus;
				}
			}
			System.out.println("The top customer is: " + highestBonusPoints.getName());
			System.out.println("Top Customer bonus points: " + highestBonusPoints.getBonus());

		}

	    // adding bonus point to customer - Kun Xuan
		public static void addbonusrewards(ArrayList<Customer> customerList) {
			String name = Helper.readString("Enter the customer name: ");
			for (int i = 0; i < customerList.size(); i++) {
				if (name.equals(customerList.get(i).getName())) {
					int bonus = Helper.readInt("Enter the customer bonus points: ");
					customerList.get(i).addBonus(bonus);
					System.out.println("Customer bonus reward is added");
				} else {
					System.out.println("Name is incorrect, please try again later. ");

				}
			}

		}
	
	

	// inputting info for new transaction before adding -soon chuan
	public static Transaction inputTransaction() {
		String customerName = Helper.readString("Enter Customer Name: ");
		int customerNumber = Helper.readInt("Enter Customer number: ");
		String staffName = Helper.readString("Enter handling Staff: ");
		String productType = Helper.readString("Enter product: ");
		String itemTransacted = Helper.readString("Enter item transacted: ");
		String actionTaken = Helper.readString("Enter action taken: ");

		Transaction tt = new Transaction(customerName, customerNumber, staffName, productType, itemTransacted, actionTaken);
		return tt;

	}

	// adding new transaction to list -soon chuan
	public static void addTransaction(ArrayList<Transaction> transactionList, Transaction tt) {

		transactionList.add(tt);
		System.out.println("New transaction added");

	}

	// Viewing and retrieving all transactions in list -soon chuan
	public static String retrieveAllTransaction(ArrayList<Transaction> transactionList) {
		String output = "";

		for (int i = 0; i < transactionList.size(); i++) {
			
			String customerName = transactionList.get(i).getCustomerName();
			int customerNumber = transactionList.get(i).getCustomerNumber();
			String handlingStaff = transactionList.get(i).getHandlingStaff();
			String productType = transactionList.get(i).getProduct();
			String itemTransacted = transactionList.get(i).getItemTransacted();
			String actionTaken = transactionList.get(i).getActionTaken();
			output += String.format("%-20s %-20d %-20s %-20s %-20s %-20s\n", customerName, customerNumber, handlingStaff, productType, itemTransacted, actionTaken);
		}
		return output;
	}

	public static void viewAllTransaction(ArrayList<Transaction> transactionList) {

		String output = String.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", "Customer Name", "Customer Number", "Handling Staff", "Product", "Item Transacted", "Action Taken");
		output += retrieveAllTransaction(transactionList);
		System.out.println(output);
	}

	// Archiving selected transaction -soon chuan
	public static void archiveTransaction(ArrayList<Transaction> transactionList, ArrayList<Transaction> archiveList) {

		int choice = Helper.readInt("Select which transaction to archive: ") - 1;
		Transaction selected = transactionList.get(choice);
		archiveList.add(selected);
		transactionList.remove(choice);
		
		System.out.println("Transaction Archived!");

	}
	
	//Updating existing transactions - soon chuan
	public static void updateTransaction(ArrayList<Transaction> transactionList) {
		
		if (transactionList != null) {
			
			int choice = Helper.readInt("Select which transaction to update: ") - 1;
			Transaction selectedUpdate = transactionList.get(choice);
			
			String newCustomerName = Helper.readString("Enter updated customer name: ");
			int newCustomerNumber = Helper.readInt("Enter updated customer number: ");
			String newHandlingStaffName = Helper.readString("Enter updated handling staff name: ");
			String newProductType = Helper.readString("Enter updated type of product: ");
			String newItemTransacted = Helper.readString("Enter updated item transacted: ");
			String newActionTaken = Helper.readString("Enter updated action taken: ");
			
			selectedUpdate.setCustomerName(newCustomerName);
			selectedUpdate.setCustomerNumber(newCustomerNumber);
			selectedUpdate.setHandlingStaff(newHandlingStaffName);
			selectedUpdate.setProduct(newProductType);
			selectedUpdate.setItemTransacted(newItemTransacted);
			selectedUpdate.setActionTaken(newActionTaken);
			
			transactionList.set(choice, selectedUpdate);

			System.out.println("Transaction successfully update!");
			
		} else {
			System.out.println("There are no transactions to update!");
			
		}
		
	}

	// adding product to arrayList - ShengEn
	public static void addProduct(ArrayList<product> productList) {
		String productName = Helper.readString("Enter a product to add > ");
		double price = Helper.readDouble("Enter price of product > ");
		String category = Helper.readString("Enter category of product > ");
		String brand = Helper.readString("Enter a brand of product > ");
		String information = Helper.readString("Enter product information > ");
		product product1 = new product(productName, price, category, brand, information);
		productList.add(product1);
	}

	// view product and category - ShengEn
	public static void viewProduct(ArrayList<product> productList) {
		for (int i = 0; i < productList.size(); i++) {
			product p = productList.get(i);
			System.out.println(String.format("%-20s %s %-20s %-20s %-20s\n", "productName", "price", "category", "brand", "information"));
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
	
	
	
	
	//MENU CODES - soon chuan
	public static void menu() {
		System.out.println("Select Category: ");
		System.out.println("1. Customer");
		System.out.println("2. Transaction");
		System.out.println("3. Product");
		System.out.println("4. Procedure");
		System.out.println("5. Quit");

	}
	
	public static void customerMenu() {
		System.out.println("Select action > ");
		System.out.println("1. Add Customer");
		System.out.println("2. View Customer");
		System.out.println("3. Delete Customer");
	}
	
	public static void transactionMenu() {
		System.out.println("Select action > ");
		System.out.println("1. Add Transaction");
		System.out.println("2. View Transaction");
		System.out.println("3. Archive Transaction");
		System.out.println("4. Update Transaction");
	}
	
	public static void productMenu() {
		System.out.println("Select action > ");
		System.out.println("1. Add Product");
		System.out.println("2. View Product");
		System.out.println("3. Delete Product");
	}
	
	public static void procedureMenu() {
		System.out.println("Select action > ");
		System.out.println("1. Add Procedure");
		System.out.println("2. View Procedure");
		System.out.println("3. Delete Procedure");
	}
}