
package com.company.프로그래머스.완전탐색.소수찾기;

import java.util.HashSet;
import java.util.Set;

class Solution {

    char[] arr;
    boolean[] check;
    int result = 0;
    Set<Integer> set = new HashSet<>();

    public void DFS(String c){

        int number = Integer.parseInt(c);
        if(!set.contains(number) && isPrime(number)){
            result++;
            System.out.println(number);
            set.add(number);
        }

        for(int i = 0; i < arr.length; i++){

            if(!check[i]){
                check[i] = true;
                DFS(c + arr[i]);
                check[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {

        if(num <= 1){
            return false;
        }

        for (int i1 = 2; i1 < num; i1++) {

            if(num % i1 == 0){
                return false;
            }
        }

        return true;
    }

    public int solution(String numbers) {

        arr = numbers.toCharArray();
        check = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++){

            if(!check[i]){

                check[i] = true;
                DFS(String.valueOf(arr[i]));
                check[i] = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        System.out.println(T.solution("011"));
    }

}
