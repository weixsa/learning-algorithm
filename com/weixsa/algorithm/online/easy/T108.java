package com.weixsa.algorithm.online.easy;

import java.util.Arrays;

public class T108 {

    public static void main(String[] args) {

        int n = 5;

        // 灯罩间距
        int[] nums = Arrays.stream("20 30 1000 30 23".split(" ")).mapToInt(Integer::parseInt).toArray();

        int res = 0;
        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            // 需要判断当前半径是否会覆盖到其他路灯的半径
            if (num > 100) {

            }
        }
        System.out.println(res);
    }
}
