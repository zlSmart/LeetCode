package com.weeks.week4;

import com.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 */
public class 二叉树的层平均值_637 {
}
class Solution12 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root==null){
            result.add(0.0);
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        double sum = 0;
        int size1 = 1;
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            size--;
            sum += temp.val;
            if(temp.left!=null) queue.add(temp.left);
            if(temp.right!=null) queue.add(temp.right);
            if(size==0){
                size = queue.size();
                result.add(sum/(double)size1);
                sum = 0;
                size1 = size;
            }
        }
        return result;
    }
}