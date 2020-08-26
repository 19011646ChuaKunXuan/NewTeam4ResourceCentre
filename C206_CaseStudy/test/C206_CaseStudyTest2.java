import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest2 {

	private ArrayList<Customer> customerList;
	
	// product for test - Sheng En
	private product p1;
	private product p2;
	private product p3;
	
	private ArrayList<product> productList;
	
	

	@Before
	public void setUp() throws Exception {
		
		// preparing test data for product - Sheng En 
		p1 = new product("cauliflower", 3.60, "food", "Giant", "1 kilogram");
		p2 = new product("towel", 0.80, "toiletries", "Giant", "water absorbant");
		p3 = new product("chicken wings", 2.67, "food", "Giant", "300 grams");
		
		productList = new ArrayList<product>();

	}

	@After
	public void tearDown() throws Exception {
		
		// for Product - Sheng En
				p1 = null;
				p2 = null;
				p3 = null;
				productList = null;
		
		
	}
	
	@Test // - Sheng En
	public void addProduct() {
		C206_CaseStudy.addProduct(productList, p1);
		// test to check for valid arrayList (normal)
		assertNotNull("Check if there is a valid arraylist to add to", productList);
		// test to see if length of list is correct (boundary) 
		assertEquals("Check if procedure list size is same number as procedures added", 2, productList.size());
		// test if item added is the same as the first item in the list (error)
		assertSame("Check that product is added already exists in the list", p1, productList.get(0));
	}
	
	@Test // - Sheng En 
	public void viewProduct() {
		C206_CaseStudy.retrieveAllProduct(productList);
		// test to see if there are products in the list (boundary)
		assertEquals("Check that there are items in the list", productList.size());
		// test that all items can be displayed (normal)
		String testOutput = String.format("%-20s %s %-20s %-20s %-20s\n", productList.get(0).toString());
		testOutput += String.format("%-20s %s %-20s %-20s %-20s\n", productList.get(1).toString());
		assertEquals("check that all items can be displayed", testOutput);
		// test that item searched exists in the list (error)
		String test = "";
		assertEquals("test that item is in the list", test, C206_CaseStudy.retrieveAllProduct(productList));
	}
	
	@Test // - Sheng En 
	public void deleteProduct() {
		
		// test to see once product removed, list size decreases by 1 (normal)
		assertEquals("Test if product list becomes empty?", 0, productList.size());
		// test if the list is empty (boundary) 
		assertNotNull("Check if there are any products to be deleted", productList);
		// test that once product is deleted it should no longer be in the list (error)
		assertNotEquals("Test if there if the deleted product is still available to be displayed", 0, productList);
		
	}
	
	@Test // - Sheng En
	public void updateProduct() {
		C206_CaseStudy.retrieveAllProduct(productList);
		// test that product to update is in the list (normal)
		product test2 = new product(null, 0, null, null, null);
		productList.add(test2);
		assertEquals("check if item is in the list", test2, C206_CaseStudy.retrieveAllProduct(productList)); 
		// test that if the list is empty, no updates can take place (boundary)
		assertNotNull("check if there are any items in the list to update", productList);
		// test that after update, item can be found in the list (error)
		product updatedP = productList.get(0);
		updatedP.setPrice(0); 
		assertEquals("check if update item information can be found", updatedP, C206_CaseStudy.retrieveAllProduct(productList));
	}
	
	@Test // - Sheng En
	public void returnProduct() {
		// test that if conditions are not met, product cannot be returned (normal)
		int conditions = 0;
		assertEquals("check that product to be returned matched conditions", productList.get(conditions));
		// test that product return conditions cannot be viewed if list is empty (boundary)
		assertNotNull("check that the list is not empty", productList.size());
		// test that item has to exist in the list before it can be returned (error) 
		String test2 = "";
		assertEquals("test that item is in the list", test2, C206_CaseStudy.retrieveAllProduct(productList));
	}

}
