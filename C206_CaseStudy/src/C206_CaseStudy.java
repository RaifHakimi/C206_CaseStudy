import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();
		User u1 = new User("jontan", "jontan@gmail.com", "jon123", 90123456, "76 smith street");
		User u2 = new User("marylim", "marylim@gmail.com", "mary987", 80987654, "52 oak street");

		ArrayList<RenovationService> services = new ArrayList<RenovationService>();
		ArrayList<Serviceprovider> ServiceproviderList = new ArrayList<Serviceprovider>();

		ArrayList<quote> quoteList = new ArrayList<quote>();
		quoteList.add(new quote(1, "name", 1234, "deserecript"));

		// display menu and ask user for options
		int opt = -99;
		menu();

		// indefinite while loop
		while (opt != 6) {
			// boolean userfound = true;
			opt = Helper.readInt("\nEnter option or 0 for main menu: ");
			// check for options
			if (opt == 0) {
				// display menu;
				menu();
			} else if (opt == 1) {
				// add
				addMenu(userList, services, ServiceproviderList, quoteList);
			} else if (opt == 2) {
				// view
				viewListMenu(userList, services, ServiceproviderList, quoteList);
			} else if (opt == 3) {
				// delete
				deleteMenu(userList, services, ServiceproviderList, quoteList);
			} else if (opt == 4) {
				// log out
				System.out.println("\nYou have logged out of the system, good bye!");
			} else {
				// invalid option chosen
				System.out.println("\n*** Invalid option selected ***\n");
			}
		}
	}
	// END OF MAIN PROGRAM

//==========================================================
//==================== START OF METHODS ====================
//==========================================================

