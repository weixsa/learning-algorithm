package com.weixsa.algorithm.learning;

  /*
        有一个N个整数的数组
        和一个长度为M的窗口
        窗口从数组内的第一个数开始滑动
        直到窗口不能滑动为止
        每次滑动产生一个窗口  和窗口内所有数的和
        求窗口滑动产生的所有窗口和的最大值

        输入描述
        第一行输入一个正整数N
        表示整数个数  0<N<100000
        第二行输入N个整数
        整数取值范围   [-100,100]
        第三行输入正整数M
        M代表窗口的大小
        M<=100000 并<=N

        输出描述
        窗口滑动产生所有窗口和的最大值

        示例一
        输入
        6
        12 10 20 30 15 23
        3

        输出
        68
         */

import java.util.Arrays;
import java.util.Scanner;

public class T032 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] nums = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scan.nextLine());


        int sum = 0;
        // 初始化窗口的值
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = n; i < nums.length ; i++) {
            sum = sum + nums[i] - nums[i-n];
            max= Math.max(max,sum);
        }
        System.out.println(max);
    }
}
