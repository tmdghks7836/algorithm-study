package com.company.대기업유제.그래프;

import java.util.*;

class 최소비행료 {
    public int solution(int n, int[][] flights, int s, int e, int k) {
        int answer = 0;

        /**
         * 0 ~ n-1번으로 되어있는 n개의 도시
         * 비행기로 목적지 도시까지
         * 각 비행기의 운항정보.  [1,2,5] 이면 1번에서 2번으로 이동하는데 비용이 5
         * 목적지 도시까지 직항이 없으면 환승
         * n = 도시의 개수 , flights = 각비행기의 운항정보, s = 현수가 사는 도시, e = 목적지, k = 최대 환승횟수
         * 갈 수 없으면 -1 반환
         *
         * */

        List<Node> nodes = createNodes(n, flights);

        // flights = 각비행기의 운항정보, s = 현수가 사는 도시, e = 목적지, k = 최대 환승횟수

        //첫번째 노드부터 큐에 삽입하여 DP 동작


        //최소 경로 누적값을 map에 저장
        Map<Node, Integer> bestPriceMap = new HashMap<>();
        PriorityQueue<Candidate> queue = new PriorityQueue<>();
        queue.add(new Candidate(nodes.get(s), 0));
        bestPriceMap.put(nodes.get(s), 0);

        int boardingCount = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Candidate poll = queue.poll();
                Node from = poll.node;

                if(from.num == e) {
                    return poll.price;
                }
                if (boardingCount > k){
                    return -1;
                }

                for (var entry : from.nexts.entrySet()) {

                    Node to = entry.getKey();
                    Integer dist = entry.getValue();
                    Integer bestPrice = bestPriceMap.getOrDefault(to, Integer.MAX_VALUE);

                    if(boardingCount == k && to.num != e) continue;

                    int min = Math.min(bestPrice, bestPriceMap.get(from) + dist);
                    bestPriceMap.put(to, min);
                    queue.add(new Candidate(to, min));
                }
            }

            boardingCount++;
        }

        return -1;
    }

    private List<Node> createNodes(int n, int[][] flights) {


        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            nodes.add(new Node(i));
        }

        for (int[] flight : flights) {

            Node from = nodes.get(flight[0]);
            Node to = nodes.get(flight[1]);
            int price = flight[2];

            from.addNode(to, price);

        }

        return nodes;
    }

    class Node {

        public Node(int num) {
            this.num = num;
        }

        final int num;

        public HashMap<Node, Integer> nexts = new HashMap<>();

        public void addNode(Node node, int price) {

            nexts.put(node, price);
        }

    }

    class Candidate implements Comparable<Candidate>{

        private Node node;

        private int price;

        public Candidate(Node node, int price) {
            this.node = node;
            this.price = price;
        }

        @Override
        public int compareTo(Candidate o) {
            return this.price - o.price;
        }
    }

    public static void main(String[] args) {
        최소비행료 T = new 최소비행료();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59}, {2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}