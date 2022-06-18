package com.weixsa.algorithm.od;


public class D004 {
    public static void main(String[] args) {

        // 骰子的初始状态
        int [] nums = {1,2,3,4,5,6};

        // 操作指令
        String input = "FCR";

        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == 'L') {
                int temp = nums[0];
                nums[0] = nums[4];
                nums[4] = nums[1];
                nums[1] = nums[5];
                nums[5] = temp;
            }else if ('R' == ch) {
                int temp = nums[0];
                nums[0] = nums[5];
                nums[5] = nums[1];
                nums[1] = nums[4];
                nums[4] = temp;
            }else if ('F' == ch) {
                int temp = nums[2];
                nums[2] = nums[4];
                nums[4] = nums[3];
                nums[3] = nums[5];
                nums[5] = temp;
            }else if ('B' == ch) {
                int temp = nums[2];
                nums[2] = nums[5];
                nums[5] = nums[3];
                nums[3] = nums[4];
                nums[4] = temp;
            }else if ('A' == ch) {
                int temp = nums[0];
                nums[0] = nums[3];
                nums[3] = nums[1];
                nums[1] = nums[2];
                nums[2] = temp;
            }else if ('C'== ch ){
                int temp = nums[0];
                nums[0] = nums[2] ;
                nums[2] = nums[1];
                nums[1] = nums[3];
                nums[3] = temp;
            }
        }

        for (int i = 0; i < nums.length ; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}
