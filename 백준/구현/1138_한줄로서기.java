import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr, answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        answer = new int[N+1];
        visited = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution(1);
    }

    private static void solution(int idx){
        if(idx == N+1)
            print();

        for(int num = 1 ; num <= N ; num++){
            if(visited[num] || !isValid(idx, num))
                continue;
            visited[num] = true;
            answer[idx] = num;
            solution(idx+1);
            answer[idx] = 0;
            visited[num] = false;
        }
    }

    private static boolean isValid(int idx, int num){
        if(arr[num] >= idx)
            return false;

        int cnt = 0;
        for(int i = 1 ; i < idx ; i++){
            if(answer[i] > num)
                cnt++;
        }

        return cnt == arr[num];
    }

    private static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= N ; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}