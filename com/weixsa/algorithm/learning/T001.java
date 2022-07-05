package com.weixsa.algorithm.learning;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 题目描述：
 * 如果三个正整数A、B、C ,A²+B²=C²则为勾股数
 * 如果ABC之间两两互质，即A与B，A与C，B与C均互质没有公约数，
 * 则称其为勾股数元组。
 * 请求出给定n~m范围内所有的勾股数元组
 *
 * 输入描述
 * 起始范围
 * 1 < n < 10000
 * n < m < 10000
 *
 * 输出描述
 * ABC保证A<B<C
 * 输出格式A B C
 * 多组勾股数元组，按照A B C升序的排序方式输出。
 * 若给定范围内，找不到勾股数元组时，输出Na。
 *
 * 示例一
 * 输入
 *
 * 1
 * 20
 * COPY
 * 输出
 *
 * 3 4 5
 * 5 12 13
 * 8 15 17
 * COPY
 * 示例二
 * 输入
 *
 * 5
 * 10
 * COPY
 * 输出
 *
 * Na
 */
public class T001 {


    // 存放已经校验过是互质的两个数
    static HashSet<String> huzhiset  = new HashSet<>();
    static int d1 = 0;

    static int d2 = 0;



    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int count = 0;
        for (int i = n; i < m - 1 ; i++) {
            for (int j = i + 1; j < m ; j++) {
                for (int k = j + 1; k < m + 1; k++) {

                    if (huzhi(i,j)
                    && huzhi(i,k)
                    && huzhi(j,k) && i*i + j*j == k*k ) {
                        count++;
                        System.out.printf("%d  %d  %d \n",i,j,k);
                    }
                }
            }
        }
        if (count == 0) {
            System.out.println("Na");
        }
        System.out.println(d1 + " " + d2);

        System.out.println();

    }

    /**
     * 存储已经计算的互质数，减少计算量
     * @param a
     * @param b
     * @return
     */
    public static boolean huzhi(int a ,int b ){
        String temp = a + "," + b;
        if (huzhiset.contains(temp)) {
            d1++;
            return false;
        }
        if (a ==1) {
            return true;
        }
        // 获取最小数据的全量质数减少计算量
        double sqrt = Math.sqrt(a);
        for (int i = 2; i < sqrt ; i++) {
            d2++;
            if (a % i ==0 && b%i==0) {
                huzhiset.add(temp);
                return false;
            }
        }

        return true;
    }
}
