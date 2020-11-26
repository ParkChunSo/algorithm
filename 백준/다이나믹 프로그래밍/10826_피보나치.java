import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        cache = new int[n+1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        System.out.println(fibonacci(n));
    }
    private static int fibonacci(int n){
        if(cache[n] != -1)
            return cache[n];

        return cache[n] = fibonacci(n-1) + fibonacci(n-2);
    }
}