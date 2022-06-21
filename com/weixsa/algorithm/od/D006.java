package com.weixsa.algorithm.od;


import java.util.*;

/**
 * 给定一个射击比赛成绩单，包含多个选手若干次射击的成绩分数，请对每个选手按其最高三个分数之和进行降序排名，输出降序排名后的选手ID序列。
 */
public class D006 {
    public static void main(String[] args) {

        int n = 13;
        int[] ids = Arrays.stream("3,3,7,4,4,4,4,7,7,3,5,5,5".split(",")).mapToInt(Integer::parseInt).toArray();
        int[] scores = Arrays.stream("53,80,68,24,39,76,66,16,100,55,53,80,55".split(",")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < ids.length ; i++) {
            int id = ids[i];
            List<Integer> list = map.getOrDefault(id, new LinkedList<>());
            list.add(scores[i]);
            map.put(id,list);
        }
        // 按照要求过滤数据
        StringBuilder sb = new StringBuilder();
         map.entrySet().stream()
                .filter(x -> x.getValue().size() >= 3)
                .sorted(((o1, o2) -> {
                    int sum1 = sum(o1.getValue());
                    int sum2 = sum(o2.getValue());
                    if (sum2 == sum1) {
                        return o2.getKey() - o1.getKey();
                    } else {
                        return sum2 - sum1;
                    }
                })).map(Map.Entry::getKey)
                 .forEach(x->sb.append(x).append(","));
        System.out.println(sb.substring(0,sb.length()-1));


    }

    public static  int sum(List<Integer> list) {
        // 获取前三个数据
        list.sort(Integer::compareTo);
        int result  = 0;
        for (int i = list.size() - 1; i >= list.size() -3 ; i--) {
            result+=list.get(i);
        }
        return result;
    }
}
