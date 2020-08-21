class Solution {
    private final String[][] p = {
            {"*", "+", "-"},
            {"*", "-", "+"},
            {"+", "*", "-"},
            {"+", "-", "*"},
            {"-", "*", "+"},
            {"-", "+", "*"}
    };

    public long solution(String expression) {
        String[] numTmp = expression.split("[*+\\-]");
        String[] operationTmp = expression.split("[0-9]");

        ArrayList<Long> nums = new ArrayList<>();
        ArrayList<String> operation = new ArrayList<>();

        for (String s : numTmp) {
            nums.add((long) Integer.parseInt(s));
        }
        for (String s : operationTmp) {
            if (s.equals(""))
                continue;
            operation.add(s);
        }

        long answer = 0;
        for (String[] totalCase : p) {
            LinkedList<Long> numList = new LinkedList<>(nums);
            LinkedList<String> operationList = new LinkedList<>(operation);
            for(int operationIdx = 0 ; operationIdx < totalCase.length ; operationIdx++){
                for(int i = 0; i < operationList.size() ; i++){
                    if(!operationList.get(i).equals(totalCase[operationIdx]))
                        continue;
                    long preNum = numList.get(i);
                    long postNum = numList.get(i+1);
                    operationList.remove(i);
                    numList.remove(i+1);
                    numList.remove(i);
                    numList.add(i, getResult(preNum, postNum, totalCase[operationIdx]));
                    i--;
                }
            }
            answer = Math.max(answer, Math.abs(numList.get(0)));
        }

        return answer;
    }

    private long getResult(long preNum, long postNum, String operation){
        if(operation.equals("*")){
            return preNum * postNum;
        }else if(operation.equals("+")){
            return preNum + postNum;
        }else{
            return preNum - postNum;
        }
    }
}