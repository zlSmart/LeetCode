package com.day21;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class 打印零与奇偶数_1116 {
    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        new Thread(()->{
            try {
                zeroEvenOdd.zero(new IntConsumer() {
                @Override
                public void accept(int value) {
                    System.out.println(value);
                }
            });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                zeroEvenOdd.even(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        System.out.println(value);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                zeroEvenOdd.odd(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        System.out.println(value);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        };
}
class ZeroEvenOdd {
    private int n;
    private Semaphore zero = new Semaphore(1);
    private Semaphore odd = new Semaphore(0);
    private Semaphore even = new Semaphore(0);
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i =0;i<n;i++){
            zero.acquire();
            printNumber.accept(0);
            if((i&1)==0) even.release();
            else odd.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i =2;i<=n;i+=2){
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i =1;i<=n;i+=2){
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}

//class ZeroEvenOdd {
//    private int n;
//    private Semaphore zero = new Semaphore(1);
//    private Semaphore odd = new Semaphore(1);
//    private Semaphore even = new Semaphore(0);
//    private Semaphore nzero = new Semaphore(0);
//    public ZeroEvenOdd(int n) {
//        this.n = n;
//    }
//
//    // printNumber.accept(x) outputs "x", where x is an integer.
//    public void zero(IntConsumer printNumber) throws InterruptedException {
//        for(int i =0;i<n;i++){
//            zero.acquire();
//            printNumber.accept(0);
//            nzero.release();
//        }
//    }
//
//    public void even(IntConsumer printNumber) throws InterruptedException {
//        for(int i =2;i<=n;i+=2){
//            even.acquire();
//            nzero.acquire();
//            printNumber.accept(i);
//            odd.release();
//            zero.release();
//        }
//    }
//
//    public void odd(IntConsumer printNumber) throws InterruptedException {
//        for(int i =1;i<=n;i+=2){
//            odd.acquire();
//            nzero.acquire();
//            printNumber.accept(i);
//            even.release();
//            zero.release();
//        }
//    }
//}