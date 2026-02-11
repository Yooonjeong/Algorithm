import java.util.*;

class Solution {
    private char[][] board;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i=0; i<5; i++) {
            board = new char[5][5];
            List<int[]> pList = new ArrayList<>();
            
            for (int j=0; j<5; j++) {
                board[j] = places[i][j].toCharArray();
                
                for (int k=0; k<5; k++) {
                    if (board[j][k] == 'P') {
                        pList.add(new int[] {j, k});
                    }
                }
            }
            
            answer[i] = solve(pList);
        }
        
        return answer;
    }
    
    private boolean isNearby(int r1, int r2, int c1, int c2) {
        int distance = Math.abs(r1-r2) + Math.abs(c1-c2);
        if (distance <= 1) return true;
        if (distance > 2) return false;
        
        if (r1 == r2) {
            if (board[r1][(c1+c2)/2] == 'O') return true;
        }
        else if (c1 == c2) {
            if (board[(r1+r2)/2][c1] == 'O') return true;
        }
        else {
            if (board[r1][c2] == 'O' || board[r2][c1] == 'O') return true;
        }
        
        return false;
    }
    
    private int solve(List<int[]> pList) {
        int len = pList.size();
        
        for (int i=0; i<len-1; i++) {
            int[] start = pList.get(i);
            
            for (int j=i+1; j<len; j++) {
                int[] target = pList.get(j);
                if (target[0] >= start[0]+3) break;
                
                if (isNearby(start[0], target[0], start[1], target[1])) return 0;
            }
        }
        
        return 1;
    }
}