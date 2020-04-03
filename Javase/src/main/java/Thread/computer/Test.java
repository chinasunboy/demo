package Thread.computer;

public class Test {
    public static void main(String[] args) {
        computer computer = new computer();
        new store(computer).start();
        new guy(computer).start();
    }
}
