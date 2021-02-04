import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'preprocessDate' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY dates as parameter.
     */

    public static List<String> preprocessDate(List<String> dates) {
        // Write your code here
        List<String> answer = new ArrayList<>();
        Map<String, String> monthMap = init();
        for(String date : dates){
            StringTokenizer st = new StringTokenizer(date);
            String day = getDay(st.nextToken());
            String month = monthMap.get(st.nextToken());
            String year = st.nextToken();
            answer.add(year + "-" + month + "-" + day);
        }
        return answer;
    }

    private static String getDay(String day){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < day.length() ; i++){
            if(day.charAt(i) >= '0' && day.charAt(i) <= '9')
                sb.append(day.charAt(i));
        }
        if(sb.length() == 1){
            sb.insert(0, "0");
        }
        return sb.toString();
    }

    private static Map<String, String> init(){
        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");
        return monthMap;
    }

}