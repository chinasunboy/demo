package Thread.lambda;

public class CTest {
    public static void main(String[] args) {

        invoke(5,6,( a, b)-> a+b);

    }

    public static void invoke(int a,int b,clebrate c){
        System.out.println(a-b);
    }

}
