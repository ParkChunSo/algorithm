import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String res = sc.next();
        String des = sc.next();

        int minValue = Integer.MAX_VALUE;
        int diff = des.length() - res.length();
        for(int i = 0 ; i <= diff ; i++){
            int tmp = howMatch(res, des.substring(i, i + res.length()));
            if(tmp < minValue){
                minValue = tmp;
            }
        }

        System.out.println(minValue);
    }

    public static int howMatch(String res, String des){
        int cnt = 0;
        for(int i = 0 ; i < res.length() ; i++){
            if(res.charAt(i) != des.charAt(i))
                cnt++;
        }
        return cnt;
    }
}