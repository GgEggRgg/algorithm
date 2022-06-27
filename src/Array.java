public class Array {
    static int len;

    static int[] insert(int idx, int num, int arr[]){
        len++;
        int temp[] = arr;
        arr = new int[len];
        for(int i = 0; i < temp.length; i++){
            arr[i] = temp[i];
        }

        for(int i = len-1; i > idx; i--){
            arr[i] = arr[i-1];
        }
        arr[idx] = num;
        return arr;
    }

    static int[] erase(int idx, int arr[]){
        len--;
        int temp[] = arr;
        for(int i = idx; i < len; i++){
            temp[i] = temp[i+1];
        }

        arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }

    static void printArr(int arr[]){
        for(int i = 0; i < len; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[];
        System.out.println("***** insert_test *****");
        arr = new int[] {10, 20, 30};
        len = 3;
        arr = insert(3, 40, arr);//10 20 30 40
        printArr(arr);
        arr = insert(1, 50, arr);// 10 50 20 30 40
        printArr(arr);
        arr = insert(0, 15, arr); // 15 10 50 20 30 40
        printArr(arr);

        System.out.println("***** erase_test *****");
        arr = new int[] {10, 50, 40, 30, 70, 20};
        len = 6;
        arr = erase(4, arr); // 10 50 40 30 20
        printArr(arr);
        arr = erase(1, arr); // 10 40 30 20
        printArr(arr);
        arr = erase(3, arr); // 10 40 30
        printArr(arr);
    }
}

