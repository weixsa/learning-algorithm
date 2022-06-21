package com.weixsa.algorithm.od;

import java.util.Arrays;

/**
 * 给定一个正整数数组，设为nums，最大为100个成员，求从第一个成员开始，正好走到数组最后一个成员，所使用的最少步骤数。
 * 要求：
 * 1、第一步必须从第一元素开始，且1<=第一步的步长<len/2;（len为数组的长度，需要自行解析）。
 * 2、从第二步开始，只能以所在成员的数字走相应的步数，不能多也不能少, 如果目标不可达返回-1，只输出最少的步骤数量。
 * 3、只能向数组的尾部走，不能往回走。
 */
public class D009 {

    public static void main(String[] args) {

        int[] nums = Arrays.stream("7 5 9 4 2 6 8 3 5 4 3 9".split(" ")).mapToInt(Integer::parseInt).toArray();

        int minStep = 101;
        int index = 0;
        for (int i = 1; i <nums.length/2 ; i++) {
            index = i;
            // 当前步数的值小于数组的长度
            int step = 1;
            while (index < nums.length -1) {
                index += nums[index];
                step++;
                if (index == nums.length-1) {
                    minStep=Math.min(minStep,step);
                    break;
                }
            }
        }
        System.out.println(minStep== 101?-1:minStep);

    }
}
