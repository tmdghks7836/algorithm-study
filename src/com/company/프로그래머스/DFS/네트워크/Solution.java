package com.company.프로그래머스.DFS.네트워크;


public class Solution {

    boolean[] check;
    int[][] computers;
    int cnt = 0;
    int n;

    public void DFS(int i) {

        for (int j = 0; j < n; j++) {

            if (!check[j] && computers[i][j] == 1) {
                check[j] = true;
                DFS(j);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.n = n;
        check = new boolean[computers.length];

        for (int i = 0; i < n; i++) {
            if (!check[i] && computers[i][i] == 1) {
                cnt++;
                DFS(i);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        System.out.println(T.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}