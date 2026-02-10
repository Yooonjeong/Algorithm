import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] board;
    private static int[] dirX = {-1, 0, 1};
    private static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        dp = new int[n][m][3];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for (int i=0; i<m; i++) {
            for (int d=0; d<3; d++) {
                dp[0][i][d] = board[0][i];
            }
        }
        
        System.out.println(calcMin());
    }

    private static boolean range(int x) {
        return x>=0 && x<m;
    }

    private static int calcMin() {
        for (int i=1; i<n; i++) {
            for (int j=0; j<m; j++) {
                for (int d=0; d<3; d++) {
                    int nX = j+dirX[d];
                    int nY = i-1;
                    if (!range(nX)) continue;

                    for (int k=0; k<3; k++) {
                        if (k == d) continue;
                        if (dp[nY][nX][k] == Integer.MAX_VALUE) continue;
                        dp[i][j][d] = Math.min(dp[i][j][d], dp[nY][nX][k] + board[i][j]);
                    } 
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i=0; i<m; i++) {
            for (int d=0; d<3; d++) {
                min = Math.min(min, dp[n-1][i][d]);
            }
        }

        return min;
    }
}