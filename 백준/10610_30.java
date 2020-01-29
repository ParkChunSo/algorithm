import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int containedZero = -1;
        long sum = 0;
        for(int i = 0 ; i < input.length() ; i++){
            int tmp =  input.charAt(i) - '0';
            sum += tmp;
            if(tmp == 0)
                containedZero = i;
        }

        //3의 배수인지 확인
        if(sum % 3 != 0 || containedZero == -1){
            System.out.println(-1);
        }else{
            //조합
            char[] chars = input.toCharArray();
            Arrays.sort(chars);
            for(int i = chars.length-1 ; i>= 0 ; i--){
                System.out.print(chars[i]);
            }
        }
    }
}