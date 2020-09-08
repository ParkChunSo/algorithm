import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static int[] arr;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = 0;
        while(st.hasMoreTokens()){
            arr[m++] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i = 0 ; i < N ; i++){
            visited[i] = true;
            list.add(arr[i]);
            answer = Math.max(answer, dfs(i, 0));
            visited[i] = false;
            list.remove(list.size()-1);
        }
        System.out.println(answer);
    }

    private static int dfs(int arrIdx, int position) {
        if(position == N-1)
            return cal();

        int answer = 0;
        for(int i = 0 ; i < N ; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            list.add(arr[i]);
            answer = Math.max(answer, dfs(i, position+1));
            visited[i] = false;
            list.remove(list.size()-1);
        }
        return answer;
    }

    private static int cal() {
        int answer = 0;
        for(int i = 0 ; i < N-1 ; i++){
            answer += Math.abs(list.get(i) - list.get(i+1));
        }
        return answer;
    }
}
