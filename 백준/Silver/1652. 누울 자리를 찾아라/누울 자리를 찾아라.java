import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int garo = 0;
        int sero = 0;
        char[][] board = new char[n][n];
        for (int i=0; i<n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i=0; i<n; i++) {
            int prevIdx = 0;
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'X') {
                    garo += (j - prevIdx >= 2) ? 1 : 0;
                    prevIdx = j+1;
                }
            }
            garo += (n - prevIdx >= 2) ? 1 : 0;
        }

        for (int i=0; i<n; i++) {
            int prevIdx = 0;
            for (int j=0; j<n; j++) {
                if (board[j][i] == 'X') {
                    sero += (j - prevIdx >= 2) ? 1 : 0;
                    prevIdx = j+1;
                }
            }
            sero += (n - prevIdx >= 2) ? 1 : 0;
        }

        System.out.println(garo+" "+sero);
    }
}