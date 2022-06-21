package com.weixsa.algorithm.od;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 幼儿园两个班的小朋友在排队时混在了一起，每位小朋友都知道自己是否与前面一位小朋友是否同班，请你帮忙把同班的小朋友找出来。
 * 小朋友的编号为整数，与前一位小朋友同班用Y表示，不同班用N表示。
 */
public class D008 {

    public static void main(String[] args) {

        // 获取到几个小朋友的数据
        String[] input = "6/N 2/Y 3/N 4/Y".split(" ");

        // 1班
        List<String> class1 = new LinkedList<>();
        // 2班
        List<String> class2 = new LinkedList<>();

        // 循环数据
        String classNum="";
        for (int i = 0; i < input.length; i++) {
            String s = input[i];
            String[] split = s.split("/");
            if ( i== 0) {
                class1.add(split[0]);
                classNum = "1";
                continue;
            }

            // 和前一个是同班的
            if ("Y".equals(split[1])) {
                if ("1".equals(classNum)) {
                    class1.add(split[0]);
                }else{
                    class2.add(split[0]);
                }
            }else{
                if ("1".equals(classNum)) {
                    class2.add(split[0]);
                    classNum = "2";
                }else{
                    class1.add(split[0]);
                    classNum = "1";
                }
            }
        }
        class1.sort(Comparator.comparingInt(Integer::parseInt));
        class2.sort(Comparator.comparingInt(Integer::parseInt));

        StringBuilder sb = new StringBuilder();
        class1.stream().forEach(x-> System.out.print(x+" "));
        System.out.println();
        class2.stream().forEach(x-> System.out.print(x+" "));


    }
}
