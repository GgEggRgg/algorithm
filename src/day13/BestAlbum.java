package day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//프로그래머스 > 해시 > 베스트앨범(Lv.3)
public class BestAlbum {

    private static class Music{
        String genre;
        int play;
        public Music(String genre, int play){
            this.genre = genre;
            this.play = play;
        }
        public String getGenre() {return genre;}
        public int getPlay() {return play;}
        public void setPlay(int play){
            this.play = play;
        }
    }

    public static int[] solution(String[] genres, int[] plays){
        List<Integer> answer = new ArrayList<>();

        HashMap<Integer, Music> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            Music music = new Music(genres[i], plays[i]);
            map.put(i, music);
            if(map2.containsKey(genres[i]))
                map2.put(genres[i], map2.get(genres[i])+plays[i]);
            else
                map2.put(genres[i], plays[i]);
        }

        for(int num = 0; num < map2.size(); num++){
            int maxGenre = Collections.max(map2.values());
            int count = 0;
            int maxPlay = 0;
            while(count < 2){
                for (Integer i : map.keySet()) {
                    if(map2.get(map.get(i).getGenre()) == maxGenre) {
                        int playCount = map.get(i).getPlay();
                        if(playCount > maxPlay)
                            maxPlay = playCount;
                    }
                }
                for (Integer i : map.keySet()) {
                    if(map.get(i).getPlay() == maxPlay) {
                        answer.add(i);
                        count++;
                        map.get(i).setPlay(-1);
                        maxPlay = 0;
                    }
                }
            }
            for (String s : map2.keySet()) {
                if(map2.get(s) == maxGenre){
                    map2.put(s, 0);
                }
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        ex1();
    }

    public static void ex1(){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        solution(genres, plays);
    }

}
