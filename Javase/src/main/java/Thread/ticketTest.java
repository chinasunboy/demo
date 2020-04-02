package Thread;

public class ticketTest {
    public static void main(String[] args) {
        //Runticket runticket = new Runticket();
        //Runticket02 runticket = new Runticket02();
        Runticket03 runticket = new Runticket03();
        new Thread(runticket).start();
        new Thread(runticket).start();
        new Thread(runticket).start();

    }
}
