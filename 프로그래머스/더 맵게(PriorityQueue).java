import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int tmp : scoville)
            queue.offer(tmp);

        while(queue.peek() < K){
            if(queue.size() == 1){
                return -1;
            }
            
            int val1 = queue.poll();
            int val2 = queue.poll();
            val1 += val2 * 2;
            answer++;
        }
        return answer;
    }
}