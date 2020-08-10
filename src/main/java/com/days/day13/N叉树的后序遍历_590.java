package com.days.day13;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/submissions/
 */
public class N叉树的后序遍历_590 {
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
class Solution4 {


    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            result.add(temp.val);
            for(Node child : temp.children){
                stack.add(child);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
class Solution3 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        post(root);
        return result;
    }
    public void post(Node root){
        if(root!=null){
            for(Node child:root.children) postorder(child);
            result.add(root.val);
        }
    }
}