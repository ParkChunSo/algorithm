import java.util.Stack;

class Solution {
    public String solution(String p) {
        if(p.equals(""))
            return "";

        int idx = findBalancedStringIdx(p);
        StringBuilder u = new StringBuilder(p.substring(0, idx));
        StringBuilder v = new StringBuilder(p.substring(idx));

        if(isPerfectString(u.toString())){
            u.append(solution(v.toString()));
            return u.toString();
        }else{
            StringBuilder sb = new StringBuilder("(");
            sb.append(solution(v.toString())).append(")");
            u.deleteCharAt(0).deleteCharAt(u.length()-1);
            sb.append(reverse(u.toString()));
            return sb.toString();
        }
    }

    private int findBalancedStringIdx(String p){
        int left =0, right = 0;
        for(int idx = 0; idx < p.length() ; idx++){
            switch (p.charAt(idx)){
                case '(':
                    left++;
                    break;
                case ')':
                    right++;
                    break;
            }
            if(left == right)
                return idx+1;
        }

        return p.length()-1;
    }


    private boolean isPerfectString(String str){
        if(str.charAt(0) == ')')
            return false;

        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == ')'){
                if(stack.isEmpty())
                    return false;

                stack.pop();
            }else{
                stack.push(str.charAt(i));
            }
        }

        return true;
    }

    private String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(')
                sb.append(')');
            else
                sb.append('(');
        }
        return sb.toString();
    }
}