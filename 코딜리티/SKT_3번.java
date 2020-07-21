// 일단 3파트로 나눈다.
// 각 파트의 a의 개수가 같도록 나눌 수 있는 경우의 수를 출력하는 문제
public class Solution {
    String str;
    final int FINAL_PART = 3;
    public int solution(String S) {
        str = S;

        int result = 0;
        int limitedSize = str.length() - 2;
        for(int i = 1 ; i <= limitedSize ; i++){
            result += dfs(i, 2, getACnt(0, i-1));
        }

        return result;
    }

    public int dfs(int startIdx, int partIdx, int aCnt){
        if(partIdx == FINAL_PART){
            if(getACnt(startIdx, str.length()-1) == aCnt) //a의 개수가 동일할 경우
                return 1;
            return 0;
        }

        int result = 0;
        int limitedSize = str.length() - (FINAL_PART - partIdx); //남은 파트를 위한 idx
        for(int i = 1 ; startIdx + i <= limitedSize ; i++){
            if(getACnt(startIdx, startIdx+i-1) != aCnt)
                continue;

            result += dfs(startIdx+i, partIdx+1, aCnt);
        }

        return result;
    }

    public int getACnt(int startIdx, int endIdx){
        int result = 0;

        for(int i = startIdx ; i <=endIdx ; i++){
            if(str.charAt(i) == 'a')
                result++;
        }

        return result;
    }
}