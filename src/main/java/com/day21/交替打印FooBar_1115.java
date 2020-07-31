package com.day21;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 */
public class 交替打印FooBar_1115 {
    public static void main(String[] args) {
        FooBar bar = new FooBar(5);
        new Thread(()->{
            try {
                bar.foo(()-> System.out.println("foo"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                bar.bar(()-> System.out.println("bar"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();


    }
}
class FooBar {
    private int n;
    private Semaphore foo1 = new Semaphore(1);
    private Semaphore bar1 = new Semaphore(0);
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException{

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            foo1.acquire();
            printFoo.run();
            bar1.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException{

        for (int i = 0; i < n; i++) {
            bar1.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo1.release();
        }
    }
}
//class FooBar {
//    private int n;
//    private CountDownLatch downLatch = new CountDownLatch(1);
//    private CyclicBarrier barrier = new CyclicBarrier(2);
//    public FooBar(int n) {
//        this.n = n;
//    }
//
//    public void foo(Runnable printFoo) throws InterruptedException{
//
//        for (int i = 0; i < n; i++) {
//            // printFoo.run() outputs "foo". Do not change or remove this line.
//            printFoo.run();
//            downLatch.countDown();
//            try {
//                barrier.await();
//            } catch (BrokenBarrierException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException{
//
//        for (int i = 0; i < n; i++) {
//            downLatch.await();
//            // printBar.run() outputs "bar". Do not change or remove this line.
//            printBar.run();
//            downLatch = new CountDownLatch(1);
//            try {
//                barrier.await();
//            } catch (BrokenBarrierException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}