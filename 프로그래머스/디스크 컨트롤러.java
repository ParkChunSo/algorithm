class Solution {
    int[][] jobs;
    boolean[] visited;
    public int solution(int[][] jobs) {
        int answer = 0;
        this.jobs = jobs;
        visited = new boolean[jobs.length];
        //제일 먼저 들어온 job을 찾는다.
        int firstJobIdx = 0;
        for(int i = 1 ; i<jobs.length ; i++){
            if(jobs[firstJobIdx][0] > jobs[i][0])
                firstJobIdx = i;
        }
        visited[firstJobIdx] = true;
        return (dfs(firstJobIdx, jobs[firstJobIdx][0]) + jobs[firstJobIdx][1]) / jobs.length;
    }

    //idx번째를 수행했을 때 얻을 수 있는 최단 시간
    public int dfs(int idx,int startTime){
        // idx의 작업을 실행한다.
        int endTime = startTime + jobs[idx][1];

        // idx의 작업이 끝나는 시간보다 작업 요청이 먼저 들어온 작업들 중 처리하지 않은 작업들을 재귀
        boolean flag = false;
        int answer = Integer.MAX_VALUE;
        for(int i = 0 ; i < jobs.length ; i++){
            if(jobs[i][0] <= endTime && !visited[i]){
                flag = true;
                visited[i] = true;
                answer = Math.min(answer, dfs(i, endTime) + (endTime - jobs[i][0] + jobs[i][1]));
                visited[i] = false;
            }
        }

        if(!flag)
            return 0;

        return answer;
    }
}