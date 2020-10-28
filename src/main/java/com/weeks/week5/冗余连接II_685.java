package com.weeks.week5;

import java.util.Arrays;

public class 冗余连接II_685 {
}
// [[2,1],[3,1],[4,2],[1,4]]
class Solution1 {
    int[] ancestor = null;
    public int find(int index) {
        if (ancestor[index] != index) {
            ancestor[index] = find(ancestor[index]);
        }
        return ancestor[index];
    }

    public void union(int index1, int index2) {
        ancestor[find(index1)] = find(index2);
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodesCount = edges.length;
        ancestor = new int[nodesCount+1];
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; ++i) {
            parent[i] = i;
            ancestor[i] = i;
        }
        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < nodesCount; ++i) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {
                conflict = i;
            } else {
                parent[node2] = node1;
                if (find(node1) == find(node2)) {
                    cycle = i;
                } else {
                    ancestor[find(node1)] = find(node2);
                }
            }
        }
        if (conflict < 0) {
            int[] redundant = {edges[cycle][0], edges[cycle][1]};
            return redundant;
        } else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {
                int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
                return redundant;
            } else {
                int[] redundant = {conflictEdge[0], conflictEdge[1]};
                return redundant;
            }
        }
    }
}