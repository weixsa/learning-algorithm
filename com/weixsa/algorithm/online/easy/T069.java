package com.weixsa.algorithm.online.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T069 {


    /**
     * 从小到大排序，然后求职计算
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = Arrays.stream("2 20 98 78 99 67 27 88 67 16".split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        Set<Integer> set = new HashSet<>();
        for (int i = nums.length -1; i >= 0  ; i--) {
            for (int j = 0; j <= i ; j++) {
                if (nums[i] % nums[j] == 0) {
                    set.add(j);
                    break;
                }
            }
        }
        System.out.println(set.size());
    }
}
