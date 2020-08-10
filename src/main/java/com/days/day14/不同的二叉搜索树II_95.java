package com.days.day14;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 */
public class 不同的二叉搜索树II_95 {
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution1 {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return generate(1,n);
    }
    public List<TreeNode> generate(int start,int end){
        List<TreeNode> ans = new ArrayList<>();
        if(start > end) {ans.add(null);return ans;}
        if(start == end) {ans.add(new TreeNode(start));return ans;}
        for(int i =start;i<=end;i++){
            List<TreeNode> lefts = generate(start,i-1);
            List<TreeNode> rights = generate(i+1,end);
            for(TreeNode left:lefts){
                for (TreeNode right:rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;

    }
}