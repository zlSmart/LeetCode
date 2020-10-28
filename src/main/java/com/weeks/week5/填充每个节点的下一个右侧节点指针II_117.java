package com.weeks.week5;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class 填充每个节点的下一个右侧节点指针II_117 {
    public static void main(String[] args) {
        double a = 5/2;
        System.out.println(a);
    }
}
class Solution {
    Node nextStart=null,last = null;
    public Node connect(Node root) {
        Node start = root;
        while (start!=null){
            nextStart = null;
            last = null;
            for (Node p = start ;p!=null;p = p.next){
                if (p.next!=null){
                    handle(p.next);
                }
                if (p.right!=null){
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }
    void handle(Node p){
        if (last!=null){
            last.next = p;
        }
        if (nextStart==null){
            nextStart = p;
        }
        last = p;
    }
}