package com.weixsa.algorithm.learning;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/*
           给定一个数组
           编写一个函数
           来计算他的最大N个数和最小N个数的和
           需要对数组进行去重

           说明
           第一行输入M
           M表示数组大小
           第二行输入M个数
           表示数组内容
           第三行输入N表示需要计算的最大最小N的个数

           输出描述
           输出最大N个数和最小N个数的和

           例一：
               输入
               5
               95 88 83 64 100
               2

               输出
               342

               说明
               最大2个数[100 95] 最小2个数[83 64]
               输出342

            例二
               输入
               5
               3 2 3 4 2
               2

               输出
                -1
                说明
                最大两个数是[4 3]最小2个数是[3 2]
                有重叠输出为-1

        */
public class T028 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i <  s.length; i++) {
            set.add(Integer.parseInt(s[i]));
        }
        int n = Integer.parseInt(scanner.nextLine());
        // 集合转化为数组
        ArrayList<Integer> nums = new ArrayList<>(set);

        if (nums.size()<2 * n) {
            System.out.println(-1);
            return;
        }

        int total = 0;
        for (int i = 0; i < nums.size() ; i++) {
            if (i< n ||i >= nums.size()-n ) {
                total += nums.get(i);
            }
        }
        System.out.println(total);
    }
}
