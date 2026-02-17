import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        int y;
        int x;
        int dist;

        Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    private static int n;
    private static int[][] board;
    private static int sharkY, sharkX;
    private static int[] dirY = {-1, 0, 1, 0};
    private static int[] dirX = {0, -1, 0, 1};
    private static int size = 2;
    private static int cnt = 0;
    private static int time = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        StringTokenizer st;

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    sharkY = i;
                    sharkX = j;
                    board[i][j] = 0;
                }
            }
        }

        while (true) {
            Node target = bfs();

            if (target == null) break;

            time += target.dist;
            sharkY = target.y;
            sharkX = target.x;
            board[sharkY][sharkX] = 0;


            cnt++;
            if (cnt == size) {
                size++;
                cnt = 0;
            }
        }

        System.out.println(time);
    }

    private static boolean range(int y, int x) {
        return y>=0 && y<n && x>=0 && x<n;
    }

    private static Node bfs() {
        boolean[][] visited = new boolean[n][n];
        Queue<Node> queue = new LinkedList<>();
        List<Node> candidates = new ArrayList<>();

        queue.add(new Node(sharkY, sharkX, 0));
        visited[sharkY][sharkX] = true;

        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.dist > min) break;

            if (board[cur.y][cur.x] > 0 && board[cur.y][cur.x] < size) {
                candidates.add(cur);
                min = cur.dist;
            }

            for (int i=0; i<4; i++) {
                int nY = cur.y + dirY[i];
                int nX = cur.x + dirX[i];

                if (!range(nY, nX)) continue;
                if (board[nY][nX] > size) continue;
                if (visited[nY][nX]) continue;

                visited[nY][nX] = true;
                queue.add(new Node(nY, nX, cur.dist+1));
            }
        }

        if (candidates.isEmpty()) return null;

        Collections.sort(candidates, (a, b) -> {
            if (a.y != b.y) return a.y - b.y;
            return a.x - b.x;
        });

        return candidates.get(0);
    }
}