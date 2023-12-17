package com.company.백준.DFSBFS;

import java.util.*;

public class Main {


    /**
     *
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        Map<Integer, Node> nodes = new HashMap<>();

        int nodeCnt = sc.nextInt();

        for (int i = 1; i <= nodeCnt; i++) {
            nodes.put(i, new Node(i));
        }

        int edgeCnt = sc.nextInt();
        int start = sc.nextInt();

        for (int i = 0; i < edgeCnt; i++) {

            int from = sc.nextInt();
            int to = sc.nextInt();

            Node fromNode = nodes.get(from);
            Node toNode = nodes.get(to);
            fromNode.addNode(toNode);
            toNode.addNode(fromNode);
        }

        Node node = nodes.get(start);
        Set<Integer> discovered = new HashSet<>();
        DFS(node, discovered);
        System.out.println();
        BFS(node);
    }

    private void BFS(Node node) {

        Queue<Node> queue = new ArrayDeque<>();

        Set<Integer> ch = new HashSet<>();

        queue.add(node);
        ch.add(node.v);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Node poll = queue.poll();

                System.out.print(poll.v + " ");

                for (Node node1 : poll.neighbor) {

                    if (ch.contains(node1.v)) continue;

                    ch.add(node1.v);
                    queue.add(node1);
                }

            }
        }

    }

    private void DFS(Node node, Set<Integer> discovered) {

        if (discovered.contains(node.v)) {
            return;
        }

        System.out.print(node.v + " ");
        discovered.add(node.v);

        for (Node node1 : node.neighbor) {

            DFS(node1, discovered);
        }
    }

    class Node implements Comparable<Node> {

        int v;

        List<Node> neighbor = new ArrayList<>();

        public Node(int v) {
            this.v = v;
        }

        void addNode(Node node){
            neighbor.add(node);
            Collections.sort(neighbor);
        }

        @Override
        public int compareTo(Node o) {
            return v - o.v;
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}