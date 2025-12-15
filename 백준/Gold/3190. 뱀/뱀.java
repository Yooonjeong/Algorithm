import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    private static int n, k;
    private static int[][] board;
    private static int dir = 0;
    private static int[] dirY = {0, 1, 0, -1};
    private static int[] dirX = {1, 0, -1, 0};
    private static Map<Integer, Integer> dirMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        for (int i=0; i<l; i++) {
            st = new StringTokenizer(br.readLine());
            dirMap.put(Integer.parseInt(st.nextToken()), st.nextToken().equals("D") ? 1 : 3);
        }

        System.out.println(move());
    }

    private static boolean isWall(int y, int x) {
        return y<0 || y>=n || x<0 || x>=n;
    }

    private static int move() {
        int time = 0;
        Deque<Point> snake = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        snake.add(new Point(0, 0));
        visited[0][0] = true;

        while(true) {
            time++;
            Point head = snake.peekFirst();
            int ny = head.y + dirY[dir];
            int nx = head.x + dirX[dir];

            if (isWall(ny, nx) || visited[ny][nx]) {
                return time;
            }

            snake.addFirst(new Point(ny, nx));
            visited[ny][nx] = true;

            if (board[ny][nx] == 1) {
                board[ny][nx] = 0;
            }
            else {
                Point tail = snake.pollLast();
                visited[tail.y][tail.x] = false;
            }

            if (dirMap.containsKey(time)) {
                dir = (dir + dirMap.get(time)) % 4;
            }
        }
    }
}

class Point {
    int x;
    int y;

    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}