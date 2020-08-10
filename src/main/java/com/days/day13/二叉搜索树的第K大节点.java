package com.days.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class 二叉搜索树的第K大节点 {
}
class Solution {
    List<Integer> list = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        int result = 0;
        order(root,k);
        return list.get(k-1);
    }
    public void order(TreeNode root,int k) {
        if(list.size()==k) return;
        if(root!=null) {
            order(root.right, k);
            list.add(root.val);
            order(root.left, k);
        }
    }
}