package day8;

//프로그래머스 > 2022 KAKAO BLIND RECRUITMENT > 양궁대회(Lv.2)
public class ArcheryCompetition {
    static int[] answer = {-1};
    static int[] ryan;
    static int max;

    /**
     * 완전탐색 부분
     */
    public static void makeRyan(int index, int[] apeach, int arrows){
        if(index == arrows+1){
            int apeachScore = 0;
            int ryanScore = 0;
            for(int i = 0; i <= 10; i++){
                if(ryan[i] != 0 || apeach[i] != 0){
                    if(ryan[i] > apeach[i]){
                        ryanScore += 10 - i;
                    } else {
                        apeachScore += 10 - i;
                    }
                }
            }
            if(ryanScore > apeachScore){
                if(ryanScore-apeachScore >= max){
                    answer = ryan.clone();
                    max = ryanScore - apeachScore;
                }
            }
            return;
        }
        for(int i = 0; i <= 10 && ryan[i] <= apeach[i]; i++){
            ryan[i]++;
            makeRyan(index+1, apeach, arrows);
            ryan[i]--;
        }
    }

    public static int[] solution(int n, int[] info){
        ryan = new int[11];
        makeRyan(1, info, n);
        return answer;
    }

    public static void main(String[] args) {
        ex1();
//        ex2();
//        ex3();
//        ex4();
    }

    public static void ex1(){
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        int[] answer = solution(n ,info);
        for (int i : answer) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void ex2(){
        int n = 1;
        int[] info = {1,0,0,0,0,0,0,0,0,0,0};
        int[] answer = solution(n, info);
        for (int i : answer) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void ex3(){
        int n = 9;
        int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
        int[] answer = solution(n, info);
        for (int i : answer) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void ex4(){
        int n = 10;
        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        int[] answer = solution(n, info);
        for (int i : answer) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
