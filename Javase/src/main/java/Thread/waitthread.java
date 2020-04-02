package Thread;

public class waitthread {
    private static Object obj = new Object();

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println("告知需求");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("客户对产品很满意");
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                synchronized (obj){
                    try {
                        System.out.println("需求需要5s");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("需求做好了");
                    obj.notify();
                }
            }
        }.start();
    }
}
