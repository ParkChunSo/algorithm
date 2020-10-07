public static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            if(map.get(i) == null)
                map.put(i, 0);
            map.put(i, map.get(i)+1);
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : brr){
            if(map.get(i) == null
                || map.get(i) == 0){
                queue.offer(i);
                continue;
            }
            map.put(i, map.get(i) - 1);
        }
        System.out.println(queue.size());
        
        int[] answer = new int[queue.size()];
        for(int i = 0 ; i <answer.length ; i++){
            answer[i] = queue.poll();
        }
        return answer;
    }