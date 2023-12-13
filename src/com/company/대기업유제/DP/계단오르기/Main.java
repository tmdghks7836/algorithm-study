package com.company.대기업유제.DP.계단오르기;

import java.util.Scanner;

public class Main {


    /**
     * 계단 아래 시작부터 꼭대기 도착점까지 가는 게임
     * 계단마다 점수가 쓰여있다.
     * 계단은 한번에 하나 또는 두계단씩 오를 수 있다.
     * 연속된 세개의 계단을 모두 밟으면 안됨.
     * 시작점은 계단에 포함되지 않음.
     * 마지막 도착계단은 반드시 밟아야함
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        // 최댓값[i - 2] + 개별점수[i] vs (최댓값[i - 3] + 개별점수[i - 1] + 개별점수[i])

        int cnt = sc.nextInt();

        int[] space = new int[cnt + 1];

        int[] maxArr = new int[cnt + 1];

        for (int i = 1; i <= cnt; i++) {
            space[i] = sc.nextInt();
        }

        maxArr[1] = space[1];

        if (cnt > 1) {
            maxArr[2] = space[1] + space[2];
        }

        for (int i = 3; i <= cnt; i++) {

            maxArr[i] = Math.max(maxArr[i - 2], maxArr[i - 3] + space[i - 1]) + space[i];

        }

        System.out.println(maxArr[maxArr.length - 1]);
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}