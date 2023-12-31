import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();
		User u1 = new User("jontan", "jontan@gmail.com", "jon123", 90123456, "76 smith street");
		User u2 = new User("marylim", "marylim@gmail.com", "mary987", 80987654, "52 oak street");
	    userList.add(u1);
	    userList.add(u2);

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
				addMenu(userList, services, quoteList, ServiceproviderList);
			} else if (opt == 2) {
				// view
				viewListMenu(userList, services, quoteList, ServiceproviderList);
			} else if (opt == 3) {
				// delete
				//String serviceNameToDelete = Helper.readString("Enter the service name to delete: ");        
				//deleteService(services, serviceNameToDelete);
				deleteMenu(userList, services, quoteList, ServiceproviderList);
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
			ArrayList<quote> quoteList, ArrayList<Serviceprovider> ServiceproviderList) {
		Helper.line(45, "-");
		System.out.print("1. Add user\n");
		System.out.print("2. Add service provider\n");
		System.out.print("3. Add a service\n");
		System.out.print("4. Add a quote\n");
		System.out.print("5. Add a request\n");
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
			System.out.println("\nADD SERVICE PROVIDER\n");
	    	  Serviceprovider sp = inputServiceprovider();
	    	  
	    	  boolean nameExists = spNameExists(ServiceproviderList, sp.getName());
	    	  boolean contactExists = spcontactExists(ServiceproviderList, sp.getContactnum());
	    	  boolean validContact = isValidContact(sp.getContactnum());
	    	  
	    	  if (nameExists) {
	    	        System.out.println("\nName already exists. Enter again.");
	    	  } else if (contactExists) {
	    	        System.out.println("Contact number already exists. Enter again.");
	    	  } else if (!validContact) {
	    	        System.out.println("Invalid contact number. Enter again (8 digits).");
	    	  } else {
	    		  	C206_CaseStudy.addServiceprovider(ServiceproviderList, sp);	
	    		  	System.out.println("\n**** Service provider added ****");
	    	  }
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
			ArrayList<quote> quoteList, ArrayList<Serviceprovider> ServiceproviderList) {
		//
		// add if statement to check if user is admin or service provider IF POSSIBLE
		Helper.line(45, "-");
		System.out.print("1. View user list\n");
		System.out.print("2. View service provider list\n");
		System.out.print("3. View service list\n");
		System.out.print("4. View quote list\n");
		System.out.print("5. View request list\n");
		System.out.print("0. Exit\n");
		Helper.line(45, "-");
		int opt = Helper.readInt("Select a choice to view:  ");
		if (opt == 1) {
			// Insert VIEW USER
			String output = retrieveAllUser(userList);
			System.out.println("User List:\n" + output);
		} else if (opt == 2) {
			// VIEW SERVICE PROVIDER
			System.out.println("\nVIEWING ALL SERVICE PROVIDER");
	    	  C206_CaseStudy.viewServiceprovider(ServiceproviderList); 
		} else if (opt == 3) {
			// VIEW SERVICE
			viewAllServices(services);
		} else if (opt == 4) {
			// VIEW QUOTE
			viewQuote(quoteList);
		} else if (opt == 5) {
			// VIEW REQUEST
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
			ArrayList<quote> quoteList, ArrayList<Serviceprovider> ServiceproviderList) {
		//
		// add if statement to check if user is admin or service provider IF POSSIBLE
		Helper.line(45, "-");
		System.out.print("1. Delete a user \n");
		System.out.print("2. Delete a service provider \n");
		//
		System.out.print("3. Delete a service \n");
		System.out.print("4. Delete a quote \n");
		System.out.print("5. Delete a request\n");
		System.out.print("0. Exit\n");
		Helper.line(45, "-");
		int opt = Helper.readInt("Select a choice to delete:  ");
		if (opt == 1) {
			// Insert DELETE USER
			deleteUser(userList);
		} else if (opt == 2) {
			// DELETE SERVICE PROVIDER
			System.out.println("\nDELETE SERVICE PROVIDER");
	    	  String spname = Helper.readString("\nEnter name of Service provider to delete > ");
	    	  boolean found = false;
	    	  for (Serviceprovider sp : ServiceproviderList) {
	    		  if (sp.getName().equalsIgnoreCase(spname)) {
	    			  ServiceproviderList.remove(sp); // Remove the matching service provider
	    	          found = true;
	    	          System.out.println("**** Service provider " + spname + " has been removed ****");
	    	          break; // Exit the loop after deletion
	    	        }
	    	    }
	    	    
	    	  if (!found) {
	    	        System.out.println("Service provider '" + spname + "not found in the list.");
	    	  }
		} else if (opt == 3) {
			// DELETE SERVICE
			String serviceNameToDelete = Helper.readString("Enter the service name to delete: ");        
			deleteService(services, serviceNameToDelete);
		} else if (opt == 4) {
			// DELETE QUOTE
			int delQuote = deleteQuoteMenu();
			deleteQuote(quoteList, delQuote);
		} else if (opt == 5) {
			// DELETE REQUEST
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
		// String email = addUser.getEmail().trim().toLowerCase(); // Trim and convert to lowercase
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
		        // Check if the mobile number is 8 digits
		        if (String.valueOf(mobile).length() == 8) {
		            userList.add(addUser);
		            System.out.println("\nUser has been added successfully!");
		        } else {
		            System.out.println("\nInvalid mobile number! Mobile number should 8 digits.");
		        }
		    }
		} else if (username.isEmpty() || email.isEmpty() || password.isEmpty() || mobile <= 0 || address.isEmpty()) {
			System.out.println("\nPlease fill in all fields.");
		} else {
			System.out.println("\nInvalid email format, please try again!");
		}
		

	}

	// ------------------------------------------------------------
	// display all user details (view)
	// ------------------------------------------------------------
	public static String retrieveAllUser(ArrayList<User> userList) { 
	    String output = ""; // Initialize the output string 
	    output += String.format("%-20s%-35s%-15s%-50s\n", "Username", "Email", "Mobile", "Address"); 
	 
	    for (int i = 0; i < userList.size(); i++) { 
	        User user = userList.get(i); // Get the current user 
	        // Append user details to the output string 
	        output += String.format("%-20s%-35s%-15d%-50s\n", user.getUsername(), user.getEmail(), user.getMobile(), user.getAddress()); 
	    } 
	    return output; 
	}

	// ------------------------------------------------------------
	// static method takes in a user arraylist and performs the remove user
	// functionality
	// It will return 'true' if the user record exist
	// ------------------------------------------------------------
	public static void deleteUser(ArrayList<User> userList) {
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
				break;
			} 
		}
		
		if (!userfound) {
	        System.out.println("*** User not found! ***\n");
	    }

	}
	
	
