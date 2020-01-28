import java.util.Arrays;

class Solution {
    public int solution(int[] budgets, int M) {
        int N = budgets.length;
        int avgBudget = M/N, nowCnt = 0, underBudget = 0;
        Arrays.sort(budgets);
        long sum = 0;
        for(int tmp : budgets)
            sum += tmp;
        if(sum < M)
            return budgets[budgets.length - 1];

        while(true) {
            for (int budget : budgets) {
                int tmp = avgBudget-budget;
                if(tmp > 0) {
                    underBudget += budget;
                }
                else if(tmp < 0) {
                    nowCnt += 1;
                }
            }

            int expectBudget = (nowCnt * avgBudget) + underBudget;
            int degreeBudget = M - expectBudget;
            if(degreeBudget < nowCnt)
                break;

            avgBudget += degreeBudget / nowCnt;
            nowCnt = underBudget = 0;
        }
        return avgBudget;
    }
}