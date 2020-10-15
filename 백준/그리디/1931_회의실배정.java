import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<Meeting> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);
        int endTime = -1;
        int cnt = 0;
        for (Meeting meeting : list) {
            if (meeting.start < endTime)
                continue;
            endTime = meeting.end;
            cnt++;
        }

        System.out.println(cnt);
    }
    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end > o.end){
                return 1;
            }else if(this.end < o.end){
                return -1;
            }else{
                if(this.start > o.start)
                    return 1;
                else
                    return -1;
            }
        }
    }
}