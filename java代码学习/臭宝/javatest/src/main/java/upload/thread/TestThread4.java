package upload.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by upload on 2021/11/3.
 */

//多个线程操作同一个资源 翁乱
public class TestThread4 implements Runnable{

    private int ticketNums = 10;
    boolean flag =true;
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (flag){
            try {
                qiang();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //
    private   void  qiang() throws InterruptedException {

        try {
            lock.lock();
            while (true){
                if (ticketNums<=0){
                    flag=false;
                    break;
                }
//                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"--> 抢到第几张"+ticketNums--+"票");
            }
        }finally {
        lock.unlock();
        }

    }


    public static void main(String[] args) {
        TestThread4 t4 = new TestThread4();
        new Thread(t4,"a").start();
        new Thread(t4,"b").start();
        new Thread(t4,"c").start();
    }
}

