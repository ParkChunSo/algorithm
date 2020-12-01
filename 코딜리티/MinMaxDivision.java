package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = solution(3, 5, new int[]{2, 1, 5, 1, 2, 2, 2});
        System.out.println(answer);
    }

    private static int solution(int K, int M, int[] A) {
        int max = 0, min = M;
        for(int i= 0 ; i < A.length ; i++){
            max += A[i];
        }

        int result = 0;
        while(max >= min){
            int mid = (max+min) / 2;
            if(divisionSolvable(mid, K-1, A)){
                max = mid-1;
                result = mid;
            }else{
                min = mid+1;
            }
        }
        return result;
    }
    private static boolean divisionSolvable(int mid, int k, int[] a) {
        int sum = 0;
        for(int i = 0 ; i < a.length ; i++){
            sum += a[i];
            if(sum > mid){
                sum = a[i];
                k--;
            }
            if(k < 0){
                return false;
            }
        }
        return true;
    }
}
