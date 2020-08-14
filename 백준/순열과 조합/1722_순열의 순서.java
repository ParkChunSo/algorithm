import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (sc.nextInt() == 1) {
            long K = sc.nextLong();
            int[] ints = solution1(N, K);
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
        } else {
            int[] input = new int[N];
            for (int i = 0; i < N; i++) {
                input[i] = sc.nextInt();
            }
            System.out.println(solution2(N, input));
        }
    }

    // N개로 나열되어 있는 순열에서 K번째 순열을 찾는 메소드
    private static int[] solution1(int N, long K) {
        int[] answer = new int[N];
        boolean[] visited = new boolean[N+1];

        long sum = 0;
        for(int i = 0 ; i < N ; i++){
            int idx = N - (i + 1);
            for(int j = 1 ; j <= N ; j++ ){
                if(visited[j])
                    continue;
                long tmp = factorial(idx);
                if(sum + tmp >= K){
                    answer[i] = j;
                    visited[j] = true;
                    break;
                }
                sum += tmp;
            }
        }
        return answer;
    }

	// N개로 나열도어 있는 순열에서 input 순열이 몇번째인지 찾는 메소드
    private static long solution2(int N, int[] input) {
        long result = 0;
        boolean[] visited = new boolean[N+1];

        for (int i = 0; i < input.length; i++) {
            int idx = N - (i + 1);
            for (int j = 1; j < input[i]; j++) {
                if (visited[j])
                    continue;
                result += factorial(idx);
            }
            visited[input[i]] = true;
        }
        return result + 1;
    }

    private static long factorial(int a) {
        long result = 1;
        while (a > 0) {
            result *= a;
            a--;
        }
        return result;
    }
}