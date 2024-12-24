package com.aklimets.data_structures.hashtables;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MyHashtable<K, V> {

    private static class Entry<K, V> {
        Entry<K, V> next;
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final double DEFAULT_THRESHOLD = 0.75;
    private static final int DEFAULT_CAPACITY = 16;

    private int size;
    private int capacity = DEFAULT_CAPACITY;
    private double threshold;

    private Entry<K, V>[] buckets;

    public MyHashtable() {
        this.buckets = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
        this.threshold = DEFAULT_THRESHOLD;
    }

    public MyHashtable(int capacity) {
        this.buckets = (Entry<K, V>[]) new Entry[capacity];
        this.threshold = DEFAULT_THRESHOLD;
        this.capacity = capacity;
    }

    public MyHashtable(double threshold) {
        this.buckets = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
        this.threshold = threshold;
    }

    public MyHashtable(int capacity, double threshold) {
        this.buckets = (Entry<K, V>[]) new Entry[capacity];
        this.threshold = threshold;
        this.capacity = capacity;
    }

    public void put(K key, V value) {
        if ((double) (size + 1) / capacity > threshold) {
            buckets = doubleBuckets();
        }
        boolean result = putElement(key, value, buckets);
        if (result) size++;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % capacity;
        Entry<K, V> pointer = buckets[index];
        while (pointer != null) {
            if (pointer.key.equals(key)) {
                return pointer.value;
            }
            pointer = pointer.next;
        }
        return null;
    }

    private Entry<K, V>[] doubleBuckets() {
        capacity *= 2;
        Entry<K, V>[] newBuckets = (Entry<K, V>[]) new Entry[capacity];
        for (Entry<K, V> bucket : buckets) {
            if (bucket != null) {
                Entry<K, V> pointer = bucket;
                while (pointer != null) {
                    putElement(pointer.key, pointer.value, newBuckets);
                    pointer = pointer.next;
                }
            }
        }
        return newBuckets;
    }

    private boolean putElement(K key, V value, Entry<K, V>[] buckets) {
        int hash = key.hashCode();
        int index = hash % capacity;
        if (buckets[index] == null) {
            buckets[index] = new Entry<>(key, value);
        } else {
            Entry<K, V> pointer = null;
            while (pointer == null || pointer.next != null) {
                pointer = pointer == null ? buckets[index] : pointer.next;
                if (pointer.key.equals(key)) {
                    pointer.value = value;
                    return false;
                }
            }
            pointer.next = new Entry<>(key, value);
        }
        return true;
    }


    // usage example
    public static void main(String[] args) {
        MyHashtable<Integer, Integer> hashtable = new MyHashtable<>(2);
        hashtable.put(1, 11);
        hashtable.put(2, 12);
        hashtable.put(18, 13);
        hashtable.put(18, 14);
        hashtable.put(19, 15);
        System.out.println();

        System.out.println(hashtable.get(2));
        System.out.println(hashtable.get(3));
    }
}
