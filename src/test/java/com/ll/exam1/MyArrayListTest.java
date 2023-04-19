package com.ll.exam1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private MyArrayList<String> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    void testAdd() {
        assertTrue(list.add("Element1"));
        assertEquals(1, list.size());
        assertEquals("Element1", list.get(0));
    }

    @Test
    void testRemove() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        assertEquals("Element2", list.remove(1));
        assertEquals(2, list.size());
    }
}