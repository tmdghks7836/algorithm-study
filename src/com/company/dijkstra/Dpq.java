package com.company.dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dpq {

    int[] dist;
    int vertexCount;
    PriorityQueue<Edge> queue;

    public Dpq(int vertexCount) {
        queue = new PriorityQueue<>(vertexCount, Comparator.comparingInt(o -> o.weight));
        this.vertexCount = vertexCount;
        dist = new int[vertexCount];
    }

    public void dijkstra(List<List<Edge>> graph, int start) {

        for (int i = 0; i < dist.length; i++) {

            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {

            Edge poll = queue.poll();
            int current = poll.end;

            if (poll.weight < dist[current]) {
                continue;
            }

            graph.get(current).forEach(next -> {

                int totalWeight = dist[current] + next.weight;
                if (totalWeight < dist[next.end]) {
                    dist[next.end] = totalWeight;
                    queue.add(new Edge(next.end,totalWeight));
                }
            });
        }

    }

    public static void main(String[] args) {

        int vertexCount = 6;
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < vertexCount; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(1, 8));
        graph.get(0).add(new Edge(2, 1));
        graph.get(0).add(new Edge(3, 2));

        graph.get(2).add(new Edge(1, 5));
        graph.get(2).add(new Edge(3, 2));

        graph.get(3).add(new Edge(4, 3));
        graph.get(3).add(new Edge(5, 5));

        graph.get(4).add(new Edge(5, 1));

        graph.get(5).add(new Edge(0, 5));


        Dpq dpq = new Dpq(vertexCount);
        dpq.dijkstra(graph, 0);


        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println((char) (0 + 65) + " to " + (char) (i + 65) + " is "
                    + dpq.dist[i]);
    }
}
