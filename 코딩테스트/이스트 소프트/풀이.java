import java.util.*;
class Solution {
    public int[] solution(String[] card_numbers) {
        int[] answer = new int[card_numbers.length];

        for(int i = 0 ; i < card_numbers.length ; i++){
            String cardNum = normalizeCardNums(card_numbers[i]);
            if(!checkCardNum(card_numbers[i]) || cardNum.equals("")){
                answer[i] = 0;
                continue;
            }

            if(checkLuhnValidation(cardNum))
                answer[i] = 1;
            else
                answer[i] = 0;
        }
        return answer;
    }
    
    //Luhn 공식을 통해 유효성 검사.
    private boolean checkLuhnValidation(String cardNum){
        int evenSum = 0;
        int oddSum = 0;

        for(int i = 0 ; i < cardNum.length() ; i++){
            int n = cardNum.charAt(i) - '0';
            if((i+1) % 2 == 0){
                int tmp = n * 2;
                evenSum += tmp/10 + tmp%10;
            }else{
                oddSum += n;
            }
        }
        return (evenSum + oddSum) % 10 == 0;
    }

    // 각 자리의 숫자가 올바르게 들어가 있는지 확인 후 문제열 뒤집기
    private String normalizeCardNums(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i));
            }
        }
        if(sb.length() != 16)
            return "";
        return sb.reverse().toString();
    }
    // - 가 3개 또는 0개인지, 각 자리의 4개의 원소가 있는지 확인.
    private boolean checkCardNum(String s){
        String[] split = s.split("-");
        if(split.length != 1 && split.length != 4)
            return false;
        if(split.length == 1)
            return true;

        for (String str : split) {
            if (str.length() != 4)
                return false;
        }
        return true;
    }
}