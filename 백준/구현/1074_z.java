import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, Y, X, next = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        draw(0, 0, size - 1, size - 1);
        System.out.println(next);
    }

    private static boolean draw(int y1, int x1, int y2, int x2) {
        if (y2 - y1 == 1) {
            if (y1 == Y && x1 == X)
                return true;
            next++;
            if (y1 == Y && x2 == X)
                return true;
            next++;
            if (y2 == Y && x1 == X)
                return true;
            next++;
            if (y2 == Y && x2 == X)
                return true;
            next++;
            return false;
        }
        int v = (y2 - y1 + 1) / 2;
        return draw(y1, x1, y1 + v - 1, x1 + v - 1)
                || draw(y1, x1 + v, y1 + v - 1, x2)
                || draw(y1 + v, x1, y2, x1 + v - 1)
                || draw(y1 + v, x1 + v, y2, x2);
    }
}