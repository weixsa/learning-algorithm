package com.weixsa.algorithm.learning;

import java.util.Scanner;

/*
        给定一个仅包含0和1的n*n二维矩阵
        请计算二维矩阵的最大值
        计算规则如下
        1、每行元素按下标顺序组成一个二进制数(下标越大约排在低位)，
        二进制数的值就是该行的值，矩阵各行之和为矩阵的值
        2、允许通过向左或向右整体循环移动每个元素来改变元素在行中的位置
        比如
        [1,0,1,1,1]   向右整体循环移动两位  [1,1,1,0,1]
        二进制数为11101 值为29
        [1,0,1,1,1]   向左整体循环移动两位  [1,1,1,1,0]
        二进制数为11110 值为30

        输入描述
        1.数据的第一行为正整数，记录了N的大小
        0<N<=20
        2.输入的第2到n+1行为二维矩阵信息
        行内元素边角逗号分割

        输出描述
        矩阵的最大值

        示例1

        输入
        5
        1,0,0,0,1
        0,0,0,1,1
        0,1,0,1,0
        1,0,0,1,1
        1,0,1,0,1

        输出
        122

        说明第一行向右整体循环移动一位，得到最大值  11000  24

        因此最大122
         */
public class T030 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int total = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(scan.nextLine().replaceAll(",",""));
            int value = 0;
            for (int j = 0; j < n ; j++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0).append(c);
                int parseInt = Integer.parseInt(sb.toString(), 2);
                value = Math.max(value,parseInt);
            }
            total+=value;
        }
        System.out.println(total);

    }
}
