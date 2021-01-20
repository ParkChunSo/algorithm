import java.util.*;

class Solution {
    int min = Integer.MAX_VALUE, max = 0;
    LinkedList<Integer> interDistance = new LinkedList<>();

    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        setInterDistance(rocks, distance);

        //이분탐색 시작
        while (min <= max) {
            int mid = (min + max) / 2;
            int cnt = n;
            boolean isBig = false;
            LinkedList<Integer> tmp = new LinkedList<>(interDistance);
            //mid값이 거리의 최소값 중 최대값이라생각하고
            //사이 거리값중 작은 원소가 있다면 cnt--(돌제거)
            for (int i = 0; i < tmp.size(); i++) {
                if (tmp.get(i) >= mid)
                    continue;
                // n개의 바위만 제가할 수 있도록 브레이크 역할
                cnt--;
                if (cnt < 0) {
                    isBig = true;
                    max = mid - 1;
                    break;
                }

                //다음 원소값 또한 mid보다 작다면 합친다.
                if (i < tmp.size()-1 && tmp.get(i+1) < mid) {
                    int v = tmp.remove(i) + tmp.remove(i);
                    tmp.add(i, v);
                    i--;//합쳐도 작을 수 있기때문
                }
            }
            if(!isBig)
                min = mid+1;
        }
        return max;
    }

    //rocks 배열을 정렬하고 각 rock사이의 거리값을 계산
    //이분탐색을 위해 사이 거리값중 가장 큰, 작은 값을 찾음.
    private void setInterDistance(int[] rocks, int distance) {
        interDistance.add(rocks[0]);
        if (rocks[0] > max)
            max = rocks[0];
        if (rocks[0] < min)
            min = rocks[0];
        for (int i = 1; i < rocks.length; i++) {
            int v = rocks[i] - rocks[i - 1];
            if (v > max)
                max = v;
            if (v < min)
                min = v;
            interDistance.add(v);
        }
        int diff = distance - rocks[rocks.length - 1];
        if (diff > max)
            max = diff;
        if (rocks[0] < min)
            min = diff;
        interDistance.add(diff);
    }
}