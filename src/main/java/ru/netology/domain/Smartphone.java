package ru.netology.domain;

public class Smartphone extends Product {
    private String manufacture;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String manufacture) {
        super(id, name, price);
        this.manufacture = manufacture;
    }


    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }


}
