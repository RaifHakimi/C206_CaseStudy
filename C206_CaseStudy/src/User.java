
public class User {
	private String username;
	private String email;
	private String password;
	private int mobile;
	private String address;
	
	public User (String username, String email, String password,
			int mobile, String address) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getMobile() {
		return mobile;
	}
	
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public boolean getIsAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Username: " + username);
		System.out.println("Email: " + email);
		System.out.println("Mobile: " + mobile);
		System.out.println("Address: " + address);
	}


}
