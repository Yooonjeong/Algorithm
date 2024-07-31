
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<in.length(); i++) {
			char at = in.charAt(i);
			if(at>='a'&&at<='z') {
				sb.append(Character.toUpperCase(at));
			}
			else if(at>='A'&&at<='Z'){
				sb.append(Character.toLowerCase(at));
			}
		}
		System.out.println(sb.toString());
	}

}
