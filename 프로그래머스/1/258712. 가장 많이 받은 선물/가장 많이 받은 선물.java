import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> indexMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            indexMap.put(friends[i], i);
        }
        
        // 주고 받은 기록
        int[][] giftCount = new int[n][n];
        int[] given = new int[n];   // 준 선물 수
        int[] received = new int[n]; // 받은 선물 수
        
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            int giver = indexMap.get(parts[0]);
            int taker = indexMap.get(parts[1]);
            
            giftCount[giver][taker]++;
            given[giver]++;
            received[taker]++;
        }
        
        // 선물 지수 = 준 선물 - 받은 선물
        int[] giftIndex = new int[n];
        for (int i = 0; i < n; i++) {
            giftIndex[i] = given[i] - received[i];
        }
        
        // 다음 달 받을 선물 수
        int[] nextGifts = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (giftCount[i][j] > giftCount[j][i]) {
                    nextGifts[i]++;
                } else if (giftCount[i][j] < giftCount[j][i]) {
                    nextGifts[j]++;
                } else {
                    if (giftIndex[i] > giftIndex[j]) {
                        nextGifts[i]++;
                    } else if (giftIndex[i] < giftIndex[j]) {
                        nextGifts[j]++;
                    }
                }
            }
        }
        
        // 가장 많이 받은 선물 수
        int answer = 0;
        for (int cnt : nextGifts) {
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}
