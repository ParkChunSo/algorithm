import java.util.*;

public class Solution {
	public int[] solution(int []arr) {
        if(arr.length == 0)
            return new int[0];
        LinkedList<Integer> list = new LinkedList<>();
        list.add(arr[0]);
        for(int i = 1 ; i < arr.length ; i++){
            if(list.peekLast() != arr[i])
                list.add(arr[i]);
        }
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = list.get(i);
        }
        return answer;
	}
}