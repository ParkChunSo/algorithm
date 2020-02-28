import java.util.Scanner;

public class Main {
    static int N;
    static Matrix[] arr;
    static int[][] memo;

    static class Matrix{
        int row;
        int col;
        Matrix(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new Matrix[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = new Matrix(sc.nextInt(), sc.nextInt());
        }
        memo = new int[N][N];
        System.out.println(solution(0, N-1));
    }

    public static int solution(int x, int y){
        if(x == y)
            return 0;
        if(memo[x][y] != 0)
            return memo[x][y];

        int answer = Integer.MAX_VALUE;
        for(int k = x ; k < y ; k++){
            answer = Math.min(answer, solution(x, k) + solution(k+1, y) + (arr[x].row * arr[k].col * arr[y].col));
        }
        return memo[x][y] = answer;
    }
}