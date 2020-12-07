public int solution(int[] A) {
        // write your code in Java SE 8
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for(int i = 1 ; i < A.length ; i++){
            sum[i] = A[i]+sum[i-1];
        }

        int totalSum = sum[A.length - 1];
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1 ; i < A.length ; i++){
            int v = sum[i-1] - (totalSum - sum[i-1]);
            minDiff = Math.min(minDiff, Math.abs(v));
        }
        return minDiff;
    }