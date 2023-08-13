import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<RenovationService> services = new ArrayList<RenovationService>();
		
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

	
	//------------------------------------------------------------
	// add a new user
	//------------------------------------------------------------
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

	
	//------------------------------------------------------------
	// display all user details (view)
	//------------------------------------------------------------
	public static String retrieveAllUser(ArrayList<User> userList) {
		// TODO Auto-generated method stub
		String output = String.format("");
		for (int i = 0; i < userList.size(); i++) {
			if (userList != null) {
				String username = userList.get(i).getUsername();
				String email = userList.get(i).getEmail();
				//String password = userList.get(i).getPassword();
				int mobile = userList.get(i).getMobile();
				String address = userList.get(i).getAddress();
				
				output += String.format(address, username, email, mobile, address);
			}
		}
		return output;
	}
	

	//------------------------------------------------------------
	//static method takes in a user arraylist and performs the remove user functionality
	//It will return 'true' if the user record exist
	//------------------------------------------------------------
	public static boolean deleteUser(ArrayList<User> userList, int j) {
		// TODO Auto-generated method stub
		boolean userfound = false;
		
		String username = Helper.readString("\nEnter user's username: ");
		for (int i = 0; i < userList.size(); i++) {
			if (username.equalsIgnoreCase(userList.get(i).getUsername())) {
				userfound = true;
				userList.get(i).display();
				char choice = Helper.readChar("\nConfirm deletion? (y/n): ");
				if (choice == 'Y' || choice == 'y') {
					userList.remove(i);
					System.out.println("\n*** User has been deleted ***\n");	
				} 
			}
		}
		return false;
	}
	
	 //------------------------------------------------------------
	 // add a new service
	 //------------------------------------------------------------
	 public static void addNewService(ArrayList<RenovationService> services, String serviceName, String description, double price) {
	        RenovationService newService = new RenovationService(serviceName, description, price);
	        services.add(newService);
	        System.out.println("Service added successfully!");
	    }

	 
	 //------------------------------------------------------------
	 // display all service details (view)
     //------------------------------------------------------------
	 public static void viewAllServices(ArrayList<RenovationService> services) {
	        System.out.println("All Services:");
	        for (int i = 0; i < services.size(); i++) {
	            RenovationService service = services.get(i);
	            System.out.println("Service Name: " + service.getServiceName());
	            System.out.println("Description: " + service.getDescription());
	            System.out.println("Price: $" + service.getPrice());
	            System.out.println();
	        }
	    } 
	
	 //------------------------------------------------------------
	 // delete a service
	 //------------------------------------------------------------
	 public static void deleteService(ArrayList<RenovationService> services, String serviceName) {
	        RenovationService serviceToRemove = null;
	        for (int i = 0; i < services.size(); i++) {
	            RenovationService service = services.get(i);
	            if (service.getServiceName().equals(serviceName)) {
	                serviceToRemove = service;
	                break;
	            }
	        }

	        if (serviceToRemove != null) {
	            services.remove(serviceToRemove);
	            System.out.println("Service deleted: " + serviceName);
	        } else {
	            System.out.println("Service not found: " + serviceName);
	        }
	    }
	 
	 
	 //------------------------------------------------------------
	 // add a new service provider
	 //------------------------------------------------------------


		
	 //------------------------------------------------------------
	 // display all service provider details (view)
	 //------------------------------------------------------------
		

	 //------------------------------------------------------------
	 // delete a service provider
	 //------------------------------------------------------------
	 
	 
	 //------------------------------------------------------------
	 // add a new quote
	 //------------------------------------------------------------


		
	 //------------------------------------------------------------
	 // display all quote details (view)
	 //------------------------------------------------------------
		

	 //------------------------------------------------------------
	 // delete a quote
	 //------------------------------------------------------------
	 
	 
	 //------------------------------------------------------------
	 // add a new service request
	 //------------------------------------------------------------


		
	 //------------------------------------------------------------
	 // display all request details (view)
	 //------------------------------------------------------------
		

	 //------------------------------------------------------------
	 // delete a request
	 //------------------------------------------------------------
	 
	 
	 //------------------------------------------------------------
	 // add a new appointment
	 //------------------------------------------------------------


		
	 //------------------------------------------------------------
	 // display all appointment details (view)
	 //------------------------------------------------------------
		

	 //------------------------------------------------------------
	 // delete a appointment
	 //------------------------------------------------------------
}
