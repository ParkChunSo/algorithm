import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T > 0){
            long max = 1, n = scanner.nextInt();
            while(n != 1){
                max = Math.max(max, n);
                if(n % 2 == 0)
                    n /= 2;
                else
                    n = n * 3 + 1;
            }
            System.out.println(max);
            T--;
        }
    }
}