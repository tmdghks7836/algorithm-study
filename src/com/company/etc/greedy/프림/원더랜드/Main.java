package com.company.etc.greedy.프림.원더랜드;

import java.util.*;

/**
 *
 */
public class Main {

    static List<List<Edge>> graph = new ArrayList<>();
    static boolean[] ch;
    static Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));


    public static class Edge {

        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
    }

    public static void solution() {

        queue.add(new Edge(1, 0));
        ch[1] = true;
        int answer = 0;
        while (!queue.isEmpty()) {

            Edge edge = queue.poll();

            if (!ch[edge.vex]) {
                answer += edge.cost;
                System.out.println(edge.vex + " " + edge.cost);
            }

            ch[edge.vex] = true;

            List<Edge> edges = graph.get(edge.vex);

            for (Edge edge1 : edges) {
                if (ch[edge1.vex] == false) {
                    queue.offer(edge1);
                }
            }

        }
        System.out.println(answer);
    }

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        ch = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            ch[i] = false;
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {

            int a = kb.nextInt();
            int b = kb.nextInt();
            int value = kb.nextInt();

            graph.get(a).add(new Edge(b, value));
            graph.get(b).add(new Edge(a, value));
        }

        solution();
    }
}
