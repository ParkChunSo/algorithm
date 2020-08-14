import java.util.*;

public class Main {

    static int N, M;
    static int[] trees;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp1 = sc.nextLine().split(" ");
        N = Integer.parseInt(tmp1[0]);
        M = Integer.parseInt(tmp1[1]);
        trees = new int[M];

        String[] tmp2 = sc.nextLine().split(" ");
        for(int i = 0 ; i < tmp2.length ; i++){
            trees[i] = Integer.parseInt(tmp2[i]);
        }
        int maxVal = 0;
        for(int i = 0 ; i < trees.length ; i++){
            maxVal = Math.max(trees[i], maxVal);
        }
        System.out.println(binarySearch(0, maxVal));
    }

    //start와 end 사이의 target이 존재하는지 확인하는 메소드
    public static int binarySearch(int start, int end){
        //base case
        if(end - start == 1){
            if(getTreesLength(end) >= M)
                return end;
            else
                return start;
        }

        int mid = (start + end) /2;
        long treesLength = getTreesLength(mid);
        if(treesLength == M)
            return mid;
        else if(treesLength > M){
            return binarySearch(mid, end);
        }else{
            return binarySearch(start, mid);
        }

    }

    public static long getTreesLength(int cuttingPoint){
        int answer = 0;
        for (int tree : trees) {
            if(tree > cuttingPoint)
                answer += tree - cuttingPoint;
        }
        return answer;
    }
}