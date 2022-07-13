package com.weixsa.algorithm.learning;

import java.util.Scanner;
import java.util.TreeMap;

/*
  Vlan是一种为局域网设备进行逻辑划分的技术
  为了标识不同的vlan 引入了vlan id 1~4094之间的整数
  定义一个vlan id 的资源池
  资源池中连续的vlan用开始vlan-结束vlan表示，
  不连续的用单个整数表示
  所有的vlan用英文逗号连接起来
  现有一个vlan资源池，业务需要从资源池中申请一个vlan
  需要你输出从vlan资源池中移除申请的vlan后的资源池

  输入描述
  第一行为字符串格式的vlan资源池
  第二行为业务要申请的vlan vlan的取值范围1~4094

  输出描述
  从输入vlan资源池中移除申请的vlan后
  字符串格式的vlan资源池
  输出要求满足题目中要求的格式，
  并且要求从小到大升序输出
  如果申请的vlan不在原资源池，输出升序排序的原资源池的字符串即可

  示例一
  输入
  1-5
  2
  输出
  1,3-5
  说明：原vlan资源池中有1 2 3 4 5 移除2后
  剩下的1 3 4 5按照升序排列的方式为 1 3-5

  示例二
  输入
  20-21,15,18,30,5-10
  15
  输出
  5-10,18,20-21,30
  说明：
  原vlan资源池中有5 6 7 8 9 10 15 18 20 21 30
  移除15后 剩下的为 5 6 7 8 9 10 18 20 21 30
  按照题目描述格式并升序后的结果为5-10,18,20-21,30

  示例三
  输入
  5,1-3
  10
  输出
  1-3,5
  资源池中有1 2 3 5
  申请的资源不在资源池中
  将原池升序输出为1-3,5

  输入池中vlan数量范围为2~2094的整数
  资源池中vlan不重复且合法1~2094的整数
  输入是乱序的

   */
public class T042 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for (int i = 0; i < split.length ; i++) {
            if (split[i].contains("-")){
                map.put(Integer.parseInt(split[i].split("-")[0]),Integer.parseInt(split[i].split("-")[1]));
            }else{
                map.put(Integer.parseInt(split[i]),Integer.parseInt(split[i]));
            }
        }

        int apply = Integer.parseInt(scanner.nextLine());
        // 遍历
        StringBuilder sb = new StringBuilder();
        for (Integer key: map.keySet()) {
            Integer value = map.get(key);
            // 存在资源进行申请
            if (apply >= key  && apply <= value) {
                int left = apply - key ;
                int right = value - apply;
                if (left == 1) sb.append(key).append(",");
                if (left > 1) sb.append(key).append("-").append(apply-1).append(",");
                if (right == 1) sb.append(value).append(",");
                if (right > 1) sb.append(apply+1).append("-").append(value).append(",");
            }else{
                if (key == value){
                    sb.append(key).append(",");
                }else{
                    sb.append(key).append("-").append(value).append(",");
                }
            }
        }
        System.out.println(sb.substring(0,sb.length()-1));

    }
}
