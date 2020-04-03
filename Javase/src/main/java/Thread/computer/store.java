package Thread.computer;

public class store extends Thread {
    //锁对象
    private computer computer;

    //使用带参构造方法给类赋值
    public store(computer computer) {
        this.computer = computer;
    }


    @Override
    public void run() {
        //生产的品种
        int count = 0;
        while (true) {
            //同步代码块
            synchronized (computer) {
                //判断是否有商品
                if (computer.flag == true) {
                    try {
                        computer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }

                //唤醒之后生产
                if (count % 2 == 0) {
                    computer.xianka = "RTX2080";
                    computer.cpu = "I9-9900k";
                } else {
                    computer.xianka = "RTX1050";
                    computer.cpu = "I5-7500H";
                }
                count++;
                System.out.println("正在生产显卡为" + computer.xianka + "cpu为" + computer.cpu + "的电脑");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                computer.flag = true;
                computer.notify();
                System.out.println("已经生产好电脑显卡为" + computer.xianka + "cpu为" + computer.cpu + "的电脑");

            }
        }
    }
}
