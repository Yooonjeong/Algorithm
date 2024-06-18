
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int k;
		String[] str;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			k = Integer.parseInt(br.readLine());
			str = new String[k];
			boolean check=false;
			for(int j=0; j<k; j++) {
				str[j] = br.readLine();
			}
			for(int j=1; j<k; j++) {
				if(check) {
					break;
				}
				for(int l=0; l<j; l++) {
					if(isPalindrome(str[j],str[l])) {
						sb.append(str[j]+str[l]).append("\n");
						check = true;
						break;
					}
					if(isPalindrome(str[l],str[j])) {
						sb.append(str[l]+str[j]).append("\n");
						check = true;
						break;
					}
				}
			}
			if(!check) {
				sb.append("0").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	public static boolean isPalindrome(String a, String b) {
		boolean isPalindrome = true;
		String cur = a+b;
		int len = cur.length();
		for(int i=0; i<len/2; i++) {
			if(cur.charAt(i)!=cur.charAt(len-1-i)) {
				isPalindrome = false;
				break;
			}
		}
		return isPalindrome;
	}

}
