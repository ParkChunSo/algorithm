import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        String next = sc.next();

        for(int i = 0 ; i < next.length() ; i++){
            char c = next.charAt(i);
            if(alphabet[c - 'a'] == -1)
                alphabet[c - 'a'] = i;
        }
        for(int i = 0 ; i < alphabet.length-1 ; i++) {
            System.out.print(alphabet[i] + " ");
        }

        System.out.print(alphabet[25]);
    }
}