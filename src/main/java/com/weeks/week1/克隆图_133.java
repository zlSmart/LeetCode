package com.weeks.week1;

import java.util.*;

public class 克隆图_133 {
}
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution4 {
    Map<Node,Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        Node cloneNode = null;
        if(node!=null) {
            if (visited.containsKey(node)) return visited.get(node);
            cloneNode = new Node(node.val);
            visited.put(node, cloneNode);
            for (Node n : node.neighbors) {
                if (visited.containsKey(n)) cloneNode.neighbors.add(visited.get(n));
                else cloneNode.neighbors.add(cloneGraph(n));
            }
        }
        return cloneNode;
    }
}