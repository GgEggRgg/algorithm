package day2;

//프로그래머스 > 2022 KAKAO BLIND RECRUITMENT > 신고 결과 받기(Lv.1)
class ReceiveReportResults {

    public static int[] solution(String[] id_list, String[] report, int k) {
        int answer[] = new int[id_list.length];
        String count[] = new String[id_list.length];
        boolean check = true;

        /**
         * 해당 인덱스의 아이디를 신고한 사람을 count 배열에 넣음(중복제거)
         */
        for(int i = 0; i < report.length; i++){
            check = true;
            String[] temp = report[i].split(" ");
            for(int ns = 0; ns < id_list.length; ns++){
                if(temp[1].equals(id_list[ns])){
                    if(count[ns] == null){
                        count[ns] = temp[0];
                    }
                    else {
                        String[] tempName = count[ns].split(" ");
                        for(int j = 0; j < tempName.length; j++){
                            if(tempName[j].equals(temp[0])){
                                check = false;
                                break;
                            }
                        }
                        if(check){
                            count[ns] = count[ns]+" "+temp[0];
                        }
                    }
                }
            }
        }

        /**
         * 신고한 사람이 있는 count 배열을 사용해서 신고 누적 횟수와 비교
         */
        for(int i = 0 ; i < count.length; i++) {
            if (!(count[i] == null)) {
                String[] temp = count[i].split(" ");
                if(temp.length >= k){
                    for(int j = 0; j < temp.length; j++){
                        for(int n = 0; n < id_list.length; n++){
                            if(temp[j].equals(id_list[n])){
                                answer[n]++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] answer1 = ex1();
        int[] answer2 = ex2();
        int[] answer3 = ex3();

        System.out.print("ex1 answer: ");
        for (int i : answer1) {
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.print("ex2 answer: ");
        for (int i : answer2) {
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.print("ex3 answer: ");
        for (int i : answer3) {
            System.out.print(i+" ");
        }
        System.out.println();


    }

    public static int[] ex1(){ //result [2, 1, 1, 0]
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        int[] answer = solution(id_list, report, k);
        return answer;
    }

    public static int[] ex2(){ //result [0, 0]
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        int[] answer = solution(id_list, report, k);
        return answer;
    }

    public static int[] ex3(){ //result [1, 0, 1, 0]
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi frodo", "frodo neo", "neo apeach", "neo apeach"};
        int k = 2;
        int[] answer = solution(id_list, report, k);
        return answer;
    }

}