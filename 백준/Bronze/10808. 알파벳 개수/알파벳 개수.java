
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		int[] arr = new int[26];
		for(int i=0; i<in.length(); i++) {
			char at = in.charAt(i);
			int idx = Character.getNumericValue(at)-10;
			arr[idx]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<26; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

}
