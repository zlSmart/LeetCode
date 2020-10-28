package com.weeks.week4;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class 二叉树的中序遍历_94 {
}
class Solution11 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return ans;
        TreeNode temp = root;
        while(temp!=null || !stack.isEmpty()){
            while(temp!=null){
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            ans.add(temp.val);
            temp = temp.right;
        }
        return ans;
    }
}