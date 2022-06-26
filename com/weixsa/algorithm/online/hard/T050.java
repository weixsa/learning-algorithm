package com.weixsa.algorithm.online.hard;



import java.util.*;

/**
 * ■ 题目描述
 * 【导师请吃火锅】
 * 入职后，导师会请你吃饭，你选择了火锅。
 * 火锅里会在不同时间下很多菜。
 * 不同食材要煮不同的时间，才能变得刚好合适。
 * 你希望吃到最多的刚好合适的菜，但你的手速不够快，用m代表手速，每次下手捞菜后至少要过m秒才能再捞（每次只能捞一个）。
 * 那么用最合理的策略，最多能吃到多少刚好合适的菜？
 * 输入描述
 * 第一行两个整数n，m，其中n代表往锅里下的菜的个数，m代表手速。
 * 接下来有n行，每行有两个数x，y代表第x秒下的菜过y秒才能变得刚好合适。
 * （1 < n, m < 1000）（1 < x, y < 1000）
 * 输出描述
 * 输出一个整数代表用最合理的策略，最多能吃到刚好合适的菜的数量。
 * 示例1   输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 2 1
 * 1 2
 * 2 1
 * 输出
 *
 * 1
 */
public class T050 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");

        // 菜品个数
        int n = Integer.parseInt(split[0]);
        // 夹菜需要的时间
        int m = Integer.parseInt(split[1]);

        // 获取每道菜的合适需要的时间,如果是合适的时候产生的不可能同时获取
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] temp = scanner.nextLine().split(" ");
            set.add(Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]));
        }

        // 已经排过序了
        List<Integer> list = new ArrayList(set);

        int count = 0;
        int time = 0 ;
        // 循环判断处理
        for (int i = 0; i < list.size(); i++) {
            if (time <= list.get(i)) {
                count++;
                time+=list.get(i)+m;
            }
        }
        System.out.println(count);
    }
}
