package com.ll.exam2;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

    }

}

class MyHashMap<K, V>{

    Object[][] arr;
    private int size;
    private static final int DEFAULT_SIZE=2;

    public MyHashMap() {
        arr = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
        size=0;
    }

    Object put(K key, V value) {
        makeNewDataIfNotEnough();

        if(isPresent(key,value)){
            return size;
        }

        arr[size] = new Object[]{key, value};

        size++;

        return null;
    }

    int size() {
        return size;
    }

    void makeNewDataIfNotEnough() {
        if (!ifEnough()) {
            resize();
        }
    }

    boolean ifEnough() {

        if (size >= arr.length) {
            return false;
        }
        return true;
    }

    void resize() {
        int newSize = DEFAULT_SIZE*2;
        arr = Arrays.copyOf(arr, newSize);
    }

    boolean isPresent(K key, V value){

        for (int i = 0; i < arr.length; i++) {
            try {
                if (arr[i][0].equals(key)) {
                    arr[i][1] = value;
                    return true;
                }

            } catch (NullPointerException e) {
                return false;
            }
        }
        return false;

    }

    V get(K key) {

        Object getValue = Arrays.stream(arr)
                .filter(e -> e[0].equals(key))
                .map(e -> e[1])
                .findFirst()
                .orElse(null);

        return (V)getValue;

    }


    int remove(K key) {

        Object removeValue = Arrays.stream(arr).filter(e -> e[1].equals(key))
                .map(e -> e[1]).findFirst().orElse(null);

        int i = Arrays.binarySearch(arr, key);


        return (int) removeValue;

    }
}
