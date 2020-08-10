package com.days.day08;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

public class 交替打印字符串_1195 {
}

class FizzBuzz {
    private int n;
    private CyclicBarrier barrier = new CyclicBarrier(4);
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i = 1;i<=n;i++){
            if(i %3==0 && i%5!=0){
                printFizz.run();
            }
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i = 1;i<=n;i++){
            if(i %3!=0 && i%5==0){
                printBuzz.run();
            }
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i = 1;i<=n;i++){
            if(i %3==0 && i%5==0){
                printFizzBuzz.run();
            }
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1;i<=n;i++){
            if(i %3!=0 && i%5!=0){
                printNumber.accept(i);
            }
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

class FizzBuzz1 {
    private int n;
    private volatile int state = -1;

    public FizzBuzz1(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {   //只输出3的倍数(不包含15的倍数)
            if (i % 15 == 0)    //15的倍数不处理，交给fizzbuzz()方法处理
                continue;
            while (state != 3)
                Thread.sleep(1);

            printFizz.run();
            state = -1;    //控制权交还给number()方法
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {   //只输出5的倍数(不包含15的倍数)
            if (i % 15 == 0)    //15的倍数不处理，交给fizzbuzz()方法处理
                continue;
            while (state != 5)
                Thread.sleep(1);

            printBuzz.run();
            state = -1;    //控制权交还给number()方法
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {   //只输出15的倍数
            while (state != 15)
                Thread.sleep(1);

            printFizzBuzz.run();
            state = -1;    //控制权交还给number()方法
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; ++i) {
            while (state != -1)
                Thread.sleep(1);

            if (i % 3 != 0 && i % 5 != 0)
                printNumber.accept(i);
            else {
                if (i % 15 == 0)
                    state = 15;    //交给fizzbuzz()方法处理
                else if (i % 5 == 0)
                    state = 5;    //交给buzz()方法处理
                else
                    state = 3;    //交给fizz()方法处理
            }
        }
    }
}