public int solution(int[] A) {
        if(A.length < 3)
            return A.length;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(A[0]); queue.offer(A[1]);
        int answer = 0, maxLength = 2;
        for(int i = 2 ; i < A.length ; i++){
            if(!queue.contains(A[i])){
                queue.poll();
                queue.offer(A[i]);
                answer = Math.max(answer, maxLength);
                maxLength = 2;
            }
            maxLength++;
        }
        answer = Math.max(answer, maxLength);

        return answer;
    }