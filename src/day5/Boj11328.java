package day5;

import java.util.Scanner;

public class Boj11328 {

    public static String check(String text){
        String text1 = text.split(" ")[0];
        String text2 = text.split(" ")[1];
        int[] temp = new int[26];

        for(int i = 0; i < text1.length(); i++){
            temp[text1.charAt(i)-97]++;
        }
        for(int i = 0; i < text2.length(); i++){
            temp[text2.charAt(i)-97]--;
        }
        for(int i = 0; i < temp.length; i++){
            if(temp[i] != 0){
                return "Impossible";
            }
        }
        return "Possible";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < N; i++){
            String text = sc.nextLine();
            System.out.println(check(text));
        }
    }
}
