package com.weixsa.algorithm.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
       在通信系统中有一个常见的问题是对用户进行不同策略的调度
       会得到不同系统消耗的性能
       假设由N个待串行用户，每个用户可以使用A/B/C三种不同的调度策略
       不同的策略会消耗不同的系统资源
       请你根据如下规则进行用户调度
       并返回总的消耗资源数
       规则是：相邻的用户不能使用相同的调度策略
       例如：
       第一个用户使用A策略 则第二个用户只能使用B和C策略
       对单的用户而言，不同的调度策略对系统资源的消耗可以规划后抽象为数值
       例如
       某用户分别使用ABC策略的系统消耗，分别为15 8 17
       每个用户依次选择当前所能选择的对系统资源消耗最少的策略,局部最优
       如果有多个满足要求的策略，选最后一个

       输入描述：
           第一行表示用户个数N
           接下来表示每一行表示一个用户分别使用三个策略的资源消耗
           resA resB resC

       输出描述：
           最优策略组合下的总的系统消耗资源数

        示例一：
         输入：
             3
             15 8 17
             12 20 9
             11 7 5
         输出：
             24
          说明:
           1号用户使用B策略
           2号用户使用C策略
           3号用户使用B策略
          系统资源消耗8+9+7

    */
public class T021 {

    // 最小优化策略
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 先把数据存储起来
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            list.add(Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray());
        }

        back(list,0,0,0);
        System.out.println(min);

    }

    /**
     * 传递数据，list的索引和上一个选择的策略和上一个所用的时间
     * @param list
     * @param listIndex
     * @param index
     * @param total
     */
    public static void back(List<int[]> list ,int listIndex , int index, int total){

        // 如果还没比较就已经多余最小值的，直接结束处理了,类似于剪枝
        if (total >= min) {
            return;
        }
        int[] nums = list.get(listIndex);
        for (int i = 0; i < nums.length ; i++) {

            // 不能选择相同坐标的策略
            if (i == index) {
                continue;
            }
            // 最后一层选择了
            if (listIndex == list.size() - 1) {
                min = Math.min(min,total+nums[i]);
            } else{
                back(list,listIndex + 1,i,total+nums[i]);
            }
        }

    }
}
