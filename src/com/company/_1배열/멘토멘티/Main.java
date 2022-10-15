package com.company._1배열.멘토멘티;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

    public Integer solution(Integer[][] arr) {


        int result = 0;


        for (int k = 0; k < arr[0].length; k++) {

            int std = arr[0][k]; //3

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {

                boolean isBetterRate = false;

                for (int j = 0; j < arr[i].length; j++) {

                    if (isBetterRate) {
                        int lowStdNum = arr[i][j];
                        int count = map.containsKey(lowStdNum) ? map.get(lowStdNum) + 1 : 1;
                        map.put(lowStdNum, count);
                    }

                    if (std == arr[i][j]) {
                        isBetterRate = true;
                    }

                }
            }

            for (Integer key : map.keySet()) {
                if (map.get(key) == arr.length) {
                    result += 1;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        Integer x = in.nextInt();
        Integer y = in.nextInt();

        Integer[][] arr = new Integer[y][x];

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(T.solution(arr));
    }
}
