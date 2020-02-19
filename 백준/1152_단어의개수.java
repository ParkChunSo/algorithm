import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String[] words = s.trim().split(" ");
        int answer = words.length;
        
        for(int i = 0 ; i < words.length ; i++){
            if(words[i].equals(""))
                answer--;
        }
        System.out.println(answer);
    }
}