    public int solution(int[] arr){
        int answer = 0;
        int tmp = 1;
        boolean flag = arr[0] < arr[1];
        for(int i = 1 ; i < arr.length-1 ; i++){
            if(keepGoing(arr, i, flag)){
                flag = !flag;
                tmp++;
            }else{
                answer = Math.max(answer, tmp+1);
                tmp = 1;
                flag = arr[i] < arr[i + 1];
            }
        }
        return Math.max(answer, tmp+1);
    }
    private boolean keepGoing(int[] arr, int i, boolean flag){
        return (arr[i] < arr[i+1] && !flag)
                || (arr[i] > arr[i+1] && flag);
    }