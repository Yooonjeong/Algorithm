
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int a,b,c;
		long abc;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());
		abc = a*b*c;
		String str = String.valueOf(abc);
		int[] arr = new int[10];
		for(int i=0; i<str.length(); i++) {
			arr[str.charAt(i)-'0']++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<10; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
