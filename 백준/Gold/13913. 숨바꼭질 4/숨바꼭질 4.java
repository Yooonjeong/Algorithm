import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, k;
    private static int[] arr = new int[100001];
    private static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Arrays.fill(arr, -1);
        
        StringBuilder ans = new StringBuilder();
        ans.append(bfs()).append("\n");
        
        List<Integer> ansList = new ArrayList<>();
        ansList.add(k);
        while (arr[k] != -1) {
            ansList.add(arr[k]);
            k = arr[k];
        }

        for (int i=ansList.size()-1; i>=0; i--) {
            ans.append(ansList.get(i)).append(" ");
        }

        System.out.println(ans.toString());
    }

    private static boolean range(int pos) {
        return pos >= 0 && pos <= 100000;
    }
    
    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {n, 0});
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int time = cur[1];

            if (pos == k) {
                return cur[1];
            }
            int[] next = {pos*2, pos-1, pos+1};
            for (int i=0; i<3; i++) {
                if (range(next[i]) && !visited[next[i]]) {
                    queue.add(new int[] {next[i], time+1});
                    arr[next[i]] = pos;
                    visited[next[i]] = true;
                }
            }
        }
        return -1;
    }
}
