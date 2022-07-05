package com.weixsa.algorithm.online.hard;

import java.util.Stack;

public class T009 {


    /**
     * 为了提升数据传输的效率，会对传输的报文进行压缩处理。
     * 输入一个压缩后的报文，请返回它解压后的原始报文。
     * 压缩规则：n[str]，表示方括号内部的 str 正好重复 n 次。
     * 注意 n 为正整数（0 < n <= 100），str只包含小写英文字母，不考虑异常情况。
     * 输入描述:
     * 输入压缩后的报文：
     * 1）不考虑无效的输入，报文没有额外的空格，方括号总是符合格式要求的；
     * 2）原始报文不包含数字，所有的数字只表示重复的次数 n ，例如不会出现像 5b 或 3[8] 的输入；
     * 输出描述:
     * 解压后的原始报文
     * 3[m2[c]]
     * 输出
     * mccmccmcc
     *
     * @param args
     */
    public static void main(String[] args) {

        String input = "";

        // 递归解析使用

        Stack<String> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '[') {

            }

        }

    }


    public static void calc(int n ,StringBuilder sb){
        String s = sb.toString();
        for (int i = 0; i < n-1; i++) {
            sb.append(s);
        }
    }
}
