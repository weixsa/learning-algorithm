package com.weixsa.algorithm.learning;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树也可以用数组来存储，
 * 给定一个数组，树的根节点的值储存在下标1，
 * 对于储存在下标n的节点，他的左子节点和右子节点分别储存在下标2*n和2*n+1，
 * 并且我们用-1代表一个节点为空，
 * 给定一个数组存储的二叉树，
 * 试求从根节点到最小的叶子节点的路径，
 * 路径由节点的值组成。
 *
 * 输入描述
 * 输入一行为数组的内容，
 * 数组的每个元素都是正整数，元素间用空格分割，
 * 注意第一个元素即为根节点的值，
 * 即数组的第n元素对应下标n，
 * 下标0在树的表示中没有使用，所以我们省略了，
 * 输入的树最多为7层。
 *
 * 输出描述
 * 输出从根节点到最小叶子节点的路径上各个节点的值，
 * 由空格分割，
 * 用例保证最小叶子节点只有一个。
 *
 * 示例一
 * 输入
 *
 * 3 5 7 -1 -1 2 4
 * COPY
 * 输出
 *
 * 3 7 2
 * COPY
 * 示例二
 * 输入
 *
 * 5 9 8 -1 -1 7 -1 -1 -1 -1 -1 6
 * COPY
 * 输出
 *
 * 5 8 7 6
 */
public class T011 {


    /**
     * 判断是否是叶子节点
     * 如果是左右两点的坐标是大于数组的数据，或者存在的值都是-1，说明是叶子节点
     * @param list
     * @param index
     * @return
     */
    public static boolean isLeaf(List<Integer> list , int index){
        return (2 * index + 1 >= list.size() || 2 * index+ 1 == -1 )
                && (2 * index + 2 >= list.size() || 2 * index+ 2 == -1 );
    }
    /**
     * dfs查询叶子节点
     * @param list
     * @param index
     * @return
     */
    public static int dfs(List<Integer> list ,int index){
        if (isLeaf(list,index)){
            return index;
        } else {
            // 往下遍历节点，存在三种场景，存在左节点，存在右节点，或者左右节点都存在
            int index_left = dfs(list,2*index + 1 );
            int index_right = dfs(list,2*index + 2 );
            if (index_left >=list.size() || list.get(index_left) == -1) {
                return index_right;
            }else if (index_right>=list.size() || list.get(index_right) == -1) {
                return index_left;
            }else {
                return list.get(index_left) > list.get(index_right)?index_right:index_left;
            }
        }

    }
    public static void main(String[] args) {
        String[] s = "5 9 8 -1 -1 7 -1 -1 -1 -1 -1 6".split(" ");
        List<Integer> list = new ArrayList<>();
        for (String str : s) {
            list.add(Integer.parseInt(str));
        }

        // 已经获取到最小的叶子节点的坐标了
        int  index = dfs(list,0);

        List<Integer> result = new ArrayList<>();
        while (index > 0) {
            result.add(list.get(index));
            // 如果是0 就说明到根节点了
            index = (index - 1) / 2;
        }
        // 根节点
        result.add(list.get(0));
        StringBuilder sb = new StringBuilder();
        for (int i = result.size() -1; i >= 0; i--) {
            sb.append(result.get(i)).append(" ");
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }
}
