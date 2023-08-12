//done by jacob
public class RenovationService {
    private String serviceName;
    private String description;
    private double price;

    public RenovationService(String serviceName, String description, double price) {
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}