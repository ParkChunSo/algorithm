import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        solution(0);
    }

    public static void solution(int cnt){
        if(cnt == M)
            System.out.println(sb.toString());
        else{
            for(int i = 1; i <= N ; i++){
                sb.append(i);
                sb.append(" ");
                solution(cnt+1);
                sb.deleteCharAt(sb.length()-1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}