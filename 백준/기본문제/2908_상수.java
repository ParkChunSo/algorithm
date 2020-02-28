import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int a, b;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 2 ; i >= 0 ; i--){
            sb1.append(arr[0].charAt(i));
            sb2.append(arr[1].charAt(i));
        }
        a = Integer.parseInt(sb1.toString());
        b = Integer.parseInt(sb2.toString());
        System.out.println(a > b ? a : b);
    }
}