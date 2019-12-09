import java.util.Scanner;

public class Main {
    static String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int answer = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(i+2 < s.length() && checkContained(s.substring(i, i+3)))
                i += 2;
            else if(i+1 < s.length() && checkContained(s.substring(i, i+2)))
                i += 1;

            answer++;
        }

        System.out.println(answer);
    }

    public static boolean checkContained(String subString){
        for(String tmp : arr){
            if(tmp.equals(subString))
                return true;
        }
        return false;
    }
}