package day8;

import java.util.ArrayList;

//프로그래머스 > 완전탐색 > 모의고사(Lv.1)
public class MockExam2 {

    public static int[] solution(int[] answers){
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == a[i%a.length])
                score[0]++;
            if(answers[i] == b[i%b.length])
                score[1]++;
            if(answers[i] == c[i%c.length])
                score[2]++;
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(max == score[0])
            list.add(1);
        if(max == score[1])
            list.add(2);
        if(max == score[2])
            list.add(3);

        return list.stream().mapToInt(i->i.intValue()).toArray();
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
