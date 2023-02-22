package com.company.프로그래머스.etc.무인도여행;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    boolean[][] check;
    int[][] map;
    int totStay;
    int[] xDir = {-1, 0, 1, 0};
    int[] yDir = {0, -1, 0, 1};

    public void DFS(int y, int x) {

        check[y][x] = true;
        totStay += map[y][x];

        for (int i = 0; i < 4; i++) {

            int newX = x + xDir[i];
            int newY = y + yDir[i];

            if (newX >= 0 && newY >= 0 && newX < map[0].length && newY < map.length)
                if (map[newY][newX] != -1 && !check[newY][newX]) {
                    DFS(newY, newX);
                }
        }
    }

    public int[] solution(String[] mapsStr) {

        map = new int[mapsStr.length][mapsStr[0].length()];
        check = new boolean[mapsStr.length][mapsStr[0].length()];

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < mapsStr.length; i++) {

            char[] chars = mapsStr[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {

                if (chars[j] == 'X') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = Integer.parseInt(String.valueOf(chars[j]));
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                totStay = 0;
                if (map[i][j] != -1 && !check[i][j]) {
                    DFS(i, j);
                }
                if (totStay > 0) {
                    answer.add(totStay);
                }
            }
        }

        if (answer.size() == 0) {
            return new int[]{-1};
        }

        return answer.stream().sorted().
                mapToInt(value -> value.intValue())
                .toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] solution1 = solution.solution(new String[]{"XXX","XXX","XXX"});

        for (int i : solution1) {
            System.out.println(i);
        }
    }
}