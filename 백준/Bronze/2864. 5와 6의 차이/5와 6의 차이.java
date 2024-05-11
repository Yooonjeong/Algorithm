
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		String a = st.nextToken();
		String b = st.nextToken();
		String maxa="", maxb="", mina="", minb="";
		for(int i=0; i<a.length(); i++) {
			char at = a.charAt(i);
			if(at=='5') {
				maxa += '6';
				mina += '5';
			}
			else if(at=='6') {
				maxa += '6';
				mina += '5';
			}
			else {
				maxa += at;
				mina += at;
			}
		}
		for(int i=0; i<b.length(); i++) {
			char at = b.charAt(i);
			if(at=='5') {
				maxb += '6';
				minb += '5';
			}
			else if(at=='6') {
				maxb += '6';
				minb += '5';
			}
			else {
				maxb += at;
				minb += at;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(Integer.valueOf(mina)+Integer.valueOf(minb)).append(" ");
		sb.append(Integer.valueOf(maxa)+Integer.valueOf(maxb));
		System.out.println(sb.toString());
	}

}
