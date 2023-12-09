package com.company.POCU.그래프.다익스트라;

import java.util.*;

class Solution {

    public static void main(String[] args) {

        HashMap<String, Node> nodes = createNodes();

        HashMap<String, String> prevs = new HashMap<>();

        HashMap<String, Integer> minDists = Dijkstra.run(nodes, "Home", prevs);

        int schoolDist = minDists.get("School");
        System.out.println(schoolDist);

        int bankDist = minDists.get("Bank");
        System.out.println(bankDist);

        int libDists = minDists.get("Library");
        System.out.println(libDists);

        LinkedList<String> path = new LinkedList<>();

        String name = "School";
        while (name != null) {
            path.addFirst(name);
            name = prevs.get(name);
        }

        String pathString = String.join(" -> ",
                path);

        System.out.println(pathString);
    }

    private static HashMap<String, Node> createNodes() {
        Node home = new Node("Home");
        Node policeStation = new Node("Police Station");
        Node school = new Node("School");
        Node park = new Node("Park");
        Node bank = new Node("Bank");
        Node library = new Node("Library");

        home.addRoad(policeStation, 2);
        policeStation.addRoad(home, 2);

        home.addRoad(park, 3);
        park.addRoad(home, 3);

        policeStation.addRoad(bank, 1);
        bank.addRoad(policeStation, 1);

        policeStation.addRoad(school, 6);
        school.addRoad(policeStation, 6);

        bank.addRoad(library, 2);
        library.addRoad(bank, 2);

        bank.addRoad(park, 2);
        park.addRoad(bank, 2);

        school.addRoad(library, 1);
        library.addRoad(school, 1);

        HashMap<String, Node> nodes = new HashMap<>();

        nodes.put(home.getName(), home);
        nodes.put(policeStation.getName(), policeStation);
        nodes.put(school.getName(), school);
        nodes.put(park.getName(), park);
        nodes.put(bank.getName(), bank);
        nodes.put(library.getName(), library);

        return nodes;
    }
}

class Node {
    private final String name;
    private final HashMap<Node, Integer> roads = new HashMap<>(); //현재노드에서 이웃 노드까지의 거리

    Node(String name) {
        this.name = name;
    }

    public Map<Node, Integer> getRoads() {
        return this.roads;
    }

    public void addRoad(final Node to, final int dist) {
        this.roads.put(to, dist);
    }

    public int getDistance(final Node to) {
        return this.roads.get(to);
    }

    public String getName() {
        return name;
    }
}

class Dijkstra {

    public static HashMap<String, Integer> run(final HashMap<String, Node> nodes, final String from, final HashMap<String, String> prevs) {
        HashMap<String, Integer> minDists = new HashMap<>();

        final int INF = Integer.MAX_VALUE;
        for (var entry : nodes.entrySet()) {
            String name = entry.getKey();

            minDists.put(name, INF);
        }

        minDists.put(from, 0);
        prevs.put(from, null);

        PriorityQueue<Candidate> open = new PriorityQueue<Candidate>(); //최단경로일 가능성이 있는 경로들

        Node s = nodes.get(from);
        Candidate candidate = new Candidate(s, 0);

        open.add(candidate);

        while (!open.isEmpty()) {
            candidate = open.poll();

            Node n = candidate.getNode();
            String nodeName = n.getName();

            int fromMinDist = minDists.get(nodeName);
            int dist = candidate.getDistance(); //

            if (fromMinDist < dist) {
                continue;
            }

            Map<Node, Integer> roads = n.getRoads();

            //이웃을 방문
            for (var entry : roads.entrySet()) {
                Node next = entry.getKey();
                Integer weight = entry.getValue(); //인접노드까지의 거리 가중치
                int newDist = fromMinDist + weight; //현재 가중치 + 인접노드까지의 거리 가중치

                String nextName = next.getName();
                Integer originMinDist = minDists.get(nextName);

                if (newDist >= originMinDist) continue;

                minDists.put(nextName, newDist);
                prevs.put(nextName, nodeName); //선행노드

                Candidate newCandidate = new Candidate(next, newDist);
                open.add(newCandidate);

            }
        }
        return minDists;
    }
}

class Candidate implements Comparable<Candidate>{

    private Node node;
    private int distance;

    public Candidate(Node node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public Node getNode() {
        return node;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Candidate o) {
        return this.distance - o.distance;
    }
}






















