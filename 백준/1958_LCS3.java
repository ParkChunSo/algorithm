import java.util.Arrays;
import java.util.Scanner;

public class Main{
    static String str1;
    static String str2;
    static String str3;
    static int[][][] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str1 = sc.next();
        str2 = sc.next();
        str3 = sc.next();
        memo = new int[str1.length()][str2.length()][str3.length()];
        for(int i = 0 ; i < str1.length() ; i++){
            for(int j = 0 ; j < str2.length() ; j++){
                Arrays.fill(memo[i][j], -1);
            }
        }
        int ans = solution(0, 0, 0);
        System.out.println(ans);
    }

    public static int solution(int idx1, int idx2, int idx3){
        if(idx1 == str1.length() || idx2 == str2.length() || idx3 == str3.length())
            return 0;

        if(memo[idx1][idx2][idx3] != -1)
            return memo[idx1][idx2][idx3];

        int answer = 0;
        if(str1.charAt(idx1) == str2.charAt(idx2) && str2.charAt(idx2) == str3.charAt(idx3)) {
            answer = solution(idx1 + 1, idx2 + 1, idx3 + 1) + 1;
        }
        else{
                answer = Math.max(answer, solution(idx1+1, idx2, idx3));
                answer = Math.max(answer, solution(idx1, idx2+1, idx3));
                answer = Math.max(answer, solution(idx1, idx2, idx3+1));
        }
        return memo[idx1][idx2][idx3] = answer;
    }
}
