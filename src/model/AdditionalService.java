package model;

import java.io.Serializable;

public class AdditionalService implements Serializable {
    public static int id=0;
    private int serviceId;
    private String name;
    private int price;
    public AdditionalService(String name, int price){
        this.serviceId = ++id;
        this.name = name;
        this.price = price;
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



    public int getServiceId() {
        return serviceId;
    }




    @Override
    public String toString() {
        return "AdditionalService{" +
                "serviceId=" + serviceId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
