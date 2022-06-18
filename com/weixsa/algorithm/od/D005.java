package com.weixsa.algorithm.od;

import java.util.ArrayList;

public class D005 {
    /**
     * 将该字符串分割成一些子串，使每个子串的ASCII码值的和均为水仙花数。
     * 1、若分割不成功则返回 0
     * 2、若分割成功且分割结果不唯一则返回-1
     * 3、若分割成功且分割结果唯一，则返回分割后的子串数目
     * 备注：“水仙花数”是指一个三位数，每位上数字的立方和等于该数字本身，如 371是“水仙花数”，因为:371=3^3+7^3+1^3。
     * @param args
     */
    public static void main(String[] args) {
        String input = "f3@d5a8";

        StringBuilder sb = new StringBuilder();
        // 切割字符串

        ArrayList<String> list = new ArrayList<>();
        spliteStr(input.toCharArray(),sb,list,0);

    }

    public static void spliteStr(char [] chars, StringBuilder sb, ArrayList<String> strings,int index ){

        int num = 0;
        StringBuilder sb_temp = new StringBuilder();
        for (int i = index; i < chars.length ; i++) {
            char aChar = chars[i];
            // 转换为数值
            num += aChar;
            sb_temp.append(aChar);
            if (!isFlower(num)) {
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder(sb);
            stringBuilder.append(sb_temp).append(" ");
            if (i == chars.length -1) {
                strings.add(stringBuilder.toString().trim());
                return;
            }
            spliteStr(chars,stringBuilder,strings,i+1);
        }
    }

    public static boolean isFlower(int n){
        if (n < 100 || n >999) {
            return false;
        }
        int bai = n / 100;
        int shi = n / 10 % 10;
        int ge = n % 10 ;
        if (Math.pow(bai,3)+Math.pow(shi,3)+Math.pow(ge,3) == n){
            return true;
        }
        return false;
    }
}
