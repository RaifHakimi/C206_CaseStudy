import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class request {
	private String id;
	private String description;
	private String details;

public request (String id, String details, String description) {
	
	this.description = description;
	this.details = details;
	this.id = id;
}

public String getdetail() {
	return details;
}

public String getid() {
	return id;
}

public String getdescription() {
	return description;
}

public void setdetail(String details) {
	this.details = details;
}

public void setdescription(String description) {
	this.description = description;
}

public void setid(String id) {
	this.id = id;
}

public void display() {
	System.out.println("id: " + id);
	System.out.println("details: " + details);
	System.out.println("description: " + description);
}

}
