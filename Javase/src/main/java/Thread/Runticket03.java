package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//使用Lock锁解决线程安全问题（访问共享资源）
//当线程的cpu时间片用完时，同步代码块没执行完成归还锁对象时，其他线程无法获得锁对象所以无法执行
//线程安全问题前使用锁对象，结束后释放
public class Runticket03 implements Runnable{
    private  Integer ticket = 100;
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            lock.lock();
            synchronized (lock){
                if ((ticket>0)){
                    try {
                        Thread.sleep(10);
                        System.out.println(Thread.currentThread().getName()+"正在卖"+ticket+"票");
                        ticket--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }

                }
            }
        }
    }
}
