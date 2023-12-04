package com.company.etc.BFS.말단노드까지가장짧은경로;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class Main {

    Queue<Node> q = new ArrayDeque<>();

    Node min;
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


        node.lt = node2;
        node.rt = node3;

        node2.lt = node4;
        node2.rt = node5;
        min = null;
        q.offer(node);

        return  BFS();
    }

    public Integer BFS() {

        int level = 0;
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

                if(node.lt == null && node.rt == null){

                   return level;
                }
            }

            System.out.println();
            level++;
        }

        return 0;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        System.out.println(T.solution());
    }
}
