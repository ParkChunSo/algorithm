import java.util.*;

class Solution {
    public boolean[][] visited;
    public int[][] picture;
    public int numberOfArea = 0, maxSizeOfOneArea = 0;
    class Location{
        int y;
        int x;
        Location(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public int[] solution(int m, int n, int[][] picture) {
        this.picture = picture;
        visited = new boolean[m][n];

        for(int y = 0 ; y < m ; y++){
            for(int x = 0 ; x < n ; x++){
                if(visited[y][x] || picture[y][x] == 0)
                    continue;
                bfs(y,x);
                numberOfArea++;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public void bfs(int y, int x){
        // 처음부터 BFS로 전체 배열을 탐색하며 visited에 체크
        // Queue에서 뺄때 마다 maxSizeOfOneArea++, 만약 Queue가 다 비워지면 numberOfArea++
        int sizeOfOneArea = 0;
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(y,x));
        System.out.println(" ( "+y+" , "+x+" ) 탐색 시작");
        while(!queue.isEmpty()){
            Location now = queue.poll();
            if(visited[now.y][now.x])
                continue;
            visited[now.y][now.x] = true;
            sizeOfOneArea++;
            //상하좌우 탐색
            if(now.y - 1 > -1 && !visited[now.y-1][now.x] && picture[now.y-1][now.x] == picture[now.y][now.x]){
                queue.offer(new Location(now.y-1, now.x));
            }
            if(now.y + 1 < picture.length && !visited[now.y+1][now.x] && picture[now.y+1][now.x] == picture[now.y][now.x]){
                queue.offer(new Location(now.y+1, now.x));
            }
            if(now.x - 1 > -1 && !visited[now.y][now.x-1] && picture[now.y][now.x-1] == picture[now.y][now.x]){
                queue.offer(new Location(now.y, now.x-1));
            }
            if(now.x + 1 < picture[0].length && !visited[now.y][now.x+1] && picture[now.y][now.x+1] == picture[now.y][now.x]){
                queue.offer(new Location(now.y, now.x+1));
            }
        }
        //maxsize Math.max()사용
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfOneArea);
    }
}