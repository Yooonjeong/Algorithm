import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] asc = new int[n];
        int[] desc = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<n; i++) {
            asc[i] = 1;
            
            for (int j=0; j<i; j++) {
                if (arr[j] < arr[i]) {
                    asc[i] = Math.max(asc[i], asc[j]+1);
                }
            }
        }

        for (int i=n-1; i>=0; i--) {
            desc[i] = 1;
            
            for (int j=n-1; j>i; j--) {
                if (arr[i] > arr[j]) {
                    desc[i] = Math.max(desc[i], desc[j]+1);
                }
            }
        }

        int max = 0;
        for (int i=0; i<n; i++) {
            max = Math.max(max, asc[i]+desc[i]-1);
        }

        System.out.println(max);
    }
}
