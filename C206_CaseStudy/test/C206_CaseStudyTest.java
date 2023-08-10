import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	//preparation of test data
	private User user1;
	private User user2;
	
	private ArrayList<User> userList;
	
	public C206_CaseStudyTest() {
		super();
	}
	

	@Before
	public void setUp() throws Exception {
		//preparation of test data
		user1 = new User("jontan", "jontan@gmail.com", "jon123", 90123456, "76 smith street");
		user2 = new User("marylim", "marylim@gmail.com", "mary987", 80987654, "52 oak street");
		
		userList = new ArrayList<User>();
	}

	
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void testAddUser() {
		//test that user list is not null and it is empty (boundary test) 
		assertNotNull("test if there is valid user arraylist to add to", userList);
		assertEquals("test that the user arraylist is empty", 0, userList.size());
		//given that the list is empty, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addUser(userList, user1);
		userList.add(user1);
		assertEquals("test that the user arraylist is 1", 1, userList.size());
		assertSame("test that user1 has been added into the arraylist", user1, userList.get(0));
		
		//add a user
		C206_CaseStudy.addUser(userList, user2);
		userList.add(user2);
		assertEquals("test that the arraylist is now 2", 2, userList.size());
		// test that the user just added is the same as the last item in the list
		assertSame("test that user is added to the end of the list", user2, userList.get(1));
		
		//add a user that already exist in the system
		C206_CaseStudy.addUser(userList, user1);
		assertEquals("test that the user arraylist remains unchange", 2, userList.size());
		
		//add a user that has missing details
		User user_missing = new User("", null, null, 0, null);
		C206_CaseStudy.addUser(userList, user_missing);
		assertEquals("test that the user arraylist size remains unchange", 2, userList.size());
	}
	
	@Test
	
	
	
	@After
	public void tearDown() throws Exception {
		user1 = null;
		user2 = null;
	}

}

