import java.util.Stack;

class Solution {
    int[][] map;
    Stack<Integer> stack = new Stack<>();

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        map = board;
        for (int i : moves) {
            if (move(i - 1)) {
                answer += 2;
            }
        }
        return answer;
    }

    public boolean move(int idx) {
        for (int i = 0; i < map.length; i++) {
            if (map[i][idx] != 0) {
                if (!stack.isEmpty() && stack.peek() == map[i][idx]) {
                    stack.pop();
                    map[i][idx] = 0;
                    return true;
                } else {
                    stack.push(map[i][idx]);
                    map[i][idx] = 0;
                    return false;
                }
            }
        }
        return false;
    }
}