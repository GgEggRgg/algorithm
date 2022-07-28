package day10;

import java.util.*;

//프로그래머스 > 2021 KAKAO BLIND RECRUITMENT > 메뉴 리뉴얼(Lv.2)
public class MenuRenewal {

    static List<String> answer = new ArrayList<>();
    static Map<String, Integer> menu = new HashMap<>();

    //메뉴에서 가능한 조합 찾기
    public static void select(String a, String b, int count){
        if(count == 0){
            menu.put(a, menu.getOrDefault(a, 0)+1);
            return;
        }
        for(int i = 0; i < b.length(); i++){
            select(a+b.charAt(i), b.substring(i+1), count-1);
        }
    }

    public static String[] solution(String[] orders, int[] course){
        //정렬안되어있는 order 를 분리해서 정렬
        for(int i = 0; i < orders.length; i++){
            char[] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            orders[i] = String.valueOf(temp);
        }

        //각 주문들로 가능한 조합을 만들고, max 값을 구해서 2번 이상이면 answer 에 추가
        for (int courseLen : course) {
            for (String order : orders) {
                select("", order, courseLen);
            }
            if(!menu.isEmpty()){
                List<Integer> countList = new ArrayList<>(menu.values());
                int max = Collections.max(countList);
                if(max > 1){
                    for (String key : menu.keySet()) {
                        if(menu.get(key) == max){
                            answer.add(key);
                        }
                    }
                }
                menu.clear();
            }
        }

        Collections.sort(answer);
        return answer.stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] answer1 = ex1();
        for (String s : answer1) {
            System.out.println(s);
        }
    }

    public static String[] ex1(){
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        String[] result = solution(orders, course);
        return result;
    }
}
