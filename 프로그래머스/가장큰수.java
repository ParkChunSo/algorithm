import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] strings = new String[numbers.length];
        for(int i = 0 ; i < numbers.length ;i++)
            strings[i] = String.valueOf(numbers[i]);
        Arrays.sort(strings, (s1, s2) -> (s2+s1).compareTo(s1+s2));
        if(strings[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String tmp : strings)
            sb.append(tmp);
        return sb.toString();
    }
}