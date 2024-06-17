
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum=0;
		String str = br.readLine();
		sum += 10;
		for(int i=1; i<str.length(); i++) {
			char at = str.charAt(i);
			char prev = str.charAt(i-1);
			if(at!=prev) {
				sum += 10;
			}
			else {
				sum += 5;
			}
		}
		System.out.println(sum);
	}

}
