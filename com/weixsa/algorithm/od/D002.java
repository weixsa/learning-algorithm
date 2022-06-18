package com.weixsa.algorithm.od;

public class D002 {

//    给定一个URL前缀和URL后缀,通过,分割， 需要将其连接为一个完整的URL，如果前缀结尾和后缀开头都没有/，需要自动补上/连接符，如果前缀结尾和后缀开头都为/，需要自动去重
//    约束：不用考虑前后缀URL不合法情况
    public static void main(String[] args) {

        String input = ",";

        // 待拼接的数据
        String[] split = input.replace("/", "").split(",");

        StringBuilder sb = new StringBuilder();
        if (split.length == 0) {
            System.out.println("/");
        } else {
            for (String str: split) {
                sb.append("/").append(str);
            }
            System.out.println(sb);
        }
    }
}
