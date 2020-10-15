import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static final int LEFT = 6, RIGHT = 2;
    static List<LinkedList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < 4; i++){
            list.add(new LinkedList<>());
            String s = br.readLine();
            for(int k = 0 ; k < s.length() ; k++){
                list.get(i).add(s.charAt(k) - '0');
            }
        }

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            visited = new boolean[4];
            rotate(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
        }
        print();
    }

    private static void rotate(int idx, int direct){
        visited[idx] = true;
        if(idx != 0
                && !visited[idx - 1]
                && !list.get(idx).get(LEFT).equals(list.get(idx - 1).get(RIGHT))){
            rotate(idx-1, direct == 1 ? -1 : 1);
        }
        if(idx != 3
                && !visited[idx + 1]
                && !list.get(idx).get(RIGHT).equals(list.get(idx + 1).get(LEFT))){
            rotate(idx+1, direct == 1 ? -1 : 1);
        }

        if(direct == -1){
            list.get(idx).offer(list.get(idx).poll());
        }else{
            list.get(idx).offerFirst(list.get(idx).pollLast());
        }
    }

    private static void print(){
        int score = 0, tmp = 1;
        for(LinkedList<Integer> l : list){
            score += l.get(0) * tmp;
            tmp *= 2;
        }
        System.out.println(score);
    }
}