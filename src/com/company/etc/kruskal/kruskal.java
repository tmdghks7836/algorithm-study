package com.company.etc.kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 크루스칼 알고리즘 : 최소 신장 트리
 */
public class kruskal {

    List<KruskalEdge> results = new ArrayList<>();
    Map<Character, Character> parentMap = new HashMap();
    Map<Character, Integer> rank = new HashMap();


    public void start(List<KruskalEdge> edges, char[] vertices) {

        //초기화
        init(vertices);

        edges.forEach(edge -> {

            if(findParent(edge.vertex) != findParent(edge.next)){

                union(edge.vertex, edge.next);
                results.add(edge);
            }
        });

        results.forEach(kruskalEdge -> System.out.println(kruskalEdge.vertex + " to "+ kruskalEdge.next + " = " + kruskalEdge.weight));
    }

    private void union(char parentVertex, char nextParentVertex) {

        char root1 = findParent(parentVertex);
        char root2 = findParent(nextParentVertex);

        if (rank.get(root1) > rank.get(root2)) {

            parentMap.put(root2, root1);
        } else {
            parentMap.put(root1, root2);
            if (rank.get(root1) == rank.get(root2)) {
                int newRank = parentMap.get(root1) + 1;
                rank.put(root1, newRank);
            }
        }
    }

    //path compression
    private char findParent(char vertex) {

        //만약 부모가 자신이 아니라면
        if (!parentMap.get(vertex).equals(vertex)) {
            char parent = findParent(parentMap.get(vertex));

            parentMap.put(vertex, parent);
        }

        return parentMap.get(vertex);
    }

    private void init(char[] vertices) {

        for (char vertex : vertices) {
            parentMap.put(vertex, vertex);
            rank.put(vertex, 0);
        }
    }

    public static void main(String[] args) {

        char[] vertices = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        ArrayList<KruskalEdge> edges = new ArrayList<>();
        edges.add(new KruskalEdge(7, 'A', 'B'));
        edges.add(new KruskalEdge(5, 'A', 'D'));
        edges.add(new KruskalEdge(7, 'B', 'A'));
        edges.add(new KruskalEdge(8, 'B', 'C'));
        edges.add(new KruskalEdge(9, 'B', 'D'));
        edges.add(new KruskalEdge(7, 'B', 'E'));
        edges.add(new KruskalEdge(8, 'C', 'B'));
        edges.add(new KruskalEdge(5, 'C', 'E'));
        edges.add(new KruskalEdge(5, 'D', 'A'));
        edges.add(new KruskalEdge(9, 'D', 'B'));
        edges.add(new KruskalEdge(7, 'D', 'E'));
        edges.add(new KruskalEdge(6, 'D', 'F'));
        edges.add(new KruskalEdge(7, 'E', 'B'));
        edges.add(new KruskalEdge(7, 'E', 'D'));
        edges.add(new KruskalEdge(8, 'E', 'F'));
        edges.add(new KruskalEdge(9, 'E', 'G'));
        edges.add(new KruskalEdge(6, 'F', 'D'));
        edges.add(new KruskalEdge(8, 'F', 'E'));
        edges.add(new KruskalEdge(11, 'F', 'G'));
        edges.add(new KruskalEdge(9, 'G', 'E'));
        edges.add(new KruskalEdge(11, 'G', 'F'));

        Collections.sort(edges);
        kruskal kruskal = new kruskal();
        kruskal.start(edges, vertices);
    }

}
