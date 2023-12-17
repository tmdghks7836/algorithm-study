package com.company.백준.DFSBFS.연결요소의갯수;

import java.util.*;

public class Main {


    /**
     *
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        /**
         * 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램
         * N : 정점의 갯수
         * M : 간선의 갯수
         *
         * */

        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<Integer, Node> nodeMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {

            nodeMap.put(i, new Node(i));
        }

        for (int i = 0; i < M; i++) {

            Node from = nodeMap.get(sc.nextInt());
            Node to = nodeMap.get(sc.nextInt());

            from.neighbor.add(to);
            to.neighbor.add(from);
        }

        Set<Node> ch = new HashSet<>();

        int result = 0;
        for (Map.Entry<Integer, Node> entry : nodeMap.entrySet()) {

            Node node = entry.getValue();

            if(!ch.contains(node)){
                result++;
                DFS(node, ch);
            }
        }

        System.out.println(result);
    }

    private void DFS(Node node, Set<Node> ch) {

        if(node == null || ch.contains(node)) return;

        ch.add(node);

        for (Node neighbor : node.neighbor) {

            DFS(neighbor, ch);
        }

    }

    class Node {

        int num;

        List<Node> neighbor = new ArrayList<>();

        public Node(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}