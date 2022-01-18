package com.company.dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dpq예제 {

    private int dist[];
    private boolean[] visited;
    private PriorityQueue<Edge예제> pq;
    private int V; //Number of vertices
    List<List<Edge예제>> adj;

    public Dpq예제(int v) {
        V = v;
        dist = new int[v];
        visited = new boolean[v];
        pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.weight));
    }

    public void dijkstra(List<List<Edge예제>> adj, int src) {
        this.adj = adj;

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        pq.add(new Edge예제(src, 0));

        dist[src] = 0;

        while (!pq.isEmpty()) {

            int current = pq.remove().end;

            visited[current] = true;

            adj.get(current).forEach(next -> {

                if (!visited[next.end]) {
                    if (dist[current] + next.weight < dist[next.end]) {
                        dist[next.end] = dist[current] + next.weight;
                        pq.add(new Edge예제(next.end, dist[next.end]));
                    }
                }
            });
        }
    }

    // Driver code
    public static void main(String arg[]) {
        int V = 6;
        int source = 0;

        List<List<Edge예제>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            List<Edge예제> item = new ArrayList<Edge예제>();
            adj.add(item);
        }

        // Inputs for the DPQ graph
        adj.get(0).add(new Edge예제(1, 8));
        adj.get(0).add(new Edge예제(2, 1));
        adj.get(0).add(new Edge예제(3, 2));

        adj.get(2).add(new Edge예제(1, 5));
        adj.get(2).add(new Edge예제(3, 2));

        adj.get(3).add(new Edge예제(4, 3));
        adj.get(3).add(new Edge예제(5, 5));

        adj.get(4).add(new Edge예제(5, 1));

        adj.get(5).add(new Edge예제(0, 5));

        // Calculate the single source shortest path
        Dpq예제 dpq2321 = new Dpq예제(V);
        dpq2321.dijkstra(adj, source);

        // Print the shortest path to all the edges
        // from the source edge
        System.out.println("The shorted path from edge :");
        for (int i = 0; i < dpq2321.dist.length; i++)
            System.out.println((char) (source + 65) + " to " + (char) (i + 65) + " is "
                    + dpq2321.dist[i]);
    }
}
