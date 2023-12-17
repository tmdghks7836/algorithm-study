package com.company.백준.사다리조작;

import java.util.Scanner;

public class Main {


    /**
     *
     * N개의 세로선 M 개의 가로선 인접한 세로선 사이에는 가로선을 놓을 수 있다.
     * 각각 세로선마다 가로선을 놓을 수 있는 위치의 개수는 H이고 모든 세로선이 같은 위치를 갖는다.
     * N : 세로선
     * M : 가로선
     * H : 가로선을 놓을 수 있는 위치 개수
     * a : 1 <= a <= 가로선을 놓을 수 있는 위치개수
     * b : 1 <= b <= 세로선 -1
     * 가장 위에있는 점선 번호는 1 아래로 내려갈때마다 1증가
     * 세로선은 가장 왼쪽에 있는것이 1 오른쪽갈때마다 1증가
     *
     *
     * N의 가로선이 짝수인지 확인
     * 짝수이면 넘어감.
     * 홀수이면 N +1 의 가로선과 서로 겹치지 않게 만들어야함
     * 1. N의 가로선은 오른쪽 왼쪽 세로선의 가로선에 겹치지 않게 해야한다.
     * 2. N의 가로선이 2일 경우
     *
     * 열렸냐 -> 닫아야함
     * 오른ㅉ
     *
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