import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 1;
        for(int i = 1 ; i <= N ; i++){
            list.add(i);
        }

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while(!list.isEmpty()){
            idx = (idx + K) % list.size();
            sb.append(list.remove(idx)).append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        System.out.println(sb.toString());
    }
}