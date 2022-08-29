package day15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//프로그래머스 > 동적계획법 > N으로 표현(Lv.3)
public class ExpressedAsN {

    public static int solution(int N, int number){
        int answer = -1;

        List<Set<Integer>> list = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            HashSet temp = new HashSet<>();
            list.add(temp);
        }

        list.get(1).add(N);

        for(int i = 2; i < 9; i++){
            Set<Integer> set = list.get(i);
            for(int j = 1; j <= i; j++){
                Set<Integer> first = list.get(j);
                Set<Integer> second = list.get(i-j);
                for (Integer num1 : first) {
                    for (Integer num2 : second) {
                        set.add(num1 + num2);
                        set.add(num1 - num2);
                        set.add(num1 * num2);
                        if(num1 != 0 && num2 != 0)
                            set.add(num1 / num2);
                    }
                }
            }

            set.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        for (Set<Integer> num :list){
            if(num.contains(number))
                return list.indexOf(num);
        }

        return answer;
    }

    public static void main(String[] args) {
        ex1();
        ex2();
    }

    public static void ex1(){
        int N = 5;
        int number = 12;
        int result = solution(N, number);
        System.out.println(result);
    }

    public static void ex2(){
        int N = 2;
        int number = 11;
        int result = solution(N, number);
        System.out.println(result);
    }
}
