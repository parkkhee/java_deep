package com.ll.exam1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

    }
}


class MyArrayList<T>{

    private T[] arr;
    private int size=0;
    private int DEFAULT_SIZE=10;

    public MyArrayList(){
        this.arr = (T[])new Object[DEFAULT_SIZE];
    }

    boolean add(T input) {
        if (size == arr.length) {
            resize();
        }
        arr[size] = input;
        size++;
        return true;
    }

    void resize() {
        int newSize = DEFAULT_SIZE*2;
        arr = Arrays.copyOf(arr, newSize);
    }

    int size() {
        return size;
    }

    T get(int idx) {
        return arr[idx];
    }

    T remove(int idx){
        T removeValue = arr[idx];
        for (int i = idx; i < size; i++) {
            arr[i] = arr[i+1];
        }
        --size;
        return removeValue;
    }


    boolean contains(T findValue) {
        Optional<T> findedValue = Arrays.stream(arr).findAny().filter(e -> e.equals(findValue));
        if (findedValue.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    int indexOf(T findIdx) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(findIdx)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        arr = (T[]) new Object[DEFAULT_SIZE];
        size=0;
    }

    public boolean isEmpty() {
        return size==0;
    }
}
