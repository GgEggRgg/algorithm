package day4;

//프로그래머스 > 2022 KAKAO BLIND RECRUITMENT > 주차 요금 계산(lv.2)
public class ParkingFee {
    public static int[] solution(int[] fees, String[] records){
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        int[] answer;
        int count = 0;
        int nCount = 0;
        String[] carTemp = new String[10000]; //가져온 기록에 있는 시간
        boolean[] car = new boolean[10000];
        int[] timeTemp = new int[10000]; //해당 차의 누적된 시간

        for(int i = 0; i < records.length; i++){
            String time = records[i].split(" ")[0];
            int carNumber = Integer.parseInt(records[i].split(" ")[1]);
            String inOut = records[i].split(" ")[2];

            int hour = Integer.parseInt(time.split(":")[0]);
            int minute = Integer.parseInt(time.split(":")[1]);
            int recordTime = hour*60 + minute;

            if(inOut.equals("IN")){
                carTemp[carNumber] = Integer.toString(recordTime);
                car[carNumber] = true;
            } else {
                timeTemp[carNumber] += recordTime - Integer.parseInt(carTemp[carNumber]);
                carTemp[carNumber] = null;
            }
        }

        for(int i = 0; i < timeTemp.length; i++){
            if(car[i] != false) {
                count++;
            }
            if(carTemp[i] != null) {
                timeTemp[i] += (23 * 60) + 59 - Integer.parseInt(carTemp[i]);
                carTemp[i] = null;
            }
        }
        answer = new int[count];


        for(int i = 0; i < timeTemp.length; i++){
            if(timeTemp[i] != 0){
                answer[nCount] = defaultFee;

                int calcTime = timeTemp[i]-defaultTime;
                if(calcTime > 0){
                    answer[nCount] += (calcTime/unitTime) * unitFee;
                    if(timeTemp[i]%unitTime != 0){
                        answer[nCount] += unitFee;
                    }
                }
                nCount++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ex4();
    }

    public static void ex1(){
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT",
                "22:59 5961 IN", "23:00 5961 OUT"};
        int[] answer = solution(fees, records);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static void ex2(){
        int[] fees = {120, 0, 60, 591};
        String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT",
                "18:00 0202 OUT","23:58 3961 IN"};
        int[] answer = solution(fees, records);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static void ex3(){
        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN"};
        int[] answer = solution(fees, records);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static void ex4(){
        int[] fees = {1, 10, 1, 11};
        String[] records = {"00:00 1234 IN", "00:02 1234 OUT"};
        int[] answer = solution(fees, records);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}
