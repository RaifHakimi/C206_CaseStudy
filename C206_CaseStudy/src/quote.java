
public class quote {
	private int id;
	private String name; 
	private int contactNum; 
	private String description;
	private int price;
	private String addInfo;
	
	
	//Customer
	public quote(int id, String name, int contactNum, String description){
		
		this.id = id;
		this.name = name;
		this.contactNum = contactNum;
		this.description = description;
		price = 0;
		addInfo = "";
	
		
	}
	
	//Admin or Service Provider
	public quote(int id, String name, int contactNum, String description, int price, String addInfo ){
		this.id = id;
		this.name = name;
		this.contactNum = contactNum;
		this.description = description;
		this.price = price;
		this.addInfo = addInfo;
		
		
	}
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNum() {
		return contactNum;
	}
	
	public String getDesc() {
		return description;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getAddInfo() {
		return addInfo;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void setContactNum(int contactNum) {
		this.contactNum = contactNum;
	}
	
	public void setDesc(String description) {
		this.description = description;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}
	

	
	public String toStringView() {
		String msg = String.format("%20d%20s%20d%20s",id,name,contactNum, description );
		return msg;
	}
}
