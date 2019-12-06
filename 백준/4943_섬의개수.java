import java.math.BigInteger;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while(true){
      int w = sc.nextInt();
      int h = sc.nextInt();
      int index = 1;
      int[][] map = new int[h][w];
      int[][] visit = new int[h][w];

      if(w == 0 || h == 0)
        break;

      for(int i = 0 ; i < h ; i++){
        for(int j = 0 ; j < w ; j++)
          map[i][j] = sc.nextInt();
      }


      for(int y = 0 ; y < h ; y++){
        for(int x = 0 ; x < w ; x++){
          if(map[y][x] != 1 || visit[y][x] != 0)
            continue;
          LinkedList<Pairs> queue = new LinkedList<>();
          queue.offer(new Pairs(x, y));
          while(!queue.isEmpty()){
            Pairs start = queue.poll();
            if(visit[start.y][start.x] != 0)
              continue;
            visit[start.y][start.x] = index;

            if(start.x + 1 < w && map[start.y][start.x+1] == 1)
              queue.offer(new Pairs(start.x+1, start.y));

            if(start.y + 1 < h && map[start.y+1][start.x] == 1)
              queue.offer(new Pairs(start.x, start.y+1));

            if(start.x + 1 < w && start.y + 1 < h && map[start.y+1][start.x+1] == 1)
              queue.offer(new Pairs(start.x + 1, start.y+1));

            if(start.x - 1 >= 0 && start.y + 1 < h && map[start.y+1][start.x-1] == 1)
              queue.offer(new Pairs(start.x - 1, start.y+1));

            if(start.x - 1 >= 0 && map[start.y][start.x - 1] == 1)
              queue.offer(new Pairs(start.x-1, start.y));

            if(start.x - 1 >= 0 && start.y - 1 >= 0 && map[start.y-1][start.x-1] == 1)
              queue.offer(new Pairs(start.x - 1, start.y - 1));

            if(start.y - 1 >= 0 && map[start.y - 1][start.x] == 1)
              queue.offer(new Pairs(start.x, start.y-1));

            if(start.x + 1 < w && start.y - 1 >= 0 && map[start.y-1][start.x+1] == 1)
              queue.offer(new Pairs(start.x + 1, start.y - 1));
          }
          index++;
        }
      }
      System.out.println(index-1);
    }

  }
  public static class Pairs{
    int x;
    int y;
    Pairs(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
}