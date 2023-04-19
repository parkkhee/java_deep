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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return size == that.size && DEFAULT_SIZE == that.DEFAULT_SIZE && Arrays.equals(arr, that.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, DEFAULT_SIZE);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }

    boolean contains(T findValue) {
        Optional<T> findedValue = Arrays.stream(arr).findAny().filter(e -> e.equals(findValue));
        if (findedValue.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
