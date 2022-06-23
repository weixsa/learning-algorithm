package com.weixsa.algorithm.od;

import java.util.ArrayList;
import java.util.List;

public class D013 {
    /**
     * 某探险队负责对地下洞穴进行探险。探险队成员在进行探险任务时，随身携带的记录器会不定期地记录自身的坐标，但在记录的间隙中也会记录其他数据。探索工作结束后，探险队需要获取到某成员在探险过程中相对于探险队总部的最远的足迹位置。
     *
     * 仪器记录坐标时，坐标的数据格式为(x,y)，如(1,2)、(100,200)，其中0<x<1000，0<y<1000。同时存在非法坐标，如(01,1)、(1,01)，(0,100)属于非法坐标。
     * 设定探险队总部的坐标为(0,0)，某位置相对总部的距离为：xx+yy。
     * 若两个座标的相对总部的距离相同，则第一次到达的坐标为最远的足迹。
     * 若记录仪中的坐标都不合法，输出总部坐标（0,0）。
     * 备注：不需要考虑双层括号嵌套的情况，比如sfsdfsd((1,2))。
     * @param args
     */
    public static void main(String[] args) {


        // 记录的数据
        String input = "ferga13fdsf3(100,200)f2r3rfasf(300,400)";
        
        // 解析获取坐标
        char[] chars = input.toCharArray();

        // 存储合适的坐标
        List<String> data = new ArrayList<>();
        StringBuilder sb = null;
        boolean start = false;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if ('(' == aChar) {
                sb= new StringBuilder();
                start = true;
                continue;
            }
            if (start) {
                if (aChar == ')') {
                    start = false;
                    data.add(sb.toString());
                }
                sb.append(aChar);
            }
        }
        int max = 0;
        int index = -1;
        // 剔除非法的数据和校验最远的距离
        for (int i = 0; i < data.size(); i++) {
            String[] split = data.get(i).split(",");
            if (split[0].startsWith("0") || split[1].startsWith("0")) {
                continue;
            }
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            if (x*x+y*y > max) {
                index = i;
            }
        }
        if (index  == -1) {
            System.out.println("(0,0)");
        }else{
            System.out.println("("+data.get(index)+")");
        }
    }
    
    
}
