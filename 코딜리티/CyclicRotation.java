public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int[] answer = new int[A.length];
        K = K % A.length;
        int idx = K;
        for(int i = 0 ; i < A.length ; i++){
            if(idx == A.length)
                idx = 0;
            answer[idx] = A[i];
            idx++;
        }
        return answer;
    }