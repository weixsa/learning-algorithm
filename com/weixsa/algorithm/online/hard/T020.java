package com.weixsa.algorithm.online.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T020 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int c = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        Map<Integer,Integer> result = new HashMap<>();
        for (int i = 2; i < split.length ; i++) {
            int num = Integer.parseInt(split[i]);

            int total = 0;
            // 获取是个字节之和
            while (num > 0) {
                total += num & 0xff;
                num >>=8;
            }
            int temp = total % b;
            if (temp < c) {
                result.put(temp,result.getOrDefault(temp,0) +1);
            }
        }

        int max = 0;
        for (int temp :  result.keySet()) {
            max = Math.max(result.get(temp),max);
        }
        System.out.println(max);

    }
}
