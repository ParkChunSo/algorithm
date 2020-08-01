import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Map<Integer, Integer> map = new HashMap<>();
    static Random random = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");

        StringBuilder sb = new StringBuilder();
        try {
            for (String s : arr)
                sb.append(solution(Integer.parseInt(s))).append(" ");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    public static int solution(int num) throws InterruptedException {
        Thread.sleep(990);
        if (map.get(num) != null)
            return map.get(num);
        int val = random.nextInt(100000000);
        map.put(num, val);
        return val;
    }
}