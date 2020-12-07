public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new TreeSet<>();
        for(int i = 0 ; i < A.length ; i++){
            if(A[i] <= 0)
                continue;
            set.add(A[i]);
        }
        int i = 1;
        for(int v : set){
            if(i != v) {
                return i;
            }
            i++;
        }
        return i;
    }