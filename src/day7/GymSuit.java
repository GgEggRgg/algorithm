package day7;

//프로그래머스 > 탐욕법(Greedy) > 체육복(Lv.1)
import java.util.Arrays;

public class GymSuit {

    public static int solution(int n, int[] lost, int[] reserve){
        int answer = n-lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j <reserve.length; j++){
                if(lost[i] == reserve[j]){
                    //자기 자신이 가지고 있을 때
                    System.out.println(lost[i]+", "+reserve[j]);
                    reserve[j] = 0;
                    lost[i] = 0;
                    answer++;
                    break;
                }
            }
        }

        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                 if(lost[i]-1 == reserve[j] && lost[i]-1 > 0){
                    //한 번호 아래 사람한테 빌리기
                    System.out.println(lost[i]+", "+reserve[j]);
                    reserve[j] = 0;
                    lost[i] = 0;
                    answer++;
                    break;
                } else if(lost[i]+1 == reserve[j] && lost[i] > 0) {
                    //한 번호 앞 사람한테 빌리기
                    System.out.println(lost[i]+", "+reserve[j]);
                    reserve[j] = 0;
                    lost[i] = 0;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("-----ex1-----");
        ex1();

        System.out.println("-----ex2-----");
        ex2();

        System.out.println("-----ex3-----");
        ex3();
    }

    public static int ex1(){ //5
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        int answer = solution(n, lost, reserve);
        return answer;
    }

    public static int ex2(){ //4
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {3};
        int answer = solution(n, lost, reserve);
        return answer;
    }

    public static int ex3(){ //2
        int n = 5;
        int[] lost = {1, 2};
        int[] reserve = {2, 3};
        int answer = solution(n ,lost, reserve);
        return answer;
    }
}
