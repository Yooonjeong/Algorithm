
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a,b;
		a = br.readLine();
		b = br.readLine();
		StringBuilder sb = new StringBuilder();
		if(a.length()>=b.length()) {
			sb.append("go");
		}
		else {
			sb.append("no");
		}
		System.out.println(sb.toString());
	}

}