//==================== ADD/VIEW/DELETE SERVICE METHODS ====================
	//====================          DONE BY JACOB          ====================
		 //------------------------------------------------------------
	// Add a new service
		public static void addNewService(ArrayList<RenovationService> services, String serviceName, String description, double price) { 
		     // Check if a service with the same name already exists 
		     for (int i = 0; i < services.size(); i++) { 
		         RenovationService existingService = services.get(i); 
		         if (existingService.getServiceName().equalsIgnoreCase(serviceName)) { 
		             System.out.println("Service with the same name already exists."); 
		             return; // Exit the method to prevent adding the same service again 
		         } 
		     } 
		 
		     // Create a new RenovationService object with provided details 
		     RenovationService newService = new RenovationService(serviceName, description, price); 
		 
		     // Add the new service to the list of services 
		     services.add(newService); 
		 
		     // Display success message 
		     System.out.println("Service added successfully!"); 
		 }

		    // Display all service details
		    public static void viewAllServices(ArrayList<RenovationService> services) {
		        // Display header
		        System.out.println("All Services:");
		        
		        // Loop through the list of services
		        for (int i = 0; i < services.size(); i++) {
		            // Display details of each service
		            displayServiceDetails(services.get(i));
		        }
		    }

		    // Delete a service
		    public static void deleteService(ArrayList<RenovationService> services, String serviceName) {
		        boolean serviceFound = false;
		        
		        // Loop through the list of services
		        for (int i = 0; i < services.size(); i++) {
		            RenovationService service = services.get(i);
		            
		            if (service.getServiceName().equalsIgnoreCase(serviceName)) {
		                // Remove the service from the list
		                services.remove(i);
		                
		                // Display success message
		                System.out.println("Service deleted: " + serviceName);
		                
		                serviceFound = true;
		                break; // Exit the loop once the service is found and removed
		            }
		        }
		        
		        if (!serviceFound) {
		            // Display not found message
		            System.out.println("Service not found: " + serviceName);
		        }
		    }
		    
		 // Display service details
		    private static void displayServiceDetails(RenovationService service) {
		        // Display service name, description, and price
		        System.out.println("Service Name: " + service.getServiceName());
		        System.out.println("Description: " + service.getDescription());
		        System.out.println("Price: $" + service.getPrice());
		        System.out.println();
		    }
		    

