import java.util.Scanner;

public class Main {
    static int N;
    static int[][] rgb;
    static int[] selectedRGB;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        rgb = new int[N][3];
        selectedRGB = new int[N];
        for (int i = 0; i < N; i++) {
            rgb[i][0] = sc.nextInt();
            rgb[i][1] = sc.nextInt();
            rgb[i][2] = sc.nextInt();
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            selectedRGB[0] = i;
            answer = Math.min(answer, dp(1) + rgb[0][i]);
        }
        System.out.println(answer);
    }

    public static int dp(int idx) {
        if (idx == N - 1) {
            int answer = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                if (selectedRGB[0] != i && selectedRGB[idx - 1] != i)
                    answer = Math.min(answer, rgb[idx][i]);
            }
            return answer;
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (selectedRGB[idx - 1] == i)
                continue;

            selectedRGB[idx] = i;
            answer = Math.min(answer, dp(idx + 1) + rgb[idx][i]);
        }
        return answer;
    }
}
