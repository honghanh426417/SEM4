package hanh.codelean.crudspringrestau.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @Column(name = "category_id")
//    private int categoryId;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    public Food() {}

    public Food(int id,  String name, String image, String description, int quantity, double price) {
        this.id = id;
//        this.categoryId = categoryId;
        this.name = name;
        this.image = image;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Food(String name, String image, String description, int quantity, double price) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

//    public int getCategoryId() { return categoryId; }
//
//    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Food [id=" + id +  ", name=" + name + ", image=" + image + ", description=" + description + ", quantity=" + quantity + ", price=" + price + "]";
    }
}
