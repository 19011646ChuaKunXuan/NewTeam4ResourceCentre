import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	// Transaction for test - soon chuan
	private Transaction tt1;
	private Transaction tt2;
	private Transaction tt0;

	private ArrayList<Transaction> transactionList;
	
	
	//Procedure for test - Leonard
	private Procedure pr1;
	private Procedure pr2;
	private Procedure pr3;

	private ArrayList<Procedure> procedureList;
	
	//Customer for test - kun xuan
	public Customer a;
	public Customer b;

	private ArrayList<Customer> customerList;
	
	// product for test - Sheng En
	private product p1;
	private product p2;
	private product p3;
	
	private ArrayList<product> productList;
	
	

	@Before
	public void setUp() throws Exception {

		// preparing test data for Transaction - soon chuan
		tt0 = new Transaction("John", "Ms Lee", "Biscuit", "Chocolate Biscuit", "Exchange Rejeceted");
		tt1 = new Transaction("John123", "Ms Lee", "Bread", "White Bread", "Exchange Accepted");
		tt2 = new Transaction("Mary", "Mr Tan", "Bottle", "Thermal flask", "Exchange Rejected");
		transactionList = new ArrayList<Transaction>();
		transactionList.add(tt0);

		// preparing test data for Procedure - Leonard
		pr1 = new Procedure("Transactions cannot be refunded after 20 days", "refund");
		pr2 = new Procedure("If items are extremely damaged, it cannot be exchanged", "exchange");
		pr3 = new Procedure("If purchase happend more than 30 days ago, item cannot be returned", "return");

		procedureList = new ArrayList<Procedure>();
		
		// preparing test data for Customer - kun xuan
		Customer a = new Customer("Kun Xuan", 98765432);
		Customer b = new Customer("Soon Chuan", 12345678);
		
		customerList = new ArrayList<Customer>();
		
		// preparing test data for product - Sheng En 
		p1 = new product("cauliflower", 3.60, "Veg", "Giant", "1 kilogram");
		p2 = new product("spring onion", 0.80, "Veg", "Giant", "100 grams");
		p3 = new product("chicken wings", 2.67, "Meat", "Giant", "300 grams");
		
		productList = new ArrayList<product>();

	}



	@After
	public void tearDown() throws Exception {

		// for transaction - soon chuan
		tt0 = null;
		tt1 = null;
		tt2 = null;
		transactionList = null;

		// for Procedure - Leonard
		pr1 = null;
		pr2 = null;
		pr3 = null;
		procedureList = null;
		
		// for Customer - kun xuan
		a = null;
		b = null;
		customerList = null;
		
		// for Product - Sheng En
				p1 = null;
				p2 = null;
				p3 = null;
				productList = null;
		
		
	}



	@Test // - soon chuan
	// Tests for adding transaction - soon chuan
	public void addTransactionTest() {
		// normal: transactions should be added into its dedicated list
		assertNotNull("Check if there is valid Transaction arraylist to add to", transactionList);

		// error: transaction cannot be added if name contains numbers
		assertFalse(tt1.getHandlingStaff().matches("^[a-zA-Z]*$"));

		// boundary: added transaction must be different
		assertFalse(tt2.equals(transactionList.get(0)));

	}
	
	@Test // - soon chuan
	// Tests for viewing/retrieving transactions - soon chuan
	public void viewTransactionTest() {
		// normal: all existing transaction records should be displayed
		String allTransaction = C206_CaseStudy.retrieveAllTransaction(transactionList);
		String testOutput = String.format("%-10s %-30s %-10s\n", transactionList.get(0).toString());
		testOutput += String.format("%-10s %-30s %-10s\n", transactionList.get(1).toString());

		assertEquals("Test viewAllTransaction lis", testOutput, allTransaction);

		// boundary: transactions cannot be displayed from an empty list
		assertNotNull("Test if there is a valid transaction arraylist to retrieve transactions", transactionList);

	}
	
	@Test // - soon chuan
	// tests for archiving transactions - soon chuan
	public void archiveTransactionTest() {
		// normal: archived transactions should no longer show up in transactionList
		int currentSize = transactionList.size();
		transactionList.remove(0);

		assertNotSame(currentSize, transactionList.size());

	}
	
	@Test // - Leonard
	public void addProcedureTest() {

		// Check for correctly added procedure - Leonard

		C206_CaseStudy.addProcedure(procedureList, pr1);
		assertNotNull("Check whether or not the procedure is correctly added in a previously empty list",
				procedureList);

		// Check if procedure list size is same number as procedures added
		C206_CaseStudy.addProcedure(procedureList, pr2);
		assertEquals("Check if procedure list size is same number as procedures added", 2, procedureList.size());

		// Check if item added in the list is the same as the first item in the list
		assertSame("Check that Procedure is added in the same position", pr1, procedureList.get(0));

	}
	
	@Test // - Leonard
	public void deleteProcedureTest() {

		// Check if procedure is deleted from the list properly - Leonard
		procedureList.remove(1);
		assertEquals("Check that procedure is deleted from the list properly", 2, procedureList.get(1));

		// Check if procedure list cannot be empty when removing a procedure
		procedureList.remove(0);
		assertNotEquals("Check that procedure is deleted from the list properly", 2, procedureList.get(1));

		// Check if procedure size decreases after removing a procedure
		C206_CaseStudy.addProcedure(procedureList, pr1);
		C206_CaseStudy.addProcedure(procedureList, pr2);
		assertEquals("Check that procedure list has 2 procedures", 2, procedureList.size());
		procedureList.remove(1);
		assertEquals("Check that procedure list has only 1 procedure", 1, procedureList.size());

	}
	
	@Test // - Leonard
	public void viewProcedureTest() {
		// Check if every procedure is added into the list correctly - Leonard
		C206_CaseStudy.addProcedure(procedureList, pr1);
		C206_CaseStudy.addProcedure(procedureList, pr2);
		assertEquals("Check that procedure list has 2 procedures", 2, procedureList.size());

	}
	
	@Test // - kun xuan
	public void addcustomerInfo() { 
		//When the test case is empty, add a customer name and test if there is only 1 item in the array list.(normal)
		C206_CaseStudy.addcustomerInfo(customerList, a);
		assertEquals("Test if customer arraylist size is 1?", 1, customerList.size());
		//boundary
		//Test if the array list is not null to add new item. (boundary)
		assertNotNull("Check if there is valid customer arraylist add to", customerList);
		//After added, the customer information should not be able to add again. (Error)
		C206_CaseStudy.addcustomerInfo(customerList, b);
		assertNotEquals("Test if customer can be added again", 0, customerList);
		
	}
	
	@Test // - kun xuan
	public void viewcustomerInfo() {
		//The list is empty at first but able to view the information after adding 1 (Normal)
		C206_CaseStudy.addcustomerInfo(customerList,a);
		assertNotEquals("Test if there is any customer information arraylist that can be viewed", 0, customerList);
		//Customer information list cannot be null before viewing the customer information (Boundary)
		assertNotNull("Check if there is valid customer arraylist to add to", customerList);
		//if the item does not exist, it should not be viewed (Error)	
		String testoutput = "";
		assertEquals("Test if customer information can be viewed if it is not available", testoutput, C206_CaseStudy.retrieveAllCustomerInformation(customerList));
	
	}
	
	@Test // - kun xuan
	public void deletecustomerInfo() {
		// Test if when customer information is deleted, the size of customerList will be reduced by 1 (normal)
		C206_CaseStudy.deletecustomerInfo(customerList);
		assertEquals("Test if customer arraylist size is 0?", 0, customerList.size());
		// customer list cannot be null when deleting a product (boundary) 
		assertNotNull("Check if there is any customer Information to be deleted", customerList);
		// when deleted, it should no longer be on the list (error)
		C206_CaseStudy.deletecustomerInfo(customerList);
		assertNotEquals("Test if there if the customer's Information is still in the customerList", 0, customerList);
	
	}
	
	@Test // - Sheng En
	public void addProduct() {
		
		// test to check for valid arrayList (normal)
		assertNotNull("Check if there is a valid arraylist to add to", productList);
		// test to see if length of list is correct (boundary) 
		assertEquals("Check if procedure list size is same number as procedures added", 2, productList.size());
		// test if item added is the same as the first item in the list (error)
		assertSame("Check that product is added already exists in the list", p1, productList.get(0));
	}
	
	@Test // - Sheng En 
	public void viewProduct() {
		
		// test to see if there are products in the list (boundary)
		assertEquals("Check that there are items in the list", productList.size());
	}
	
	@Test // Sheng En 
	public void deleteProduct() {
		
		// test to see once product removed, list size decreases by 1 (normal)
		assertEquals("Test if product list becomes empty?", 0, productList.size());
		// test if the list is empty (boundary) 
		assertNotNull("Check if there are any products to be deleted", productList);
		// test that once product is deleted it should no longer be in the list (error)
		assertNotEquals("Test if there if the deleted product is still available to be displayed", 0, productList);
		
	}

}
