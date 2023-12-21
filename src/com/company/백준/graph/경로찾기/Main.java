package com.company.백준.graph.경로찾기;

import java.util.*;

public class Main {

    public void solution() {

        Scanner sc = new Scanner(System.in);

        /**
         *가중치 없는 방향 그래프 G가 주어졌을 때,
         * 모든 정점 (i, j)에 대해서, i에서 j로 가는 길이가 양수인 경로가 있는지 없는지 구하는 프로그램을 작성하시오.
         *
         * */

        int N = sc.nextInt();

        Map<Integer, Node> nodes = new HashMap<>();
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {

            nodes.putIfAbsent(i, new Node(i));
            for (int j = 0; j < N; j++) {

                nodes.putIfAbsent(j, new Node(j));
                int k = sc.nextInt();
                if (k == 1) {

                    Node from = nodes.get(i);
                    Node to = nodes.get(j);

                    from.neighbor.add(to);
                }
            }
        }

        for (Map.Entry<Integer, Node> entry : nodes.entrySet()) {

            Set<Integer> discovered = new HashSet<>();

            DFS(entry.getValue(), entry.getValue(), discovered);
        }

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {

                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }

    int[][] arr;

    private void DFS(Node start, Node node, Set<Integer> discovered) {

        for (Node neighbor : node.neighbor) {

            if(discovered.contains(neighbor.num)) continue;

            discovered.add(neighbor.num);
            arr[start.num][neighbor.num] = 1;
            DFS(start, neighbor, discovered);
        }
    }

    class Node implements Comparable<Node>{
        int num;

        Queue<Node> neighbor = new PriorityQueue<>();

        public Node(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return this.num - o.num;
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}
