package com.weeks.week2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class 二叉树的最小深度_111 {
}
class Solution6 {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if(treeNode.left==null && treeNode.right==null) break;
            size--;
            if(treeNode.left!=null) queue.offer(treeNode.left);
            if(treeNode.right!=null) queue.offer(treeNode.right);
            if(size==0) {
                depth++;
                size = queue.size();
            }
        }
        return depth;
    }
}