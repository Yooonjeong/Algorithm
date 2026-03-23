import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m, k;
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] a = makeArr(n, m, br);
        
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][] b = makeArr(m, k, br);

        int[][] result = multArrs(a, b);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            for (int j=0; j<k; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int[][] makeArr(int n, int m, BufferedReader br) throws Exception {
        int[][] arr = new int[n][m];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return arr;
    }

    private static int[][] multArrs(int[][] a, int[][] b) {
        int n = a.length;
        int m = b.length;
        int k = b[0].length;

        int[][] arr = new int[n][k];
        for (int i=0; i<n; i++) {
            for (int j=0; j<k; j++) {
                for (int l=0; l<m; l++) {
                    arr[i][j] += a[i][l] * b[l][j];
                }
            }
        }

        return arr;
    }
}