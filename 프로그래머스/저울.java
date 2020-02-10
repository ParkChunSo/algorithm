import java.util.Arrays;

class Solution {
    public int solution(int[] weight) {
        int answer = 0;
        Arrays.sort(weight);
        for(int w : weight){
            if(answer + 1 < w)
                break;
            answer += w;
        }
        return answer + 1;
    }
}