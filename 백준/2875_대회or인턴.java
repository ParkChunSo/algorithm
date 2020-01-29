import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        int surplusPeople = 0;
        int answer = 0;
        int girlTeamNum = N / 2;
        int tmp = girlTeamNum - M;
        if (tmp < 0) {
            surplusPeople = (M - girlTeamNum) + (N - (girlTeamNum * 2));
            answer = girlTeamNum;
        } else if (tmp == 0) {
            surplusPeople = N - (girlTeamNum * 2);
            answer = girlTeamNum;
        } else {
            surplusPeople = N - (M * 2);
            answer = M;
        }

        if(surplusPeople < K){
            int requiredPeople = K - surplusPeople;
            long requiredTeamLong = requiredPeople%3;
            int requiredTeamInt = requiredPeople/3;
            if(requiredTeamLong > 0)
                requiredTeamInt++;

            answer -= requiredTeamInt;
        }

        System.out.println(answer);
    }
}