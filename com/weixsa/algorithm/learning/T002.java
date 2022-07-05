package com.weixsa.algorithm.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给定两个整数数组，arr1、arr2，数组元素按升序排列；
 * 假设从arr1、arr2中分别取出一个元素，可构成一对元素；
 * 现在需要取出k对元素，并对取出的所有元素求和，计算和的最小值；
 * 注意：两对元素对应arr1、arr2的下标是相同的，视为同一对元素。
 *
 * 输入描述
 * 输入两行数组arr1、arr2
 * 每行首个数字为数组大小size， 0 < size <= 100
 * arr1，arr2中的每个元素e， 0< e <1000
 * 接下来一行，正整数k 0 < k <= arr1.size * arr2.size
 *
 * 输出描述
 * 满足要求的最小值
 *
 * 示例一
 * 输入
 *
 * 1 1 2
 * 1 2 3
 * 2
 * COPY
 * 输出
 *
 * 4
 * COPY
 * 说明：
 * 用例中需要取两个元素，取第一个数组第0个元素与第二个数组第0个元素组成一个元素[1,1];
 * 取第一个数组第1个元素与第二个数组第0个元素组成一个元素[1,1];
 * 求和为1+1+1+1=4 ,满足要求最小
 */
public class T002 {

    public static void main(String[] args) {
        int[] m = Arrays.stream("1 1 2".split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] n = Arrays.stream("1 2 3".split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> list = new ArrayList<>();

        int k = 2;
        for (int i = 0; i < m.length ; i++) {
            for (int j = 0; j < n.length; j++) {
                list.add(m[i]+n[j]);
            }
        }
        list.sort(Integer::compareTo);
        int total = 0;
        for (int i = 0; i < k ; i++) {
            total+=list.get(i);
        }
        System.out.println(total);


    }
}
