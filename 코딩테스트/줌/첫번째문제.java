public int solution(String S) {
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Integer> checkedIndex = new ArrayList<>();
        int cnt = 1;
        for(int i = 0 ; i < S.length() ; i++){
            if(list.contains(S.charAt(i))) {
                int beforeIdx = list.lastIndexOf(S.charAt(i));
                boolean tmp = true;
                for(int index : checkedIndex){
                    if(beforeIdx < index)
                        tmp = false;
                }
                if(tmp || checkedIndex.size() == 0)
                    cnt++;

                checkedIndex.add(beforeIdx);
                checkedIndex.add(i);
            }

            list.add(S.charAt(i));
        }
        return cnt;
}