package com.company.동적계획법.돌다리건너기;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        int[] arr = new int[n + 1];

        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < arr.length; i++) {

            arr[i] = arr[i - 2] + arr[i - 1];
        }

        System.out.println(arr[n]);
    }
}
