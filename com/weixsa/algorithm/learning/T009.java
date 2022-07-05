package com.weixsa.algorithm.learning;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 给定两个字符串，
 * 从字符串2中找出字符串1中的所有字符，
 * 去重并按照ASCII码值从小到大排列，
 *
 * 输入描述
 * 字符范围满足ASCII编码要求，
 * 输入字符串1长度不超过1024，
 * 字符串2长度不超过100
 *
 * 输出描述
 * 按照ASCII由小到大排序
 *
 * 示例一
 * 输入
 *
 * bach
 * bbaaccddfg
 * COPY
 * 输出
 *
 * abc
 * COPY
 * 示例二
 * 输入
 *
 * fach
 * bbaaccedfg
 * COPY
 * 输出
 *
 * acf
 */
public class T009 {

    public static void main(String[] args) {

        String a= "bach";
        String b ="bbaaccddfg";

        Set<Character> set =new HashSet<>();
        for (char ch: a.toCharArray()) {
            set.add(ch);
        }
        TreeSet<Character> result = new TreeSet<>();
        for (char ch: b.toCharArray()) {
            if (set.contains(ch)){
                result.add(ch);
            }
        }
        for (char ch : result) {
            System.out.print(ch);
        }

    }
}
