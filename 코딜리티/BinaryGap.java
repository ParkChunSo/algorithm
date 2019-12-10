import java.util.ArrayList;

class Solution {
    public int solution(int N) {
        StringBuilder sb = new StringBuilder();
        while(N != 1 ){
            sb.append(N % 2);
            N /= 2;
        }
        sb.append(N);

        ArrayList<Integer> list = new ArrayList<>();
        String s = sb.reverse().toString();
        int cnt = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == '0')
                cnt++;
            if(s.charAt(i) == '1' && i != 0){
                list.add(cnt);
                cnt = 0;
            }
        }

        int maxSequence = 0;
        for(int i = 0 ; i < list.size() ; i++){
            maxSequence = Math.max(maxSequence, list.get(i));
        }
        return maxSequence;
    }
}