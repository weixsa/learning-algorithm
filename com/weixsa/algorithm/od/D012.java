package com.weixsa.algorithm.od;

import java.util.*;

public class D012 {

    /**
     * 输入一个字符串，返回其最长的数字子串，以及其长度。若有多个最长的数字子串，则将它们全部输出（按原字符串的相对位置）
     * 本题含有多组样例输入。
     * 数据范围：字符串长度 1 \le n \le 200 \1≤n≤200 ， 保证每组输入都至少含有一个数字输入一个字符串，返回其最长的数字子串，以及其长度。若有多个最长的数字子串，则将它们全部输出（按原字符串的相对位置）
     * 本题含有多组样例输入。
     * 数据范围：字符串长度 1 \le n \le 200 \1≤n≤200 ， 保证每组输入都至少含有一个数字
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();

            String[] split = nextLine.split("\\D+");

            Map<Integer, List<String>> result = new HashMap<>();
            int max = 0;
            for (int i = 0; i < split.length; i++) {
                String temp = split[i];
                if ("".equals(temp)) {
                    continue;
                }
                max = Math.max(max,temp.length());
                List<String> list = result.getOrDefault(temp.length(), new LinkedList<>());
                list.add(temp);
                result.put(temp.length(),list);
            }
            StringBuilder sb = new StringBuilder();
            // 输出
            result.get(max).forEach(x->{
                sb.append(x);
            });
            System.out.println(sb.append(",").append(max));

        }

    }
}
