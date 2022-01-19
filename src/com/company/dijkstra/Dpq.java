package com.company.dijkstra;

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
}
