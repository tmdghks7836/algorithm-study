package com.company.대기업유제.DP.사탕가게;

import java.util.Scanner;

public class Main {


    /**
     * 같은 돈을 가지고 사탕을 산다.
     * 구매한 사탕의 칼로리가 더 큰사람이 내기에서 이김
     * 시스템 해킹 : 사탕가게에 있는 사탕의 가격과 칼로리가 모두 등재
     * 모든 사탕의 가격과 칼로리가 주어짐
     * 칼로리의 합이 가장 크게되는지 구하는 프로그램 작성.
     * n : 사탕종류수
     * m : 가지고 있는 돈의 양
     * n -> c : 각 사탕의 칼로리  항상 정수
     * n -> p : 각 사탕의 가격  항상 소수점 둘째자리
     * <p>
     * 입력의 마지막 줄에는 '0 0.00'
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        while(true){
            int value = sc.nextInt();
            int space = (int)Math.round(sc.nextDouble() * 100);

            if (value == 0 || space == 0) return;

            int[] dy = new int[space+1];
            for (int i = 0; i < value; i++) {
                int unitValue = sc.nextInt();
                int unitSpace = (int)Math.round(sc.nextDouble()*100); //7.00
                for (int j = unitSpace; j <= space; j++) {
                    dy[j] = Math.max(dy[j], dy[j -unitSpace] + unitValue);
                }
            }
            System.out.println(dy[space]);
        }

    }
    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}