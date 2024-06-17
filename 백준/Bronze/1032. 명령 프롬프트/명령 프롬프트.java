
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine();
		}
		int len = arr[0].length();
		StringBuilder ans = new StringBuilder();
		for(int i=0; i<len; i++) {
			char at = arr[0].charAt(i);
			boolean check=false;
			for(int j=1; j<n; j++) {
				if(at!=arr[j].charAt(i)) {
					ans.append("?");
					check=true;
					break;
				}
			}
			if(!check) {
				ans.append(at);
			}
		}
		System.out.println(ans.toString());
	}

}
