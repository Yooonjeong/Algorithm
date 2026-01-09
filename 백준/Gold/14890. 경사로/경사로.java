import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, l;
    private static int[][] board;
    private static int[][] board2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        board2 = new int[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                board2[j][i] = num;
            }
        }

        int cnt=0;
        for (int i=0; i<n; i++) {
            if (solve(board[i])) cnt++;
            if (solve(board2[i])) cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean solve(int[] street) {
        int prev = street[0];
        int temp = street[0];
        int idx = 1;
        while (idx <= n) {
            if (idx == n) {
                if (l > 1 && prev > temp) return false;
                return true;
            }

            int cnt = 1;

            while (idx < n && street[idx] == temp) {
                cnt++;
                idx++;
                if (idx == n) {
                    if (cnt < l && prev > temp) return false;
                    return true;
                }
            }

            if (Math.abs(street[idx] - temp) > 1) return false;
            
            if (cnt < l) {
                if (prev > temp) return false;
                if (street[idx] > temp) return false;
            }
            else {
                if (cnt < 2*l && prev > temp && street[idx] > temp) return false;
            }
            temp = street[idx];
            prev = street[idx-1];
            idx++;
        }

        return true;
    }
}
