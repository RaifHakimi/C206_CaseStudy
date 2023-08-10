import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();
		
		//display menu and ask user for options
		int opt = -99;
		menu();
		
		//indefinite while loop
		while(opt != -90) {
			opt = Helper.readInt("\nEnter option or 0 for main menu > ");
		
			//check for options
			if (opt == 0) {
				//display menu;
				menu();
			} else if (opt == 1) {
				//register for account 
			} else if (opt == 2) {
				//login account as admin, user or service provider
			} else if (opt == 3) {
				//add
			} else if (opt == 4) {
				//view
			} else if (opt == 5) {
				//delete
			} else if (opt == 6){
				//log out
				System.out.println("\nYou have logged out of the system, good bye!");
			} else {
				//invalid option chosen
				System.out.println("\n*** Invalid option selected ***\n");
			}
		}
	} //end of main 

	public static void addUser(ArrayList<User> userList, User addUser) {
		// TODO Auto-generated method stub
		int bef = userList.size();
		User user = addUser;
		if (user.getEmail().endsWith("@gmail.com" )) {
			boolean duplicate = false;
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getUsername().equals(user.getUsername())) {
					duplicate = true;
					System.out.println("Username exists, please try with another username!");
					break;
				}
			}
			if (duplicate == false) {
				userList.add(addUser);
			}
		} else {
			System.out.println("Invalid email format, please try again!");			
		}
		
		int aft = userList.size();
		if (aft > bef ) {
			System.out.println("\nUser has been added successfully!");
		}
	}
	
	public static String retrieveAllUser(ArrayList<User> userList) {
		// TODO Auto-generated method stub
		String output = "";
		for (int i = 0; i < userList.size(); i++) {
			output += String.format("", 
					userList.get(i).getUsername(), 
					userList.get(i).getEmail(), 
					userList.get(i).getPassword(), 
					userList.get(i).getMobile(),
					userList.get(i).getAddress());
		}
		return output;
	}

	//------------------------------------------------------------
	// static method to print menu
	//------------------------------------------------------------
	public static void menu() {
		Helper.line(45, "-");
		System.out.println("*****         RENOVATION PORTAL         *****");
		Helper.line(45, "-");
		System.out.println("1. Register for an account\n"
				+ "2. Login account\n"
				+ "3. Add User/Service Provider/Service/Quote/Request/Appointment\n"
				+ "4. View User/Service Provider/Service/Quote/Request/Appointment\n"
				+ "5. Delete User/Service Provider/Service/Quote/Request/Appointment\n"
				+ "6. Exit");
	
		
	}

		

}
