package com.weixsa.algorithm.od;

import java.util.Scanner;

public class D011 {

    /**
     * 给一个字符串和一个二维字符数组，如果该字符串存在于该数组中，则按字符串的字符顺序输出字符串每个字符所在单元格的位置下标字符串，如果找不到返回字符串"N"。
     *
     * 需要按照字符串的字符组成顺序搜索，且搜索到的位置必须是相邻单元格，其中“相邻单元格”是指那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     * 假定在数组中最多只存在一个可能的匹配。
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        char[][] twodim = new char[N][N];
        int count = 0;
        while (count < N) {
            String line = scanner.nextLine();
            String replacedLine = line.replace(",", "");
            for (int i = 0; i < N; i++) {
                twodim[count][i] = replacedLine.charAt(i);
            }
            count++;
        }
        String lastLine = scanner.nextLine();

        StringBuilder str = new StringBuilder();
        boolean result = false;
        for (int i = 0; i < N; i++) {
             for (int j = 0; j < N; j++) {
                if (lastLine.charAt(0) == twodim[i][j]) {
                    StringBuilder resultStr = new StringBuilder();
                    if (find(twodim, lastLine, i, j, 0, resultStr)) {
                        str = resultStr;
                    }
                }
            }
        }

        System.out.println(str.reverse());

    }

    private static boolean find(char[][] twodim, String lastLine, int i, int j, int indexOfStr, StringBuilder resultStr) {
        if (indexOfStr >= lastLine.length()) {
            return true;
        }
        if ( i >= twodim.length || j >= twodim.length || twodim[i][j] != lastLine.charAt(indexOfStr)) {
            return false;
        }
//        twodim[i][j] += 300; // 防止该位置被重复判断

        boolean result =
//                           find(twodim, lastLine, i - 1, j, indexOfStr + 1, resultStr)
                        find(twodim, lastLine, i + 1, j, indexOfStr + 1, resultStr)
//                        || find(twodim, lastLine, i, j - 1, indexOfStr + 1, resultStr)
                         || find(twodim, lastLine, i, j + 1, indexOfStr + 1, resultStr);
//        twodim[i][j] -= 300;
         if (result) {
            if (indexOfStr == 0) {
                resultStr.append(j).append(",").append(i);
            }
            if (indexOfStr != 0) {
                 resultStr.append(j).append(",").append(i).append(",");
            }
        }
        return result;
    }
}
