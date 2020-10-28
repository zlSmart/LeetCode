package com.weeks.week5;

import com.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 左叶子之和_404 {
}
class Solution4 {
    public int sumOfLeftLeaves(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> que = new LinkedList<>();
        if (root!=null){
            que.offer(root);
            while(!que.isEmpty()){
                TreeNode node = que.poll();
                if (node.left!=null){
                    if (node.left.left==null && node.left.right==null) ans += node.left.val;
                    que.offer(node.left);
                }
                if (node.right!=null){
                    que.offer(node.right);
                }
            }
        }
        return ans;
    }
}