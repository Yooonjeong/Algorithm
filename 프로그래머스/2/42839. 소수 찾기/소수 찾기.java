import java.util.*;

class Solution {
    public static boolean[] visited;
    public static Set<Integer> arr;
    public int solution(String numbers) {
        int answer = 0;
        int len = numbers.length();
        visited = new boolean[len];
        arr = new HashSet<>();
        for(int i=1; i<=len; i++){
            dfs(numbers, "", i);
        }
        for(int at:arr){
            if(isPrime(at)){
                answer++;
            }
        }
        return answer;
    }
    public static boolean isPrime(int num){
        if(num<2){
            return false;
        }
        for(int i=2; i*i<=num; i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public static void dfs(String numbers, String cur, int len){
        if(cur.length()==len){
            int num = Integer.valueOf(cur);
            arr.add(num);
        }
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                cur += numbers.charAt(i);
                dfs(numbers, cur, len);
                visited[i] = false;
                cur = cur.substring(0, cur.length()-1);
            }
        }
    }
}