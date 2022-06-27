import java.util.Scanner;

public class Boj10808 {

    static void check(String text){
        int alphabet[] = new int[26];

        for(int i = 0; i < text.length(); i++){
            int textInt = text.charAt(i);
            alphabet[textInt-97]++;
        }

        for(int i = 0; i < alphabet.length; i++){
            System.out.print(alphabet[i]);
            if(i+1 < alphabet.length){
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        check(text);
    }
}
