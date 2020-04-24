class Solution {
    int[] visit, bridge;
    public int solution(int[] nums) {
        bridge = nums;
        visit = new int[nums.length];

        return dfs(0);
    }
    public int dfs(int index){
        if(index == 0 ){
            return dfs(bridge[index]) + 1;
        }
        if(index == bridge.length-1)
            return 0;

        if(visit[index] != 0){
            return visit[index];
        }

        int left = index - bridge[index];
        int right = index + bridge[index];
        if(left <= 0 || bridge[left] == 0){
            return visit[index] = dfs(right) + 1;
        }
        else if(right >= bridge.length || bridge[right] == 0) {
            return visit[index] = dfs(left) + 1;
        }
        else{
            return visit[index] = Math.min(dfs(left), dfs(right)) + 1;
        }
    }
}