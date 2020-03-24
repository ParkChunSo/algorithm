import java.util.*;

class Solution {
    public boolean[] visited;
    public String[] words;
    public int solution(String begin, String target, String[] words) {
        this.visited= new boolean[words.length];
        this.words = words;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        
        int cnt = 0;
        boolean flag = false;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i = 0 ; i < queueSize ; i++){
                String str = queue.poll();
                if(cnt != 1){
                    checkVisited(str);
                }
                if(str.equals(target)){
                    flag = true;
                    break;
                }
                
                for(int j = 0 ; j < words.length ; j++){
                    if(canChange(str, words[j]) && !visited[j])
                        queue.offer(words[j]);
                }
            }
            
            if(flag){
                break;
            }else{
                cnt++;
            }
        }
        
        if(!flag)
            return 0;
        
        return cnt;
    }
    
    public void checkVisited(String str){
        for(int i = 0 ; i < words.length ; i++){
            if(words[i].equals(str))
                visited[i] = true;
        }
    }
    
    public boolean canChange(String begin, String target){
        int cnt = 0;
        for(int i = 0 ; i < begin.length() ; i++){
            if(begin.charAt(i) != target.charAt(i))
                cnt++;
        }
        if(cnt == 1)
            return true;
        
        return false;
    }
}