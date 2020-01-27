import java.util.Stack;

class Solution {
    public int solution(String arrangement) {
        if(arrangement.length() < 3)
            return 0;

        int answer = 0;
        Stack<Character> stack = new Stack<>();
        stack.push(arrangement.charAt(0));

        for(int i = 1 ; i < arrangement.length() ; i++){
            char preC = arrangement.charAt(i-1);
            char nowC = arrangement.charAt(i);
            if(nowC == '('){
                stack.push(nowC);
            }
            else if(nowC == ')' && preC == '('){
                stack.pop();
                answer += stack.size();
            }
            else if(nowC == ')' && preC == ')'){
                stack.pop();
                answer += 1;
            }
        }
        return answer;
    }
}