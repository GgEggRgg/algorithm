package day4;

//프로그래머스 > 2021 카카오 채용연계형 인턴십 > 숫자 문자열과 영단어(lv.1)
public class AlphabetToNumber {

    public static int solution(String s) {
        int answer = 0;
        char[] temp;
        String answerTemp = "";
        temp = s.toCharArray();

        /**
         * temp 를 돌면서 문자를 확인한다.
         */
        for(int i = 0; i < temp.length; i++){
            if(temp[i] >= 'a' && temp[i] <= 'z'){
                switch(temp[i]){
                    case 'e': //8
                        answerTemp += '8';
                        i += 4;
                        break;
                    case 'f': //4, 5
                        if(temp[i+1] == 'o'){
                            answerTemp += '4';
                        } else {
                            answerTemp += '5';
                        }
                        i += 3;
                        break;
                    case 'n': //9
                        answerTemp += '9';
                        i += 3;
                        break;
                    case 'o': //1
                        answerTemp += '1';
                        i += 2;
                        break;
                    case 's': //6, 7
                        if(temp[i+1] == 'i'){
                            answerTemp += '6';
                            i += 2;
                        } else {
                            answerTemp += '7';
                            i += 4;
                        }
                        break;
                    case 't': //2, 3
                        if (temp[i+1] == 'w'){
                            answerTemp += '2';
                            i += 2;
                        } else {
                            answerTemp += '3';
                            i += 4;
                        }
                        break;
                    case 'z': //0
                        answerTemp += '0';
                        i += 3;
                        break;
                }
            } else {
                answerTemp += temp[i];
            }
        }
        /**
         * 문자열인 answerTemp 를 int 형으로 변환해서 반환
         */
        answer = Integer.parseInt(answerTemp);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(ex1());
        System.out.println(ex2());
        System.out.println(ex3());
    }

    public static int ex1(){
        String s = "one4seveneight";
        int answer = solution(s);
        return answer;
    }

    public static int ex2(){
        String s = "23four5six7";
        int answer = solution(s);
        return answer;
    }

    public static int ex3(){
        String s = "2three45sixseven";
        int answer = solution(s);
        return answer;
    }
}
