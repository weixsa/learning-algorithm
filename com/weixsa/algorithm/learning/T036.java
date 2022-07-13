package com.weixsa.algorithm.learning;

 /*
        用数组代表每个人的能力
        一个比赛活动要求 参赛团队的最低能力值为N
        每个团队可以由一人或者两人组成
        且一个人只能参加一个团队
        计算出最多可以派出多少只符合要求的队伍

        输入描述
        5
        3 1 5 7 9
        8
        第一行代表总人数，范围  1~500000
        第二行数组代表每个人的能力
           数组大小范围 1~500000
           元素取值范围 1~500000
        第三行数值为团队要求的最低能力值
         1~500000

         输出描述
         3
         最多可以派出的团队数量

         示例一
         输入
         5
         3 1 5 7 9
         8

         输出
         3

         说明 3、5组成一队   1、7一队  9自己一队  输出3

         7
         3 1 5 7 9 2 6
         8

        3
        1 1 9
        8

          */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class T036 {

    public static void main(String[] args) {
        calc();
//        Scanner scanner = new Scanner(System.in);
//        List<Integer> collect = Arrays.stream(scanner.nextLine().split(" "))
//                .map(Integer::parseInt).collect(Collectors.toList());
//
//        int k = Integer.parseInt(scanner.nextLine());
//
//        TreeSet<Integer> set = new TreeSet(collect);
//        int count = 0;
//        while (!set.isEmpty()){
//            int last = set.pollLast();
//            if (last >=k) {
//                count++;
//                continue;
//            }
//            while (!set.isEmpty()) {
//                int first = set.pollFirst();
//                if (first + last >= k) {
//                    count++;
//                    break;
//                }
//            }
//        }
//
//        System.out.println(count);
    }

    public static void calc(){
        Scanner scanner = new Scanner(System.in);
        List<Integer> collect = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).sorted().collect(Collectors.toList());

        int k = Integer.parseInt(scanner.nextLine());

        int count = 0;
        int left = 0;int right = collect.size()-1;
        while(left<right) {
            if (collect.get(right) >= k) {
                count++;
                right--;
                continue;
            }else if (collect.get(right) + collect.get(left) >= k){
                count++;
                right--;
                left++;
                continue;
            }else{
                left++;
            }
        }
        System.out.println(count);
    }
}
