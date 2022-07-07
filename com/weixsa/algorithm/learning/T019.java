package com.weixsa.algorithm.learning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
   删除字符串中出现次数最少的字符
   如果多个字符出现次数一样则都删除

   例子：
   输入
     abcdd
     字符串中只
    输出
     dd

   输入
     aabbccdd

   输出
     empty

     如果都被删除  则换为empty

    */
public class T019 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();

        // 存放统计字符的数据
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            map.put(aChar,map.getOrDefault(aChar,0)+1);
        }
        List<Integer> collect = map.values().stream().sorted().collect(Collectors.toList());

        // 循环删除处理
        for (Character ch: map.keySet()) {
            if (map.get(ch) == collect.get(0)) {
                s=s.replaceAll(String.valueOf(ch),"");
            }
        }
        System.out.println(s.length() == 0 ? "empty":s);
    }
}
