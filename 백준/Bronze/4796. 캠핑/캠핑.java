
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int a, b, c;
		StringBuilder sb = new StringBuilder();
		int cnt=0;
		long rst=0;
		while(true) {
			rst=0;
			cnt++;
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(a==0&&b==0&&c==0) {
				break;
			}
			rst = a*(c/b)+Math.min(c%b, a);
			sb.append("Case ").append(cnt).append(": ").append(rst).append("\n");
		}
		System.out.println(sb.toString());
	}

}
