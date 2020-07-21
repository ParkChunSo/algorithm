    public int solution(int A, int B) {
        int result = 0;
        char[] chars = Integer.toBinaryString(A * B).toCharArray();
        for(char c : chars){
            if(c == '1')
                result++;
        }
        return result;
    }