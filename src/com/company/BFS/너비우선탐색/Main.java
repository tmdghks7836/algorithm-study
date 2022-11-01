package com.company.BFS.너비우선탐색;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class Main {

    Queue<Node> q = new ArrayDeque<>();

    public class Node {

        int value;
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

        q.offer(node);
        BFS();
        return "";
    }

    public void BFS() {

        int level = 1;
        while (!q.isEmpty()) {

            System.out.print("level " + level + ": ");

            int size = q.size();
            for (int i = 0; i < size; i++) {

                Node node = q.poll();
                System.out.print(node.value + " ");

                if (node.lt != null)
                    q.add(node.lt);
                if (node.rt != null)
                    q.add(node.rt);
            }

            System.out.println();
            level++;
        }


    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        T.solution();
    }
}
