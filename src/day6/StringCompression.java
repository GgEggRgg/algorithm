package day6;

//2020 KAKAO BLIND RECRUITMENT > 문자열 압축(Lv.2)
public class StringCompression{

    public static int solution(String s){
        int answer = s.length();

        for(int i = 1; i < s.length(); i++){
            String temp = compression(s, i);
            if(answer > temp.length()){
                answer = temp.length();
            }
        }
        return answer;
    }

    /**
     * 문자열 압축하는 함수
     * substring 을 이용해서 주어진(n) 만큼 문자열을 잘라서 비교한다.
     * 연속된 문자열이어야지만 압축 가능하기 때문에 이전의 것과만 비교하면 된다.
     */
    public static String compression(String str, int n) {
        int count = 1;
        String compression = "";
        String pattern = "";

        for (int i = 0; i <= str.length() + n; i += n) {
            String temp;
            if (i >= str.length()) {
                temp = "";
            } else if (str.length() < i + n) {
                temp = str.substring(i);
            } else {
                temp = str.substring(i, i + n);
            }

            if (i != 0) {
                if (temp.equals(pattern)) {
                    count++;
                } else if (count >= 2) {
                    compression += count + pattern;
                    count = 1;
                } else {
                    compression += pattern;
                }
            }
            pattern = temp;
        }

        return compression;
    }

    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();
        ex6();
    }

    public static void ex1(){
        String s = "aabbaccc";
        int answer = solution(s);
        System.out.println(answer);
    }

    public static void ex2(){
        String s = "ababcdcdababcdcd";
        int answer = solution(s);
        System.out.println(answer);
    }

    public static void ex3(){
        String s = "abcabcdede";
        int answer = solution(s);
        System.out.println(answer);
    }

    public static void ex4(){
        String s = "abcabcabcabcdededededede";
        int answer = solution(s);
        System.out.println(answer);
    }

    public static void ex5(){
        String s = "xababcdcdababcdcd";
        int answer = solution(s);
        System.out.println(answer);
    }

    public static void ex6(){
        String s = "a";
        int answer = solution(s);
        System.out.println(answer);
    }
}
