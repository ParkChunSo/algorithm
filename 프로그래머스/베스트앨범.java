import java.util.*;

class Solution {
    Map<String, Integer> genreMap;
    Map<String, List<Album>> albumMap;
    public int[] solution(String[] genres, int[] plays) {
        albumMap = new HashMap<>();
        genreMap = new HashMap<>();
        for(int i = 0 ; i < genres.length ; i++){
            if(albumMap.get(genres[i]) == null){
                genreMap.put(genres[i], 0);
                albumMap.put(genres[i], new ArrayList<>());
            }
            genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);
            albumMap.get(genres[i]).add(new Album(i, plays[i]));
        }

        PriorityQueue<Genre> queue = new PriorityQueue<>(Comparator.comparing(Genre::getPlay).reversed());
        Set<String> keys = genreMap.keySet();
        for(String key : keys){
            queue.offer(new Genre(key, genreMap.get(key)));
        }
        List<Integer> answer = new LinkedList<>();
        while(!queue.isEmpty()){
            Genre poll = queue.poll();
            List<Album> albums = albumMap.get(poll.name);
            albums.sort(Comparator.comparing(Album::getPlay).reversed().thenComparing(Album::getId));
            for(int i = 0 ; i < albums.size() ; i++){
                if(i == 2)
                    break;
                answer.add(albums.get(i).id);
            }
        }
        int[] result = new int[answer.size()];
        for(int i = 0 ; i < result.length ; i++){
            result[i] = answer.get(i);
        }
        return result;
    }

    public class Genre{
        String name;
        int play;

        public Genre(String name, int play) {
            this.name = name;
            this.play = play;
        }

        public int getPlay() {
            return play;
        }
    }
    public class Album{
        int id;
        int play;

        public Album(int id, int play) {
            this.id = id;
            this.play = play;
        }

        public int getPlay() {
            return play;
        }

        public int getId() {
            return id;
        }
    }
}