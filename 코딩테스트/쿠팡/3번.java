public int solution(int k, int[] score) {
        int cnt = 0;
        Map<Integer, Tmp> map = new HashMap<>();

        for(int i = 1 ; i < score.length ; i++){
            int diff = score[i-1] - score[i];
            if(map.get(diff) == null)
                map.put(diff, new Tmp());
            map.get(diff).cnt++;
            map.get(diff).set.add(i);
            map.get(diff).set.add(i-1);
        }

        boolean[] visited = new boolean[score.length];
        for(int i : map.keySet()){
            if(map.get(i).cnt < k){
                continue;
            }
            for(int j : map.get(i).set){
                visited[j] = true;
            }
        }

        for (boolean b : visited) {
            if (!b)
                cnt++;
        }
        return cnt;
    }

    class Tmp{
        int cnt;
        Set<Integer> set;

        public Tmp() {
            cnt = 0;
            set = new HashSet<>();
        }
    }