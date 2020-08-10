package com.days.day14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 */
public class 从上到下打印二叉树II {
}
class Solution4 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return new ArrayList<>(new ArrayList<>());
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> ans1 = new ArrayList<>();
            while(size-->0){
                TreeNode treeNode = queue.poll();
                ans1.add(treeNode.val);
                if(treeNode.left!=null) queue.offer(treeNode.left);
                if(treeNode.right!=null) queue.offer(treeNode.right);
            }
            ans.add(ans1);
        }
        return ans;
    }
}