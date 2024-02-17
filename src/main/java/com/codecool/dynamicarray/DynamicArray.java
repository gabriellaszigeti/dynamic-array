package com.codecool.dynamicarray;

public class DynamicArray {
    private int[] array;
    private int elementsOfArray = 0;

    public DynamicArray(int capacity) {
        this.array = new int[capacity];
    }

    public DynamicArray() {
        this.array = new int[4];
    }

    public int getCapacity() {
        return array.length;
    }

    public int size() {
        return elementsOfArray;
    }

    public void add(int value) {
        if (elementsOfArray == getCapacity()) {
            int[] arrayCopy = array.clone();
            this.array = new int[2 * elementsOfArray];
            System.out.println(array.length);
            System.arraycopy(arrayCopy, 0, array, 0, arrayCopy.length);
        } else {
            array[elementsOfArray] = value;
            elementsOfArray++;
        }
    }

    public int get(int index) {
        if (index > elementsOfArray) {
            throw new IndexOutOfBoundsException(index + "is out of bound!");
        }
        return array[index];
    }

    public void remove(int indexToBeRemoved) {
        if (elementsOfArray > 0 && indexToBeRemoved < elementsOfArray) {
            if (elementsOfArray - 1 - indexToBeRemoved >= 0)
                System.arraycopy(array, indexToBeRemoved + 1, array, indexToBeRemoved, elementsOfArray - 1 - indexToBeRemoved);
            array[elementsOfArray - 1] = 0;
            elementsOfArray--;
        } else {
            throw new IndexOutOfBoundsException("Out of index!");
        }
    }

    public void insert(int index, int newValue) {
        if (index == elementsOfArray) {
            array[index] = newValue;
            elementsOfArray++;
        } else if (index < elementsOfArray && index > 0) {
            int[] arrayCopy = array.clone();
            this.array = new int[2 * elementsOfArray];
            System.arraycopy(arrayCopy, 0, array, 0, arrayCopy.length);
            array[elementsOfArray] = newValue;
            elementsOfArray++;
        } else if (index < 0) {
            throw new IndexOutOfBoundsException("Out of index!");
        }
    }

    @Override
    public String toString() {
        StringBuilder elements = new StringBuilder("[");
        for (int i = 0; i < elementsOfArray - 1; i++) {
            elements.append(array[i]).append(", ");
        }
        return elements.toString() + array[elementsOfArray - 1] + "]";
    }
}