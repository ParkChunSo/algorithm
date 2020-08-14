package com.company;

import java.util.*;

public class Main {

    static int N;
    static int[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        A = new int[N];

        String[] tmp = sc.nextLine().split(" ");
        for (int i = 0 ; i < tmp.length ; i++){
            A[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(A);

        int M = Integer.parseInt(sc.nextLine());
        while(M > 0){
            int target = sc.nextInt();
            if(binarySearch(0, N-1, target))
                System.out.println(1);
            else
                System.out.println(0);
            M--;
        }
    }

    //start와 end 사이의 target이 존재하는지 확인하는 메소드
    public static boolean binarySearch(int start, int end, int target){
        //base case
        if(A[start] == target || A[end] == target)
            return true;
        if(end - start == 1)
            return false;

        int mid = (end + start)/2;
        if(A[mid] == target)
            return true;
        else if(A[start] < target && A[mid] > target)
            return binarySearch(start, mid, target);
        else
            return binarySearch(mid, end, target);
    }
}