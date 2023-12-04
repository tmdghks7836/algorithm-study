package com.company.etc.프로그래머스.정렬.k번째수;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int[] solution(int[] array, int[][] commands) {

        int[] result = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];

            result[i] = extracted(array, command);
        }


        return result;
    }

    private int extracted(int[] array, int[] command) {
        List<Integer> list = new ArrayList<>();

        for (int i = command[0] - 1; i < command[1]; i++) {

            list.add(array[i]);
            list.sort(Comparator.comparingInt(o -> o));
        }

        return list.get(command[2] - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }
}