
package com.company.프로그래머스.다음큰숫자;

public class Solution {

    public int solution(int n) {

        int answer = 0;
        int base = 0;
        String s = Integer.toBinaryString(n);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '1'){
                base++;
            }
        }

        while(true){

            n +=1;

            String ns = Integer.toBinaryString(n);
            char[] nsChars = ns.toCharArray();
            int nsCnt = 0;
            for (int i = 0; i < nsChars.length; i++) {
                if(nsChars[i] == '1'){
                    nsCnt++;
                }
            }

            if(base == nsCnt){
                answer = n;
                break;
            }

        }

        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(15);
        System.out.println(solution1);
    }
}