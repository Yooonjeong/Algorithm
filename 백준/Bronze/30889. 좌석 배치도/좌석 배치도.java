import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        char[][] seats = new char[10][20];
        for (int i=0; i<10; i++) {
            Arrays.fill(seats[i], '.');
        }

        for (int i=0; i<n; i++) {
            String info = br.readLine();
            int row = info.charAt(0) - 'A';
            int col = Integer.parseInt(info.substring(1)) - 1;
            seats[row][col] = 'o';
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<10; i++) {
            for (int j=0; j<20; j++) {
                sb.append(seats[i][j]);
            }
            sb.append('\n');
        }
        
        System.out.print(sb.toString());
    }
}