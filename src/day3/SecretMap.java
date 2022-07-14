package day3;

//프로그래머스 > 2018 KAKAO BLIND RECRUITMENT > [1차] 비밀지도(lv.1)
public class SecretMap {

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        /**
         * 입력받는 두 지도(arr1, arr2)를 비트연산해서 계산
         * 계산한 값을 replace 를 사용해서 0을 빈칸으로, 1을 #으로 변경
         * 앞의 값이 0이라서 없어지는 칸을 반복문을 통해서 빈칸을 넣어줌
         */
        for(int i = 0; i < n; i++){
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            answer[i] = answer[i].replace("0", " ");
            answer[i] = answer[i].replace("1", "#");
            if(answer[i].length() < n){
                int count = n - answer[i].length();
                for(int j = 0; j < count; j++)
                    answer[i] = " "+answer[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] answer1 = ex1();
        for (String s : answer1) {
            System.out.println(s);
        }
        System.out.println();

        String[] answer2 = ex2();
        for (String s : answer2) {
            System.out.println(s);
        }
        System.out.println();

        String[] answer3 = ex3();
        for (String s : answer3) {
            System.out.println(s);
        }
    }

    public static String[] ex1(){
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] answer = solution(n, arr1, arr2);
        return answer;
    }

    public static String[] ex2(){
        int n = 6;
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};
        String[] answer = solution(n, arr1, arr2);
        return answer;
    }

    public static String[] ex3(){
        int n = 6;
        int[] arr1 = {46, 33, 33, 22, 31, 1};
        int[] arr2 = {27, 56, 19, 14, 14, 3};
        String[] answer = solution(n, arr1, arr2);
        return answer;
    }
}
