package com.company.프로그래머스.전화번호목록;


import java.util.Arrays;

public class Solution {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {

            if (phone_book[i].startsWith(phone_book[i - 1])) {
                return false;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        System.out.println(T.solution(new String[]{"97674223", "1195524421", "119", "1188"}));
    }
}