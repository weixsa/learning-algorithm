package com.weixsa.algorithm.od;

public class D001 {

    // 给你一个字符串 s，字符串s首尾相连成一个环形 ，请你在环中找出 'o' 字符出现了偶数次最长子字符串的长度。
    // 可以转化为有多少了o的数据，如果是是奇数的话，直接是字符串的长度，否则就是字符串的长度减一
    public static void main(String[] args) {

        String input = "looxdolx";
        char[] chars = input.toCharArray();
        int num = 0;
        for (char ch : chars) {
            if (ch == 'o') {
                num++;
            }
        }
        if (num % 2 == 0 ) {
            System.out.println(input.length());
        } else {
            System.out.println(input.length() - 1);
        }

    }
}
