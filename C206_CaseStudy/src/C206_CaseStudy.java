import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();

	}

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

	public static void menu() {
		C206_CaseStudy.setHeader("Renovation Portal");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
		

}
