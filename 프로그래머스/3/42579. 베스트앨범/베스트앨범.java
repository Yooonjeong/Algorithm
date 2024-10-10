import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> cnt = new HashMap<>();
        HashMap<String, List<int[]>> map = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            cnt.put(genres[i], cnt.getOrDefault(genres[i], 0)+plays[i]);
            map.putIfAbsent(genres[i], new ArrayList<>());
            map.get(genres[i]).add(new int[]{plays[i], i});
        }
        
        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(cnt.entrySet());
        genreList.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        List<Integer> answerList = new ArrayList<>();
        
        for (Map.Entry<String, Integer> entry : genreList) {
            String key = entry.getKey();
            List<int[]> songs = map.get(key);
            songs.sort((a, b)-> b[0] - a[0]);
            
            for(int j=0; j<Math.min(songs.size(), 2); j++){
                answerList.add(songs.get(j)[1]);
            }
        }
        
        return answerList.stream().mapToInt(i->i).toArray();
    }
}