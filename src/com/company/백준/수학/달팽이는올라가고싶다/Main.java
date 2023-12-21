package com.company.백준.수학.달팽이는올라가고싶다;

import java.util.Scanner;

public class Main {


    /**
     *달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다
     *  정상에 올라간 후에는 미끄러지지 않는다.
     *  달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        int X = (V - A) / (A-B); // 5 / 4
        int Y = (V - A) % (A-B); // 5  4

        System.out.println(Y == 0 ? X + 1 : X + 2);

    }
    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}