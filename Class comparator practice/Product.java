public class Product implements Comparable<Product> {
    // Attributes
    private String id;
    private String name;
    private double price;
    private int quantity;

    // Constructor
    public Product(String id, String name, double price, int quantity) {
        // TODO: initialize attributes
        this.id=id;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    // Accessors
    public String getId() {
        // TODO: return id
        return id;
        
    }

    public String getName() {
        // TODO: return name
        return name;
    }

    public double getPrice() {
        // TODO: return price
        return price;
    }

    public int getQuantity() {
        // TODO: return quantity
        return quantity;
    }

    // compareTo method (compare by ID)
    @Override
    public int compareTo(Product p) {
        // TODO: compare this.id with p.id
        return this.id.compareTo(p.getId())
        return 0;
    }

    // toString method
    @Override
    public String toString() {
        // TODO: return formatted string
        return "Product[id:" + id + ", name:" + name + ", price:" + price + ", quantity:" + quantity + "]";;
    }
}
