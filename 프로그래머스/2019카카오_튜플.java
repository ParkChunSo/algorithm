import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
    public int[] solution(String s) {

        List<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s, "{}");
        while(st.hasMoreTokens()){
            String tmp = st.nextToken();
            if(!tmp.equals(",")){
                list.add(tmp);
            }
        }
        list.sort((Comparator.comparingInt(String::length)));

        List<Integer> answer = new ArrayList<>();
        for(String string : list){
            String[] arr = string.split(",");
            for(String num : arr){
                int element = Integer.parseInt(num);
                if(!answer.contains(element))
                    answer.add(element);
            }
        }
        int[] arr = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            arr[i] = answer.get(i);
        }

        return arr;
    }
}