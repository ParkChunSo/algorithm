import java.util.*;

public class Solution {
	public int[] solution(int []arr) {
        if(arr.length == 1)
            return arr;
        
        ArrayList<Integer> tmp = new ArrayList<>();
        int preNum = arr[0];
        tmp.add(arr[0]);
        for(int idx = 1 ; idx < arr.length ; idx++){
            if(preNum != arr[idx]){
                tmp.add(arr[idx]);
                preNum = arr[idx];
            }
        }

        int[] answer = new int[tmp.size()];
        
        for(int i = 0 ; i < tmp.size() ; i++){
            answer[i] = tmp.get(i);
        }
            
        return answer;
	}
}