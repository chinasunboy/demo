package Thread;

public class Test {
    public static void main(String[] args) {

        MyThread mt = new MyThread();
        //开启新线程        
        //mt.start();
        RunImpl r = new RunImpl();
        Thread t = new Thread(r);
        //t.start();

        //用匿名内部类的方式实现多线程
        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("大傻逼");
                }
            }
        }.start();

//        for (int i =1;i<=60;i++){
//            System.out.println(i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("小傻逼");
                }

            }
        }).start();

       //JDK1.7之后可以用新方法 等同于上面
        new Thread(() -> System.out.println("超级大傻逼")).start();


    }

}
