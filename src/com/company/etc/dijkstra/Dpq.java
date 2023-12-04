package com.company.etc.dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dpq {

    //결과값
    Map<Character, Integer> resultMap = new HashMap<>();
    PriorityQueue<Edge> priorityQueue;

    public Dpq() {

    }

    public void dijkstra(Map<Character, List<Edge>> edgeMap, char startNode) {


        priorityQueue = new PriorityQueue<Edge>(edgeMap.size(), Comparator.comparingInt(o -> o.weight));
        edgeMap.forEach((character, edges) ->
        {
            resultMap.put(character, Integer.MAX_VALUE);
        });

        resultMap.put(startNode, 0);
        priorityQueue.add(new Edge(startNode, 0));

        while (!priorityQueue.isEmpty()) {

            //현재 간선의 정보를 가져옵니다.
            Edge current = priorityQueue.poll();
            Integer currentMinWeight = resultMap.get(current.node);

            if(currentMinWeight < current.weight){
                continue;
            }

            for (Edge edge : edgeMap.get(current.node)) {
                int totalDistance = currentMinWeight + edge.weight;
                if (totalDistance < resultMap.get(edge.node)) {

                    resultMap.put(edge.node, totalDistance);
                    priorityQueue.add(edge);
                }
            }
        }

        resultMap.forEach((character, integer) -> System.out.println(startNode + " to " + character + " = " + integer));
    }

    public static void main(String[] args) {

        Map<Character, List<Edge>> edgeMap = new HashMap<>();

        char[] vertex_list = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};

        for (char c : vertex_list) {
            edgeMap.put(c, new ArrayList<>());
        }

        edgeMap.get('A').add(new Edge('B', 8));
        edgeMap.get('A').add(new Edge('C', 1));
        edgeMap.get('A').add(new Edge('D', 2));

        edgeMap.get('C').add(new Edge('B', 5));
        edgeMap.get('C').add(new Edge('D', 2));

        edgeMap.get('D').add(new Edge('E', 3));
        edgeMap.get('D').add(new Edge('F', 5));

        edgeMap.get('E').add(new Edge('F', 1));

        edgeMap.get('F').add(new Edge('A', 5));

        Dpq dpq = new Dpq();
        dpq.dijkstra(edgeMap, 'A');
    }
}
