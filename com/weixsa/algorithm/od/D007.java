package com.weixsa.algorithm.od;

/**
 * 给定一个含有N个正整数的数组, 求出有多少个连续区间（包括单个正整数）, 它们的和大于等于x。
 */
public class D007 {


    public static void main(String[] args) {
        int [] nums = {3 ,4 ,7};
        int x= 7;


        int result = 0;
        int sum = 0;

        for (int i = 0; i < nums.length ; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum>=x) {
                    result++;
                }
            }
            sum = 0;
        }

        System.out.println(result);
    }
}
