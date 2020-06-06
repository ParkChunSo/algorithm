import java.util.*;

public class Main {
    static int[][] map;

    static int totalNodeCnt;
    static final int MAX_VAL = 100001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        totalNodeCnt = (int) Math.pow(2, n);
        map = new int[totalNodeCnt][totalNodeCnt];
        for(int i = 0 ; i < map.length ; i++){
            Arrays.fill(map[i], MAX_VAL);
            map[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            String[] input = sc.nextLine().split(" ");
            map[convertOX2Int(input[0])][convertOX2Int(input[1])] = Integer.parseInt(input[2]);
        }
        for(int k = 0 ; k < totalNodeCnt ; k++){
            for(int i = 0 ; i < totalNodeCnt ; i++){
                for(int j = 0; j < totalNodeCnt ; j++){
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int q = Integer.parseInt(sc.nextLine());
        int[] answer = new int[q];
        for(int i = 0 ; i < q ; i++) {
            String[] input = sc.nextLine().split(" ");
            answer[i] = map[convertOX2Int(input[0])][convertOX2Int(input[1])];
            if(answer[i] == MAX_VAL)
                answer[i] = -1;
        }
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static int convertOX2Int(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'o') {
                n = n << 1 | 1;
            } else
                n = n << 1;
        }
        return n;
    }
}
