package com.days.day21;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * https://leetcode-cn.com/problems/building-h2o/
 */
public class H2O生成_1117 {
    public static void main(String[] args) {

    }
}
class H2O {
    private Semaphore hy = new Semaphore(2);
    private Semaphore ox = new Semaphore(1);
    private CyclicBarrier barrier = new CyclicBarrier(3);
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hy.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hy.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        ox.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        ox.release();
    }
}