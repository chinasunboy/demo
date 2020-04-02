package Thread;

public class MyThread extends Thread {
    /**
     * 重写run方法
     */
    @Override
    public void run() {
//        for (int i=0;i<20;i++){
//            System.out.println(getName()+":执行了"+i+"次！");
//        }

        String name = getName();
        //System.out.println(name);
        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread().getName());
    }
}
