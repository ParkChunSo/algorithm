import java.util.*;

public class Main {
    static int[][] cache = new int[1001][1001];
    static String str1, str2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str1 = sc.next();
        str2 = sc.next();
        System.out.println(lcs(0, 0));
    }
    public static int lcs(int i, int k){
        if(cache[i][k] != 0)
            return cache[i][k];
        if(str1.length() == i || str2.length() == k)
            return 0;
        if(str1.charAt(i) == str2.charAt(k))
            return lcs(i+1, k+1) + 1;
        return cache[i][k] = Math.max(lcs(i+1, k), lcs(i, k+1));
    }
}