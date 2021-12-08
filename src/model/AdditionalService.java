package model;

import java.io.Serializable;

public class AdditionalService implements Serializable {
    public static int id=0;
    private String name;
    private int price;
    private int quantity;
    public AdditionalService(String name, int price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity= quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "AdditionalService{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
