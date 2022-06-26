package com.weixsa.algorithm.online.easy;

import java.util.Arrays;

public class T054 {

    public static void main(String[] args) {

        int m = 3;
        int[] nums = Arrays.stream("10 20 30 15 23 12".split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = 0;
        int left = 0;
        int total = 0;
        for (int i = 0; i < nums.length ; i++) {
            while (i-left < m - 1) {
                total+= nums[i];
                i++;
            }
           // 获取最大值
            total+= nums[i];
            max = Math.max(max,total);
            if (i== nums.length -1) {
                break;
            }
            total-=nums[left];
            left++;
        }

        System.out.println(max);
    }
}
