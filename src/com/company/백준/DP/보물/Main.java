package com.company.백준.DP.보물;

import java.util.*;

public class Main {


    public void solution() {

        Scanner sc = new Scanner(System.in);

        //길이가 N인 정수 배열 A와 B가
        //함수 S를 정의 S = A[0] × B[0] + ... + A[N-1] × B[N-1]
        //S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자.

        int num = sc.nextInt();

        int[] A = new int[num];
        int[] B = new int[num];
        boolean[] ch = new boolean[num];
        for (int j = 0; j < num; j++) {
            A[j] = sc.nextInt();
        }
        for (int j = 0; j < num; j++) {
            B[j] = sc.nextInt();
        }

        Arrays.sort(A);

        int Anum = 0;
        while (Anum < A.length) {

            int[] max = new int[2];
            for (int i = 0; i < B.length; i++) {

                if (!ch[max[0]] && B[i] > max[1] ) {
                    max[0] = i;
                    max[1] = Math.max(B[i], max[1]);
                }

            }
            int temp =A[Anum];
            A[Anum] = A[max[0]];
            A[max[0]] = temp;

            Anum++;
        }


    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}
