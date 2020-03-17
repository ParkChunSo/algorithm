import java.util.ArrayList;
import java.util.Arrays;

class Solution {
  public int[] solution(int[] arr, int divisor) {
      ArrayList<Integer> list = new ArrayList<>();
      for(int val : arr){
          if(val % divisor == 0)
              list.add(val);
      }
      int[] answer;
      if(list.size() == 0){
          answer = new int[1];
          answer[0] = -1;
          return answer;
      }
      answer = new int[list.size()];
      for(int i = 0 ; i <answer.length ; i++)
          answer[i] = list.get(i);
      Arrays.sort(answer);
      return answer;
  }
}