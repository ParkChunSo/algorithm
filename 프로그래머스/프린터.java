import java.util.*;

class Solution {
    class Document{
        int order;
        int priorities;
        Document(int order, int priorities){
            this.order = order;
            this.priorities = priorities;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Document> queue = new LinkedList<>();
        for(int i = 0 ; i < priorities.length ; i++){
            queue.offer(new Document(i, priorities[i]));
        }

        while(true){
            boolean isRight = true;
            Document document = queue.poll();
            answer++;
            for(int i = 0 ; i < queue.size() ; i++){
                if(document.priorities < queue.get(i).priorities){
                    queue.offer(document);
                    answer--;
                    isRight = false;
                    break;
                }
            }
            if(isRight && document.order == location)
                break;
        }
        return answer;
    }
}