package day12;

//프로그래머스 > Summer/Winter Coding(~2018) > 지형 편집(Lv.4)
public class MapTransformation {

    static long mid;
    static long answer;

    public static long calcCost(int[][] land, int P, int Q, long level){
        long addCount = 0;
        long removeCount = 0;

        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land.length; j++){
                if(land[i][j] < level)
                    addCount += level - land[i][j];
                else if(land[i][j] > level)
                    removeCount += land[i][j] - level;
            }
        }

        long resultCost = addCount*P + removeCount*Q;
        System.out.println(resultCost);

        return resultCost;
    }

    public static void bin(int[][] land, int add, int remove, long start, long end){

        if(start+1 >= end){
            long startCost = calcCost(land, add, remove, start);
            long endCost = calcCost(land, add, remove, end);

            if(startCost >= endCost)
                answer = endCost;
            else
                answer = startCost;
            return;
        }

        mid = (start+end)/2;
        long midCost = calcCost(land, add, remove, mid);
        long upCost = calcCost(land, add, remove, mid+1);

        if(upCost > midCost)
            bin(land, add, remove, start, mid);
        else
            bin(land, add, remove, mid+1, end);
    }

    public static long solution(int[][] land, int P, int Q){
        long max = 0;
        for (int[] temp : land) {
            for (int comp : temp) {
                if(comp > max)
                    max = comp;
            }
        }

        bin(land, P, Q, 0, max);

        return answer;
    }

    public static void main(String[] args) {
        ex1();
        ex2();
    }

    public static void ex1(){
        int land[][] = {{1,2}, {2, 3}};
        int P = 3;
        int Q = 2;
        solution(land, P, Q);
    }

    public static void ex2(){
        int land[][] = {{4, 4, 3}, {3, 2, 2}, {2, 1, 0}};
        int P = 5;
        int Q = 3;
        solution(land, P, Q);
    }

    public static void ex3(){
        int land[][] = {{1, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        int P = 5;
    }
}
