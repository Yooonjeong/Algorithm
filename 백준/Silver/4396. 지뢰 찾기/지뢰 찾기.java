import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int n;
	private static String[] board;
	private static String[] play;
	private static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
	private static int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new String[n];
		play = new String[n];
		
		for(int i=0; i<n; i++) {
			board[i] = br.readLine();
		}
		for(int i=0; i<n; i++) {
			play[i] = br.readLine();
		}
		System.out.println(result());
	}
	
	public static boolean range(int y, int x) {
		return y>=0 && y<n && x>=0 && x<n;
	}
	
	public static String result() {
		StringBuilder ans = new StringBuilder();
		boolean found = false;
		
		for (int i=0; i<n && !found; i++) {
			for (int j = 0; j < n; j++) {
				if (play[i].charAt(j) == 'x' && board[i].charAt(j) == '*') {
					found = true;
					break;
				}
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (play[i].charAt(j) == 'x') {
					if (board[i].charAt(j) == '*') {
						ans.append("*");
					} else {
						int cnt = 0;
						for (int d=0; d<8; d++) {
							int ny = i + dirY[d];
							int nx = j + dirX[d];
							if (range(ny, nx) && board[ny].charAt(nx) == '*') {
								cnt++;
							}
						}
						ans.append(cnt);
					}
				} else {
					if (found && board[i].charAt(j) == '*') {
						ans.append("*");
					} else {
						ans.append(".");
					}
				}
			}
			ans.append("\n");
		}
		return ans.toString();
	}
}