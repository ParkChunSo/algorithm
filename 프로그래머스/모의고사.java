import java.util.ArrayList;
class Solution {
    int[] answers;
    public int[] solution(int[] answers) {
        this.answers = answers;
        int[] first = { 1, 2, 3, 4, 5 };
        int[] second = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] third = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        
        int[] answer = new int[3];
        answer[0] = checkAnswer(first);
        answer[1] = checkAnswer(second);
        answer[2] = checkAnswer(third);
        
        int maxValue = -1;
        for(int i = 0 ; i < answer.length ; i++){
            if(answer[i] > maxValue){
                maxValue = answer[i];
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < answer.length ; i++){
            if(maxValue == answer[i])
                list.add(i+1);
        }
        int[] tmp = new int[list.size()];
        for(int i = 0 ; i < tmp.length ; i++)
            tmp[i] = list.get(i);
        return tmp;
    }
    
    public int checkAnswer(int[] person){
        int cnt = 0;
        for(int i = 0 ; i < answers.length ; i++){
            if(answers[i] == person[i % person.length])
                cnt++;
        }
        return cnt;
    }
}