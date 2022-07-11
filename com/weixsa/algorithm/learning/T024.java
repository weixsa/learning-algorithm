package com.weixsa.algorithm.learning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
   身高从低到高
   身高相同体重从轻到重
   体重相同维持原来顺序
   输入
   4
   100 100 120 130
   40 30 60 50
   输出：
   2 1 3 4
   输入
   3
   90 110 90
   45 60 45
   输出
   1 3 2
    */
public class T024 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [] [] nums = new int[n][3];
        String[] highs = scanner.nextLine().split(" ");
        String[] weights = scanner.nextLine().split(" ");
        for (int i = 0; i < n ; i++) {
           nums[i][0] = Integer.parseInt(highs[i]);
           nums[i][1] = Integer.parseInt(weights[i]);
           nums[i][2] = i+1;
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length ; i++) {
            sb.append(nums[i][2]).append(" ");
        }
        System.out.println(sb.substring(0,sb.length()-1));

    }
}
