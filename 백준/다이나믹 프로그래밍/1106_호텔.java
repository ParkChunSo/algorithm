import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int C,N, MAX_PEOPLE;
    static int[] memo, money, people;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        money = new int[N];
        people = new int[N];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            money[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
            MAX_PEOPLE = Math.max(people[i], MAX_PEOPLE);
        }

        memo = new int[1101];
        Arrays.fill(memo, Integer.MAX_VALUE);

        for(int c = 1 ; c <= C + MAX_PEOPLE ; c++){
            for(int i = 0 ; i < N ; i++){
                if(c <= people[i]){
                    memo[c] = Math.min(memo[c], money[i]);
                }else{
                    memo[c] = Math.min(memo[c], memo[c-people[i]] + money[i]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = C ; i <= C+MAX_PEOPLE ; i++){
            answer = Math.min(memo[i], answer);
        }
        System.out.println(answer);
    }
}