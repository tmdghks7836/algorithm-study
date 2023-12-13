package com.company.대기업유제.DP.사탕가게;

import java.util.Scanner;

public class MainBak {


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
            int candyNum = sc.nextInt();
            int money = (int)Math.round(sc.nextDouble() * 100);

            Candy[] candies = new Candy[candyNum];

            if (candies.length == 0 || money == 0) return;

            go(candyNum, sc, candies, money);
        }

    }

    private void go(int candyNum, Scanner sc, Candy[] candies, int money) {
        for (int i = 0; i < candyNum; i++) {

            int cal = sc.nextInt();
            int space =  (int)Math.round(sc.nextDouble() * 100);

            Candy candy = new Candy(cal, space);

            candies[i] = candy;
        }

        int[][] cache = new int[candyNum][money + 1];

        for (int i = 1; i < cache[0].length; i++) { //첫번째 행 계산

            Candy firstCandy = candies[0];

            if (i < firstCandy.space) { //현재공간보다 작으면 넘어가기
                continue;
            }

            cache[0][i] = firstCandy.cal * (i / firstCandy.space);
        }

        //두번째 행부터 이전 행을 체크하며 계산
        for (int i = 1; i < candies.length; i++) { //첫번째 행 계산

            Candy candy = candies[i];

            for (int j = 1; j < cache[0].length; j++) { //두번째 캔디부터 넣기

                if (j < candy.space) { //현재공간보다 작으면
                    cache[i][j] = cache[i - 1][j]; //이전값의 최대값
                    continue;
                }

                //j가 현재공간 이상이면
                //현재 최대값 + 이전 행,남은 열의 최댓값 vs 이전 행의 최댓값
                int choice1 = candy.cal * (j / candy.space) + cache[i - 1][j - candy.space];
                int choice2 = cache[i - 1][j];

                int max = Math.max(choice1, choice2);

                cache[i][j] = max;
            }
        }

        System.out.println(cache[candies.length - 1][cache[0].length - 1]);
    }

    class Candy {
        public Candy(int cal, int space) {
            this.cal = cal;
            this.space = space;
        }

        int cal;
        int space;
    }


    public static void main(String[] args) {

        MainBak T = new MainBak();
        T.solution();
    }
}