package com.weixsa.algorithm.online.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 众数是指一组数据中出现次数量多的那个数，众数可以是多个。
 * 中位数是指把一组数据从小到大排列，最中间的那个数，如果这组数据的个数是奇数，那最中间那个就是中位数，如果这组数据的个数为偶数，那就把中间的两个数之和除以2，所得的结果就是中位数。
 * 查找整型数组中元素的众数并组成一个新的数组，求新数组的中位数。
 * 输入描述
 * 输入一个一维整型数组，数组大小取值范围 0<N<1000，数组中每个元素取值范围 0<E<1000
 * 输出描述
 * 输出众数组成的新数组的中位数
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 10 11 21 19 21 17 21 16 21 18 15
 * 输出
 * 21
 */
public class T043 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();

        Map<Integer,Integer> map = new HashMap<>();
        // 获取众数
        for (int i = 0; i < nums.length ; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int max = 0;
        for (int value : map.values()) {
            max = Math.max(max,value);
        }

       

    }
}