//==================== MENU METHODS ====================
	// ------------------------------------------------------------
	// static method to print main menu
	// ------------------------------------------------------------
	public static void menu() {
		Helper.line(45, "-");
		System.out.println("*****         RENOVATION PORTAL         *****");
		Helper.line(45, "-");
		System.out.print("1. Add User or Service\n");
		System.out.print("2. View User/services List\n");
		System.out.print("3. Delete User/Services List\n");
		System.out.print("4. Exit\n");
		Helper.line(45, "-");
	}

	// ------------------------------------------------------------
	// static method to print addMenu
	// ------------------------------------------------------------
	public static void addMenu(ArrayList<User> userList, ArrayList<RenovationService> services,
			ArrayList<Serviceprovider> serviceProviderList, ArrayList<quote> quoteList) {
		Helper.line(45, "-");
		System.out.print("1. Add user\n");
		System.out.print("2. Add service provider\n");
		System.out.print("3. Add a service\n");
		System.out.print("4. Add a quote\n");
		System.out.print("5. Add a request\n");
		System.out.print("6. Add a appointment\n");
		System.out.print("0. Exit\n");
		Helper.line(45, "-");
		int opt = Helper.readInt("Select a choice to add:  ");
		if (opt == 1) {
			// Insert Add user command
			String username = "";
			String email = "";
			String password = "";
			int mobile = -1;
			String address = "";
			User newUser = new User(username, email, password, mobile, address);
			addUser(userList, newUser);
		} else if (opt == 2) {
			// Add SERVICE PROVIDER
		} else if (opt == 3) {
			// ADD A SERVICE
			String serviceName = Helper.readString("Enter service name: ");
			String description = Helper.readString("Enter description: ");
			double price = Helper.readDouble("Enter price: ");
			addNewService(services, serviceName, description, price);
		} else if (opt == 4) {
			// ADD A QUOTE
			quote newQuote = addQuoteMenu();
			addQuote(quoteList, newQuote);
		} else if (opt == 5) {
			// ADD A REQUEST
		} else if (opt == 6) {
			// ADD APPOINTMENT
		} else if (opt == 0) {
			// EXIT
		} else {
			System.out.print("Invalid Option");
		}
	}

	// ------------------------------------------------------------
	// static method to print viewListMenu
	// ------------------------------------------------------------
	public static void viewListMenu(ArrayList<User> userList, ArrayList<RenovationService> services,
			ArrayList<Serviceprovider> serviceProviderList, ArrayList<quote> quoteList) {
		//
		// add if statement to check if user is admin or service provider IF POSSIBLE
		Helper.line(45, "-");
		System.out.print("1. View user list\n");
		System.out.print("2. View service provider list\n");
		System.out.print("3. View service list\n");
		System.out.print("4. View quote list\n");
		System.out.print("5. View request list\n");
		System.out.print("6. View appointment list\n");
		System.out.print("0. Exit\n");
		Helper.line(45, "-");
		int opt = Helper.readInt("Select a choice to view:  ");
		if (opt == 1) {
			// Insert VIEW USER
			String output = retrieveAllUser(userList);
			System.out.println("User List:\n" + output);
		} else if (opt == 2) {
			// VIEW SERVICE PROVIDER
		} else if (opt == 3) {
			// VIEW SERVICE
			viewAllServices(services);
		} else if (opt == 4) {
			// VIEW QUOTE
			viewQuote(quoteList);
		} else if (opt == 5) {
			// VIEW REQUEST
		} else if (opt == 6) {
			// VIEW APPOINTMENT
		} else if (opt == 0) {
			// EXIT
		} else {
			System.out.print("Invalid Option");
		}
	}

	// ------------------------------------------------------------
	// static method to print deleteMenu
	// ------------------------------------------------------------
	public static void deleteMenu(ArrayList<User> userList, ArrayList<RenovationService> services,
			ArrayList<Serviceprovider> serviceProviderList, ArrayList<quote> quoteList) {
		//
		// add if statement to check if user is admin or service provider IF POSSIBLE
		Helper.line(45, "-");
		System.out.print("1. Delete a user \n");
		System.out.print("2. Delete a service provider \n");
		//
		System.out.print("3. Delete a service \n");
		System.out.print("4. Delete a quote \n");
		System.out.print("5. Delete a request\n");
		System.out.print("6. Delete appointment\n");
		System.out.print("0. Exit\n");
		Helper.line(45, "-");
		int opt = Helper.readInt("Select a choice to delete:  ");
		if (opt == 1) {
			// Insert DELETE USER
		} else if (opt == 2) {
			// DELETE SERVICE PROVIDER
		} else if (opt == 3) {
			// DELETE SERVICE
		} else if (opt == 4) {
			// DELETE QUOTE
			int delQuote = deleteQuoteMenu();
			deleteQuote(quoteList, delQuote);
		} else if (opt == 5) {
			// DELETE REQUEST
		} else if (opt == 6) {
			// DELETE APPOINTMENT
		} else if (opt == 0) {
			// EXIT
		} else {
			System.out.print("Invalid Option");
		}
	}

