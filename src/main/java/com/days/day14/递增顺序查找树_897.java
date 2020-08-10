package com.days.day14;

import java.util.ArrayList;
import java.util.List;

public class 递增顺序查找树_897 {
}

class Solution2 {
    private List<Integer> ans = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        order(root);
        root.left = null;
        root.right = null;
        root.val = ans.get(0);
        TreeNode node = root;
        for(int i = 1;i<ans.size();i++){
            node.right = new TreeNode(ans.get(i));
            node = node.right;
        }
        return  root;
    }

    public void order(TreeNode root){
        if(root!=null) {
            order(root.left);
            ans.add(root.val);
            order(root.right);
        }
    }
}