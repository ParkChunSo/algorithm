import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Info> stack = new Stack<>();
        stack.push(new Info(0, prices[0]));
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= stack.peek().price) {
                stack.push(new Info(i, prices[i]));
                continue;
            }

            while (!stack.isEmpty()) {
                Info pop = stack.pop();
                if (prices[i] >= pop.price) {
                    stack.push(pop);
                    break;
                }
                answer[pop.idx] = i - pop.idx;
            }
            stack.push(new Info(i, prices[i]));
        }
        while (!stack.isEmpty()) {
            Info pop = stack.pop();
            answer[pop.idx] = prices.length - pop.idx - 1;
        }

        return answer;
    }

    public class Info {
        int idx;
        int price;

        public Info(int idx, int price) {
            this.idx = idx;
            this.price = price;
        }
    }
}