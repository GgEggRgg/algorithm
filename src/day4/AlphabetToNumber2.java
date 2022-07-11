package day4;

public class AlphabetToNumber2 {

    public static int solution(String s){
        String[] eng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        for(int i = 0; i < eng.length; i++){
            s = s.replace(eng[i], Integer.toString(i));
        }
        int answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(ex1());
        System.out.println(ex2());
        System.out.println(ex3());
    }

    public static int ex1(){ //1478
        String s = "one4seveneight";
        int answer = solution(s);
        return answer;
    }

    public static int ex2(){ //234567
        String s = "23four5six7";
        int answer = solution(s);
        return answer;
    }

    public static int ex3(){ //234567
        String s = "2three45sixseven";
        int answer = solution(s);
        return answer;
    }
}
