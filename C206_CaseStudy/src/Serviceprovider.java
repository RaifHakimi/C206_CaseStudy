public class Serviceprovider {
	private String name;
	private String description;
	private String service;
	private int contactnum;
	
	public Serviceprovider (String name, String description, String service, int contactnum) {
		this.name = name;
		this.description = description;
		this.service = service;
		this.contactnum = contactnum;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	
	public int getContactnum() {
		return contactnum;
	}
	public void setContactnum(int contactnum) {
		this.contactnum = contactnum;
	}
	
	@Override
    public String toString() {
        return "ServiceProvider{" +
                "companyName='" + name + '\'' +
                ", Description='" + description + '\'' +
                ", servicesOffered='" + service + '\'' +
                ", Contact Number='" + contactnum + '\'' +
                '}';
    }

	public static boolean addServiceprovider(Serviceprovider minProvider) {
		
		return false;
	}

	public static Serviceprovider viewServiceprovider(String string) {
		
		return null;
	}

	public static boolean deleteServiceprovider(String string) {
		
		return false;
	}

}
