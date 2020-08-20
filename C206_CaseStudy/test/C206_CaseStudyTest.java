import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private product p1;
	private product p2;
	private product p3;
	
	private ArrayList<product> productList;
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		p1 = new product("spring onion", "Veg", 2.50);
		p2 = new product("chicken wing", "Meat", 2.67);
		p3 = new product("cauliflower", "Veg", 3.60);
		
		productList = new ArrayList<product>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	public void addProductTest() {
		// add a product normal 
		assertEquals("Check that product arraylist size is 1", 1, productList.size());
		assertSame("Check that product is added", p1, productList.get(1));
		
		//check that product added is not a duplicate 
		
		// check that there is a product ArrayList
		assertNotNull("Check if there is valid product arraylist to add to", productList);
	}
	
	public void viewProductTest() {
		
	}
	
	public void deleteProductTest() {
		
	}

}
