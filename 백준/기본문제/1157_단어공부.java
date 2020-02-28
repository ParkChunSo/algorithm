import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toLowerCase().toCharArray();
        int[] cnt = new int[26];
        int max = -1;
        char answer = '?';
        for(int i = 0 ; i < arr.length ; i++){
            cnt[arr[i] - 'a']++;
            if(cnt[arr[i] - 'a'] > max){
                max = cnt[arr[i] - 'a'];
                answer = arr[i];
            }else if(cnt[arr[i] - 'a'] == max){
                answer = '?';
            }
        }
        System.out.println(String.valueOf(answer).toUpperCase());
    }
}