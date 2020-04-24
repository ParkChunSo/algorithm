class Solution {
    String answer;
    public int solution(String answer_sheet, String[] sheets) {
        this.answer = answer_sheet;

        int maxCheatingPercentage = 0;
        for (int i = 0; i < sheets.length; i++) {
            for (int j = i + 1; j < sheets.length; j++) {
                maxCheatingPercentage = Math.max(maxCheatingPercentage, getCheatingPercentage(sheets[i], sheets[j]));
            }
        }

        return maxCheatingPercentage;
    }

    public int getCheatingPercentage(String sheet1, String sheet2) {
        int tmp = 0;
        int longestContinuousCheating = 0;
        int cheatingCnt = 0;
        for (int i = 0; i < answer.length(); i++) {
            if (sheet1.charAt(i) == sheet2.charAt(i) && sheet1.charAt(i) != answer.charAt(i)) {
                cheatingCnt++;
                tmp++;
            } else {
                longestContinuousCheating = Math.max(longestContinuousCheating, tmp);
                tmp = 0;
            }
        }
        if (tmp != 0) {
            longestContinuousCheating = Math.max(longestContinuousCheating, tmp);
        }
        return cheatingCnt + (longestContinuousCheating * longestContinuousCheating);
    }
}