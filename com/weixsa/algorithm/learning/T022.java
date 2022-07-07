package com.weixsa.algorithm.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
       现在有多组整数数组
       需要将他们合并成一个新的数组
       合并规则从每个数组里按顺序取出固定长度的内容
       合并到新的数组
       取完的内容会删除掉
       如果改行不足固定长度，或者已经为空
       则直接取出剩余部分的内容放到新的数组中继续下一行

       输入描述
         第一 行每次读取的固定长度
         长度0<len<10
         第二行是整数数组的数目
         数目 0<num<10000
         第3~n行是需要合并的数组
         不同的数组用换行分割
         元素之间用逗号分割
         最大不超过100个元素

        输出描述
         输出一个新的数组，用逗号分割

         示例1
         输入
             3
             2
             2,5,6,7,9,5,7
             1,7,4,3,4
         输出
             2,5,6,1,7,4,7,9,5,3,4,7

         说明  获得长度3和数组数目2
            先遍历第一行 获得2,5,6
            再遍历第二行 获得1,7,4
            再循环回到第一行获得7,9,5
            再遍历第二行获得3,4
            再回到第一行获得7

         示例2
         输入
            4
            3
            1,2,3,4,5,6
            1,2,3
            1,2,3,4
          输出
            1,2,3,4,1,2,3,1,2,3,4,5,6
        */
public class T022 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            list.add(Arrays.stream(scanner.nextLine().split(","))
                    .mapToInt(Integer::parseInt).toArray());
        }
        int max = 0;
        for (int i = 0; i < list.size() ; i++) {
            max = Math.max(max,list.get(i).length);
        }

        // 处理数据,一次循环每个数组轮训一遍
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i= i + size) {
            for (int j = 0; j < list.size() ; j++) {
                int[] nums = list.get(j);
                for (int k = i; k < i + size && k< nums.length ; k++) {
                    sb.append(nums[k]).append(",");
                }
            }
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }
}
