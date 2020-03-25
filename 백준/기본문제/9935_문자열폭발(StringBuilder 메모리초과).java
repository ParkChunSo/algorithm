import java.util.*;

public class Main{
    static StringBuilder sb;
    static String bomb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder(sc.next());
        bomb = sc.next();

        while(true){
            if(!removeBomb())
                break;
        }

        if(sb.length() == 0)
            System.out.println("FRULA");
        else
            System.out.println(sb.toString());
    }

    //문자열 중 폭탄이 있으면 폭탄을 제거하고 제거를 한번이라도 하면 true를 반환
    //남아있는 sting이 있는지 검사도 필수
    public static boolean removeBomb(){
        boolean flag = false;
        int idx = 0;
        while(idx <= sb.length() - bomb.length() + 1){
            if(sb.charAt(idx) == bomb.charAt(0) && bomb.equals(sb.substring(idx, idx + bomb.length()))){
                flag = true;
                sb.delete(idx, idx + bomb.length());
                continue;
            }
            idx++;
        }

        return flag;
    }
}