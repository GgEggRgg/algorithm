package day9;

import java.util.HashMap;
import java.util.Map;

public class HotelRoom {
    static Map<Long, Long> map = new HashMap<>();
    public static long findRoom(long room){
        if(!map.containsKey(room)){
            map.put(room, room+1);
            return room;
        }

        long nextRoom = map.get(room);
        long emptyRoom = findRoom(nextRoom);
        map.put(room, emptyRoom);
        return emptyRoom;
    }

    public static long[] solution(long k, long[] room_number){
        long[] answer = new long[room_number.length];

        for(int i = 0; i < room_number.length; i++){
            answer[i] = findRoom(room_number[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        ex1();
    }

    public static void ex1(){
        long k = 10;
        long[] room_number = {1, 3, 4, 1, 3, 1};
        long[] result = solution(k, room_number);
        for (long l : result) {
            System.out.print(l);
        }
        System.out.println();
    }
}
