//완전탐색으로 시간초과

class Solution {
    public int solution(int[] A, int[] B) {
        if(B.length == 1){
            if(A[0] > B[0])
                return 0;
            else
                return 1;
        }

        int maxium = -1;
        for(int i = 0 ; i < B.length ; i++){
            int cnt = 0;
            if(B[i] > A[i])
                cnt++;
            int[] copyA = new int[B.length-1];
            int[] copyB = new int[B.length-1];
            int idx = 0;
            for(int j = 0 ; j < B.length ; j++){
                if( i == j)
                    continue;

                copyA[idx] = A[j];
                copyB[idx] = B[j];
                idx++;
            }

            maxium = Math.max(maxium, solution(copyA, copyB) + cnt);
        }

        return maxium;
    }
}