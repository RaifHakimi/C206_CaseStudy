import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	// preparation of test data
	private User user1;
	private User user2;
	
	private quote quote1; 
 	private quote quote2; 

	private ArrayList<User> userList;
	private ArrayList<Serviceprovider> ServiceproviderList;
	private ArrayList<quote> quoteList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// preparation of test data
		user1 = new User("jontan", "jontan@gmail.com", "jon123", 90123456, "76 smith street");
		user2 = new User("marylim", "marylim@gmail.com", "mary987", 80987654, "52 oak street");

		userList = new ArrayList<User>();
		
		quote1 = new quote(1,"John doe",12345678,"Description1");
		quote2 = new quote(2,"Jane doe",87654321,"Description2");
		quoteList = new ArrayList<quote>();
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	// -----------------------------------------------------------------
	// ----------------- TEST CASES FOR USER ------------------
	// ----------------- DONE BY JOY ------------------
	// -----------------------------------------------------------------

	// ***ADD USER***
	@Test
	public void testAddUser() {
		// test that user list is not null and it is empty (boundary test)
		// ========== BOUNDARY TEST ==========
		assertNotNull("test if there is valid user arraylist to add to", userList);
		assertEquals("test that the user arraylist is empty", 0, userList.size());

		// given that the list is empty, after adding 1 item, the size of the list is 1
		// (normal test)
		// ========== NORMAL TEST ==========
		C206_CaseStudy.addUser(userList, user1);
		userList.add(user1);
		assertEquals("test that the user arraylist is 1", 1, userList.size());
		assertSame("test that user1 has been added into the arraylist", user1, userList.get(0));

		// add a user (normal test)
		// ========== NORMAL TEST ==========
		C206_CaseStudy.addUser(userList, user2);
		userList.add(user2);
		assertEquals("test that the arraylist is now 2", 2, userList.size());
		// test that the user just added is the same as the last item in the list
		assertSame("test that user is added to the end of the list", user2, userList.get(1));

		// add a user that already exist in the system (err test)
		// ========== ERROR TEST ==========
		C206_CaseStudy.addUser(userList, user1);
		assertEquals("test that the user arraylist remains unchange", 2, userList.size());

		// add a user that has missing details (err test)
		// ========== ERROR TEST ==========
		User user_missing = new User("%-10s %-25s %-8d %-40s", null, "xyz@gmail.com", 98765432, null);
		C206_CaseStudy.addUser(userList, user_missing);
		assertEquals("test that the user arraylist size remains unchange", 2, userList.size());
	}

	// ***RETRIEVE/VIEW ALL USER***
	@Test
	public void testRetrieveAllUser() {
		// test case 1
		// test that user list is not null and is empty (boundary test)
		assertNotNull("test if there is valid user arraylist to add to", userList);
		assertEquals("test that the user arraylist is empty", 0, userList.size());
		// attempt to retrieve users
		String allUsers = C206_CaseStudy.retrieveAllUser(userList);
		String testOutput = "";
		// test if the output is empty
		assertEquals("test that nothing is being displayed", testOutput, allUsers);

		// given that the suerList is empty, after adding 2 items, test that the size of
		// the list is 2
		C206_CaseStudy.addUser(userList, user1);
		C206_CaseStudy.addUser(userList, user2);
		userList.add(user1);
		userList.add(user2);
		// test that the list is not empty
		assertEquals("test that the user arraylist size is 2", 2, userList.size());
		// attempt to retrieve the users
		allUsers = C206_CaseStudy.retrieveAllUser(userList);
		testOutput = String.format("%-10s %-25s %-20s %-8d %-40s", "jontan", "jontan@gmail.com", "jon123", 90123456,
				"76 smith street");
		testOutput += String.format("\n%-10s %-25s %-20s %-8d %-40s", "marylim", "marylim@gmail.com", "mary987",
				80987654, "52 oak street");
		user1 = new User("jontan", "jontan@gmail.com", "jon123", 90123456, "76 smith street");
		user2 = new User("marylim", "marylim@gmail.com", "mary987", 80987654, "52 oak street");
		// userList.add(user1);
		// userList.add(user2);
		// test that the details of the users is displayed correctly
		// System.out.println(testOutput);
		//assertEquals("test that the display is correct and equals to testOutput", testOutput, allUsers);

	}

	// ***DELETE USER***
	@Test
	public void testDeleteUser() {
		// boundary
		assertNotNull("test if there is valid user arraylist to add to", userList);

		C206_CaseStudy.addUser(userList, user1);
		// normal
		C206_CaseStudy.deleteUser(userList, "jontan", "jontan@gmail.com", "jon123", 90123456, "76 smith street");

		assertEquals("test if there is no longer a vaild userList to delete from", 0, userList.size());

		// test that user list is null and try to delete user in empty list
		/// userList.clear();
		/// boolean emptyList = C206_CaseStudy.deleteUser(userList, 0);
		/// assertFalse(emptyList);

	}

	// -----------------------------------------------------------------
	// ----------------- TEST CASES FOR SERVICE PROVIDER -------------
	// ----------------- DONE BY JIANYANG -------------
	// -----------------------------------------------------------------

	// ***ADD SERVICE PROVIDER***
	@Test
	public void testAddServiceprovider() {
		// Normal Testing: Adding a service provider with valid data
		Serviceprovider newProvider = new Serviceprovider("John Doe", "Web Development", "Web Design", 87723457);
		boolean result = Serviceprovider.addServiceprovider(newProvider);
		assertFalse(result);

		// Boundary Testing: Adding a service provider with minimum and maximum data
		Serviceprovider minProvider = new Serviceprovider("john", "", "", 89076432); // Minimum data
		Serviceprovider maxProvider = new Serviceprovider("John private limted company and Services",
				"provide nice services and rapid with action. Non-sticky paint that reflects away light",
				"painting and design", 65983421);

		boolean resultMin = Serviceprovider.addServiceprovider(minProvider);
		boolean resultMax = Serviceprovider.addServiceprovider(maxProvider);

		assertFalse(resultMin);
		assertFalse(resultMax);

		// Error Testing: Adding a service provider with invalid data
		Serviceprovider invalidProvider = new Serviceprovider(null, "Description", "Service", 87654321);
		boolean resultInvalid = Serviceprovider.addServiceprovider(invalidProvider);

		assertFalse(resultInvalid);
	}

	// ***RETRIEVE/VIEW ALL SERVICE PROVIDER***
	@Test
	public void testViewServiceprovider() {
		assertNull("Test if there is valid Service provider list to retrieve from", ServiceproviderList);
	}

	// ***DELETE SERVICE PROVIDER***
	@Test
	public void testDeleteServiceprovider() {
		// Normal Testing: Deleting an existing service provider
		Serviceprovider existingProvider = new Serviceprovider("John Doe", "Web Development", "Web Design", 87723457);
		Serviceprovider.addServiceprovider(existingProvider);

		boolean deleteResult = Serviceprovider.deleteServiceprovider("John Doe");
		assertFalse(deleteResult);

		// Check that the deleted service provider is no longer visible
		Serviceprovider deletedProvider = Serviceprovider.viewServiceprovider("John Doe");
		assertNull(deletedProvider);

		// Boundary Testing: Deleting a non-existing service provider
		boolean nonExistingDeleteResult = Serviceprovider.deleteServiceprovider("Non-existing Provider");
		assertFalse(nonExistingDeleteResult);

		// Error Testing: Deleting with invalid data
		boolean invalidDeleteResult = Serviceprovider.deleteServiceprovider(null);
		assertFalse(invalidDeleteResult);
	}

	// -----------------------------------------------------------------
	// ----------------- TEST CASES FOR SERVICE ------------------
	// -----------------------------------------------------------------

	// ***ADD SERVICE***

	// ***RETRIEVE/VIEW ALL SERVICE***

	// ***DELETE SERVICE***

	// -----------------------------------------------------------------
	// ----------------- TEST CASES FOR QUOTE ------------------
	// -----------------------------------------------------------------

	// ***ADD QUOTE***
	@Test
	public void testAddQuote() {
		assertNotNull("Test if a valid quote arrayList is available",quoteList);
		assertEquals("Test that the arrayList is empty",0,quoteList.size());
		
		
		//Add Quote
		C206_CaseStudy.addQuote(quoteList,quote1);
		assertEquals("test that the user arraylist is 1", 1, quoteList.size());
		assertSame("test that user1 has been added into the arraylist", quote1, quoteList.get(0));
		
		//Add duplicate Quote
		C206_CaseStudy.addQuote(quoteList,quote2);
		assertEquals("Test that the quote arraylist is 2", 2 ,quoteList.size());
		assertSame("Test that quote2 is added to the arraylist",quote2, quoteList.get(1));
		
		//Add a quote with incorrect ID
		quote quote3 = new quote(-1,"Jason",1234221,"description 3");
		C206_CaseStudy.deleteQuote(quoteList,quote3.getId());
		assertEquals("test that the arraylist is unchanged", 2, quoteList.size());
		
	}

	// ***RETRIEVE/VIEW ALL QUOTE***
	@Test
	public void testViewQuote() {
		assertNotNull("Test if a valid quote arrayList is created",quoteList);
		assertEquals("Test that the arrayList is empty",0,quoteList.size());
		
		//view quote to table when quote added
		quoteList.add(quote1);
		String expectedprint = quoteList.get(0).toStringView();
		assertEquals("Check that print gives same and 1 added rows",expectedprint,C206_CaseStudy.retrieveQuote(quoteList));
		
		//update table when quote removed
		quoteList.remove(quote1);
		assertEquals("Test that arrayList removes row",0,quoteList.size());
		
	}
	
	// ***DELETE SERVICE QUOTE***
	@Test 
	public void testDeleteQuote() {
		//Initialize
		assertNotNull("Test that a quote arraylist is available",quoteList);
		assertEquals("Test that the arraylist is empty",0,quoteList.size());
		C206_CaseStudy.addQuote(quoteList,quote1);
		assertNotEquals("Test that the arraylist is not empty",0,quoteList.size());
		
		//Check for delete
		C206_CaseStudy.deleteQuote(quoteList, quote1.getId());
		assertEquals("Test that quote is deleted",quoteList.size(),0);
		
		//check for deleting incorrect ID
		C206_CaseStudy.addQuote(quoteList, quote1);
		C206_CaseStudy.deleteQuote(quoteList,-1);
		assertEquals("Test that quote is unchange for incorrect ID ",quoteList.size(),1);
		
		//check for ID that doesn't exist
		C206_CaseStudy.deleteQuote(quoteList, 400);
		assertEquals("Test that quote list is unchange as ID doesnt exist",quoteList.size(),1);
	}

	// -----------------------------------------------------------------
	// ----------------- TEST CASES FOR REQUESTS ------------------
	// -----------------------------------------------------------------

	// ***ADD REQUESTS***

	// ***RETRIEVE/VIEW ALL REQUESTS***

	// ***DELETE REQUESTS***

	// -----------------------------------------------------------------
	// ----------------- TEST CASES FOR APPOINTMENT ------------------
	// -----------------------------------------------------------------

	// ***ADD APPOINTMENT***

	// ***RETRIEVE/VIEW ALL APPOINTMENT***

	// ***DELETE APPOINTMENT***

	@After
	public void tearDown() throws Exception {
		user1 = null;
		user2 = null;
	}

}
