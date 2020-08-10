package com.days.day24;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class 恢复二叉搜索树_99 {
}
class Solution10 {
    private List<Integer> list;
    private int x,y;
    public void recoverTree(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
        int[] pos = findPos();
        x = pos[0];
        y = pos[1];
        recover(root);
    }

    public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
    }
    public void recover(TreeNode root){
        if(root!=null){
            recover(root.left);
            if(root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
            }
            recover(root.right);
        }
    }

    public int[] findPos(){
        int[] result = new int[2];
        int pos = 0;
        for(int i = 0;i<list.size()-1;i++){
            if(list.get(i+1) < list.get(i)){
                if(pos==0){
                    result[pos++] = list.get(i + 1);
                    result[pos] = list.get(i);
                }else{
                    result[0] = list.get(i+1);
                }
            }
        }
        return result;
    }
}