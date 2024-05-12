
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		StringBuilder sb = new StringBuilder();
		int i;
		for(i=0; i<in.length(); i+=10) {
			if(i+10>in.length()) {
				break;
			}
			sb.append(in.substring(i,i+10)).append("\n");
		}
		sb.append(in.substring(i));
		System.out.println(sb.toString());
	}

}
