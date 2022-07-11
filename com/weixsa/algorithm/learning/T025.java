package com.weixsa.algorithm.learning;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入
 * -1 -3 7 5 11 15
 * 输出
 * -3 5 2
 * 看起来应该是
 */

public class T025 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 获取到的数据
        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();

        int min =  Integer.MAX_VALUE;
        int a=0,b = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (min > Math.abs(nums[i] + nums[j])) {
                    a = nums[i];
                    b = nums[j];
                    min =Math.abs(nums[i] + nums[j]);
                }
            }
        }
        System.out.println(a + " " +b + " " + min);

    }

}
