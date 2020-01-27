class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] strings = s.split(" ");
        for(String tmp : strings){
            if(tmp.equals("")) {
                answer.append(" ");
                continue;
            }
            char[] chars = tmp.toLowerCase().toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            answer.append(chars);
            answer.append(" ");
        }
        answer.delete(answer.length()-1, answer.length());
        return answer.toString();
    }
}