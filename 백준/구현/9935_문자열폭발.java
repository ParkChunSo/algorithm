import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        String s2 = br.readLine();
        int idx = 0;
        while(idx+s2.length() <= sb.length()){
            boolean isBoom = true;
            for(int i = idx ; i < idx+s2.length() ; i++){
                if(sb.charAt(i) != s2.charAt(i - idx)){
                    isBoom = false;
                    break;
                }
            }
            if(isBoom){
                sb.delete(idx, idx+s2.length());
                idx = idx == 0 ? idx-1 : idx-2;
            }
            idx++;
        }
        if(sb.length() == 0){
            System.out.println("FRULA");
        }else {
            System.out.println(sb.toString());
        }
    }
}