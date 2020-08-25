package com.weeks.week3;

import com.ListNode;

import java.util.*;

public class 链表中的下一个更大节点_1019 {
}
class Solution6 {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> arrays = new ArrayList<>();
        while(head!=null){
            arrays.add(head.val);
            head = head.next;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<arrays.size();i++){
            Integer num = arrays.get(i);
            while(!stack.isEmpty() && num > arrays.get(stack.peek())){
                int pos = stack.pop();
                arrays.set(pos, num);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            arrays.set(stack.pop(),0);
        }
        int[] result = new int[arrays.size()];
        int i = 0;
        for(int a:arrays){
            result[i++] = a;
        }
        return result;
    }
}
