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
	
	

	@Before
	public void setUp() throws Exception {

		// preparing test data for Transaction - soon chuan
		tt0 = new Transaction("John", "Ms Lee", "Pencil", "2B Pencil", "Exchange Rejeceted");
		tt1 = new Transaction("John123", "Ms Lee", "Pen", "Ball-point pen", "Exchange Accepted");
		tt2 = new Transaction("Mary", "Mr Tan", "Bottle", "Thermal flask", "Exchange Rejected");
		transactionList = new ArrayList<Transaction>();
		transactionList.add(tt0);

		// preparing test data for Procedure - Leonard
		pr1 = new Procedure("Transactions cannot be refunded after 20 days", "refund");
		pr2 = new Procedure("If items are extremely damaged, it cannot be exchanged", "exchange");
		pr3 = new Procedure("If purchase happend more than 30 days ago, item cannot be returned", "return");

		procedureList = new ArrayList<Procedure>();

	}



	@After
	public void tearDown() throws Exception {

		// for transaction - soon chuan
		tt1 = null;
		tt2 = null;
		transactionList = null;

		// for Procedure - Leonard
		pr1 = null;
		pr2 = null;
		pr3 = null;
		procedureList = null;
	}



	@Test
	// Tests for adding transaction - soon chuan
	public void addTransactionTest() {
		// normal: transactions should be added into its dedicated list
		assertNotNull("Check if there is valid Transaction arraylist to add to", transactionList);

		// error: transaction cannot be added if name contains numbers
		assertFalse(tt1.getHandlingStaff().matches("^[a-zA-Z]*$"));

		// boundary: added transaction must be different
		assertFalse(tt2.equals(transactionList.get(0)));

	}

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

	// tests for archiving transactions - soon chuan
	public void archiveTransactionTest() {
		// normal: archived transactions should no longer show up in transactionList
		int currentSize = transactionList.size();
		transactionList.remove(0);

		assertNotSame(currentSize, transactionList.size());

	}

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

	public void viewProcedureTest() {
		// Check if every procedure is added into the list correctly - Leonard
		C206_CaseStudy.addProcedure(procedureList, pr1);
		C206_CaseStudy.addProcedure(procedureList, pr2);
		assertEquals("Check that procedure list has 2 procedures", 2, procedureList.size());

	}

}
