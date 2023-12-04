package com.company.etc.kruskal;

public class KruskalEdge implements Comparable<KruskalEdge>{

    int weight;
    char vertex;
    char next;

    public KruskalEdge(int weight, char vertex, char next) {
        this.weight = weight;
        this.vertex = vertex;
        this.next = next;
    }

    @Override
    public int compareTo(KruskalEdge o) {
        return this.weight - o.weight;
    }
}
