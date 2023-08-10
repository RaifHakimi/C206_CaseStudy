
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
	
	public void setUsername() {
		this.username = username;
	}
	
	public String getEmail() {
		return username;
	}
	
	public void setEmail() {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword() {
		this.password = password;
	}
	
	public int getMobile() {
		return mobile;
	}
	
	public void setMobile() {
		this.mobile = mobile;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void Address() {
		this.address = address;
	}

	public boolean getIsAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

}
