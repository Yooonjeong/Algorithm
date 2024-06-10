
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] num = new int[3];
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			num = new int[3];
			num[0] = Integer.parseInt(st.nextToken());
			num[1] = Integer.parseInt(st.nextToken());
			num[2] = Integer.parseInt(st.nextToken());
			if(num[0]==0&&num[1]==0&&num[2]==0) {
				break;
			}
			Arrays.sort(num);
			if(num[2]*num[2]==num[0]*num[0]+num[1]*num[1]) {
				sb.append("right").append("\n");
			}
			else {
				sb.append("wrong").append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
