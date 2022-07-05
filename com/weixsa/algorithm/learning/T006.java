package com.weixsa.algorithm.learning;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 小明今年升学到了小学一年级，
 * 来到新班级后，发现其他小朋友身高参差不齐，
 * 然后就想基于各小朋友和自己的身高差，对他们进行排序，
 * 请帮他实现排序
 *
 * 输入描述
 * 第一行为正整数 H和N
 * 0 < H < 200 为小明的身高
 * 0 < H < 50 为新班级其他小朋友个数
 * 第二行为N个正整数
 * H1 ~ Hn分别是其他小朋友的身高
 * 取值范围0 < Hi < 200
 * 且N个正整数各不相同
 *
 * 输出描述
 * 输出排序结果，各正整数以空格分割
 * 和小明身高差绝对值最小的小朋友排在前面
 * 和小明身高差绝对值最大的小朋友排在后面
 * 如果两个小朋友和小明身高差一样
 * 则个子较小的小朋友排在前面
 *
 * 示例一
 * 输入
 *
 * 100 10
 * 95 96 97 98 99 101 102 103 104 105
 * COPY
 * 输出
 *
 * 99 101 98 102 97 103 96 104 95 105
 */
public class T006 {

    public static void main(String[] args) {

        int h = 100;
        String[] s = "95 96 97 98 99 101 102 103 104 105".split(" ");

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length ; i++) {
            list.add(Integer.parseInt(s[i]));
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int h1 = Math.abs(o1 - h);
                int h2 = Math.abs(o2 - h);
                if (h1 == h2){
                    return o1 -o2;
                }else{
                    return h1 - h2;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() ; i++) {
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }

}
