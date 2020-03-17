import java.util.*;

class Solution {
    int[] arr;
    ArrayList<Integer> list = new ArrayList<>();
    public int solution(int n, int[] lost, int[] reserve) {
        arr = new int[n+1];
        for(int i = 0 ; i < lost.length ; i++)
            --arr[lost[i]];
        for(int i = 0 ; i < reserve.length ; i++)
            ++arr[reserve[i]];

        int cnt = 0;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] == -1)
                list.add(i);
            else
                cnt++;
        }
        return cnt+dfs(0);
    }

    public int dfs(int idx){
        int answer = 0;
        for(int i = idx ; i <list.size() ; i++){
            int arrIdx = list.get(i);
            if(arrIdx != 0 && arr[arrIdx-1] == 1){
                ++arr[arrIdx];
                --arr[arrIdx-1];
                answer = Math.max(answer, dfs(i+1)+1);
                --arr[arrIdx];
                ++arr[arrIdx-1];
            }
            if(arrIdx != arr.length-1 && arr[arrIdx+1] == 1){
                ++arr[arrIdx];
                --arr[arrIdx+1];
                answer = Math.max(answer, dfs(i+1)+1);
                --arr[arrIdx];
                ++arr[arrIdx+1];
            }
        }
        return answer;
    }
}