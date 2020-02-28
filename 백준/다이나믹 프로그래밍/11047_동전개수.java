import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int input = scanner.nextInt();
        int ret = 0;

        int[] coin = new int[cnt];
        for(int i = 0 ; i < cnt ; i++){
            coin[i] = scanner.nextInt();
        }

        for(int i = cnt-1 ; i > -1 ; i--){
            ret += input/coin[i];
            input %= coin[i];
        }

        System.out.println(ret);
    }
}
