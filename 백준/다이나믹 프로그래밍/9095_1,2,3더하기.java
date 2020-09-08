import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] t = new int[T];

        int max = 0;
        for(int i = 0 ; i< T ; i++) {
            t[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, t[i]);
        }

        int[] memo = new int[max+1];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;
        for(int i = 4 ; i <= max ; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }
        for (int i : t) {
            System.out.println(memo[i]);
        }
    }
}