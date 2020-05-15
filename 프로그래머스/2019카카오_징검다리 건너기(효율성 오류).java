import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    class Pair {
        private int val;
        private int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        public int getVal() {
            return this.val;
        }

        public int getIdx() {
            return idx;
        }
    }

    int k;
    boolean[] visited;
    List<Pair> stoneList = new ArrayList<>();

    public int solution(int[] stones, int k) {
        this.k = k;
        this.visited = new boolean[stones.length];

        int answer = 0;
        for (int i = 0; i < stones.length; i++)
            stoneList.add(new Pair(stones[i], i));

        stoneList.sort(Comparator.comparing(Pair::getVal).thenComparing(Pair::getIdx));

        for (Pair pair : stoneList) {
            if (isContinue(pair.idx)) {
                answer = pair.val;
                break;
            }
        }

        return answer;
    }

    public boolean isContinue(int idx) {
        int left = idx - (k - 1);
        int right = idx + (k - 1);
        visited[idx] = true;
        if (left < 0)
            left = 0;
        if (right >= visited.length)
            right = visited.length - 1;

        int cnt = 0;
        while (left <= right) {
            if (visited[left]) {
                cnt++;
            } else {
                if (cnt < k)
                    cnt = 0;
                else {
                    break;
                }
            }
            left++;
        }
        return cnt >= k;
    }
}