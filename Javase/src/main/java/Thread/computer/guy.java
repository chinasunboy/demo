package Thread.computer;

public class guy extends Thread {
    //锁对象
    private computer computer;

    //使用带参构造方法给类赋值
    public guy(computer computer) {
        this.computer = computer;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (computer) {
                if (computer.flag==false){
                    try {
                        computer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("正在购买显卡为" + computer.xianka + "cpu为" + computer.cpu + "的电脑");
                computer.flag=false;
                computer.notify();
                System.out.println("顾客已经购买，场商开始继续生产");
                System.out.println("--------------------");
            }
        }
    }
}
