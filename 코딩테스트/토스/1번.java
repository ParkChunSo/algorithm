import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s.charAt(s.length()-1) == '1')
            System.out.println(false);
        else {
            System.out.println(checkValidation(s));
        }
    }

    public static boolean checkValidation(String s){
        boolean isTrue = true;
        for(int i = 1; i < s.length() ; i++){
            if(s.charAt(i) == '1' && s.charAt(i-1) == '1') {
                isTrue = false;
                break;
            }
        }
        return isTrue;
    }
}