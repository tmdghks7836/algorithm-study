package com.company.대기업유제.그래프;

import java.util.*;

class 최소환승경로 {
    public int solution(int[][] routes, int s, int e) {
        int answer = 0;


        /**
         * 지하철 노선 정보가 담긴 routes 배열  routes[i] 는 i호선 지하철 운행 노선 역번호
         * routes[i] =[1,2,7] 이면 i호선 지하철은 1->2->7->1->2->7 반복운행
         * s : 출발역 번호
         * e : 도착역 번호
         * 출발역에서 도착역까지 최소환승경로 횟수 반환
         * 갈수 없다면 -1 반환
         *• routes의 길이는 1부터 1,000
         * 역번호는 0번부터 1,000,000까지
         *
         * 가중치가 없으므로 동적 프로그래밍을 안해도 됨 그냥 BFS로 풀자.
         * 지하철의 순서가 뒤죽박죽임.
         * 지하철 하나의 라인을 강한 결합 요소로 생각하여 노드 하나로 뭉침.
         * */
        //코사라주 알고리즘을 만들기 위해 순환되는 역을 모두 노드형식으로 만든다.
        HashMap<Integer, Line> lineMap = new HashMap<>();
        HashMap<Integer, Set<Line>> stationMap = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            Line line = new Line(i);
            lineMap.putIfAbsent(i, line);
            for (int j = 0; j < routes[i].length; j++) {
                int station = routes[i][j];
                stationMap.putIfAbsent(station, new HashSet<>());
                stationMap.get(station).add(line); //역별 호선 리스트 추가
            }
        }

        //호선마다 이웃, 지하철 역 리스트 넣기
        for (int i = 0; i < routes.length; i++) {

            Line line = lineMap.get(i); //호선을 하나 꺼내서

            for (int j = 0; j < routes[i].length; j++) { //역 리스트를 돌린다.

                int station = routes[i][j];
                Set<Line> lines = stationMap.get(station); // 역 리스트의 호선 정보들을
                line.neighbor.addAll(lines);
                line.stations.add(routes[i][j]);
            }
        }

        //////////////////////////////////////////////////////////

        int min = Integer.MAX_VALUE;
        for (var entry : lineMap.entrySet()) {

            Line line = entry.getValue();
            //호선 안에 역이 존재하면 다익스트라 돌린다.
            if (line.stations.contains(s))
                min = Math.min(min, dijkstra(line, e));
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int dijkstra(Line start, int end) {

        Set<Line> ch = new HashSet<>();
        //해당 호선으로 부터 시작해서 방문

        Queue<Line> queue = new ArrayDeque<>();

        queue.add(start);
        ch.add(start);

        int level = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Line line = queue.poll();//라인을 꺼내서

                //다음 라인이 있다면 큐에 추가
                HashSet<Integer> stations = line.stations; //해당 호선의 역 리스트 중에 종착지가 있으면

                if (stations.contains(end)) return level;

                //종착지가 없으면 다음 이웃을 추가
                for (Line neighbor : line.neighbor) {

                    if (ch.contains(neighbor)) continue; //해당 호선에 방문했다면 넘어감
                    if (neighbor.num == line.num) continue;
                    ch.add(neighbor);
                    queue.add(neighbor);
                }
            }

            level++;
        }

        return -1;
    }


    class Line {

        public Line(int num) {
            this.num = num;
        }

        int num;
        HashSet<Integer> stations = new HashSet<>();

        HashSet<Line> neighbor = new HashSet<>();
    }

    public static void main(String[] args) {
        최소환승경로 T = new 최소환승경로();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12}, {5, 19}, {7, 19}, {9, 12, 13}, {9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5}, {9, 7, 10}, {7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}