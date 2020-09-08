import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static List<Integer> list;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        sb = new StringBuilder();
        while(M-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "add":
                    add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    check(Integer.parseInt(st.nextToken()));
                    break;
                case "toggle":
                    toggle(Integer.parseInt(st.nextToken()));
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }
        System.out.println(sb.toString());
    }

    private static void add(int x){
        if(!list.contains(x))
            list.add(x);
    }

    private static void remove(int x){
        int i = list.indexOf(x);
        if(i != -1)
           list.remove(i);
    }

    private static void check(int x){
        if(list.contains(x))
            sb.append(1).append("\n");
        else
            sb.append(0).append("\n");
    }

    private static void toggle(int x){
        int i = list.indexOf(x);
        if(i != -1)
            list.remove(i);
        else
            list.add(x);
    }

    private static void all(){
        list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
    }

    private static void empty(){
        list = new ArrayList<>();
    }

}