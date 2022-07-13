package com.weixsa.algorithm.learning;

 /*
        实现一个整数编码方法
        使得待编码的数字越小
        编码后所占用的字节数越小
        编码规则如下
        1.编码时7位一组，每个字节的低7位用于存储待编码数字的补码
        2.字节的最高位表示后续是否还有字节，置1表示后面还有更多的字节，
        置0表示当前字节为最后一个字节
        3.采用小端序编码，低位和低字节放在低地址上
        4.编码结果按16进制数的字符格式进行输出，小写字母需要转化为大写字母

        输入描述
        输入的为一个字符串表示的非负整数
        输出描述
        输出一个字符串表示整数编码的16进制码流

        示例一
        输入
        0
        输出
        00
        说明：输出的16进制字符不足两位的前面补零

        示例二
        输入
        100
        输出
        64
        说明:100的二进制表示为0110 0100只需一个字节进行编码
        字节的最高位0，剩余7位存储数字100的低7位(1100100)所以编码后的输出为64

        示例三
        输入
        1000
        输出
        E807
        说明
        1000的二进制表示为 0011 1110 1000 至少需要两个字节进行编码
        第一个字节最高位是1 剩余7位存储数字 1000的低7位(1101000)
        所以第一个字节的二进制位(1110 1000)即E8
        第二个字节最高位置0 剩余的7位存储数字 1000的第二个低7位(0000111)
        所以第一个字节的二进制为(0000 0111)即07
        采用小端序编码 所以低字节E8输出在前面
        高字节07输出在后面

        备注
            代编码数字取值范围为 [0,1<<64-1]
         */

import java.util.Scanner;

public class T043 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i > 0  ; i=i-7) {
            int start = Math.max(i -7,0);
            String bin = s.substring(start, i);
            if (bin.length() < 7) {
                StringBuilder head = new StringBuilder();
                for (int j = 0; j < 7 - bin.length() ; j++) {
                    head.append(0);
                }
                bin=head.append(bin).toString();
            }
            bin = i-7 <=0 ? 0+bin:1+bin;
            String hex = Integer.toHexString(Integer.parseInt(bin,2)).toUpperCase();
            if (hex.length()==1) hex="0"+hex;
            sb.append(hex);
        }
        System.out.println(sb);

    }
}