package com.weixsa.algorithm.online.easy;

import java.util.Arrays;
import java.util.Scanner;

public class T001 {
    /**
     * 近些年来，我国防沙治沙取得显著成果。某沙漠新种植N棵胡杨（编号1-N），排成一排。
     *
     * 一个月后，有M棵胡杨未能成活。
     *
     * 现可补种胡杨K棵，请问如何补种（只能补种，不能新种），可以得到最多的连续胡杨树？
     *
     * 输入描述
     *
     * N 总种植数量
     *
     * M 未成活胡杨数量
     *
     * M 个空格分隔的数，按编号从小到大排列
     *
     * K 最多可以补种的数量
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 总数
        int n = Integer.parseInt(scanner.nextLine());

        // 未成活的数据
        int m = Integer.parseInt(scanner.nextLine());

        // 未成活的数组
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 可以补种的个数
        int k = Integer.parseInt(scanner.nextLine());

        // 最长的数据一定是连续补种的
        int max = 0;
        for (int i = 0; i <= m - k; i++) {

            int left  = 0;
            int right = n;

            if (i > 0) {
                left = nums[i-1];
            }
            if (i + k < m) {
                right = nums[i+k] -1;
            }
            max = Math.max(max,right - left);
        }

        System.out.println(max);
    }
}
