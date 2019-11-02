import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Set<Integer> set =  new LinkedHashSet<>();

        int cnt = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < cnt ; i++){
            String[] tmp = sc.nextLine().split(" ");
            String order = tmp[0];

            if(order.equals("add")){
                set.add(Integer.parseInt(tmp[1]));
            }else if(order.equals("remove")){
                set.remove(Integer.parseInt(tmp[1]));
            }else if(order.equals("check")){
                if(set.contains(Integer.parseInt(tmp[1])))
                    sb.append("1\n");
                else
                    sb.append("0\n");
            }else if(order.equals("toggle")){
                if(set.contains(Integer.parseInt(tmp[1])))
                    set.remove(Integer.parseInt(tmp[1]));
                else
                    set.add(Integer.parseInt(tmp[1]));
            }else if(order.equals("all")){
                for(int k = 1 ; k < 21 ; k++)
                    set.add(k);
            }else if(order.equals("empty")){
                set = new LinkedHashSet<>();
            }
        }
        System.out.println(sb);
    }
}
