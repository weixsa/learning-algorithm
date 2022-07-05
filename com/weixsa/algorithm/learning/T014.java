package com.weixsa.algorithm.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 单词接龙的规则是:
 * 可用于接龙的单词,首字母必须要与前一个单词的尾字母相同；
 * 当存在多个首字母相同的单词时，取长度最长的单词；
 * 如果长度也相等，则取字典序最小的单词；
 * 已经参与接龙的单词不能重复使用；
 * 现给定一组全部由小写字母组成的单词数组，
 * 并指定其中一个单词为起始单词，进行单词接龙，
 * 请输出最长的单词串。
 * 单词串是单词拼接而成的，中间没有空格。
 *
 * 单词个数 1 < N < 20
 * 单个单词的长度 1 ~ 30
 *
 * 输入描述
 * 输入第一行为一个非负整数
 * 表示起始单词在数组中的索引k
 * 0 <= k < N
 * 输入的第二行为非负整数N
 * 接下来的N行分别表示单词数组中的单词
 *
 * 输出描述
 * 输出一个字符串表示最终拼接的单词串
 *
 * 示例一
 * 输入
 *
 * 0
 * 6
 * word
 * dd
 * da
 * dc
 * dword
 * d
 * COPY
 * 输出
 *
 * worddwordda
 * COPY
 * 示例二
 * 输入
 *
 * 4
 * 6
 * word
 * dd
 * da
 * dc
 * dword
 * d
 * COPY
 * 输出
 *
 * dwordda
 */
public class T014 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();

        int n = scanner.nextInt();

        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }

        list
                

    }
}
