import java.util.Arrays;
// 일단 Arrays.sort()를 통해 오름차순으로 정렬
// 연산을 통해 새로운 배열에 넣음
// Arrrays.sort를 하고 가장 작은 숫자가 K를 넘으면 break; 아니면 다시 연산.
class Solution {
    public int solution(int[] scoville, int K) {
        if(K== 0)
            return 0;
        int answer = 0;
        Arrays.sort(scoville);
        while(true){
            if(scoville[1] == 1000000000){
                answer = -1;
                break;
            }
            if(scoville[0] > K)
                break;
            scoville[0] = scoville[0] + (scoville[1] * 2);
            scoville[1] = 1000000000;
            answer++;
            Arrays.sort(scoville);
        }
        return answer;
    }
}