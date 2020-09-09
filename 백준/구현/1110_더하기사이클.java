import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int num = N, answer = 0;
        do {
            answer++;
            if (num / 10 == 0) {
                num = (num * 10) + num;
            } else {
                int tmp = ((num / 10) + (num % 10)) % 10; // 일의 자리
                num = ((num % 10) * 10) + tmp;
            }

        } while (num != N);

        System.out.println(answer);
    }
}