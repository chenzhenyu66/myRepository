package test;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2020/4/12 17:21
 *
 * @author a1344
 * 说明：
 */
public class Demo7 {
    public static void main(String[] args) {
        // 1.调用Executors的newFixedThreadPool(),返回指定线程数量的ExecutorService
        ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.execute(new MyThread());
        pool.execute(new MyThread());
        pool.execute(new MyThread());
        pool.shutdown();

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        new Thread(futureTask).start();
        try {
            Integer value = futureTask.get();
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        Window window =new Window();
        Thread t = new Thread(window);
        t.start();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("hello world!");
    }
}

/**
 * jdk5.0的时候引入的新技术，有返回值
 */
class MyThread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 200;
    }
}

class Window implements Runnable {
    int ticket = 100;
    private final ReentrantLock lock = new ReentrantLock();

    public void run() {

        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticket--);
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
