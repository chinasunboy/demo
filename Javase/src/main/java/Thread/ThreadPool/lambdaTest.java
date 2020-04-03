package Thread.ThreadPool;

public class lambdaTest {
    public static void main(String[] args) {
        test(()->System.out.println("大傻逼"));
    }

    public static void test(IAccountDao iAccountDao){
        iAccountDao.findAll();
    }
}
