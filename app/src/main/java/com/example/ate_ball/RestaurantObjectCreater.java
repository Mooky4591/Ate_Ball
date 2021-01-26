package com.example.ate_ball;

public class RestaurantObjectCreater {

    String name;
    int price;
    int rating;
    String address;

    public RestaurantObjectCreater(String name, int price, int rating, String address) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.address = address;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
