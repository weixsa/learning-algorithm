package com.weixsa.algorithm.online.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T002 {


    /**
     *  题目描述*
     * 【水仙花数】*
     * 给定非空字符串s，将该字符串分割成一些子串，使每个子串的ASCII码值的和均为水仙花数。*
     * 1、若分割不成功，则返回0；*
     * 2、若分割成功且分割结果不唯一，则返回-1；*
     * 3、若分割成功且分割结果唯一，则返回分割后子串的数目。*
     * 输入描述*
     * 输入字符串的最大长度为200*
     * 输出描述*
     * 根据题目描述中情况，返回相应的结果。
     * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
     * @param args
     */

    // 用来存储拆分的水仙花数
    public static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] chars = scanner.nextLine().toCharArray();
        find(chars,0,new StringBuilder());

        if (list.size() == 0) {
            System.out.println(0);
        }else if (list.size() > 1){
            System.out.println(-1);
        }else{
            System.out.println(list.get(0).split(" ").length);
        }
    }

    /**
     * 查询水仙花数
     */
    public static void find(char [] chars ,int index ,StringBuilder sb){
        int temp = 0;
        StringBuilder sb_temp = new StringBuilder();
        for (int i = index ; i < chars.length; i++) {
            // 获取分隔数据的数值
            temp += chars[i];
            sb_temp.append(chars[i]);
            if (!isFllower(temp)) {
                continue;
            }
            // 已经是最后一个数据了，正好是水仙花数
            StringBuilder stringBuilder = new StringBuilder(sb);
            stringBuilder.append(sb_temp).append(" ");
            if (i == chars.length - 1) {
                list.add(stringBuilder.toString());
                return;
            }
            find(chars,i+1,stringBuilder);
        }

    }
    public static boolean isFllower(int num){
        if (num > 999 || num <100) {
            return false;
        }
        int a = num / 100;
        int b = num % 10;
        int c = num / 10 % 10;
        return num == Math.pow(a,3) + Math.pow(b,3) + Math.pow(c,3);
    }
}
