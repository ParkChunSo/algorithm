import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sb = new StringBuilder();

        solution(1,0);
    }

    public static void solution(int num, int cnt){
        if(cnt == M)
            System.out.println(sb.toString());
        else{
            for(int i = num; i <= N ; i++){
                sb.append(i);
                sb.append(" ");
                solution(i, cnt+1);
                sb.deleteCharAt(sb.length()-1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}