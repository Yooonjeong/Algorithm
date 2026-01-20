import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new char[n][2*n-1];

        for (int i=0; i<n; i++) {
            for (int j=0; j<2*n-1; j++) {
                board[i][j] = ' ';
            }
        }

        draw(0, n-1, n);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(board[i]).append("\n");
        }
        
        System.out.println(sb.toString());
    }

    private static void draw(int r, int c, int n) {
        if (n == 3) {
            board[r][c] = '*';
            board[r+1][c-1] = '*';
            board[r+1][c+1] = '*';
            for (int i=c-2; i<c+3; i++) {
                board[r+2][i] = '*';
            }
            return;
        }

        int half = n/2;

        draw(r, c, half);
        draw(r+half, c-half, half);
        draw(r+half, c+half, half);
    }
}