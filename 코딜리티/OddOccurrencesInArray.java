import java.util.ArrayList;

class Solution {
    public int solution(int[] A) {
        if(A.length == 1)
            return A[0];

        ArrayList<Integer> seq = new ArrayList<>();
        seq.add(A[0]);
        for(int i = 1 ; i < A.length ; i++){
            if(!seq.contains(A[i])){
                seq.add(A[i]);
                continue;
            }
            seq.remove(seq.indexOf(A[i]));
        }

        return seq.get(0);
    }
}
