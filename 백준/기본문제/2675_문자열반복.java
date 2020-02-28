import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T > 0){
            int R = sc.nextInt();
            String next = sc.next();
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < next.length() ; i++){
                for(int j = 0 ; j < R ; j++){
                    sb.append(next.charAt(i));
                }
            }
            System.out.println(sb.toString());
            T--;
        }
    }
}