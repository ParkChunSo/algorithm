class Solution {
	public long solution(int w,int h) {
        // 최대 공약수 구하기
        long val1 = (long)w, val2 = (long)h;
        if( val2 > val1 ){
            long tmp = val1;
            val1 = val2;
            val2 = tmp;
        }
        long r = 1;
        while(r != 0){
            r = val1 % val2;
            val1 = val2;
            val2 = r;
        }
        long blankBox = (w / val1) + (h / val1) - 1;
        long totalBlankBox = blankBox * (w / (w / val1));
        long totalBox = w * h;
        
		return totalBox - totalBlankBox;
	}
}