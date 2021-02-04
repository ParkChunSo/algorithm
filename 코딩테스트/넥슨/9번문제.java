public static List<String> smallestNegativeBalance(List<List<String>> debts) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();
        for(List<String> list : debts){
            map.putIfAbsent(list.get(0), 0);
            map.putIfAbsent(list.get(1), 0);
            int val = Integer.parseInt(list.get(2));
            map.put(list.get(0), map.get(list.get(0)) - val);
            map.put(list.get(1), map.get(list.get(1)) + val);
        }
        int minDebt = Integer.MAX_VALUE;
        List<String> answer = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key) < 0){
                if(map.get(key) < minDebt){
                    answer = new ArrayList<>();
                    minDebt = map.get(key);
                    answer.add(key);
                }else if(map.get(key) == minDebt){
                    answer.add(key);
                }
            }
        }

        if(answer.size() == 0)
            answer.add("Nobody has a negative balance");

        answer.sort(Comparator.naturalOrder());
        return answer;
    }