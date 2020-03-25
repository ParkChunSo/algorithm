import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<String, Boolean> map = new HashMap<>();
        for(int i = 0 ; i < N ; i++){
            map.put(sc.next(), true);
        }

        ArrayList<String> answer = new ArrayList<>();
        for(int i = 0 ; i < M ; i++){
            String s = sc.next();
            if(map.get(s) != null)
                answer.add(s);
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for(String str : answer)
            System.out.println(str);
    }
}