package com.weixsa.algorithm.learning;

import java.util.Arrays;
import java.util.Scanner;

/*

        一个正整数数组 设为nums
        最大为100个成员
        求从第一个成员开始正好走到数组最后一个成员所使用的最小步骤数
                    3 5 9 4 2 6 8 3 5 4 3 9
        要求：
        1. 第一步 必须从第一元素起  且 1<=第一步步长<len/2  (len为数组长度)
        2. 从第二步开始只能以所在成员的数字走相应的步数，不能多不能少，
         如果目标不可达返回-1
         只输出最小的步骤数量
        3. 只能向数组的尾部走不能向回走

        输入描述：
        有正整数数组 空格分割
        数组长度<100

        输出描述 ：
         正整数  最小步数
         不存在输出-1

         例子：
         输入
             7 5 9 4 2 6 8 3 5 4 3 9
         输出
            2
         第一个可选步长选择2
         从第一个成员7开始走两步到9
         第二步：从9经过9个成员到最后

         例子：
         输入
          1 2 3 7 1 5 9 3 2 1
         输出
          -1
         */
public class T020 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 先转换成数组
        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int min = Integer.MAX_VALUE;

        // 循环遍历数据
        for (int i = 1; i < nums.length / 2 ; i++) {
            int step = 2;
            int index = i + nums[i];
            // 下一个数据的坐标
            while (true) {
                if (index == nums.length -1) {
                    min = Math.min(min,step);
                    break;
                }
                if (index > nums.length -1) {
                    break;
                }
                step++;
                index += nums[index];
            }
        }

        System.out.println(min== Integer.MAX_VALUE ? -1 :min);
    }
}
