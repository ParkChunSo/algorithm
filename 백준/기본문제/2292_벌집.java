import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int i = 1, sum = 1;
        while(N > sum){
            sum += 6 * i;
            i++;
        }

        System.out.println(i);
    }
}