package com.company.etc.동적계획법.최대부분증가수열;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        int[] arr = new int[n];
        int[] dy = new int[n];
        dy[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextInt();
        }

        for (int i = 1; i < arr.length; i++) {

            int result= 1;
            for (int j = i - 1; j >= 0; j--) {

                if (arr[j] < arr[i] && result <= dy[j]) {
                    result = dy[j] + 1;
                }
            }

            dy[i] = result;
        }


        OptionalInt max = Arrays.stream(dy).max();

        System.out.println(max.getAsInt());
    }
}
