package com.weixsa.algorithm.learning;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*
         给定一个非空数组(列表)
         起元素数据类型为整型
         请按照数组元素十进制最低位从小到大进行排序
         十进制最低位相同的元素，相对位置保持不变
         当数组元素为负值时，十进制最低为等同于去除符号位后对应十进制值最低位

         输入描述
         给定一个非空数组(列表)
         其元素数据类型为32位有符号整数
        数组长度为[1,1000]
        输出排序后的数组

        输入
        1,2,5,-21,22,11,55,-101,42,8,7,32
        输出
        1,-21,11,-101,2,22,42,32,5,55,7,8

         */
public class T027 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return getKey(o1) - getKey(o2);
            }

            public int getKey(int n){
                return n>0?n%10:-n%10;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() ; i++) {
            sb.append(list.get(i)).append(",");
        }
        System.out.println(sb.substring(0,sb.length()-1));

    }
}
