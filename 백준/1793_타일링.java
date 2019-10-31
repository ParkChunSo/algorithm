import java.math.BigInteger;
import java.util.Scanner;


public class Main {

    public static BigInteger[] memo = new BigInteger[251];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        memo[0] = BigInteger.valueOf(1);
        memo[1] = BigInteger.valueOf(1);
        memo[2] = BigInteger.valueOf(3);

        while(scanner.hasNextInt()){
            int input = scanner.nextInt();
            for(int i = 3 ; i <= input ; i++){
                if(memo[i] != null)
                    continue;
                memo[i] = memo[i-1].add(memo[i-2].multiply(BigInteger.valueOf(2)));
                System.out.println(memo[i]);
                if(i == input)
                    break;
            }
            System.out.println(memo[input]);
        }
    }
}
