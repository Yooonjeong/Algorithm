class Solution {
    public int solution(String name) {
        int sum = 0;
        int len = name.length();
        int minMoves = len - 1;

        for (int i = 0; i < len; i++) {
            sum += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            int nextIdx = i+1;
            while(nextIdx<len && name.charAt(nextIdx)=='A'){
                nextIdx++;
            }
            
            minMoves = Math.min(minMoves, (2*i+len-nextIdx));
            minMoves = Math.min(minMoves, (2*(len-nextIdx)+i));
        }
        return sum + minMoves;
    }
}
