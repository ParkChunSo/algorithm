import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public class Location{
        int time;
        int money;

        public Location(int time, int money) {
            this.time = time;
            this.money = money;
        }
    }
    public int solution(int K, int[][] travel) {
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(0, 0));
        int idx = 0, max = -1;
        while(!queue.isEmpty() && idx < travel.length){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                Location l = queue.poll();
                max = Math.max(max, l.money);
                if(l.time + travel[idx][0] <= K)
                    queue.offer(new Location(l.time + travel[idx][0], l.money + travel[idx][1]));
                if(l.time + travel[idx][2] <= K)
                    queue.offer(new Location(l.time + travel[idx][2], l.money + travel[idx][3]));
            }
            idx++;
        }
        while(!queue.isEmpty())
            max = Math.max(max, queue.poll().money);
        return max;
    }
}