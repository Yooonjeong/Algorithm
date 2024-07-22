
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m[] = {500,100,50,10,5,1};
		int sum=0,cnt=0;
		n = 1000-n;
		for(int i=0; i<6; i++) {
			cnt=n/m[i];
			sum+=cnt;
			n%=m[i];
		}
		System.out.println(sum);
	}

}
