import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int solution(int n, int[][] results) {
        ArrayList<ArrayList<Integer>> winList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> loseList = new ArrayList<>();
        for(int i = 0 ; i < n+1; i++){
            winList.add(new ArrayList<>());
            loseList.add(new ArrayList<>());
        }
        for(int[] tmp : results){
            winList.get(tmp[0]).add(tmp[1]);
            loseList.get(tmp[1]).add(tmp[0]);
        }
        int count = 0;
        for(int i = 1 ; i < n+1 ; i++){
            boolean[] winVisit = dfs(winList, n, i);
            boolean[] loseVisit = dfs(loseList, n, i);
            if(checkAllVisit(winVisit, loseVisit))
                count++;
        }
        return count;
    }
    public boolean checkAllVisit(boolean[] visit1, boolean[] visit2){
        for(int i = 0 ; i < visit1.length ; i++){
            if(!visit1[i] && !visit2[i])
                return false;
        }
        return true;
    }
    public boolean[] dfs(ArrayList<ArrayList<Integer>> list,int n, int idx){
        boolean[] visit = new boolean[n+1];
        visit[0] = visit[idx] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(idx);
        while(!stack.isEmpty()){
            int node = stack.pop();
            visit[node] = true;
            for(int tmp : list.get(node)){
                if(!visit[tmp])
                    stack.push(tmp);
            }
        }
        return visit;
    }
}