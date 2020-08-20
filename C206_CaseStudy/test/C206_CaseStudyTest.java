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

	@Before
	public void setUp() throws Exception {

		// preparing test data for Transaction - soon chuan
		tt0 = new Transaction("John", "Ms Lee", "Pencil", "2B Pencil", "Exchange Rejeceted");
		tt1 = new Transaction("John123", "Ms Lee", "Pen", "Ball-point pen", "Exchange Accepted");
		tt2 = new Transaction("Mary", "Mr Tan", "Bottle", "Thermal flask", "Exchange Rejected");
		transactionList = new ArrayList<Transaction>();
		transactionList.add(tt0);

	}

	@After
	public void tearDown() throws Exception {

		// for transaction - soon chuan
		tt1 = null;
		tt2 = null;
		transactionList = null;

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
	
	//tests for archiving transactions - soon chuan
	public void archiveTransactionTest() {
		//normal: archived transactions should no longer show up in transactionList
		int currentSize = transactionList.size();
		transactionList.remove(0);
		
		assertNotSame(currentSize, transactionList.size());
		
	}

}
