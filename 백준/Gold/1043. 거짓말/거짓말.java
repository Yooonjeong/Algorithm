import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static List<Integer>[] graph;
    private static List<Integer>[] party;
    private static Queue<Integer> truth;
    private static boolean[] visited;
    private static boolean[] deleted;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        party = new ArrayList[m];
        truth = new LinkedList<>();
        visited = new boolean[n+1];
        deleted = new boolean[m];

        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i=0; i<t; i++) {
            truth.add(Integer.parseInt(st.nextToken()));
        }

        for (int i=0; i<m; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            
            int p = Integer.parseInt(st.nextToken());
            for (int j=0; j<p; j++) {
                int pn = Integer.parseInt(st.nextToken());
                party[i].add(pn);
                graph[pn].add(i);
            }
        }

        int cnt = 0;
        while(!truth.isEmpty()) {
            int cur = truth.poll();
            if (!visited[cur]) {
                dfs(cur);
            } 
        }

        for (int i=0; i<m; i++) {
            if (!deleted[i]) cnt++;
        }
        System.out.println(cnt);
    }
    private static void dfs(int truth) {
        visited[truth] = true;
        for (int p : graph[truth]) {
            deleted[p] = true;
            for (int member : party[p]) {
                if (!visited[member]) {
                    dfs(member);
                }
            }
        }
    }
}
