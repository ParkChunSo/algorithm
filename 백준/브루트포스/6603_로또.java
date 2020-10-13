import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, DEPTH = 6;
    static int[] nums;
    static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N == 0)
                break;
            nums = new int[N];
            for(int i = 0 ; i < N ; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            System.out.println();
        }
    }

    private static void dfs(int depth, int idx){
        if(depth == DEPTH){
            print();
            return;
        }

        for(int i = idx; i < nums.length ; i++){
            list.add(nums[i]);
            dfs(depth+1, i+1);
            list.remove(list.size()-1);
        }
    }

    private static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i : list){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}