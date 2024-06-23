
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n, sum = 0, ans=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int cur=1;
		while(sum<=n) {
			if(cur%2==1&&sum==n) {
				ans = cur;
				break;
			}
			sum+=cur;
			if(cur%2==1&&sum>n) {
				ans = sum-n;
				break;
			}
			cur++;
		}
		System.out.println(ans);
	}

}
