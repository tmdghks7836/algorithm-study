package com.company.etc._5재귀.깊이우선탐색;

import java.util.Scanner;


public class Main {

    public class Node {

        int value;
        boolean isVisited = false;
        Node lt, rt;

        public Node(int value) {
            this.value = value;
        }
    }

    public Object solution() {

        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node.lt = node2;
        node.rt = node3;

        node2.lt = node4;
        node2.rt = node5;

        node3.lt = node6;
        node3.rt = node7;

        DFS(node);

        return "";
    }

    public void DFS(Node target) {

        if (target == null) return;
        DFS(target.lt);
        System.out.println(target.value);
        DFS(target.rt);
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        T.solution();
    }
}
