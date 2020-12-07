public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] answer = new int[N];
        int maxCounter = 0;
        int maxCount = 0;
        for(int v : A){
            if(v == N+1){
                maxCounter = maxCount;
                continue;
            }
            if(answer[v-1] < maxCounter)
                answer[v-1] = maxCounter;

            if(++answer[v-1] > maxCount){
                maxCount = answer[v-1];
            }
        }
        for(int i = 0 ; i < answer.length ; i++){
            if(answer[i] < maxCounter)
                answer[i] = maxCounter;
        }
        return answer;
    }