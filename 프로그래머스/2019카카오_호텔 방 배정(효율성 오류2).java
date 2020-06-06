import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long k = 10;
        long[] room_number = {1L,3L,4L,1L,3L,1L};
        long[] answer = solution.solution(k, room_number);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    Map<Long, Long> map = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            answer[i] = findRoom(room_number[i]);
        }
        return answer;
    }

    public long findRoom(long wanted) {
        if (map.get(wanted) == null) {
            map.put(wanted, wanted + 1);
            return wanted;
        }

        return findRoom(wanted + 1);
    }
}