import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static boolean[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        visited = new boolean[M];
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = ((s.charAt(j) - '0') == 1);
            }
        }
        K = Integer.parseInt(br.readLine());
        br.close();

        int answer = -1;
        for(int i = 0 ; i < M ; i++){
            visited[i] = true;
            turnOn(i);
            answer = Math.max(answer, solution(i, 1));
            turnOn(i);
            visited[i] = false;
        }

        System.out.println(answer);
    }

    private static int solution(int idx, int cnt) {
        if(cnt == K){
            return find();
        }
        int answer = -1;
        for(int i = 0 ; i < M ; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            turnOn(i);
            answer = Math.max(answer, solution(i, cnt));
            turnOn(i);
            visited[i] = false;
        }

        return answer;
    }

    private static void turnOn(int idx){
        for(int i = 0 ; i < N ; i++){
            map[i][idx] = !map[i][idx];
        }
    }

    private static int find(){
        int answer = 0;
        for(int y = 0 ; y < N ; y++ ){
            boolean isOn = true;
            for(int x = 0 ; x < M ; x++){
                if(!map[y][x]) {
                    isOn = false;
                    break;
                }
            }

            if(isOn){
                answer++;
            }
        }
        return answer;
    }

}
