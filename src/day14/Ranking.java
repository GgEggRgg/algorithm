package day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//프로그래머스 > 그래프 > 순위(Lv.3)
public class Ranking {

    public static int solution(int n, int[][] results){
        int answer = 0;
        int[][] count = new int[n+1][n+1];

        for(int i = 0; i < results.length; i++){
            int a = results[i][0]; //a선수
            int b = results[i][1]; //b선수
            count[a][b] = 1;
            count[b][a] = -1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(count[i][k] == 1 && count[k][j] == 1){
                        count[i][j] = 1;
                        count[j][i] = -1;
                    }
                    if(count[i][k] == -1 && count[k][j] == -1){
                        count[i][j] = -1;
                        count[j][i] = 1;
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(count[i][j] != 0) cnt++;
            }
            if(cnt == n-1)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        ex1();
        ex2();
    }

    public static void ex1(){
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int solution = solution(n, results);
        System.out.println(solution);
    }

    public static void ex2(){
        int n = 5;
        int[][] results = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int solution = solution(n, results);
        System.out.println(solution);
    }
}
