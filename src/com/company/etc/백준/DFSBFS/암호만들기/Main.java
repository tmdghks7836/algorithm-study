package com.company.etc.백준.DFSBFS.암호만들기;


import java.util.*;

/**
 * 1. 먼저 알파벳 순서대로 정렬한다.
 * 2. 주어진 알파벳 - 만들 문자 길이 만큼 for문 돌며 DFS
 */
public class Main {

    static char[] chars;
    static char[] current;
    static int L;

    public static void DFS(int level, int index) {

        if (L == level) {
            int aeiouCnt = 0;
            int elseCnt = 0;
            for (char c : current) {
                if(c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u'){
                    aeiouCnt++;
                }else{
                    elseCnt++;
                }
            }

            if(!(aeiouCnt >= 1 && elseCnt >= 2)){
                return;
            }

            for (char c : current) {
                System.out.print(c);
            }
            System.out.println();
            return;
        } else {
            for (int i = index; i < chars.length; i++) {
                //다음 번째 순서
                current[level] = chars[i];
                DFS(level + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //만들 암호 갯수
        L = in.nextInt();

        //주어진 문자 갯수
        int C = in.nextInt();
        chars = new char[C];
        current = new char[L];
        for (int i = 0; i < C; i++) {
            chars[i] = in.next().charAt(0);
        }

        Arrays.sort(chars);

        DFS(0, 0);

    }
}

