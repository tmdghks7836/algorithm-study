package com.company.백준.DFSBFS.숫자고르기;

import java.util.*;

public class Main {

    public void solution() {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Map<Integer, Node> nodes = new HashMap<>();

        for (int i = 1; i <= N; i++) {

            create(nodes, i);
            int j = sc.nextInt();
            create(nodes, j);

            Node from = nodes.get(i);
            Node to = nodes.get(j);

            from.next = to;
        }

        TreeSet<Integer> treeset = new TreeSet<>();

        for (Map.Entry<Integer, Node> entry : nodes.entrySet()) {

            Node start = entry.getValue();
            List<Integer> list = DFS(start, start.next, new ArrayList<>(), new HashSet<>());

            treeset.addAll(list);
        }

        int size = treeset.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {

            System.out.println(treeset.pollFirst());
        }
    }

    private List<Integer> DFS(Node start, Node node, List<Integer> list, Set<Integer> discovered) {

        if (node == null) return Collections.emptyList();
        if(discovered.contains(node.num)) return Collections.emptyList();

        discovered.add(node.num);
        list.add(node.num);
        if (start.num == node.num) return list;

        return DFS(start, node.next, list, discovered);
    }

    private void create(Map<Integer, Node> nodes, int j) {
        if (!nodes.containsKey(j)) {
            nodes.put(j, new Node(j));
        }
    }

    class Node {

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