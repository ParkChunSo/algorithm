import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] kimArr = sc.nextLine().split(" ");
        String[] leeArr = sc.nextLine().split(" ");

        int cumulativeAmount = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < kimArr.length ; i++){
            int kimVal = Integer.parseInt(kimArr[i]);
            int leeVal = Integer.parseInt(leeArr[i]);
            if(kimVal >= leeVal){
                int diff = kimVal - leeVal;
                if(diff >= cumulativeAmount) {
                    sb.append(diff - cumulativeAmount).append(" ");
                    cumulativeAmount = 0;
                }else{
                    sb.append(0).append(" ");
                    cumulativeAmount -= diff;
                }
            }else{
                sb.append(0).append(" ");
                cumulativeAmount += leeVal - kimVal;
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}