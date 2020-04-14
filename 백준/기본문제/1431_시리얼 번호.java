import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            list.add(sc.next());
        }
        list.sort((String first, String second) -> {
            if(first.length() < second.length())
                return -1;
            else if(first.length() == second.length()){
                int firstSum = makeSumInteger(first);
                int secondSum = makeSumInteger(second);
                if(firstSum < secondSum)
                    return -1;
                else if(firstSum > secondSum)
                    return 1;
                else
                    return first.compareTo(second);

            }
            else
                return 1;
        });

        for(String str : list)
            System.out.println(str);
    }

    public static int makeSumInteger(String s){
        int result = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) > '0' && s.charAt(i) <= '9')
                result += s.charAt(i) - '0';
        }
        return result;
    }
}