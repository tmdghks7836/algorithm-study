package com.company.etc.프로그래머스.BFS.여행경로;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    String[][] tickets;
    boolean[] check;
    int max;
    public List<String[] > list = new ArrayList<>();
    String[] arr;

    public void DFS(String[] names, int L) {

        if (L >= max - 1) {

            arr[L] = names[1];
            list.add(arr.clone());
        }

        for (int i = 0; i < tickets.length; i++) {

            String s = tickets[i][0];
            if (!s.equals(names[1]) || check[i]) continue;

            check[i] = true;
            arr[L] = s;
            DFS(tickets[i], L + 1);
            check[i] = false;

        }
    }

    public String[] solution(String[][] tickets) {

        this.tickets = tickets;
        this.check = new boolean[tickets.length];
        max = tickets.length + 1;
        arr = new String[max];

        for (int i = 0; i < tickets.length; i++) {

            if (tickets[i][0].equals("ICN")) {
                check[i] = true;
                arr[0] = "ICN";
                DFS(tickets[i], 1);
                check[i] = false;
            }
        }

        String[] strings = list.get(0);
        for (int i = 1; i < list.size(); i++) {

            String[] strings2 = list.get(i);

            String s = Arrays.stream(strings).reduce((o1, o2) -> o1 + o2).get();
            String s2 = Arrays.stream(strings2).reduce((o1, o2) -> o1 + o2).get();

            if(s.compareTo(s2) > 0){
                strings = strings2;
            }
        }

        return strings;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] solution1 = solution.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        System.out.println(Arrays.toString(solution1));
    }
}