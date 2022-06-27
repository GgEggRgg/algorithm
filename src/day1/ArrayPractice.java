package day1;

public class ArrayPractice {

    static int func2(int arr[], int len){
        int temp[] = new int[101];
        for (int i : arr) {
            temp[i]++;
        }

        if(temp[50] > 1){
            return 1;
        }
        for(int i = 0; i < temp.length; i++) {
            if(i != 50 && temp[i] != 0 && temp[100-i] != 0){
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[];
        System.out.println("***** test1 *****");
        arr = new int[] {1, 52, 48};
        System.out.println(func2(arr, 3));

        System.out.println("***** test2 *****");
        arr = new int[] {50, 42};
        System.out.println(func2(arr, 2));

        System.out.println("***** test3 *****");
        arr = new int[] {4, 13, 63, 87};
        System.out.println(func2(arr, 4));

    }
}