//==================== ADD/VIEW/DELETE SERVICE PROVIDER METHODS ====================
		 // ------------------------------------------------------------
			// add a new service provider
			// ------------------------------------------------------------
				    public static Serviceprovider inputServiceprovider() {
						String name = Helper.readString("Enter service provider name > ");
						String description = Helper.readString("Enter description > ");
						String service = Helper.readString("Enter offered service > ");
						int contactnum = Helper.readInt("Enter contact number > ");

						Serviceprovider sp= new Serviceprovider(name, description, service, contactnum);
						return sp;
						
					}
					
					public static void addServiceprovider(ArrayList ServiceproviderList, Serviceprovider sp) {
					    
					    ServiceproviderList.add(sp);
					}
					
					public static boolean spNameExists(ArrayList<Serviceprovider> ServiceproviderList, String name) {
					    for (Serviceprovider sp : ServiceproviderList) {
					        if (sp.getName().equalsIgnoreCase(name)) {
					            return true;
					        }
					    }
					    return false;
					}
					
					public static boolean spcontactExists(ArrayList<Serviceprovider> ServiceproviderList, int contactnum) {
					    for (Serviceprovider sp : ServiceproviderList) {
					        if (sp.getContactnum() == contactnum) {
					            return true;
					        }
					    }
					    return false;
					}
					
					public static boolean isValidContact(int contactnum) {
					    int numDigits = String.valueOf(contactnum).length();
					    return numDigits == 8;
					}
					
					
			// ------------------------------------------------------------
			// display all service provider details (view)
			// ------------------------------------------------------------
					public static void viewServiceprovider(ArrayList<Serviceprovider> ServiceproviderList) {
					    for (Serviceprovider sp : ServiceproviderList) {
					        System.out.println("\nNAME: " + sp.getName() + "\nDESCRIPTION: " + sp.getDescription() 
					                + "\nSERVICE: " + sp.getService() + "\nCONTACT NUMBER: " + sp.getContactnum());
					    }   
					    System.out.println();
					}
					
					
					
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
	public static request inputRequest() {
		String id = Helper.readString("Enter id > ");
		String detail = Helper.readString("Enter details > ");
		String description = Helper.readString("Enter description > ");

		request cc = new request(id, detail, description);
		return cc;
		
	}
	public static void addRequest(ArrayList<request> requestList, request cc) {
		request item;
		for(int i = 0; i < requestList.size(); i++) {
			item = requestList.get(i);
			if (item.getdetail().equalsIgnoreCase(cc.getdetail()) )
				return;
		}
		if ((cc.getdetail().isEmpty()) || (cc.getdescription().isEmpty()) ) {
			return;
		}
		
		requestList.add(cc);
	}
	
	// ------------------------------------------------------------
	// display all request details (view)
	// ------------------------------------------------------------
	public static String retrieveAllRequest(ArrayList<request> requestList) {
		// TODO Auto-generated method stub
		String output = String.format("");
		for (int i = 0; i < requestList.size(); i++) {
			if (requestList != null) {
				String id = requestList.get(i).getid();
				String detail = requestList.get(i).getdetail();
				String description = requestList.get(i).getdescription();
			}
		}
		return output;
	}
	
	// ------------------------------------------------------------
	// delete a request
	// ------------------------------------------------------------
	public static boolean deleteRequest(ArrayList<request> requestList, String string, String string2, String string3, int j, String string4) {
		// TODO Auto-generated method stub
		boolean requestfound = false;
		
		String id = Helper.readString("\nEnter request's id: ");
		for (int i = 0; i < requestList.size(); i++) {
			if (id.equalsIgnoreCase(requestList.get(i).getid())) {
				requestfound = true;
				requestList.get(i).display();
				char choice = Helper.readChar("\nConfirm deletion? (y/n): ");
				if (choice == 'Y' || choice == 'y') {
					requestList.remove(i);
					System.out.println("\n*** User has been deleted ***\n");	
				} 
			} else {
				System.out.println("*** User not found! ***\n");
			}
		}
		return false;
	}
	

}
