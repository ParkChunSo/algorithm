import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();
        int maxDay = (V-A) / (A-B);
        if((A-B) * maxDay + A >= V)
            System.out.println(maxDay+1);
        else
            System.out.println(maxDay+2);
    }
}