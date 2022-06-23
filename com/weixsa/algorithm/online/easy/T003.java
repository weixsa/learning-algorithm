package com.weixsa.algorithm.online.easy;

import java.util.ArrayList;
import java.util.Scanner;

public class T003 {

    /**
     * 给定一个由多个命令字组成的命令字符串：
     * 1、字符串长度小于等于127字节，只包含大小写字母，数字，下划线和偶数个双引号；
     * 2、命令字之间以一个或多个下划线_进行分割；
     * 3、可以通过两个双引号””来标识包含下划线_的命令字或空命令字（仅包含两个双引号的命令字），双引号不会在命令字内部出现；
     *
     * 请对指定索引的敏感字段进行加密，替换为******（6个*），并删除命令字前后多余的下划线_。
     * 如果无法找到指定索引的命令字，输出字符串ERROR。
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        ArrayList<String> coms = new ArrayList<>();
        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < chars.length ; i++) {

            char aChar = chars[i];
             if (aChar == '"') {
                sb.append(aChar);
                i++;
                while (chars[i] !='"') {
                    sb.append(chars[i]);
                    i++;
                }
                sb.append(chars[i]);
                coms.add(sb.toString());
                sb = new StringBuilder();
            }else if (aChar !='_') {
                sb.append(aChar);
            }else if (aChar == '_'){
                if (sb.length()>0){
                    coms.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
             if (i == chars.length-1 && sb.length()>0){
                 coms.add(sb.toString());
             }
        }
        sb = new StringBuilder();
        if (k>coms.size()-1) {
            System.out.println("ERROR");
        }else {
            for (int i = 0; i < coms.size(); i++) {

                if (k == i) {
                    sb.append("******").append("_");
                }else{
                    sb.append(coms.get(i)).append("_");
                }
            }
            System.out.println(sb.substring(0,sb.length()-1));
        }
//        for (int i = 0; i < s.length(); ) {
//            if (s.charAt(i) == '"') {
//                int j = i + 1;
//                for (; j < s.length(); j++) {
//                    if (s.charAt(j) == '"') {
//                        break;
//                    }
//                }
//                coms.add(s.substring(i, j + 1));
//                i = j + 1;
//                continue;
//            }
//            if (s.charAt(i) != '_' && s.charAt(i) != '"') {
//                int j = i + 1;
//                for (; j < s.length(); j++) {
//                    if (s.charAt(j) == '_') {
//                        break;
//                    }
//                }
//                coms.add(s.substring(i, j));
//                i = j;
//                continue;
//            }
//            if (s.charAt(i) == '_') {
//                i++;
//            }
//        }
//        StringBuilder out = new StringBuilder();
//        if (k >= coms.size()) {
//            System.out.println("ERROR");
//            return;
//        }
//        for (int i = 0; i < coms.size() - 1; i++) {
//            if (i != k) {
//                out.append(coms.get(i)).append("_");
//            } else {
//                out.append("******").append("_");
//            }
//        }
//        if (k == coms.size() - 1) {
//            out.append("******");
//        } else {
//            out.append(coms.get(coms.size() - 1));
//        }
//        System.out.println(out);
    }

}
