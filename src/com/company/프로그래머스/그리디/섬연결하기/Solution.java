
package com.company.프로그래머스.그리디.섬연결하기;

import java.util.*;

class Solution {

    public static class Edge implements Comparable<Edge> {

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }

        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    public int solution(int n, int[][] costs) {

        int answer = 0;
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] cost : costs) {

            graph.get(cost[0]).add(new Edge(cost[1], cost[2]));
            graph.get(cost[1]).add(new Edge(cost[0], cost[2]));
        }

        Queue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(0, 0));
        boolean[] visit = new boolean[n];
        while (!queue.isEmpty()) {

            //0번째를 뽑아서
            Edge edge = queue.poll();
            if (visit[edge.vertex]) continue;
            visit[edge.vertex] = true;
            answer += edge.cost;

            List<Edge> edges = graph.get(edge.vertex);
            for (int i = 0; i < edges.size(); i++) {

                if(visit[edges.get(i).vertex]) continue;
                queue.add(edges.get(i));
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        System.out.println(T.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }

}
