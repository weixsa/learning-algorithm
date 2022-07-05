package com.weixsa.algorithm.learning;

/**
 * 输入一个英文文章片段，
 * 翻转指定区域的单词顺序，
 * 标点符号和普通字母一样处理，
 * 例如输入字符串
 * I am a developer.
 * [0,3]
 * 则输出
 * developer. a am I
 *
 * 输入描述
 * 使用换行隔开3个参数
 * 第一个参数为文章内容 即英文字符串
 * 第二个参数为翻转起始单词下标，下标从0开始
 * 第三个参数为结束单词下标
 *
 * 输出描述
 * 翻转后英文文章片段每个单词之间以一个半角空格分割输出
 *
 * 示例一
 * 输入
 *
 * I am a developer.
 * 0
 * 3
 * COPY
 * 输出
 *
 * developer. a am I
 */
public class T007 {

    public static void main(String[] args) {

        int start = 0;
        int end = 3;

        String input = "hello world!";
        String[] s = input.split(" ");


        // 非法参数
        if (start>=s.length-1 || end<=0 ||end <= start) {
            System.out.println(input);
            return;
        }
        if (start < 0 ) {
            start = 0;
        }
        if (end > s.length -1 ) {
            end = s.length -1;
        }

        StringBuilder sb = new StringBuilder();

        int count = end;
        for (int i = 0; i < s.length; i++) {
            if (i < start || i > end) {
                sb.append(s[i]).append(" ");
            }else{
                sb.append(s[count]).append(" ");
                count--;
            }
        }
        System.out.println(sb.substring(0,sb.length()-1));

    }
}
