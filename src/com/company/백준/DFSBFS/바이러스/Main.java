package com.company.백준.DFSBFS.바이러스;

import java.util.*;

public class Main {


    /**
     * 한 컴퓨터가 바이러스 걸리면 네트워크에 연결된 모든 컴퓨터는 바이러스 걸림
     *
     */
    int res = 0;
    public void solution() {

        Scanner sc = new Scanner(System.in);

        int nodeCnt = sc.nextInt();
        int networkCnt = sc.nextInt();

        Map<Integer, Node> nodeMap = new HashMap<>();

        for (int i = 1; i <= nodeCnt; i++) {

            nodeMap.putIfAbsent(i, new Node(i));
        }

        for (int i = 0; i < networkCnt; i++) {

            Node from = nodeMap.get(sc.nextInt());
            Node to = nodeMap.get(sc.nextInt());

            from.add(to);
            to.add(from);
        }


        Node node = nodeMap.get(1);

        Set<Node> discovered = new HashSet<>();
        discovered.add(node);
        DFS(node, discovered);

        System.out.println(res);

    }

    private void DFS(Node node, Set<Node> discovered) {

        for (Node node1 : node.nodes) {

            if(discovered.contains(node1)) continue;
            res++;
            discovered.add(node1);

            DFS(node1, discovered);


        }


    }

    class Node{

        int num;
        LinkedList<Node> nodes = new LinkedList<>();

        public void add(Node node){

            nodes.add(node);
        }

        public Node(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}