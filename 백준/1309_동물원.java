import java.util.*;

public class Main{
    static int[][] cache;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        cache = new int[N+1][3];
        cache[1][0] = 1;
        cache[1][1] = 1;
        cache[1][2] = 1;
        int answer = (solution(N, 0)+solution(N, 1)+solution(N, 2)) % 9901;
        System.out.println(answer);
    }

    public static int solution(int N, int location){
        if(cache[N][location] != 0)
            return cache[N][location];
        if(location == 0){
            cache[N][location] = (solution(N-1, 0)+solution(N-1, 1)+solution(N-1, 2)) % 9901;
        }else if(location == 1){
            cache[N][location] = (solution(N-1, 0) + solution(N-1, 2)) % 9901;
        }else{
            cache[N][location] = (solution(N-1, 0) + solution(N-1, 1)) % 9901;
        }
        return cache[N][location];
    }
}