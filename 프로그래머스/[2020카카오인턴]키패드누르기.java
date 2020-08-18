package com.company;

class Solution {
    private int[] leftKeyPad = {1, 4, 7};
    private int[] rightKeyPad = {3, 6, 9};
    private int[][] keyPad = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {-1, 0, -2}
    };
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int leftNum = -1, rightNum = -2;
        for(int num : numbers){
            if(isRightKeyPad(num)){
                sb.append("R");
                rightNum = num;
            }else if(isLeftKeyPad(num)){
                sb.append("L");
                leftNum = num;
            }else{
                int leftDistance = getDistance(leftNum, num);
                int rightDistance = getDistance(rightNum, num);
                if(leftDistance > rightDistance){
                    sb.append("R");
                    rightNum = num;
                } else if(leftDistance < rightDistance){
                    sb.append("L");
                    leftNum = num;
                } else{
                    if(hand.equals("right")){
                        sb.append("R");
                        rightNum = num;
                    }else{
                        sb.append("L");
                        leftNum = num;
                    }
                }
            }
        }
        return sb.toString();
    }

    private boolean isRightKeyPad(int num){
        for (int j : rightKeyPad) {
            if (num == j)
                return true;
        }
        return false;
    }


    private boolean isLeftKeyPad(int num){
        for (int j : leftKeyPad) {
            if (num == j)
                return true;
        }
        return false;
    }

    private int getDistance(int start, int end){
        int x1 = 0, x2 = 0;
        int y1 = 0, y2 = 0;
        for(int y = 0 ; y < keyPad.length ; y++) {
            for(int x = 0 ; x < keyPad[0].length ; x++){
                if(keyPad[y][x] == start) {
                    x1 = x;
                    y1 = y;
                }else if (keyPad[y][x] == end) {
                    x2 = x;
                    y2 = y;
                }
            }
        }
        return Math.abs(y1-y2) + Math.abs(x1-x2);
    }
}