class Solution {
    public char[] vowel = {'A', 'E', 'I', 'O', 'U'};
    public int cnt=0, answer=0;
    public int solution(String word) {
        dfs(word, "");
        return answer;
    }
    public void dfs(String word, String cur){
        if(cur.equals(word)){
            answer = cnt;
            return;
        }
        cnt++;
        if(cur.length()>=5){
            return;
        }

        for(int i=0; i<5; i++){
            cur += vowel[i];
            dfs(word, cur);
            cur = cur.substring(0, cur.length()-1);
        }
    }
}