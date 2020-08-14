import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        visited = new boolean[N+1];

        solution(0);
    }

    public static void solution(int depth){
        if(depth == N){
            print(arr);
        }

        for(int i =1 ; i <= N ; i++){
            if(visited[i])
                continue;
            arr[depth] = i;
            visited[i] = true;
            solution(depth+1);
            visited[i] = false;
        }
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}