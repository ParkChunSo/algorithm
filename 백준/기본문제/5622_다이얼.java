import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        int answer = 0;
        for(int i = 0 ; i < next.length() ; i++){
            answer += (next.charAt(i) - 'A') / 3 + 2 + 1;
             if(next.charAt(i) == 'S' || next.charAt(i) == 'V' || next.charAt(i) == 'Z' || next.charAt(i) == 'Y')
                 answer -= 1;
        }
        System.out.println(answer);
    }
}