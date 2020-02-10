import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Work> workList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            int tmp = scanner.nextInt();
            if(tmp == 1)
                workList.add(new Work(scanner.nextInt(), scanner.nextInt()));
            else
                workList.add(new Work(0, 0));
        }
        int totalScore = 0;
        Stack<Work> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            Work work = workList.get(i);
            if(work.time == 0){
                if(stack.size() == 0)
                    continue;
                work = stack.pop();
            }
            work.time--;
            if(work.time == 0){
                totalScore += work.score;
                continue;
            }
            stack.push(work);
        }
        System.out.println(totalScore);
    }

    static class Work{
        int score;
        int time;
        Work(int score, int time){
            this.score = score;
            this.time = time;
        }
    }
}