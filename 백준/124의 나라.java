public class Main {

  public static void main(String[] args) {

  }
  public static String solution(int n) {
    StringBuilder sb = new StringBuilder();
    int tmp = n;

    while(true){
      if(tmp < 4)
        break;

      int idx = tmp % 3;
      tmp /= 3;

      switch(idx){
        case 1:
          sb.append("1");
          break;
        case 2:
          sb.append("2");
          break;
        case 0:
          sb.append("4");
          tmp--;
          break;
      }
    }
    if(tmp == 1)
      sb.append("1");
    else if(tmp == 2)
      sb.append("2");
    else if(tmp == 3)
      sb.append("4");

    String answer = sb.reverse().toString();
    return answer;
  }
}