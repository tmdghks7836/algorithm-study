package com.company.백준.그리디.거스름돈;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int result = 0;

        Scanner in = new Scanner(System.in);

        int[] arr = {500, 100, 50, 10, 5, 1};
        int money = 1000 - in.nextInt(); // 1000 - 380 = 620


        for (int i = 0; i < arr.length; i++) {

            result += money / arr[i]; // 20 / 10 = 1 + 1 + 0 + 2
            money = money % arr[i]; // 0
        }

        System.out.println(result); //4
    }
}