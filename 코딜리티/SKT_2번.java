public class Solution {
    int M, F;
    int[] A;
    int[] arr;

    public int[] solution(int[] A, int F, int M) {
        this.A = A;
        this.F = F;
        this.M = M;
        this.arr = new int[F];

        //조건이 맞는 배열을 찾았다면 해당 값을 리턴합니다.
        if(dfs(0))
            return arr;

        //조건이 맞는 배열이 없을 경우 빈 배열을 리턴합니다.
        return new int[1];
    }

    // 각 자리수에 1~6까지의 수를 삽입하였습니다.
    // 마지막 자리수까지 삽입이 완료되었다면 제공한 평균과 동일한지 맞는지 확인합니다.
    // 상기의 조건이 맞다면 현재 배열을 반환합니다.
    public boolean dfs(int idx){
        if(idx == F){
            return checkAverage();
        }

        for(int i = 1 ; i <= 6 ; i++){
            arr[idx] = i;
            if (dfs(idx + 1))
                return true;
        }
        return false;
    }

    // 조건을 확인하는 메소드로 제공된 평균값과 같은지를 확인하고,
    // 나머지가 없는지를 확인합니다.
    public boolean checkAverage(){
        int val = 0;
        for(int i : A)
            val += i;
        for(int i : arr)
            val += i;

        return (val % (A.length + arr.length) == 0)
                && (val / (A.length + arr.length) == M);
    }
}