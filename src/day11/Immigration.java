package day11;

import java.util.Arrays;

public class Immigration {
    static long mid;

    public static void bin_search(int[] times, int n, long start, long end){
        if(start >= end){
            mid = end;
            return;
        }
        mid = (start + end) / 2;
        System.out.println("mid:"+mid+", start:"+start+", end:"+end);
        long count = 0;

        for(int i = 0; i < times.length; i++){
            count += mid/times[i];
        }

        if(count >= n)
            bin_search(times, n, start, mid);
        else
            bin_search(times, n, mid+1, end);
    }

    public static long solution(int n, int[] times){
        Arrays.sort(times);
        bin_search(times, n, 0, (long)n*times[times.length-1]);
        return mid;
    }

    public static void main(String[] args) {
//        ex1();
//        ex2();
//        ex3();
//        ex4();
//        ex5();
    }

    public static void ex1(){
        int n = 6;
        int[] times = {7, 10};
        long result = solution(n, times);
        System.out.println("result:"+result);
    }

    public static void ex2(){
        int n = 6;
        int[] times = {6, 8, 13, 17, 21};
        long result = solution(n, times);
        System.out.println("result:"+result);
    }

    public static void ex3(){
        int n = 6;
        int[] times = {3, 40, 60, 80, 90, 100, 120};
        long result = solution(n, times);
        System.out.println("result:"+result);
    }

    public static void ex4(){
        int n = 1000000000;
        int[] times = new int[100000];
        Arrays.fill(times, 1000000000);
        long result = solution(n ,times);
        System.out.println("result:"+result);
    }

    public static void ex5(){
        int n = 10;
        int[] times = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        long solution = solution(n, times);
        System.out.println(solution);
    }

}
