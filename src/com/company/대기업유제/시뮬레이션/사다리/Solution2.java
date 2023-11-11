package com.company.대기업유제.시뮬레이션.사다리;

import java.util.Arrays;
/**
 *
 * 윗줄부터 사다리 가로를 만날때마다 왼쪽 오른쪽을 동시에 바꿔주면서 내려간다.
 * */
class Solution2 {

    public char[] solution(int n, int[][] ladder) {

        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (char) (i + 65);
        }
        for (int[] line : ladder) {
            for (int x : line) {
                char tmp = answer[x];
                answer[x] = answer[x - 1];
                answer[x - 1] = tmp;
            }
            System.out.println("");
        }
        return answer;
    }


    public static void main(String[] args) {
        Solution2 T = new Solution2();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
/**
 *
 *
 *
 *
 * answer
 * 5
 * [[1, 3], [2, 4], [1, 4]]
 * ['D', 'B', 'A', 'C', 'E']
 * 7
 * [[1, 3, 5], [1, 3, 6], [2, 4]]
 * ['A', 'C', 'B', 'F', 'D', 'G', 'E']
 * 8
 * [[1, 5], [2, 4, 7], [1, 5, 7], [2, 5, 7]]
 * ['C', 'A', 'B', 'F', 'D', 'E', 'H', 'G']
 * 12
 * [[1, 5, 8, 10], [2, 4, 7], [1, 5, 7, 9, 11], [2, 5, 7, 10], [3, 6, 8, 11]]
 * ['C', 'A', 'F', 'B', 'D', 'I', 'E', 'K', 'G', 'L', 'J', 'H']
 */