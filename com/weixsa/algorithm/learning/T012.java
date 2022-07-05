package com.weixsa.algorithm.learning;

import java.util.Arrays;

/**
 * 一辆运送快递的货车，
 * 运送的快递放在大小不等的长方体快递盒中，
 * 为了能够装载更多的快递同时不能让货车超载，
 * 需要计算最多能装多少个快递。
 * 注：快递的体积不受限制。
 * 快递数最多1000个，货车载重最大50000。
 *
 * 输入描述
 * 第一行输入每个快递的重量
 * 用英文逗号隔开
 * 如 5,10,2,11
 * 第二行输入货车的载重量
 * 如 20
 *
 * 输出描述
 * 输出最多能装多少个快递
 * 如 3
 */
public class T012 {

    public static void main(String[] args) {

        int high = 20;

        int[] nums = Arrays.stream("5,10,2,11".split(","))
                .mapToInt(Integer::parseInt).sorted().toArray();

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max += nums[i];
            if (max > high) {
                System.out.println(i);
                return;
            }
        }
    }
}
