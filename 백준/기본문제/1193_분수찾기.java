import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int idx = 1, sum = 0;
        while( X > sum )
            sum += idx++;
        --idx;

        int top;
        int down;
        if(idx % 2 == 1){
            top = 1 + (sum - X);
            down = idx - (sum - X);
        }else {
            top = idx - (sum - X);
            down = 1 + (sum - X);
        }

        System.out.println(top + "/" + down);
    }
}