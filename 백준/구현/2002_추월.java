import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] entryArr = new String[N];
        String[] endArr = new String[N];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            entryArr[i] = s;
            map.put(s, i);
        }

        for(int i = 0 ; i < N ; i++){
            endArr[i] = br.readLine();
        }

        boolean[] overtaking = new boolean[N];
        int answer = 0, entry = 0, end = 0;
        while(entry < N){
            if(overtaking[entry]){
                entry++;
                continue;
            }
            if(entryArr[entry].equals(endArr[end])){
                entry++; end++;
                continue;
            }
            int idx = map.get(endArr[end]);
            overtaking[idx] = true;
            answer++;
            end++;
        }
        System.out.println(answer);
    }
}