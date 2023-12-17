package com.company.백준.DFSBFS.순열사이클;

import java.util.*;

public class Main {


    /**
     *
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        /**
         *
         * 1~ N 까지 정수 N개로 이루어진 순열을 나타내는 방법
         * 3 2 7 8 1 4 5 6
         *
         *
         * */

        //DFS로 푼다.
        //방문이끝나게 되면 +1

        int testCnt = sc.nextInt();

        for (int j = 0; j < testCnt; j++) {
            int length = sc.nextInt();
            Map<Integer, Node> nodeMap = new HashMap<>();
            Set<Integer> visit = new HashSet<>();
            for (int i = 1; i <= length; i++) {

                Node from= nodeMap.getOrDefault(i, new Node(i));
                int i1 = sc.nextInt();
                Node to = nodeMap.getOrDefault(i1, new Node(i1));

                nodeMap.put(i, from);
                nodeMap.put(i1, to);

                from.next = to;
            }

            int res = 0;
            for (var entry : nodeMap.entrySet()) {

                if(!visit.contains(entry.getKey())){

                    res++;
                    DFS(entry.getValue(), visit);
                }

            }

            System.out.println(res);
        }


    }

    private void DFS(Node node, Set<Integer> visit) {

        if(node == null || visit.contains(node.num)) return;
        visit.add(node.num);

        Node next = node.next;

        DFS(next, visit);


    }

    class Node{

        int num;
        Node next;

        public Node(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}