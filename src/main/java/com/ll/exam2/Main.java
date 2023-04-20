package com.ll.exam2;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

    }

}

class MyHashMap<K, V>{

    Node[] arr;
    private int size;
    private static final int DEFAULT_SIZE=2;

    public MyHashMap() {
        arr = new Node[DEFAULT_SIZE];
        size=0;
    }

    Object put(K key, V value) {
        makeNewDataIfNotEnough();

        if(isPresent(key,value)){
            return size;
        }

        arr[size] = new Node(key, value);

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

        try {
            if (Arrays.stream(arr).findFirst().filter(e -> e.key.equals(key)).map(e -> e.value = value).isPresent()) {
                return true;
            }
        } catch (NullPointerException ne) {
            return false;
        }

        return false;
    }

    V get(K key) {

        Object getValue = Arrays.stream(arr)
                .filter(e -> e.key.equals(key))
                .map(e -> e.value)
                .findFirst()
                .orElse(null);

        return (V)getValue;

    }


    V remove(K key) {

        try {
            Object removeValue = Arrays.stream(arr).filter(e -> e.key.equals(key))
                    .map(e -> e.value).findFirst().orElse(null);

            int idx=0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].key.equals(key)) {
                    idx = i;
                    --size;
                    break;
                }

            }

            for (int i = idx+1; i < arr.length; i++) {
                arr[i-1] = arr[i];
            }

            return (V) removeValue;
        } catch (NullPointerException ne) {
            return null;
        }

    }

    public boolean containsKey(K key) {

        if (Arrays.stream(arr).findAny().filter(e -> e.key.equals(key)).isPresent()) {
            return true;
        }
        return false;

    }

    public boolean containsValue(V value) {

        if (Arrays.stream(arr).findAny().filter(e -> e.value.equals(value)).isPresent()) {
            return true;
        }
        return false;

    }

    public void clear() {

        for (int i = 0; i < size; i++) {

            arr[i] = null;

        }
        size=0;

    }

    public boolean isEmpty() {
        return size==0;
    }


    private static class Node<K,V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }


    }
}
