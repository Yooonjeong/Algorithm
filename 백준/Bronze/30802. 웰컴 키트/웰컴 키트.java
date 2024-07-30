
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n;
		long[] arr = new long[6];
		long t, p;
		StringTokenizer st;
		n = Long.parseLong(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<6; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		t = Long.parseLong(st.nextToken());
		p = Long.parseLong(st.nextToken());
		int cnt=0;
		for(int i=0; i<6; i++) {
			if(arr[i]%t==0) {
				cnt+=arr[i]/t;
			}
			else {
				cnt+=(arr[i]/t)+1;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		sb.append(n/p).append(" ").append(n%p);
		System.out.println(sb.toString());
	}

}
