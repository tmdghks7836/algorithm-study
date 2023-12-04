package com.company.etc.BFS.그래프최단거리;

import java.util.*;

//6 9
//1 3
//1 4
//3 4
//4 5
//4 6
//2 1
//2 5
//6 2
//6 5
public class Main {

    static int n, m = 0;
    static Queue<Node> queue = new LinkedList<>();
    static List<Node> totList = new ArrayList<>();

    public static class Node {

        boolean checked;
        int value;
        List<Node> list = new ArrayList<>();

        public Node(int value) {
            this.value = value;
        }
    }

    public void BFS() {

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Node root = queue.poll();

                for (Node child : root.list) {

                    if (!child.checked) {

                        child.checked = true;
                        queue.add(child);

                        System.out.println(child.value + " : " + level);
                    }
                }
            }

            level++;

        }

    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        for (int i = 0; i < m; i++) {

            int a = in.nextInt();
            int b = in.nextInt();

            Optional<Node> nodeA = find(a);
            Optional<Node> nodeB = find(b);

            Node an;
            Node bn;
            if (nodeA.isEmpty()) {
                an = new Node(a);
                totList.add(an);
            } else {
                an = nodeA.get();
            }

            if (nodeB.isEmpty()) {
                bn = new Node(b);
                totList.add(bn);
            } else {
                bn = nodeB.get();
            }

            an.list.add(bn);
        }

        Node node = find(1).get();
        node.checked = true;
        queue.add(node);
        T.BFS();
    }

    public static Optional<Node> find(int value) {

        return totList.stream().filter(node -> node.value == value)
                .findFirst();
    }

}
