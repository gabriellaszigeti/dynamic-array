package com.codecool.dynamicarray;

public class Main {
    public static void main(String[] args) {
        DynamicArray myArray = new DynamicArray(5);
        System.out.println("capacity: " + myArray.getCapacity());
        myArray.add(19);
        myArray.add(3);
        myArray.add(8);
        myArray.add(4);
        System.out.println("size: " + myArray.size());
        System.out.println("index of 2: " + myArray.get(2));
        System.out.println(myArray.toString());
        myArray.remove(1);
        System.out.println(myArray.toString());

    }
}