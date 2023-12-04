package com.company.대기업유제.깊이우선탐색;


import java.util.ArrayList;
import java.util.List;

/**
 * 암호화 코드 만들기
 * <p>
 * A = 1 B = 2 .... Z = 26 으로 해서 번호로 보내기
 * 숫자의 해독 경우의 수를 반환
 */

class 알파코드 {

    int answer;
    char max = 'A' + 26;
    int[] arr;
    String s;
    int n;

    public int solution(String s) {
        this.s = s;

        answer = 0;
        arr = new int[s.length()];
        n = arr.length;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            arr[i] = charArray[i] - 48;
        }
        //문자가 여러 경우로 조합이 가능하다.
        DFS(0, "");
        //System.out.println();
        return answer;
    }

    private void DFS(int L, String str) {

        //끝까지 왔으면 리턴
        if (L >= n) {
            answer++;
//            System.out.println(str);
            return;
        }

        int next = L + 1;

        boolean isNotOver = next <= n - 1 && arr[L] % 10 * 10 + arr[next] <= 26;

        if (arr[L] == 0) return;

        //뒤에 숫자를 붙일 수 있다면
        if (L + 1 <= n - 1 && (arr[next] == 0 && isNotOver) || isNotOver) {
            DFS(L + 2, str + " " + arr[L] + arr[next] + " ");
        }
        //뒤에 숫자를 붙일 수 없으면 그냥 호출
        DFS(L + 1, str + " " + arr[L] + " ");
    }

    public static void main(String[] args) {
        알파코드 T = new 알파코드();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}