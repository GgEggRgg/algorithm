package day10;

import java.util.Arrays;
import java.util.Comparator;

//프로그래머스 > 탐욕법 > 섬 연결하기(Lv.3)
public class ConnectIsland {

    public static int solution(int n, int[][] costs){
        //costs[x][0] : a섬, costs[x][1] : b 섬, costs[x][2] : 다리 비용
        int answer = 0;
        boolean[] isIn = new boolean[n];

        //배열을 다리 비용을 기준으로 오름차순 계산
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        isIn[costs[0][0]] = true;
        isIn[costs[0][1]] = true;
        answer += costs[0][2];

        for(int i = 1; i < costs.length; i++){
            if(isIn[costs[i][0]] ^ isIn[costs[i][1]]){
                isIn[costs[i][0]] = true;
                isIn[costs[i][1]] = true;
                answer += costs[i][2];
                i = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ex1();
        ex2();
    }

    public static void ex1(){
        int n = 4;
        int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
        int result = solution(n, costs);
        System.out.println(result);
    }

    public static void ex2(){
        int n = 7;
        int[][] costs = {{2,3,7}, {3,6,13}, {3,5,23}, {5,6,25}, {0,1,29},
                {1,5,34}, {1,2,35}, {4,5,53}, {0,4,75}};
        int result = solution(n, costs);
        System.out.println(result);
    }
}
