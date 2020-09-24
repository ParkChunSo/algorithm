class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long r = 0, l = 0, m = 0;
        for (int time : times) {
            r = Math.max(r, time);
        }

        r *= n;

        while (l <= r) {
            long done = 0;
            m = (r + l) / 2;

            for (int time : times) {
                done += m / time;
            }
            if (done < n) {
                l = m + 1;
            } else {
                r = m - 1;
                if (m < answer)
                    answer = m;
            }
        }
        return answer;
    }
}