package Thread;

//使用同步方法解决线程安全问题（访问共享资源）
//当线程的cpu时间片用完时，同步代码块没执行完成归还锁对象时，其他线程无法获得锁对象所以无法执行
//同步方法的锁对象是创建时new的Runticket02对象
public class Runticket02 implements Runnable{
    private Integer ticket = 100;
    public void run() {
        while (true){
                buyTicket();
        }
    }

    public synchronized void buyTicket(){
        if ((ticket>0)){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"正在卖"+ticket+"票");
            ticket--;
        }
    }
}
