    public int[] solution(int[][] paths){

        int[] pathList = new int[100000];
        Arrays.fill(pathList, -1);
        for(int[] tmp : paths){
            pathList[tmp[0]] = tmp[1];
        }
        ArrayList<Integer> answer = new ArrayList<>();
        int start = -1, end = -1;
        for(int i = 0 ; i < pathList.length ; i++){
            if(pathList[i] == -1) {
                if(start != -1 && end != -1){
                    answer.add(start); answer.add(end);
                    start = -1; end = -1;
                }
                continue;
            }
            if(pathList[i] < i && end == -1) {
                end = pathList[i];
            }
            else if(pathList[i] < i){
                start = i;
            }
            if(pathList[i] > i && start == -1)
                start = i;
            else if(pathList[i] > i){
                end = pathList[i];
            }
        }
        int[] answerArr = new int[answer.size()];
        for(int i = 0 ; i < answer.size() ; i++)
            answerArr[i] = answer.get(i);
        return answerArr;
    }