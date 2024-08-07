
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in;
		StringBuilder sb = new StringBuilder();
		while(true) {
			in = br.readLine();
			if(in.equals("#")) {
				break;
			}
			int cnt=0;
			for(int i=0; i<in.length(); i++) {
				char at = in.charAt(i);
				if(at=='a'||at=='e'||at=='i'||at=='o'||at=='u'
					||at=='A'||at=='E'||at=='I'||at=='O'||at=='U') {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

}
