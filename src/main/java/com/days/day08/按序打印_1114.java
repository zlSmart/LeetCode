package com.days.day08;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode-cn.com/problems/print-in-order/
 */
public class 按序打印_1114 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.newCondition();
    }
}
class Foo {
    private Semaphore s1 = new Semaphore(1);
    private Semaphore s2 = new Semaphore(0);
    private Semaphore s3 = new Semaphore(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        s1.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
// 简单无锁情况下 用标记位加死循环
class Foo2 {
    private volatile int num = 1;
    public Foo2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        num++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(num!=2);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        num++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(num!=3);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
// 超时代码
class Foo1 {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private int num =1;
    public Foo1() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try{
            while(num!=1) conditionA.await();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            num = 2;
            conditionB.signal();
        }finally {
            lock.unlock();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try{
            while(num!=2) conditionB.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            num = 3;
            conditionC.signal();
        }finally {
            lock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try{
            while(num!=3) conditionB.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            num = 1;
            conditionA.signal();
        }finally {
            lock.unlock();
        }
    }
}