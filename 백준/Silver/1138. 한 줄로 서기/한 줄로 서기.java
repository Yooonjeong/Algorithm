
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[][] = new int[n+1][2];
		for(int i=1; i<=n; i++) {
			arr[i][0] = i;
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}
				else {
					return Integer.compare(o1[1], o2[1]);
				}
			}
			
		});
		ArrayList<Integer> ans = new ArrayList<>();
		int cnt, idx;
		for(int i=1; i<=n; i++) {
			cnt=0;
			idx=-1;
			for(int j=0; j<ans.size(); j++) {
				if(arr[i][0]<ans.get(j)) {
					cnt++;
				}
				if(cnt>arr[i][1]) {
					idx=j;
					break;
				}
			}
			if(idx!=-1) {
				ans.add(idx, arr[i][0]);
			}
			else {
				ans.add(arr[i][0]);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<ans.size(); i++) {
			sb.append(ans.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}

}
