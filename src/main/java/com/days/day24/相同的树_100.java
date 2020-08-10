package com.days.day24;

/**
 * https://leetcode-cn.com/problems/same-tree/
 */
public class 相同的树_100 {
}
class Solution8 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        else if(p==null ^ q==null) return false;
        else if(q.val==p.val &&
                isSameTree(p.left,q.left) &&
                isSameTree(p.right,q.right)) return true;
        else return false;
    }
}
