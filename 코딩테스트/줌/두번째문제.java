public int solution(String S, int[] C) {
        int cost = 0;
        ArrayList<Integer> list = new ArrayList<>();
        char preChar = S.charAt(0);
        for(int i = 1 ; i< S.length() ; i++) {
            if (preChar == S.charAt(i) && list.size() == 0)
                list.add(i - 1);

            if ((preChar != S.charAt(i) || i+1 == S.length()) && list.size() != 0){
                list.add(i);
                int[] tmp;
                if(i+1 == S.length())
                    tmp = Arrays.copyOfRange(C, list.get(0), list.get(1)+1);
                else
                    tmp = Arrays.copyOfRange(C, list.get(0), list.get(1));
                Arrays.sort(tmp);
                for(int k = 0 ; k < tmp.length-1 ; k++)
                    cost += tmp[k];

                list.clear();
            }
            preChar = S.charAt(i);
        }
        return cost;
    }