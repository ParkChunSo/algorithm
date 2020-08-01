import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");

        for(int i = 0 ; i < arr.length ; i++){
            StringBuilder sb = new StringBuilder();
            Set<String> set = new HashSet<>();
            for(int j = i ; j >= 0 ; j--){
                if(set.contains(arr[j])){
                    continue;
                }else if(set.size() == 5){
                    break;
                }
                set.add(arr[j]);
                sb.append(arr[j]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }
}