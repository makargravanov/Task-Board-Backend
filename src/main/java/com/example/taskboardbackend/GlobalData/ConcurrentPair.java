package com.example.taskboardbackend.GlobalData;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentPair<K, V> {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock writeLock = lock.writeLock();
    private final Lock readLock = lock.readLock();
    private volatile K key;
    private volatile V value;

    public ConcurrentPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public ConcurrentPair() {
    }

    public void setPair(K key, V value) {
        writeLock.lock();
        try {
            System.out.println(key);
            this.key = key;
            this.value = value;
        } finally {
            writeLock.unlock();
        }

    }

    public K getKey() {
        readLock.lock();
        try {
            System.out.println("task3");
            return this.key;
        } finally {
            readLock.unlock();
        }
    }

    public void setKey(K key) {
        writeLock.lock();
        try {
            this.key = key;
        } finally {
            writeLock.unlock();
        }
    }

    public V getValue() {
        readLock.lock();
        try {
            return this.value;
        } finally {
            readLock.unlock();
        }
    }

    public void setValue(V value) {
        writeLock.lock();
        try {
            this.value = value;
        } finally {
            writeLock.unlock();
        }
    }
}