//==========	
//==================== ADD/VIEW/DELETE USER METHODS ====================
//====================         DONE BY JOY          ====================
	// ------------------------------------------------------------
	// add a new user
	// ------------------------------------------------------------
	public static void addUser(ArrayList<User> userList, User addUser) {
		int bef = userList.size();
		// String email = addUser.getEmail().trim().toLowerCase(); // Trim and convert
		// to lowercase
		String username = Helper.readString("\nEnter username: ");
        String email = Helper.readString("\nEnter email: ");
        String password = Helper.readString("\nEnter password: ");
        int mobile = Helper.readInt("\nEnter mobile number: ");
        String address = Helper.readString("Enter address: ");

		email = email.trim().toLowerCase(); // Trim and convert to lowercase
		
		// Set the properties of the 'addUser' object
	    addUser.setUsername(username);
	    addUser.setEmail(email);
	    addUser.setPassword(password);
	    addUser.setMobile(mobile);
	    addUser.setAddress(address);
		
		if (email.endsWith("@gmail.com")) {
			boolean duplicate = false;
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getUsername().equals(addUser.getUsername())) {
					duplicate = true;
					System.out.println("\nUsername exists, please try with another username!");
					break;
				}
			}

			if (!duplicate) {
				userList.add(addUser);
				System.out.println("\nUser has been added successfully!");
			}
		} else if (username.isEmpty() || email.isEmpty() || password.isEmpty() || mobile <= 0 || address.isEmpty()) {
			System.out.println("\nPlease fill in all fields.");
		} else {
			System.out.println("\nInvalid email format, please try again!");
		}

		int aft = userList.size();
		if (aft > bef) {
			System.out.println("\nTotal users in the list: " + aft);
		}
	}

	// ------------------------------------------------------------
	// display all user details (view)
	// ------------------------------------------------------------
	public static String retrieveAllUser(ArrayList<User> userList) {
	    String output = ""; // Initialize the output string
	    for (int i = 0; i < userList.size(); i++) {
	        User user = userList.get(i); // Get the current user
	        // Append user details to the output string
	        output += String.format("%-20s%-35s%-8d%-50s", "Username:", "Email:", 
	        		"Mobile:", "Address", 
	            user.getUsername(), user.getEmail(), user.getMobile(), user.getAddress());
	    }
	    return output;
	}

	// ------------------------------------------------------------
	// static method takes in a user arraylist and performs the remove user
	// functionality
	// It will return 'true' if the user record exist
	// ------------------------------------------------------------
	public static boolean deleteUser(ArrayList<User> userList, String string, String string2, String string3, int j,
			String string4) {
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
			} else {
				System.out.println("*** User not found! ***\n");
			}
		}
		return false;
	}

//==================== ADD/VIEW/DELETE SERVICE METHODS ====================
//====================          DONE BY JACOB          ====================
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
			 // update a service
			 //------------------------------------------------------------
		 public static boolean updateService(ArrayList<RenovationService> services, String serviceName, String newDescription, double newPrice) {
			    for (int i = 0; i < services.size(); i++) {
			        RenovationService service = services.get(i);
			        if (service.getServiceName().equals(serviceName)) {
			            // Update the description and price of the matching service
			            service.setDescription(newDescription);
			            service.setPrice(newPrice);
			            return true; // Successfully updated
			        }
			    }
			    return false; // Service not found, update failed
			}


		 //This method returns a RenovationService object if a match is found or null if no match is found.
		 public static RenovationService searchService(ArrayList<RenovationService> services, String serviceName) {
			    // Loop through the list of services to find a match
			    for (RenovationService service : services) {
			        // Check if the current service's name matches the target service name
			        if (service.getServiceName().equals(serviceName)) {
			            return service; // Found a matching service
			        }
			    }
			    return null; // No matching service found
			}

		 
		 //This method will display the details of the services provided in the serviceNames array, allowing users to compare them side by side.
		 public static void compareServices(ArrayList<RenovationService> services, String[] serviceNames) {
			    // Loop through the array of service names to compare
			    for (int i = 0; i < serviceNames.length; i++) {
			        // Get the current service name from the array
			        String serviceName = serviceNames[i];
			        
			        // Search for the service with the current name in the list of services
			        RenovationService service = searchService(services, serviceName);
			        
			        // If the service is found, display its details
			        if (service != null) {
			            System.out.println("Service Name: " + service.getServiceName());
			            System.out.println("Description: " + service.getDescription());
			            System.out.println("Price: $" + service.getPrice());
			            System.out.println();
			        } else {
			            // If the service is not found, display a message
			            System.out.println("Service not found: " + serviceName);
			        }
			    }
			}

//==================== ADD/VIEW/DELETE SERVICE PROVIDER METHODS ====================
	// ------------------------------------------------------------
	// add a new service provider
	// ------------------------------------------------------------

	// ------------------------------------------------------------
	// display all service provider details (view)
	// ------------------------------------------------------------

	// ------------------------------------------------------------
	// delete a service provider
	// ------------------------------------------------------------

