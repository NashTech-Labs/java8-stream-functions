package com.functional.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Customer customer1 = new Customer("Amy","1265135",5,500);
        Customer customer2 = new Customer("Alice","1255531",4,400);
        Customer customer3 = new Customer("Ben","1234544",15,1500);
        Customer customer4 = new Customer("steve","1298524",2,200);
        Customer customer5 = new Customer("clark","1234454",25,2500);
        Customer customer6 = new Customer("Dan","1278259",12,1200);
        Customer customer7 = new Customer("Zole","1235450",6,600);
        Customer customer8 = new Customer("kelly","1248513",10,1000);
        Customer customer9 = new Customer("Megan","1285236",20,2000);
        Customer customer10 = new Customer("Emily","1234567",22,2200);

        // here we will learn about some stream functions and how to use them in different scenarios

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer6);
        customerList.add(customer7);
        customerList.add(customer8);
        customerList.add(customer9);
        customerList.add(customer10);
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
        customerList.add(customer5);


        customerList.stream().forEach(System.out::println);
        // 1 Get the customers whose ordernumber are even
        //The filter() method accepts a Predicate to filter all elements of the stream.
        // This operation is intermediate which enables us to call another stream operation (e.g. forEach()) on the result.

        List<Customer> evenOrderNumber = customerList.stream().filter(a -> a.getTotalOrderItem() % 2 == 0).toList();
        evenOrderNumber.forEach(System.out::println);

        // The map() intermediate operation converts each element in the stream into another object via the given function.
        //The following example converts each string into an UPPERCASE string. But we can use map()
        // to transform an object into another type as well.

        // using custom comparator as we are familiar with it.
        Collections.sort(customerList, new NameComparator());

        System.out.println("CustomerList - " + customerList );

//       customerList.stream().map(customer -> customer.getName().toUpperCase()).forEach(System.out::println);

        // To use a comparator in the stream you can use it like this.
        customerList.stream().sorted((Customer c1, Customer c2) -> c1.getName().compareToIgnoreCase( c2.getName())).forEach(System.out::println);

        System.out.println();
        System.out.println();

        customerList.stream().sorted((Customer c1, Customer c2) -> {
            if(c1.getTotalOrderItem() > c2.getTotalOrderItem()) return 1;
            if(c1.getTotalOrderItem() < c2.getTotalOrderItem()) return -1;
            return 0;

        }).forEach(System.out::println);

        System.out.println();
        System.out.println();

        // how to use a custom comparator in java 8 stream
        customerList.stream().sorted((Customer c1, Customer c2) -> {
            if(c1.getTotalOrderAmount() > c2.getTotalOrderAmount()) return 1;
            if(c1.getTotalOrderAmount() < c2.getTotalOrderAmount()) return -1;
            return 0;

        }).forEach(System.out::println);

        //The sorted() method is an intermediate operation that returns a sorted view of the stream.
        // The elements in the stream are sorted in natural order unless we pass a custom Comparator.
        List<String> nameList = customerList.stream().map(Customer::getName).toList();
        System.out.println();
        nameList.stream().sorted().map(String::toUpperCase).forEach(System.out::println);

        // Various matching operations can be used to check whether a given predicate matches the stream elements.
        // All of these matching operations are terminal and return a boolean result.

        System.out.println();

        boolean matchedResult = nameList.stream()
                .anyMatch((s) -> s.startsWith("A"));

        System.out.println(matchedResult);   // true

        matchedResult = nameList.stream()
                .allMatch((s) -> s.startsWith("A"));

        System.out.println(matchedResult);    // false

        matchedResult = nameList.stream()
                .noneMatch((s) -> s.startsWith("A"));

        System.out.println(matchedResult);   //true


        // The count() is a terminal operation returning the number of elements in the stream as a long value.

        long totalMatched = nameList.stream()
                .filter((s) -> s.startsWith("A"))
                .count();

        System.out.println(totalMatched);     //2
    }
}
