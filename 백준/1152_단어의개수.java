import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String[] words = s.toLowerCase().split(" ");
        ArrayList<String> countList = new ArrayList<>();
        for(String word : words){
            if(!countList.contains(word) && !word.equals(""))
                countList.add(word);
        }

        System.out.println(countList.size());
    }
}