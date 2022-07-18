package day7;

import java.util.HashMap;

//프로그래머스 > 2019 KAKAO BLIND RECRUITMENT > 오픈채팅방
public class OpenChatting {

    public static String[] solution(String[] record){
        HashMap<String, String> user = new HashMap<String, String>();
        int count = 0;

        for(int i = 0; i < record.length; i++){
            String act = record[i].split(" ")[0];
            String uid = record[i].split(" ")[1];
            if(act.equals("Enter") || act.equals("Change")){
                String nick = record[i].split(" ")[2];
                user.put(uid, nick);
            }
            if(act.equals("Enter") || act.equals("Leave")){
                count++;
            }
        }

        String[] answer = new String[count];
        count = 0;

        for(int i = 0; i < record.length; i++){
            String act = record[i].split(" ")[0];
            String uid = record[i].split(" ")[1];
            String nick = user.get(uid);
            if(act.equals("Enter")){
                answer[count] = nick+"님이 들어왔습니다.";
                count++;
            } else if(act.equals("Leave")){
                answer[count] = nick+"님이 나갔습니다.";
                count++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] answer = ex1();
        for (String s : answer) {
            System.out.println(s);
        }
    }

    public static String[] ex1(){
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] answer = solution(record);
        return answer;
    }
}
