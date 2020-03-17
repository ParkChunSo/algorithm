class Solution {
    public int solution(String s) {
        if(s.length() == 1)
            return 1;
        int answer = Integer.MAX_VALUE;
        //1개 ~ 1/n개로 짤랐을때의 경우의 수
        for(int cutLine = 1 ; cutLine <= s.length()/2 ; cutLine++){
            int cnt = 1;
            StringBuilder sb = new StringBuilder();
            String loop = s.substring(0, cutLine);
            for(int j = cutLine * 2 ; j <= s.length() ; j+=cutLine){
                if(loop.equals(s.substring(j-cutLine, j))){
                    cnt++;
                }else{
                    if(cnt != 1)
                        sb.append(cnt).append(loop);
                    else
                        sb.append(loop);
                    cnt = 1;
                    loop = s.substring(j-cutLine, j);
                }
            }
            if(cnt != 1)
                sb.append(cnt).append(loop);
            else
                sb.append(loop);

            if(s.length() % cutLine != 0){
                sb.append(s, (s.length() / cutLine) * cutLine, s.length());
            }
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}