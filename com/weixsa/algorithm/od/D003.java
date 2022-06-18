package com.weixsa.algorithm.od;

public class D003 {

//    输入：一个正整数num（0 < num <= 2147483647）
//    输出：如果成功找到，以单个空格分割，从小到大输出两个素数，分解失败，请输出-1 -1

    public static void main(String[] args) {

        int num = 542321000;
        double sqrt = Math.sqrt(num);
        // c循环到这个数可以了
        for (int i = 2; i <= sqrt; i++) {
            // 可以整除。需要检查i  和 num%i是素数才行
            if (num % i != 0) {
                continue;
            }
            if (isPrime(i) && isPrime(num / i)) {
                System.out.println(i + " " + num / i);
            }
        }
        System.out.println("-1 -1");
    }

    public static boolean isPrime(int n){
        if (n<=2) {
            return false;
        }
        double sqrt = Math.sqrt(n);
        for (int i = 2; i <= sqrt ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
