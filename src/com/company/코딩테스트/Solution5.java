package com.company.코딩테스트;

class Solution5 {

    /**
     * 순열 개수 구하기
     */
    int[] arr;
    boolean[] ch;
    int answer ;
    public int solution(int num) {

        String strNum = String.valueOf(num);
        answer = 0;

        char[] charArray = strNum.toCharArray();
        arr = new int[charArray.length];
        ch = new boolean[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            arr[i] = charArray[i] - 48;
        }

        DFS(0, 0);

        return answer;
    }

    private void DFS(int L, int num) {

        if(L == arr.length){
            answer++;
//            System.out.println(num);
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if(!ch[i]){
                ch[i] = true;
                DFS(L + 1, num * 10 + arr[i]);
                ch[i] = false;
            }

        }
    }


    public static void main(String[] args) {
        Solution5 T = new Solution5();
        System.out.println(T.solution(123));
    }
}