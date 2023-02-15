package QueueAndStack;

//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
//
//完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
//
//示例 1：
//
//输入：n = 12
//输出：3
//解释：12 = 4 + 4 + 4

//示例 2：
//
//输入：n = 13
//输出：2
//解释：13 = 4 + 9

//解题思路
//https://leetcode.cn/leetbook/read/queue-stack/kfgtt/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class question279完全平方数 {
    //构建由层级的完全平方数的树

    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        //记录访问过的节点值
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        //树的第几层
        int level = 0;
        while (!queue.isEmpty()) {
            //每一层的节点数量
            int size = queue.size();
            level++;
            //遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                //节点的值
                int digit = queue.poll();
                //访问当前节点的子节点，类比于二叉树的左右子节点
                for (int j = 1; j <= n; j++) {
                    //子节点的值
                    int nodeValue = digit + j * j;
                    //nodeValue始终是完全平方数的和，当他等于n的时候直接返回
                    if (nodeValue == n)
                        return level;
                    //如果大于n，终止内层循环
                    if (nodeValue > n)
                        break;
                    //注意这个位置，由于广度优先是横向遍历，所以如果遇到相同值的节点，必定是先遇到的节点数量小于后遇到的
                    if (!visited.contains(nodeValue)) {
                        queue.offer(nodeValue);
                        visited.add(nodeValue);
                    }
                }
            }
        }
        return level;
    }
}
