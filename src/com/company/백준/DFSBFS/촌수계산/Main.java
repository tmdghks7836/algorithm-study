package com.company.백준.DFSBFS.촌수계산;

import java.util.*;

public class Main {

    int res = -1;

    /**
     *
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        /**
         *  부모 자식 사이를 1촌
         *  n: 사람의 수
         *
         * 둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다
         * 셋째 줄에는 부모 자식들 간의 관계의 개수 m
         * x: 부모
         * y: 자식
         *
         * 친척 관계 없을 경우 -1
         *
         *
         * */

        int cnt = sc.nextInt();

        int child = sc.nextInt();
        int parent = sc.nextInt();

        Map<Integer, Node> map = new HashMap<>();

        for (int i = 1; i <= cnt; i++) {

            map.put(i, new Node(i));
        }

        int connection = sc.nextInt();


        for (int i = 0; i < connection; i++) {

            Node from = map.get(sc.nextInt());
            Node to = map.get(sc.nextInt());

            from.add(to);
            to.add(from);
        }

        Set<Node> discovered = new HashSet<>();

        discovered.add(map.get(parent));
        DFS(discovered, map.get(parent), 0, map.get(child));
        System.out.println(res);
        ;
    }

    private void DFS(Set<Node> discovered, Node node, int chon, Node target) {

        if (node == target) {
            res = chon;
        }
        ;

        for (Node node1 : node.neighbor) {

            if (discovered.contains(node1)) continue;

            discovered.add(node1);

            DFS(discovered, node1, chon + 1, target);
        }

    }

    class Node {

        int num;

        Set<Node> neighbor = new HashSet<>();

        public Node(int num) {
            this.num = num;
        }

        public void add(Node node) {

            neighbor.add(node);
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}