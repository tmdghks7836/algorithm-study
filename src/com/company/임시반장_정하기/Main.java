package com.company.임시반장_정하기;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {

    public Integer solution(Integer[][] arr) {


        int result = 0;
        int std = 0;
        for (int i = 0; i < arr.length; i++) {

            int cnt = 0;
            for (int j = 0; j < arr.length; j++) {

                for (int k = 0; k < 5; k++) {

                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }

            if(result < cnt){
                result = cnt;
                std = i;
            }
        }

        return std + 1;
    }



    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        Integer next = in.nextInt();

        Integer[][] arr = new Integer[next][5];

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < 5; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(T.solution(arr));
    }
}
