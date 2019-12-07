import java.math.BigInteger;
import java.util.*;

public class Main {
  static int[] memo = new int[100];

  public static void main(String[] args) {
    int[] progresses = {5, 5, 5};
    int[] speeds = {21, 25, 20};
    int[] solution = solution(progresses, speeds);
    for(int tmp : solution){
      System.out.println(tmp);
    }
  }
  public static int[] solution(int[] progresses, int[] speeds) {
    for(int i = 0 ; i < progresses.length ; i++){
      int job = 100 - progresses[i];
      int days = job / speeds[i];
      if(job % speeds[i] != 0)
        days++;
      memo[i] = days;
    }
    ArrayList<Integer> ret = new ArrayList<>();
    int cnt = 0;
    for(int i = 0 ; i < progresses.length ; i++){
      cnt = 1;
      int day = memo[i];
      for(int j = i+1 ; j < progresses.length ; j++){
        if(memo[j] > day){
          ret.add(cnt);
          i = j-1;
          break;
        }
        cnt++;
        if(j + 1 == progresses.length)
          i = j;
      }
    }
    ret.add(cnt);

    int[] answer = new int[ret.size()];
    for(int i = 0 ; i < ret.size() ; i++){
      answer[i] = (int)ret.get(i);
    }

    return answer;
  }
}

/*
4
1 4, 14
1 1 4, 1 14, 11 4
5 1 1 4, 5 1 14, 5 11 4
2 5 1 1 4, 2 5 1 14, 2 5 11 4, 25 1 1 4, 25 1 14, 25 11 4
if(i * 10 + i-1
memo[i] =
 */