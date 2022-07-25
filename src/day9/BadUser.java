package day9;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.regex.Pattern;

//프로그래머스 > 2019 카카오 개발자 겨울 인턴십 > 불량 사용자(Lv.3)
public class BadUser {

    static HashSet<HashSet<String>> answer;
    public static int solution(String[] user_id, String[] banned_id){
        answer = new HashSet<>();

        dfs(new LinkedHashSet<>(), user_id, banned_id);

        for (HashSet<String> strings : answer) {
            System.out.println(strings);
        }

        return answer.size();
    }

    public static boolean check(HashSet<String> hs, String[] banned_id){
        int i = 0;
        for(String user : hs){
            String ban = banned_id[i++];
            if(user.length() != ban.length())
                return false;
            String temp = ban.replace("*", "[a-z0-9]");
            Pattern p = Pattern.compile(temp);
            if(!p.matcher(user).find())
                return false;
        }
        return true;
    }

    public static void dfs(HashSet<String> hs, String[] user_id, String[] banned_id){
        if(hs.size() == banned_id.length){
            if(check(hs, banned_id)){
                answer.add(new HashSet<>(hs));
            }
            return;
        }
        for (String userId : user_id) {
            if(hs.add(userId)){
                dfs(hs, user_id, banned_id);
                hs.remove(userId);
            }
        }
    }

    public static void main(String[] args) {
        ex1();
    }

    public static void ex1(){ //result = 2
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};
        int result = solution(user_id, banned_id);
        System.out.println(result);
    }
}
