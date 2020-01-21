import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {

    public int solution(int[][] routes) {
        int answer = 0;
        List<Route> routeList = new ArrayList<>();

        for(int[] route : routes){
            routeList.add(new Route(route[0], route[1]));
        }
        routeList.sort(new Comparator<Route>() {
            @Override
            public int compare(Route route1, Route route2) {
                if(route1.end > route2.end)
                    return 1;
                else if(route1.end == route2.end)
                    return 0;

                return -1;
            }
        });

        boolean[] memo = new boolean[routeList.size()];
        Arrays.fill(memo, false);
        for(int i = 0 ; i < routeList.size() ;i++){
            if(memo[i])
                continue;
            Route route = routeList.get(i);
            int time = route.end;
            for(int j = i+1 ; j < routeList.size() ; j++){
                Route tmp = routeList.get(j);
                if(tmp.contained(time)){
                    memo[j] = true;
                }
            }
            answer++;
        }

        return answer;
    }

    class Route {
        int start;
        int end;
        Route(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean contained(int time){
            if(start <= time
                && end >= time)
                return true;

            return false;
        }
    }
}
