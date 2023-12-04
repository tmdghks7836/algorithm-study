package com.company.대기업유제.깊이우선탐색;

import java.util.*;

class IP주소 {

    /**
     * 숫자로 구성된 s 문자열로 유효한 IP주소 경우 찾기
     * 0이 앞에오는 두자리는 안된다.
     */
    char[] charArray;
    List<String> list;

    public String[] solution(String s) {
        String[] answer = {};

        //0이 앞에오는 두자리 빼고 .붙이기
        //255보다 큰 숫자면 안됨
        //.이 몇번쨰에 붙어있었는지 기억해야한다.
        charArray = s.toCharArray();
        list = new ArrayList<>();
        DFS(1, 0, String.valueOf(charArray[0]));

        return list.toArray(String[]::new);
    }

    private void DFS(int L, int dot, String str) {

        if (L > charArray.length - 1) {
             list.add(str);
            return;
        }

        if (dot < 3) {

            DFS(L + 1, dot + 1, str + '.' + charArray[L]);
        }

        String newStr = str + charArray[L];
        String[] split = newStr.split("\\.");
        String s = split[split.length - 1];

        if (s.toCharArray()[0] == '0' && s.length() >= 2) {
            return;
        }

        if (Integer.parseInt(s) > 255) {
            return;
        }

        DFS(L + 1, dot, str + charArray[L]);
    }

    public static void main(String[] args) {
        IP주소 T = new IP주소();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}