package com.functional.example;

import java.time.LocalDate;

public class Customer {
    private final String name;
    private final String phoneNumber;
    private  int totalOrderItem;
    private  double totalOrderAmount;


    public Customer(String name, String phoneNumber, int totalOrderItem, double totalOrderAmount) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.totalOrderItem = totalOrderItem;
        this.totalOrderAmount = totalOrderAmount;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getTotalOrderItem() {
        return totalOrderItem;
    }

    public void setTotalOrderItem(int totalOrderItem) {
        this.totalOrderItem = totalOrderItem;
    }

    public double getTotalOrderAmount() {
        return totalOrderAmount;
    }

    public void setTotalOrderAmount(double totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", totalOrderItem=" + totalOrderItem +
                ", totalOrderAmount=" + totalOrderAmount +
                '}';
    }
}

