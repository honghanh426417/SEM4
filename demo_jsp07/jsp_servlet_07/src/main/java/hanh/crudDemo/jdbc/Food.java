package hanh.crudDemo.jdbc;

import java.math.BigDecimal;

public class Food {

    private int id;
    private int categoryId;
    private String name;
    private String image;
    private String description;
    private int quantity;
    private BigDecimal price;

    public Food(int categoryId, String name, String image, String description, int quantity, BigDecimal price) {
        this.categoryId = categoryId;
        this.name = name;
        this.image = image;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Food(int id, int categoryId, String name, String image, String description, int quantity, BigDecimal price) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.image = image;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", image=" + image + ", description=" + description + ", quantity=" + quantity + ", price=" + price + "]";
    }
}
