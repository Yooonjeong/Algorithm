import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int sec=0;
        int len = jobs.length;
        Arrays.sort(jobs, (o1, o2) -> o1[0]-o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        int idx=0, cnt=0;
        while(cnt<len){
            while(idx<len && jobs[idx][0] <= sec){
                pq.add(jobs[idx++]);
            }
            if(pq.isEmpty()){
                sec++;
                continue;
            }
            int[] front = pq.peek();
            sec += front[1];
            answer += sec-front[0];
            cnt++;
            pq.poll();
        }
        return (int)((double)answer/len);
    }
}