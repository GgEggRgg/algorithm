package day8;

import java.util.Arrays;

//프로그래머스 > 완전탐색 > 모의고사(Lv.1)
public class MockExam {

    public static int[] solution(int[] answers){
        int[] a = new int[answers.length];
        int[] b = new int[answers.length];
        int[] c = new int[answers.length];

        int countA = 1, countB = 1, countC = 1;
        int[] score = new int[3];

        for(int i = 0; i < answers.length; i++){
            if(countA > 5){
                countA = 1;
            }
            if(countB > 5){
                countB = 1;
            } else if (countB == 2){
                countB++;
            }
            if(countC > 5){
                countC = 1;
            } else if(countC == 3){
                countC++;
            }
            a[i] = countA++;
            if(i%2 == 0){
                b[i] = 2;
            } else {
                b[i] = countB++;
            }
            if(i%10 == 0 || i%10 == 1){
                c[i] = 3;
            } else if(i%2 == 0){
                c[i] = countC;
            } else {
                c[i] = countC++;
            }
        }

        for(int i = 0; i < a.length; i++){
            if(answers[i] == a[i])
                score[0]++;
            if(answers[i] == b[i])
                score[1]++;
            if(answers[i] == c[i])
                score[2]++;
        }

        int[] answer = {};
        int count = 0;
        int max = Arrays.stream(score).max().getAsInt();
        for(int i = 0; i < 3; i++){
            if(score[i] == max){
                count++;
            }
        }

        answer = new int[count];
        count = 0;

        for(int i = 0; i < 3; i++){
            if(score[i] == max){
                answer[count++] = i+1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        ex1();
        ex2();
    }

    public static void ex1(){
        int[] answers = {1, 2, 3, 4, 5};
        int[] result = solution(answers);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static void ex2(){
        int[] answers = {1, 3, 2, 4, 2};
        int[] result = solution(answers);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
