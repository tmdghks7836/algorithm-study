package com.company.백준.greedy.대회or인턴;

import java.util.Scanner;

public class Main {


    public void solution() {

        Scanner sc = new Scanner(System.in);

        //때 2명의 여학생과 1명의 남학생이
        // 올해에도 N명의 여학생과 M명의 남학생이 팀원을 찾고 있다
        //학생들 중 K명은 반드시 인턴쉽 프로그램에 참여
        //인턴쉽에 참여하는 학생은 대회에 참여하지 못한다.
        //첫째 줄에 N, M, K가 순서대로 주어진다. (0 ≤ M ≤ 100, 0 ≤ N ≤ 100, 0 ≤ K ≤ M+N),

        //남 여 비율을 1:2로 만들면서 k만큼 인원을 채운다.

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        // N 2배 : M

        int value = 0;
        while (N >= 2 && M >= 1 && (N + M -3) >= K) {
            //남자 뺴기      여자 빼기  ,
            N -= 2;
            M -= 1;
            value++;
        }

        System.out.println(value);

    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}