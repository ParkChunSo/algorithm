public String solution(String S) {
        StringBuffer sb = new StringBuffer(S);
        for(int i = 0 ; i < sb.length() - 1 ; i++){
            if((sb.charAt(i) == 'A' && sb.charAt(i+1) == 'B')
                    || (sb.charAt(i) == 'B' && sb.charAt(i+1) == 'A')
                    ||(sb.charAt(i) == 'C' && sb.charAt(i+1) == 'D')
                    ||(sb.charAt(i) == 'D' && sb.charAt(i+1) == 'C')){
                sb.deleteCharAt(i); sb.deleteCharAt(i);
                if(i != 0)
                    i -= 2;
                else
                    i -= 1;
            }
        }
        return sb.toString();
    }