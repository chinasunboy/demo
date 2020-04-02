package Thread;

import java.util.TreeMap;

//使用同步代码块解决线程安全问题（访问共享资源）
//当线程的cpu时间片用完时，同步代码块没执行完成归还锁对象时，其他线程无法获得锁对象所以无法执行
//synchronized (lock)中传递的同步锁对象可以为任意对象，但必须是同一对象
//缺点：程序频繁判断锁，获取锁，释放锁，程序的效率会降低
public class Runticket implements Runnable {
    private Integer ticket = 100;
    Object lock =new Object();
    @Override
    public void run() {
        while (true){
            synchronized (lock){
                if ((ticket>0)){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"正在卖"+ticket+"票");
                    ticket--;
                }
            }
        }
    }
}
