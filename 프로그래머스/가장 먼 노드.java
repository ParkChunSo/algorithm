import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> vertex = new ArrayList<>();
        for(int i = 0 ; i < n+1 ; i++){
            vertex.add(new ArrayList<>());
        }
        for(int[] tmp : edge){
            vertex.get(tmp[0]).add(tmp[1]);
            vertex.get(tmp[1]).add(tmp[0]);
        }
        int[] howFar = new int[n+1], checkedNode = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(checkedNode[node] != 0)
                continue;
            checkedNode[node] = 1;
            ArrayList<Integer> list = vertex.get(node);
            for(int tmp : list) {
                if(queue.contains(tmp) || checkedNode[tmp] != 0)
                    continue;
                queue.offer(tmp);

                if(howFar[tmp] != 0)
                    howFar[tmp] = Math.min(howFar[tmp], howFar[node] + 1);
                else
                    howFar[tmp] = howFar[node] + 1;
            }
        }
        Arrays.sort(howFar);
        int maxPath = howFar[howFar.length -1], count = 1;
        for(int i = howFar.length - 2; i > 0 ; i--){
            if(howFar[i] != maxPath)
                break;
            count++;
        }
        return count;
    }
}