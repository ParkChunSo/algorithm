import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        list = new int[N];
        solution(1, 0);
    }

    public static void solution(int num, int cnt){
        if(cnt == M){
            for(int i = 0 ; i < M ; i++)
                System.out.print(list[i]+ " ");
            System.out.println();
        }else{
            for(int i = num ; i <= N ; i++){
                list[cnt] = i;
                solution(i+1, cnt+1);
            }
        }
    }
}