package Product;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private String brand;

    // Constructor
    public Product(int id, String name, int quantity, String brand) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.brand = brand;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getBrand() {
        return brand;
    }
}
