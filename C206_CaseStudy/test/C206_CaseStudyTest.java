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
	private ArrayList<RenovationService> serviceList;

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
		
		serviceList = new ArrayList<RenovationService>();
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
	//***ADD USER***
	@Test
	public void testAddUser() {
		// test that user list is not null and it is empty (boundary test)
		// ========== BOUNDARY TEST ==========
		assertNotNull("test if there is valid user arraylist to add to", userList);
		assertEquals("test that the user arraylist is empty", 0, userList.size());

		// given that the list is empty, after adding 1 item, the size of the list is 1
		// (normal test)
		// ========== NORMAL TEST ==========
		//C206_CaseStudy.addUser(userList, user1);
		userList.add(user1);
		assertEquals("test that the user arraylist is 1", 1, userList.size());
		assertSame("test that user1 has been added into the arraylist", user1, userList.get(0));

		// add a user (normal test)
		// ========== NORMAL TEST ==========
		//C206_CaseStudy.addUser(userList, user2);
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


		
		//***RETRIEVE/VIEW ALL USER***
		@Test
		public void testRetrieveAllUser() {
			// test that user list is not null and it is empty (boundary test)
			// ========== BOUNDARY TEST ==========
			assertNotNull("test if there is valid user arraylist to add to", userList);
			assertEquals("test that the user arraylist is empty", 0, userList.size());

			// ========== NORMAL TEST ==========
			userList.add(user1);
			assertEquals("test that the list retrieves 1 user", 1 , userList.size());
			
			// ========== ERROR TEST ==========
			//empty input fields
			User user3 = new User("", null, null, 0, null);
			C206_CaseStudy.addUser(userList, user3);
			assertEquals("test when field are empty, list remains as 1", 1, userList.size());
			
		}
		
		//***DELETE USER***
		@Test
		public void testDeleteUser() {
			// test that user list is not null and it is empty (boundary test)
						// ========== BOUNDARY TEST ==========
						assertNotNull("test if there is valid user arraylist to add to", userList);
						assertEquals("test that the user arraylist is empty", 0, userList.size());

						C206_CaseStudy.addUser(userList, user1);
						// normal
						C206_CaseStudy.deleteUser(userList, "jontan", "jontan@gmail.com", "jon123", 90123456, "76 smith street");

						//error
						assertEquals("test if there is no longer a vaild userList to delete from", 0, userList.size());
			
			
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
		    Serviceprovider maxProvider = new Serviceprovider(
		        "John private limted company and Services", 
		        "provide nice services and rapid with action. Non-sticky paint that reflects away light",
		        "painting and design",
		        65983421);
		    
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
	// ----------------- DONE BY JACOB --------------------------
	// -----------------------------------------------------------------

		@Test
		public void testAddNewService() {
		    // Normal test case: Adding a new service with valid details
		    assertEquals("Service list size should be 0 initially", 0, serviceList.size());

		    // Call the method to add a new service with valid details
		    C206_CaseStudy.addNewService(serviceList, "Painting", "Professional painting service", 150.0);

		    // Check if the service list size increases by 1 after adding
		    assertEquals("Service list size should be 1 after adding", 1, serviceList.size());

		    // Check if the added service matches the expected values
		    assertEquals("Service Name should match", "Painting", serviceList.get(0).getServiceName());
		    assertEquals("Description should match", "Professional painting service", serviceList.get(0).getDescription());
		    assertEquals("Price should match", 150.0, serviceList.get(0).getPrice(), 0.01);
		    
		    
		    

		    // Boundary test case: Adding a new service with minimum valid details
		    String serviceName = "Flooring";   // Service name with valid value
		    String description = "";           // Empty description
		    double price = 0.0;                // Minimum valid price

		    // Call the method to add a new service with minimum valid details
		    C206_CaseStudy.addNewService(serviceList, serviceName, description, price);

		    // Check if the service list size increases by 1 after adding
		    assertEquals("Service list size should be 2 after adding", 2, serviceList.size());

		    // Check if the added service matches the values provided
		    assertEquals("Service added should match the one in the list", serviceName, serviceList.get(1).getServiceName());
		    assertEquals("Description should match", description, serviceList.get(1).getDescription());
		    assertEquals("Price should match", price, serviceList.get(1).getPrice(), 0.01);
		    
		    
		    
		    // Error test case: Adding a service with missing name, which should fail
		    int initialServiceListSize = serviceList.size();

		    // Call the method to add a new service with empty service name
		    C206_CaseStudy.addNewService(serviceList, "", "Test description", 100.0);

		    // Check if the serviceList size remains the same after adding a service with an empty name
		    assertEquals("Service list size should remain the same", initialServiceListSize, serviceList.size());
		}



		@Test
	    //normal testing
	    public void testViewAllServices() {
	        // Create a sample service named service1 with details
	        RenovationService service1 = new RenovationService("Painting", "Professional painting service", 150.0);

	        // Create another sample service named service2 with different details
	        RenovationService service2 = new RenovationService("Flooring", "High-quality flooring solutions", 200.0);

	        // Add both sample services to the serviceList to simulate having services in the list
	        serviceList.add(service1);
	        serviceList.add(service2);

	        // Call the method to view all services in the serviceList
	        // The method doesn't return a value, it only displays information using System.out.println
	        // Therefore, the purpose of this test case is to check if the method executes without errors
	        C206_CaseStudy.viewAllServices(serviceList);
	    }



    @Test
	 // Test case: Deleting existing services 
	//NORMAL
	 public void testDeleteServices() {
	     // Normal test case: Deleting an existing service
	     RenovationService service1 = new RenovationService("Painting", "Professional painting service", 150.0);
	     serviceList.add(service1);

	     // Store the initial size of the serviceList
	     int initialSize = serviceList.size();

	     // Call the deleteService method to remove the service named "Painting"
	     C206_CaseStudy.deleteService(serviceList, "Painting");

	     // Check whether the size of the serviceList has reduced by 1
	     assertEquals("Service list size should be reduced by 1 after deletion", initialSize - 1, serviceList.size());

	     // Check that the deleted service is no longer in the list
	     assertFalse("Service 'Painting' should no longer be in the list", serviceList.contains(service1));
	     
	     
	     
	     //ERROR
	     // Error test case: Deleting a non-existing service
	     int initialSizeError = serviceList.size();
	     // Attempt to delete a non-existing service named "NonExistingService
	     C206_CaseStudy.deleteService(serviceList, "NonExistingService");

	     // Check that the size of the serviceList remains the same
	     assertEquals("Service list size should remain the same after error", initialSizeError, serviceList.size());
	 }


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



	@After
	public void tearDown() throws Exception {
		user1 = null;
		user2 = null;
	}

}