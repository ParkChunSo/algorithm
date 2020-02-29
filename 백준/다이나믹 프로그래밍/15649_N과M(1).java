import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] list;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        list = new int[N+1];
        visited = new boolean[N+1];

        solution(0);
    }

    public static void solution(int cnt){
        if(cnt == M){
            for(int i = 0 ; i < M ; i++)
                System.out.print(list[i]+ " ");
            System.out.println();
        }else{
            for(int i = 1 ; i <= N ; i++){
                if(visited[i])
                    continue;
                visited[i] = true;
                list[cnt] = i;
                solution(cnt+1);
                visited[i] = false;
            }
        }
    }
}