//==================== ADD/VIEW/DELETE QUOTE METHODS ====================
//====================          DONE BY RAIF         ====================
	// ------------------------------------------------------------
	// add a new quote
	// ------------------------------------------------------------
	public static quote addQuoteMenu() {
		quote quoteDetails;
		int id = Helper.readInt("Insert ID: ");
		String name = Helper.readString("Insert Name: ");
		int num = Helper.readInt("Insert Mobile Number: ");
		String desc = Helper.readString("Enter a description: ");
		quoteDetails = new quote(id, name, num, desc);
		return quoteDetails;
	}

	public static void addQuote(ArrayList<quote> quoteList, quote addQuote) {
		boolean check = true;
		for (int i = 0; i < quoteList.size(); i++) {
			if (quoteList.get(i).equals(addQuote)) {
				check = false;
				break;
			}
		}
		if (check == false) {
			System.out.print("Quote already exist");
		} else {
			quoteList.add(addQuote);
		}

	}

	// ------------------------------------------------------------
	// display all quote details (view)
	// ------------------------------------------------------------
	public static String retrieveQuote(ArrayList<quote> quoteList) {
		String msg = "";
		for(int i = 0 ; i < quoteList.size() ; i++) {
			msg += String.format("%20d%20s%20d%20s",quoteList.get(i).getId(),quoteList.get(i).getName(),quoteList.get(i).getNum(), quoteList.get(i).getDesc());
		}
		return msg;
	}

	public static void viewQuote(ArrayList<quote> quoteList) {
		System.out.print(
				"***************************************************************************************************************\n");
		System.out.print(
				"**************************************  QUOTE LIST  ***********************************************************\n");
		System.out.print(
				"***************************************************************************************************************\n");
		String msg = String.format("|  %-2s  |  %-4s  |  %-14s  |  %-30s  |\n", "ID", "NAME", "CONTACT NUMBER",
				"DESCRIPTION");
		for (int i = 0; i < quoteList.size(); i++) {

			msg += String.format("|  %-2d  |  %-4s  |  %-14d  |  %-30s  |\n", quoteList.get(i).getId(),
					quoteList.get(i).getName(), quoteList.get(i).getNum(), quoteList.get(i).getDesc());
		}

		System.out.print(msg);
		System.out.print(
				"***************************************************************************************************************\n");

	}

	// ------------------------------------------------------------
	// delete a quote
	// ------------------------------------------------------------
	public static int deleteQuoteMenu() {
		int id = Helper.readInt("Select ID to delete");
		return id;
	}

	public static void deleteQuote(ArrayList<quote> quoteList, int id) {
		boolean check = false;
		if (id < 0) {
			System.out.print("Error: Negative ID");
		} else {

			for (int i = 0; i < quoteList.size(); i++) {
				if (id == quoteList.get(i).getId()) {
					quoteList.remove(i);
					check = true;
				}
			}
		}
		if (check == true) {
			System.out.print("Deletion Successful\n");
		} else {
			System.out.print("Deletion Unsuccessful \n");
		}

	}



//==================== ADD/VIEW/DELETE REQUEST METHODS ====================	 
//====================          DONE BY DAVIN          ====================
	// ------------------------------------------------------------
	// add a new request
	// ------------------------------------------------------------

	// ------------------------------------------------------------
	// display all request details (view)
	// ------------------------------------------------------------

	// ------------------------------------------------------------
	// delete a request
	// ------------------------------------------------------------

//==================== ADD/VIEW/DELETE APPOINTMENT METHODS ====================	 
	// ------------------------------------------------------------
	// add a new appointment
	// ------------------------------------------------------------

	// ------------------------------------------------------------
	// display all appointment details (view)
	// ------------------------------------------------------------

	// ------------------------------------------------------------
	// delete a appointment
	// ------------------------------------------------------------
}
