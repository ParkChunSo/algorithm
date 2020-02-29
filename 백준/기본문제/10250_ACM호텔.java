import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0){
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int X = N / H + 1;
            if(N % H == 0)
                --X;
            int Y = N - (H * (N / H));
            if(Y == 0)
                Y = H;
            StringBuilder sb = new StringBuilder();
            sb.append(Y);
            if(X < 10)
                sb.append(0);
            sb.append(X);
            System.out.println(sb.toString());
            T--;
        }
    }
}