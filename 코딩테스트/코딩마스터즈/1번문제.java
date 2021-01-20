    public static long getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes, List<Integer> priceOfSkirts, List<Integer> priceOfTops, int budgeted) {
    // Write your code here
        List<Long> jeanAndShoes = new ArrayList<>();
        List<Long> skirtsAndTops = new ArrayList<>();
        for(int j : priceOfJeans){
            for(int s : priceOfShoes){
                jeanAndShoes.add((long)(j + s));
            }
        }
        
        for(int s : priceOfSkirts){
            for(int t : priceOfTops){
                skirtsAndTops.add((long)(s + t));
            }
        }
        
        jeanAndShoes.sort(Comparator.naturalOrder());
        skirtsAndTops.sort(Comparator.naturalOrder());
        
        long answer = 0;
        for(long js : jeanAndShoes){
            long val = budgeted - js;
            int high = upperBound(skirtsAndTops, val);
            answer += high;
        }
        
        return answer;
    }
    
    private static int upperBound(List<Long> list, long val){
        int start = 0, end = list.size();
        int mid;
        while(start < end){
            mid = (start +end) / 2;
            if(list.get(mid) <= val){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return end;
    }

}