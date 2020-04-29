import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long[] num = {1, 3, 4, 1, 3, 1};
        long[] answer = solution.solution(10, num);
        for (long a : answer)
            System.out.println(a);
    }

    ArrayList<Long> list = new ArrayList<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            if (!list.contains(room_number[i])) {
                answer[i] = room_number[i];
                list.add(room_number[i]);
            } else {
                for (long idx = room_number[i]; idx <= k; idx++) {
                    if (!list.contains(idx)) {
                        answer[i] = idx;
                        list.add(idx);
                        break;
                    }
                }
            }
        }
        return answer;
    }

//    public long findRoomNum(long wantedNum){
//
//    }
}