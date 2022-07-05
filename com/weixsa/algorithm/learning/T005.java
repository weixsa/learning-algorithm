package com.weixsa.algorithm.learning;

import java.util.Arrays;

/**
 * 为了充分发挥Gpu算力，
 * 需要尽可能多的将任务交给GPU执行，
 * 现在有一个任务数组，
 * 数组元素表示在这1s内新增的任务个数，
 * 且每秒都有新增任务，
 * 假设GPU最多一次执行n个任务，
 * 一次执行耗时1s，
 * 在保证Gpu不空闲的情况下，最少需要多长时间执行完成。
 *
 * 输入描述
 * 第一个参数为gpu最多执行的任务个数
 * 取值范围1~10000
 * 第二个参数为任务数组的长度
 * 取值范围1~10000
 * 第三个参数为任务数组
 * 数字范围1~10000
 *
 * 输出描述
 * 执行完所有任务需要多少秒
 *
 * 示例一
 * 输入
 *
 * 3
 * 5
 * 1 2 3 4 5
 * COPY
 * 输出
 *
 * 6
 * COPY
 * 说明
 * 一次最多执行3个任务，最少耗时6s
 */
public class T005 {
    public static void main(String[] args) {
        int[] nums = Arrays.stream("5 4 1 9 1".split(" ")).mapToInt(Integer::parseInt).toArray();


        int left = 0;
        int count = 0;

        int n = 4;

        for (int i = 0; i < nums.length ; i++) {
            left +=nums[i];
            if (left > n){
                left-=n;
            }else{
                left = 0;
            }
            count++;
        }
        if (left>0) {
            count = left % 3 == 0 ? count+left/3: count+left/3+1;
        }
        System.out.println(count);
    }
}
