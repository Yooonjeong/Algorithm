import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] ceil = new int[h+1];
        int[] floor = new int[h+1];

        for (int i=0; i<n; i++) {
            int size = Integer.parseInt(br.readLine());
            if (i % 2 == 0) floor[size]++;
            else ceil[size]++;
        }
        
        for (int i=h-1; i>=1; i--) {
            floor[i] += floor[i+1];
            ceil[i] += ceil[i+1];
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i=1; i<=h; i++) {
            int sum = floor[i] + ceil[h-i+1];
            
            if (sum < min) {
                min = sum;
                cnt = 1;
            }
            else if (sum == min) {
                cnt++;
            }
        }

        System.out.println(min+" "+cnt);
    }
}