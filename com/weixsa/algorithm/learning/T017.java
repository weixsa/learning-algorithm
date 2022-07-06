package com.weixsa.algorithm.learning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 /*
 给定一个字符串
 只包含大写字母
 求在包含同一字母的子串中
 长度第K长的子串
 相同字母只取最长的子串

 输入
 第一行 一个子串 1<len<=100
 只包含大写字母
 第二行为k的值

 输出
 输出连续出现次数第k多的字母的次数

 例子：
 输入
 AABAAA
 2
 输出
 1
 同一字母连续出现最多的A 3次
 第二多2次  但A出现连续3次

 输入

 AAAAHHHBBCDHHHH
 3

 输出
 2

 //如果子串中只包含同一字母的子串数小于k

 则输出-1

 */
public class T017 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());
        // 遍历字符串
        Map<Character,Integer> map = new HashMap<>();

        char[] chars = line.toCharArray();
        char cur = chars[0];
        int count= 0;
        for (int i = 1; i < chars.length ; i++) {
            char aChar = chars[i];
            if (aChar == cur) {
                count++;
            }else{
                cur = aChar;
                count=1;
            }
            map.put(cur,Math.max(count,map.getOrDefault(cur, 0)));
        }

        if (map.size() < k ) {
            System.out.println(-1);
            return;
        }
        List<Integer> collect = map.values().stream().sorted().collect(Collectors.toList());
        System.out.println(collect.get(collect.size()-k));

    }
}
