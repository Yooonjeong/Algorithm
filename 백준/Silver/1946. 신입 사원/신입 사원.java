
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t,n,min,cnt;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][2];
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[0], o2[0]);
				}
				
			});
			min = arr[0][1];
			cnt=1;
			for(int j=1; j<n; j++) {
				if(arr[j][1]<min) {
					cnt++;
					min = arr[j][1];
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

}
