import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static List<Integer>[] graph;
    private static int ans = Integer.MAX_VALUE;
    private static int ansCnt = 0;
    private static List<Integer> ansList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        int a, b;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i=1; i<=n; i++) {
            int score = bfs(i);
            if (score < ans) {
                ans = score;
                ansCnt = 1;
                ansList.clear();
                ansList.add(i);
            }
            else if (score == ans) {
                ansCnt++;
                ansList.add(i);
            }
        }

        StringBuilder sb = new StringBuilder().append(ans).append(" ").append(ansCnt).append("\n");
        Collections.sort(ansList);
        for (int ans : ansList) {
            sb.append(ans).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static int bfs(int start) {
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[start] = 0;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int g : graph[cur]) {
                if (!visited[g]) {
                    visited[g] = true;
                    dist[g] = dist[cur] + 1;
                    queue.add(g);
                }
            }
        }

        int score = 0;
        for (int i = 1; i <= n; i++) {
            score = Math.max(score, dist[i]);
        }
        return score;
    }
    
}
