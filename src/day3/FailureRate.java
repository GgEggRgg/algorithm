package day3;

//프로그래머스 > 2019 KAKAO BLIND RECRUITMENT > 실패율(Lv.1)
public class FailureRate {

    public static int[] solution(int N, int[] stages){
        int[] answer = new int[N];
        for(int i = 0; i < N; i++){
            answer[i] = i+1;
        }
        float[] failRate = new float[N];

        int count, fail;
        float temp;
        int temp2;

        /**
         * 1부터 N 까지의 스테이지를 기준으로 크거나 같으면 "해당 스테이지를 플레이한 유저", 같으면 "클리어 못한 유저"
         * 실패율 = (클리어 못한 유저) / (스테이지를 플레이한 유저)
         */
        for(int i = 0; i < N; i++){
            count = 0;
            fail = 0;
            for(int j = 0; j < stages.length; j++){
                if(stages[j] >= i+1)
                    count++;
                if(stages[j] == i+1)
                    fail++;
            }
            failRate[i] = (float)fail/(float)count;
        }

        /**
         * 실패율 배열을 기준으로 answer 와 failRate 를 같이 정렬(failRate 기준 내림차순 정렬)
         */
        for(int i = 0; i < failRate.length; i++){
            temp = 0;
            for(int j = i+1; j < failRate.length; j++){
                if(failRate[i] < failRate[j]){
                    temp = failRate[i];
                    failRate[i] = failRate[j];
                    failRate[j] = temp;

                    temp2 = answer[i];
                    answer[i] = answer[j];
                    answer[j] = temp2;
                }
            }
        }

        /**
         * failRate 기준 내림차순으로 정렬한 answer 와 failRate 를 한번 더 정렬
         * failRate 의 값이 같을 때 answer 를 기준으로 내림차순
         */
        for(int i = 0; i < failRate.length; i++){
            temp = 0;
            for(int j = i+1; j < failRate.length; j++){
                if((failRate[i] == failRate[j]) && (answer[i] > answer[j])){
                    temp = failRate[i];
                    failRate[i] = failRate[j];
                    failRate[j] = temp;

                    temp2 = answer[i];
                    answer[i] = answer[j];
                    answer[j] = temp2;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("----------ex1----------");
        int[] sol1 = ex1();
        for(int i = 0; i < sol1.length; i++){
            System.out.print(sol1[i]+" ");
        }
        System.out.println();

        System.out.println("----------ex2----------");
        int[] sol2 = ex2();
        for(int i = 0; i < sol2.length; i++){
            System.out.print(sol2[i]+" ");
        }
        System.out.println();

        System.out.println("----------ex3----------");
        int[] sol3 = ex3();
        for(int i = 0; i < sol3.length; i++){
            System.out.print(sol3[i]+" ");
        }
        System.out.println();
    }

    public static int[] ex1(){ //result = 3, 4, 2, 1, 5
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] answer = solution(N, stages);
        return answer;
    }

    public static int[] ex2(){ //result = 4, 1, 2, 3
        int N = 4;
        int[] stages = {4, 4, 4, 4, 4};
        int[] answer = solution(N, stages);
        return answer;
    }

    public static int[] ex3(){ //result = 5 3 4 1 2 6
        int N = 6;
        int[] stages = {1, 3, 4, 3, 5, 5, 1, 2};
        int[] answer = solution(N, stages);
        return answer;
    }

}
