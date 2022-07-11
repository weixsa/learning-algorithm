package com.weixsa.algorithm.learning;

import java.util.Scanner;

/*
       一个整数可以由连续的自然数之和来表示
       给定一个整数
       计算该整数有几种连续自然数之和的表达式
       并打印出每一种表达式

       输入描述
       一个目标整数t  1<= t <=1000

       输出描述
       1.该整数的所有表达式和表达式的个数
       如果有多种表达式，自然数个数最少的表达式优先输出
       2.每个表达式中按自然数递增输出

       具体的格式参见样例
       在每个测试数据结束时，输出一行"Result:X"
       其中X是最终的表达式个数

       输入
       9

       输出
       9=9
       9=4+5
       9=2+3+4
       Result:3

       说明 整数9有三种表达方法：

       示例二
       输入
       10
       输出
       10=10
       10=1+2+3+4
       Result:2

        */
public class T031 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int count = 0;
        for (int i = 1; i <= n ; i++) {
            int sum = 0;
            for (int j = i; j <=n; j++) {
                // 连续累计求和
                sum+=j;
                if (sum == n) {
                    count++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(n).append("=");
                    for (int k = i; k <= j ; k++) {
                        sb.append(k).append("+");
                    }
                    System.out.println(sb.substring(0,sb.length()-1));
                    break;
                }
                if (sum>n) {
                    break;
                }
            }
        }
        System.out.println("Result:"+count);


    }
}
