import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        for(int i = 0 ; i < N ; i++){
            String str = sc.next();
            int[] arr = new int[26];
            Arrays.fill(arr, -1);
            arr[str.charAt(0) - 'a'] = 1;
            boolean groupWord = true;
            for(int k = 1 ; k < str.length() ; k++){
                if(arr[str.charAt(k) - 'a'] != -1 && str.charAt(k) != str.charAt(k-1)) {
                    groupWord = false;
                    break;
                }
                arr[str.charAt(k) - 'a'] = 1;
            }
            if(groupWord)
                answer++;
        }
        System.out.println(answer);
    }
}