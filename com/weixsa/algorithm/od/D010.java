package com.weixsa.algorithm.od;

public class D010 {


    /**
     * 已知火星人使用的运算符为#、$，其与地球人的等价公式如下：
     * x#y = 2x+3y+4
     * x$y = 3*x+y+2
     * 1、其中x、y是无符号整数
     * 2、地球人公式按C语言规则计算
     * 3、火星人公式中，$的优先级高于#，相同的运算符，按从左到右的顺序计算
     * 现有一段火星人的字符串报文，请你来翻译并计算结果。
     * @param args
     */
    public static void main(String[] args) {

        String input = "7#6$5#12";

        // 按照#号进行分割
        String[] split = input.split("#");

        int result = calc(split[0]);
        for (int i = 1; i < split.length; i++) {
            // 获取每一个字符串
            result = calc_jin(result, calc(split[i]));
        }
        System.out.println(result);
    }

    public static int calc(String temp){
        if (!temp.contains("$")) {
            return Integer.parseInt(temp);
        }
        String[] split = temp.split("\\$");
        int result = Integer.parseInt(split[0]);
        for (int i = 1; i < split.length; i++) {
            result = calc_doller(result, Integer.parseInt(split[i]));
        }
        return result;
    }

    public static int calc_doller(int x ,int y ){
        return 3 * x + y + 2;
    }
    public static int calc_jin(int x ,int y ){
        return 2 * x + 3 * y + 4;
    }
}
