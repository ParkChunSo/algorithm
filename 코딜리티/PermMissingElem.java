    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        for(int i = 0 ; i < A.length ; i++){
            if(i+1 != A[i])
                return i+1;
        }
        return A.length+1;
    }