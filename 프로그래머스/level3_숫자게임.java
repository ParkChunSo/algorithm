import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int cnt = 0, idxB = B.length -1, idxA = A.length - 1;
        for(int i = idxB ; i >= 0 ; i--){
            for(int k = idxA ; k >= 0 ; k--){
                if(B[i] > A[k]) {
                    cnt++;
                    idxA = k -1;
                    break;
                }
            }
        }

        return cnt;
    }
}