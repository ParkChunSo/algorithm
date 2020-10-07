import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : scoville){
            queue.offer(i);
        }
        
        int answer = 0;
        while(!queue.isEmpty()){
            int poll = queue.poll();
            if(poll >= K){
                break;
            }
            if(queue.isEmpty()){
                return -1;
            }
            answer++;
            int next = queue.poll();
            queue.offer(poll+(next*2));
        }
        return answer;
    }
}