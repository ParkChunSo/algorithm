import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Long N, P, Q;
    static HashMap<Long, Long> memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        P = sc.nextLong();
        Q = sc.nextLong();
        memo = new HashMap<>();
        memo.put(0L, 1L);
        System.out.println(solution(N));
    }

    public static Long solution(Long idx) {
        if(memo.containsKey(idx))
            return memo.get(idx);
        memo.put(idx, solution(idx/P) +solution(idx/Q));

        return memo.get(idx);
    }
}