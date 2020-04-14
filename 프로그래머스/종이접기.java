import java.util.ArrayList;

class Solution {
  public int[] solution(int n) {
      ArrayList<Integer> list = new ArrayList<>();
      list.add(0);
      int time = 1;
      while(time < n){
          time++;
          int size  = list.size();
          list.add(0);
          for(int i = size-1 ; i >= 0 ; i--){
              list.add(list.get(i) == 1 ? 0 : 1);
          }
      }
      int[] answer = new int[list.size()];
      for(int i = 0 ; i < answer.length ;i++)
          answer[i] = list.get(i);
      return answer;
  }
}