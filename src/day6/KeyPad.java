package day6;

//프로그래머스 > 2020 카카오 인턴쉽 > 키패드 누르기(Lv.1)
public class KeyPad {

    /**
     * 오른손은 3으로 나눴을때 나머지가 0인 값들
     * 왼손은 3으로 나눴을때 나머지가 1인 값들
     * 가운데는 거리계산값을 기준으로 한다.
     */
    public static String solution(int[] numbers, String hand){
        String answer = "";
        int left = 10;
        int right = 11;

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i]%3 == 0 && numbers[i] != 0){
                answer += "R";
                right = numbers[i];
            } else if(numbers[i]%3 == 1){
                answer += "L";
                left = numbers[i];
            } else {
                int distanceR = distance(right, numbers[i]);
                int distanceL = distance(left, numbers[i]);
                if(distanceL > distanceR){
                    answer += "R";
                    System.out.println("R");
                    right = numbers[i];
                } else if(distanceL < distanceR){
                    answer += "L";
                    System.out.println("L");
                    left = numbers[i];
                } else if(distanceL == distanceR) {
                    if(hand.equals("right")){
                        answer += "R";
                        System.out.println("R");
                        right = numbers[i];
                    } else {
                        answer += "L";
                        System.out.println("L");
                        left = numbers[i];
                    }
                }
            }
        }

        return answer;
    }

    /**
     * 거리 구하는 함수
     * 각 숫자에 해당하는 인덱스를 찾아서 인덱스 값의 비교로 거리를 구한다.
     */
    public static int distance(int hand, int n){
        int distance = 0;
        int positionHand1 = 0;
        int positionHand2 = 0;
        int[][] keyPad = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 0, 11}};

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                if(keyPad[i][j] == hand){
                    positionHand1 = i;
                    positionHand2 = j;
                }
            }
        }

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                if(keyPad[i][j] == n){
                    distance = Math.abs(positionHand1-i) + Math.abs(positionHand2-j);
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        System.out.println("LRLLLRLLRRL");
        ex1();
        System.out.println("LRLLRRLLLRR");
        ex2();
        System.out.println("LLRLLRLLRL");
        ex3();
    }

    public static void ex1(){
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String answer = solution(numbers, hand);
        System.out.println("ex1:"+answer);
    }

    public static void ex2(){
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        String answer = solution(numbers, hand);
        System.out.println("ex2:"+answer);
    }

    public static void ex3(){
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";
        String answer = solution(numbers, hand);
        System.out.println("ex3:"+answer);
    }
}
