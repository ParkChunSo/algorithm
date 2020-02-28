import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String next = sc.next();

        int answer = 0;
        for(int i = 0 ; i < N ; i++){
            answer += next.charAt(i) - '0';
        }

        System.out.println(answer);
    }
}