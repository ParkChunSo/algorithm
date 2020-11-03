import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = arr.length - 1;
        int alkali = 0, acid = 0;
        long diff = Long.MAX_VALUE;
        while (left < right) {
            long v = arr[left] + arr[right];
            if (Math.abs(v) < diff) {
                alkali = arr[left];
                acid = arr[right];
                diff = Math.abs(v);
            }
            if (diff == 0) {
                break;
            }

            if (v < 0) {
                left++;
            } else {
                right--;
            }

        }
        System.out.println(alkali + " " + acid);
    }
}