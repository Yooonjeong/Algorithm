import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int[][] board;
    private static Map<Integer, Integer> ans = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        cutPaper(0, 0, n);

        System.out.println(ans.getOrDefault(-1, 0));
        System.out.println(ans.getOrDefault(0, 0));
        System.out.println(ans.getOrDefault(1, 0));
    }
    private static void cutPaper(int sY, int sX, int size) {
        int cur = sameAll(sY, sX, size);
        if (cur != -100) {
            ans.put(cur, ans.getOrDefault(cur, 0) + 1);
            return;
        }

        int newSize = size / 3;
        for (int dy = 0; dy < 3; dy++) {
            for (int dx = 0; dx < 3; dx++) {
                cutPaper(sY + dy * newSize, sX + dx * newSize, newSize);
            }
        }
    }

    private static int sameAll(int sY, int sX, int size) {
        int first = board[sY][sX];
        for (int i = sY; i < sY + size; i++) {
            for (int j = sX; j < sX + size; j++) {
                if (board[i][j] != first) return -100;
            }
        }
        return first;
    }
}
