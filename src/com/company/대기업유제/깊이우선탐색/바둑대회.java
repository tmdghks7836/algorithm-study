package com.company.대기업유제.깊이우선탐색;

/**
 * 팀전 바둑대회
 * N(짝수)명 출전  흰돌/검은돌  반반
 * 한 선수는 검은돌 흰돌중 하나만 선택가능
 * 검읜돌 흰돌 능력 주어지면 최상의 선택
 * 흰돌팀 검은돌 팀의 능력차가 비슷하게 하는게 최상
 * 검은돌 흰돌 팀 능력차의 최소값 반환
 */
class 바둑대회 {

    boolean[] ch;
    int[][] cans;

    int answer;
    int whiteCnt;

    public int solution(int[][] cans) {
        answer = Integer.MAX_VALUE;
        this.cans = cans;
        whiteCnt = 0;
        ch = new boolean[cans.length];

        DFS(0, 0);

        return answer;
    }

    private void DFS(int L, int s) {

        if(L == cans.length/2){

            int A = 0;
            int B = 0;
            for (int i = 0; i < ch.length; i++) {
                if(ch[i]) A += cans[i][0];
                else B += cans[i][1];
            }
            answer = Math.min(answer, Math.abs(A -B) );
        }else{
            for (int i = s; i < cans.length; i++) {

                if(!ch[i]){
                    ch[i] = true;
                    DFS(L+1, i + 1);
                    ch[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        바둑대회 T = new 바둑대회();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33}, {25, 32}, {37, 59}, {33, 47}}));
    }
}
