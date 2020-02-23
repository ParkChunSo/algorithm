import java.util.Arrays;
import java.util.Scanner;

public class Main{
    static int N;
    static int M;
    static int K;
    static int[][] memo;

    static class Location{
        int x;
        int y;
        Location(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        memo = new int[N][M];
        for(int i = 0 ; i < N ; i++)
            Arrays.fill(memo[i], -1);

        if(K == 0){
            System.out.println(solution(0, 0, N-1, M-1));
        }else{
            Location location = findK();
            if(location == null)
                return;
            int val1 = solution(0, 0, location.y, location.x);
            int val2 = solution(location.y, location.x, N-1, M-1);
            System.out.println(val1*val2);
        }

    }

    public static Location findK(){
        int cnt = 1;
        for(int y = 0 ; y < N ; y++){
            for(int x = 0 ; x < M ; x++){
                if(cnt == K)
                    return new Location(y, x);
                cnt++;
            }
        }
        return null;
    }
    public static int solution(int sourceY, int sourceX, int destinationY, int destinationX) {
        if(sourceY == destinationY && sourceX == destinationX)
            return 1;

        if(memo[sourceY][sourceX] != -1)
            return memo[sourceY][sourceX];

        int answer = 0;
        if(sourceX  < destinationX){
            answer += solution(sourceY, sourceX+1, destinationY, destinationX);
        }
        if (sourceY < destinationY){
            answer += solution(sourceY+1, sourceX, destinationY, destinationX);
        }
        return memo[sourceY][sourceX] = answer;
    }
}