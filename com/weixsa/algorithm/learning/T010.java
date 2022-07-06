package com.weixsa.algorithm.learning;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 对一个数据a进行分类，
 * 分类方法是，此数据a(4个字节大小)的4个字节相加对一个给定值b取模，
 * 如果得到的结果小于一个给定的值c则数据a为有效类型，其类型为取模的值。
 * 如果得到的结果大于或者等于c则数据a为无效类型。
 *
 * 比如一个数据a=0x01010101，b=3
 * 按照分类方法计算：(0x01+0x01+0x01+0x01)%3=1
 * 所以如果c等于2，则此a就是有效类型，其类型为1
 * 如果c等于1，则此a是无效类型
 *
 * 又比如一个数据a=0x01010103，b=3
 * 按分类方法计算：(0x01+0x01+0x01+0x03)%3=0
 * 所以如果c=2则此a就是有效类型 其类型为0
 * 如果c等于0 则此a是无效类型
 *
 * 输入12个数据，
 * 第一个数据为c，第二个数据为b，
 * 剩余10个数据为需要分类的数据
 *
 * 请找到有效类型中包含数据最多的类型，
 * 并输出该类型含有多少个数据
 *
 * 输入描述
 * 输入12个数据用空格分割，
 * 第一个数据为c，第二个数据为b，
 * 剩余10个数据为需要分类的数据。
 *
 * 输出描述
 * 请找到有效类型中包含数据最多的类型，
 * 并输出该类型含有多少个数据。
 *
 * 示例一
 * 输入
 *
 * 3 4 256 257 258 259 260 261 262 263 264 265
 * COPY
 * 输出
 *
 * 3
 * COPY
 * 说明
 *
 * 这10个数据4个字节相加后的结果分别是
 * 1 2 3 4 5 6 7 8 9 10
 * 故对4取模的结果为
 * 1 2 3 0 1 2 3 0 1 2
 * c是3所以012都是有效类型
 * 类型为1和2的有3个数据
 * 类型为0和3的只有两个
 * COPY
 * 示例二
 * 输入
 *
 * 1 4 256 257 258 259 260 261 262 263 264 265
 * COPY
 * 输出
 *
 * 2
 */
public class T010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");

        int c = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        // 用来存储和统计结果
        Map<Integer,Integer> result = new HashMap<>();

        for (int i = 2; i < s.length ; i++) {
            int num = Integer.parseInt(s[i]);
            int total = 0;
            while (num > 0) {
                total+= num & 0xff;
                num >>=8;
            }
            int temp = total % b;
            if (temp< c) {
                result.put(temp,result.getOrDefault(temp,0) +1);
            }
        }
        int max = 0;
        for (Integer i: result.keySet()) {
            max= Math.max(max,result.get(i));
        }
        System.out.println(max);
    }
}
