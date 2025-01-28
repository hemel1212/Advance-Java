package Exam;
public class Product {

    private int id;
    private String name;
    private int quantity;
    private String brand;

    public Product(int id, String name, int quantity, String brand) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return
                "ID: " + id +
                        "\nName: " + name +
                        "\nQuantity: " + quantity +
                        "\nbrand: " + brand;
    }
}