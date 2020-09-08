import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        int answer = 0;
        int cnt = 0;
        boolean finish = false;
        for(int i = 2; i <= N ; i++){
            if(!isPrime(i))
                continue;
            int prime = i;
            while(prime <= N){
                if(visited[prime]) {
                    prime += i;
                    continue;
                }
                visited[prime] = true;
                cnt++;
                if(cnt == K) {
                    finish = true;
                    answer = prime;
                    break;
                }
                prime += i;
            }
            if(finish)
                break;
        }

        System.out.println(answer);
        br.close();
    }

    private static boolean isPrime(int num) {
        for(int i = 2 ; i < num ; i++){
            if(num%i == 0)
                return false;
        }
        return true;
    }
}